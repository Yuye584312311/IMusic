package com.android.imusic.web.listener;

import android.webkit.WebView;

/**
 * Created by TinyHung@outlook.com
 * 2019/8/16
 */

public interface IWebView {
    /**
     * 开始加载网页
     * @param webView webView
     * @param url 网页url
     */
    void onPageStart(WebView webView, String url, String title);

    /**
     * 网页加载完成
     * @param webView webView
     * @param url 网页url
     * @param title 网页标题
     */
    void onPageFinish(WebView webView, String url, String title);

    /**
     * 网页加载失败
     * @param webView webView
     * @param url 网页url
     */
    void onPageError(WebView webView, String url);
}
