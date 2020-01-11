package com.android.imusic.web.inteface;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.UserManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.imusic.web.listener.IWebView;
import com.music.player.lib.util.Logger;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by TinyHung@outlook.com
 * 2019/8/16
 * WEB状态交互
 */

public class AndroidWebClient extends WebViewClient {

    private static final String TAG = "AndroidWebClient";
    private final CookieManager mCookieManager;
    private IWebView mIWebView;

    public AndroidWebClient(){
        mCookieManager = CookieManager.getInstance();
        mCookieManager.setAcceptCookie(true);
    }

    public void setWebViewClientListener(IWebView iWebView){
        this.mIWebView=iWebView;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Logger.d(TAG,"onPageStarted-->url:"+url);
        if(null!=mIWebView){
            mIWebView.onPageStart(view,url,null);
        }
        //页面开始加载时写入cookie
        if(null!=mCookieManager){
            // 改为通过host来添加cookie
            String host = "";
            try {
                host = getRootDomain(url);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                CookieSyncManager.getInstance().sync();
            }
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        Logger.d(TAG,"onPageFinished-->url:"+url);
        super.onPageFinished(view, url);
        if(null!=mIWebView){
            mIWebView.onPageFinish(view,url,view.getTitle());
        }
    }

    @Override
    public void onReceivedError(WebView webView, int i, String s, String s1) {
        super.onReceivedError(webView, i, s, s1);
        if(null!=mIWebView){
            mIWebView.onPageError(webView,webView.getTitle());
        }
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Logger.d(TAG,"shouldOverrideUrlLoading-->url:"+url);
        //电话、短信
        if (url.startsWith(WebView.SCHEME_TEL) || url.startsWith("sms:") || url.startsWith(WebView.SCHEME_MAILTO)) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse(url));
                view.getContext().startActivity(intent);
            } catch (ActivityNotFoundException ignored) {
                ignored.fillInStackTrace();
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    /**
     * 获取url根域名. 如www.caoliao.com取.caoliao.com
     */
    public String getRootDomain(String url) {
        try {
            URL u = new URL(url);
            return u.getHost();
        }catch (MalformedURLException e){
            return url;
        }
    }

    /**
     * 判断是否是其他意图，
     * @param url 跳转的url地址
     * @return 是否是其他schema头, 即判断url地址是不是http的.
     */
    private boolean isOtherSchema(String url) {
        Uri uri = Uri.parse(url);
        String schema = uri.getScheme();
        return schema != null && !schema.contains("http");
    }
}