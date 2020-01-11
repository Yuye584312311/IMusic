package com.android.imusic.web.listener;

/**
 * Created by TinyHung@outlook.com
 * 2019/8/16
 * JS通信回调
 */

public interface AndroidJavascriptListener {

    /**
     * H5呼叫原生APP方法
     * @param action 事件意图
     * @param event 事件参数
     */
    void setJsContent(String action, String event);
}