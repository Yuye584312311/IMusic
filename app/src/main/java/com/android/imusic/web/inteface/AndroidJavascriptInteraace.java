package com.android.imusic.web.inteface;

import com.android.imusic.web.listener.AndroidJavascriptListener;

/**
 * Created by TinyHung@outlook.com
 * 2019/8/16
 * 与JS通信Interaace
 */

public class AndroidJavascriptInteraace {

    private AndroidJavascriptListener mJavascriptListener;

    public void setJavascriptListener(AndroidJavascriptListener javascriptListener) {
        mJavascriptListener = javascriptListener;
    }

    @android.webkit.JavascriptInterface
    public void setJsContent(String action, String event){
        if(null!=mJavascriptListener){
            mJavascriptListener.setJsContent(action,event);
        }
    }
}