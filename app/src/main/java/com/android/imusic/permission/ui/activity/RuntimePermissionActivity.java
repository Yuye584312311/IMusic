package com.android.imusic.permission.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;
import com.android.imusic.music.dialog.QuireDialog;
import com.android.imusic.permission.listener.OnRuntimePermissionListener;
import com.android.imusic.permission.manager.RuntimePermissionManager;
import com.android.imusic.permission.model.PermissionModel;
import com.android.imusic.permission.ui.dialog.RuntimePermissionDialog;
import com.music.player.lib.util.Logger;

/**
 * Created by TinyHung@Outlook.com
 * 2019/12/17
 * 运行时权限获取
 */

public class RuntimePermissionActivity extends AppCompatActivity {

    //设置回执
    protected final static int SETTING_REQUST = 123;
    private static final String TAG = "RuntimePermissionActivity";
    //授权状态,true:授权完成 false:授权被拒绝
    private boolean mSuccess;
    private static PermissionModel[] sModels;
    //所申请的权限是否必须
    private boolean mIsMust;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.color.transparent));
        String is_must = getIntent().getStringExtra("is_must");
        mIsMust = !TextUtils.isEmpty(is_must)&&is_must.equals("1");
        requstPermissions();
    }

    /**
     * 向用户申请的权限列表
     */
    private void onRequstPermissionResult(boolean success) {
        this.mSuccess=success;
        finish();
    }

    /**
     * 运行时权限
     */
    protected void requstPermissions() {
        if(Build.VERSION.SDK_INT < 23){
            onRequstPermissionResult(true);
            return;
        }
        if(null==sModels){
            OnRuntimePermissionListener instance = RuntimePermissionManager.getInstance().getListenerInstance();
            if(null!=instance&&null!=instance.getRequstPermissions()){
                sModels = instance.getRequstPermissions();
            }
        }
        if(null==sModels||sModels.length==0){
            onRequstPermissionResult(true);
            return;
        }
        try {
            for (PermissionModel model : sModels) {
                if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, model.permission)) {
                    ActivityCompat.requestPermissions(this, new String[]{model.permission}, model.requestCode);
                    return;
                }
            }
            //到这里就表示所有需要的权限已经通过
            onRequstPermissionResult(true);
        } catch (Exception e) {
            e.printStackTrace();
            //到这里就表示所有需要的权限已经通过
            onRequstPermissionResult(true);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (SETTING_REQUST == requestCode) {
            if (isAllRequestedPermissionGranted()) {
                onRequstPermissionResult(true);
            } else {
                requstPermissions();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 申请结果回调
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Logger.d(TAG,"grantResults:"+grantResults.toString());
        if(null!=grantResults&&grantResults.length>0){
            if (PackageManager.PERMISSION_GRANTED != grantResults[0]) {
                //用户拒绝过其中一个权限
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                    //如果权限为必须的
                    if(mIsMust){
                        RuntimePermissionDialog dialog = RuntimePermissionDialog.getInstance(RuntimePermissionActivity.this)
                                .setDialogCancelable(false)
                                .setTipsContent(findPermissionExplain(permissions[0]))
                                .setDialogCanceledOnTouchOutside(false);
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                requstPermissions();
                            }
                        });
                        dialog.show();
                        return;
                    }
                    QuireDialog.getInstance(RuntimePermissionActivity.this)
                            .setTitleText("权限申请失败")
                            .setContentText(findPermissionExplain(permissions[0]))
                            .setSubmitTitleText("确定")
                            .setCancelTitleText("取消")
                            .setDialogCancelable(false)
                            .setBtnClickDismiss(true)
                            .setDialogCanceledOnTouchOutside(false)
                            .setOnQueraConsentListener(new QuireDialog.OnQueraConsentListener() {
                                @Override
                                public void onConsent(QuireDialog dialog) {
                                    requstPermissions();
                                }

                                @Override
                                public void onRefuse(QuireDialog dialog) {
                                    onRequstPermissionResult(false);
                                }
                            }).show();
                    //继续下个权限请求
                } else {
                    //如果权限为必须的
                    if(mIsMust){
                        String tips="您已拒绝部分权限，请手动授权以保障APP正常运行！";
                        OnRuntimePermissionListener instance = RuntimePermissionManager.getInstance().getListenerInstance();
                        if(null!=instance&&!TextUtils.isEmpty(instance.getErrorPermissionTips())){
                            tips = instance.getErrorPermissionTips();
                        }
                        RuntimePermissionDialog dialog = RuntimePermissionDialog.getInstance(RuntimePermissionActivity.this)
                                .setDialogCancelable(false)
                                .setTipsContent(tips)
                                .setDialogCanceledOnTouchOutside(false);
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                try {
                                    startActivityForResult(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).setData(Uri.fromParts("package", getPackageName(), null)), SETTING_REQUST);
                                }catch (Exception e){
                                    e.printStackTrace();
                                    Toast.makeText(RuntimePermissionActivity.this,"跳转失败！",Toast.LENGTH_LONG).show();
                                    onRequstPermissionResult(true);
                                }
                            }
                        });
                        dialog.show();
                        return;
                    }
                    //用户勾选了不再询问，手动开启
                    String tips="您已拒绝部分权限，请手动授权以保障APP正常运行！";
                    OnRuntimePermissionListener instance = RuntimePermissionManager.getInstance().getListenerInstance();
                    if(null!=instance&&!TextUtils.isEmpty(instance.getErrorPermissionTips())){
                        tips = instance.getErrorPermissionTips();
                    }
                    QuireDialog.getInstance(RuntimePermissionActivity.this)
                            .setTitleText("权限申请失败")
                            .setContentText(tips)
                            .setSubmitTitleText("去设置")
                            .setCancelTitleText("取消")
                            .setBtnClickDismiss(true)
                            .setDialogCancelable(false)
                            .setDialogCanceledOnTouchOutside(false)
                            .setOnQueraConsentListener(new QuireDialog.OnQueraConsentListener() {
                                @Override
                                public void onConsent(QuireDialog dialog) {
                                    try {
                                        startActivityForResult(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).setData(Uri.fromParts("package", getPackageName(), null)), SETTING_REQUST);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                        Toast.makeText(RuntimePermissionActivity.this,"跳转失败！",Toast.LENGTH_LONG).show();
                                        onRequstPermissionResult(true);
                                    }
                                }

                                @Override
                                public void onRefuse(QuireDialog dialog) {
                                    onRequstPermissionResult(false);
                                }
                            }).show();
                }
                return;
            }
            // 到这里就表示用户允许了本次请求，继续检查是否还有待申请的权限没有申请
            if (isAllRequestedPermissionGranted()) {
                onRequstPermissionResult(true);
            } else {
                requstPermissions();
            }
        }
    }

    protected String findPermissionExplain(String permission) {
        if (null!= sModels) {
            for (PermissionModel model : sModels) {
                if (model != null && model.permission != null && model.permission.equals(permission)) {
                    return model.explain;
                }
            }
        }
        return null;
    }

    protected boolean isAllRequestedPermissionGranted() {
        if(null!= sModels){
            for (PermissionModel model : sModels) {
                if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, model.permission)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sModels=null;
        RuntimePermissionManager.getInstance().onRequstPermissionResult(mSuccess);
    }
}