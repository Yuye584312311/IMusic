package com.android.imusic.permission.listener;

import com.android.imusic.permission.model.PermissionModel;

/**
 * Created by TinyHung@Outlook.com
 * 2019/12/17
 * 运行时权限获取监听器
 */

public interface OnRuntimePermissionListener {
    /**
     * 返回需要请求的权限列表
     * @return 权限列表
     */
    PermissionModel[] getRequstPermissions();

    /**
     * 返回请求权限失败时的问询文案
     * @return 文案
     */
    String getErrorPermissionTips();

    /**
     * 所有权限获取状态
     * @param success true：已授予 fakse：未授予
     */
    void onRequstPermissionResult(boolean success);
}