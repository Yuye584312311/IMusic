package com.android.imusic.permission.manager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import com.android.imusic.permission.listener.OnRuntimePermissionListener;
import com.android.imusic.permission.model.PermissionModel;
import com.android.imusic.permission.ui.activity.RuntimePermissionActivity;

/**
 * TinyHung@outlook.com
 * 2019/12/17
 * 运行时权限获取辅助管理者
 */

public class RuntimePermissionManager {

    private static final String TAG = "RequstPermissionManager";
    private volatile static RuntimePermissionManager mInstance;
    private OnRuntimePermissionListener mListener;

    public static synchronized RuntimePermissionManager getInstance() {
        synchronized (RuntimePermissionManager.class) {
            if (null == mInstance) {
                mInstance = new RuntimePermissionManager();
            }
        }
        return mInstance;
    }

    /**
     * 检查指定的权限是否已经都获取了
     * @param context 上下文
     * @param permissModels 待检查的权限
     * @return
     */
    public boolean isAllRequestedPermission(Context context, PermissionModel[] permissModels) {
        for (final PermissionModel model : permissModels) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(context, model.permission)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 开始权限请求
     * @param listener 状态监听器
     */
    public void startRequstPermission(Context context, OnRuntimePermissionListener listener) {
        startRequstPermission(context,"0",listener);
    }

    /**
     * 开始权限请求
     * @param listener 状态监听器
     * @param isMust 是否必须
     */
    public void startRequstPermission(Context context, String isMust, OnRuntimePermissionListener listener) {
        this.mListener =listener;
        Intent intent=new Intent(context,RuntimePermissionActivity.class);
        intent.putExtra("is_must",isMust);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 所有权限获取状态
     * @param success true：已授予 fakse：未授予
     */
    public void onRequstPermissionResult(boolean success) {
        if (null != mListener) {
            mListener.onRequstPermissionResult(success);
        }
    }

    /**
     * 返回监听实例
     * @return 监听器
     */
    public OnRuntimePermissionListener getListenerInstance(){
        return mListener;
    }

    /**
     * 释放重置
     */
    public void onReset() {
        mListener =null;
    }
}