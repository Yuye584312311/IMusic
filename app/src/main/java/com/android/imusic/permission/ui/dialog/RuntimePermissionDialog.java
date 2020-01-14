package com.android.imusic.permission.ui.dialog;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.android.imusic.R;
import com.android.imusic.base.BaseDialog;
import com.android.imusic.music.utils.MediaUtils;

/**
 * Created by TinyHung@outlook.com
 * 2019/12/17
 * 运行时权限获取失败提示框
 */

public class RuntimePermissionDialog extends BaseDialog {

    public static RuntimePermissionDialog getInstance(Activity activity) {
        return new RuntimePermissionDialog(activity);
    }

    public RuntimePermissionDialog(@NonNull Activity activity) {
        super(activity, R.style.CenterDialogAnimationStyle);
        setCancelable(false);
        setContentView(R.layout.ad_dialog_runtime_permission);
        MediaUtils.getInstance().setDialogWidth(this);
    }

    /**
     * 是否允许按下返回键关闭弹窗
     * @param isCancelable
     * @return
     */
    public RuntimePermissionDialog setDialogCancelable(boolean isCancelable){
        this.setCancelable(isCancelable);
        return this;
    }

    /**
     * 是否允许触摸边界关闭此弹窗
     * @param isCanceledOnTouchOutside
     * @return
     */
    public RuntimePermissionDialog setDialogCanceledOnTouchOutside(boolean isCanceledOnTouchOutside){
        this.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
        return this;
    }

    /**
     * 设置权限申请提示内容
     * @param content
     */
    public RuntimePermissionDialog setTipsContent(String content){
        if(!TextUtils.isEmpty(content)){
            ((TextView) findViewById(R.id.tv_content)).setText(Html.fromHtml(content));
        }
        return this;
    }

    @Override
    public void initViews() {
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = v.getId();
                if (i == R.id.btn_submit) {
                    RuntimePermissionDialog.this.dismiss();
                    if(null!=mListener){
                        mListener.onConsent();
                    }
                }
            }
        };
        findViewById(R.id.btn_submit).setOnClickListener(onClickListener);
    }

    @Override
    public void show() {
        super.show();
    }

    public interface OnDialogActionListener{
        void onConsent();

    }
    private OnDialogActionListener mListener;

    public RuntimePermissionDialog setOnDialogActionListener(OnDialogActionListener listener) {
        mListener = listener;
        return this;
    }
}