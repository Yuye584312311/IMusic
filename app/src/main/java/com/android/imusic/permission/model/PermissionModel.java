package com.android.imusic.permission.model;

/**
 * Created by TinyHung@Outlook.com
 * 2019/12/2
 * 权限信息
 */

public class PermissionModel {

    public String permission;
    public String explain;
    public int requestCode;

    public PermissionModel(String permission, String explain, int requestCode) {
        this.permission = permission;
        this.explain = explain;
        this.requestCode = requestCode;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    @Override
    public String toString() {
        return "PermissionModel{" +
                "permission='" + permission + '\'' +
                ", explain='" + explain + '\'' +
                ", requestCode=" + requestCode +
                '}';
    }
}