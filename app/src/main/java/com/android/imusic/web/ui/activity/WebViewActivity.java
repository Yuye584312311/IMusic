package com.android.imusic.web.ui.activity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.imusic.R;
import com.android.imusic.base.BaseActivity;
import com.android.imusic.base.BasePresenter;
import com.android.imusic.music.view.CommentTitleView;
import com.android.imusic.web.inteface.AndroidJavascriptInteraace;
import com.android.imusic.web.inteface.AndroidWebChromeClient;
import com.android.imusic.web.inteface.AndroidWebClient;
import com.android.imusic.web.listener.AndroidJavascriptListener;
import com.android.imusic.web.listener.IWebView;
import com.android.imusic.web.view.X5WebView;
import com.music.player.lib.util.Logger;

/**
 * Created by TinyHung@outlook.com
 * 2019/8/16
 * WebView
 */

public class WebViewActivity extends BaseActivity implements IWebView, AndroidJavascriptListener {

    private static final String TAG = "WebViewActivity";
    private X5WebView mWebView;
    private SwipeRefreshLayout mRefreshLayout;
    private ProgressBar mProgressBar;
    private CommentTitleView mTitleView;
    private AndroidWebChromeClient mWebChromeClient;
    private String mUrl;
    private CookieManager mCookieManager;
    //当前已位移进度,位移进度目标最大值,进度条最大值
    private int mCurrentProgress,mToMaxProgress,mMaxProgress=1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        if(TextUtils.isEmpty(mUrl)){
            Toast.makeText(this,"无效的URL地址",Toast.LENGTH_SHORT).show();
            finish();
           return;
        }
        initViews();
        initWebView();
        mWebView.loadUrl(mUrl);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void initViews() {
        mTitleView = (CommentTitleView) findViewById(R.id.title_view);
        mTitleView.setOnTitleClickListener(new CommentTitleView.OnTitleClickListener() {
            @Override
            public void onBack(View view) {
                onBackPressed();
            }

            @Override
            public void onClose(View v) {
                finish();
            }
        });
        mTitleView.setTitle(getIntent().getStringExtra("title"));
        mWebView = (X5WebView) findViewById(R.id.web_view);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        mRefreshLayout.setEnabled(false);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mWebView.reload();
            }
        });
        mProgressBar = (ProgressBar) findViewById(R.id.pb_progress);
    }

    /**
     * 初始化
     */
    @SuppressLint("JavascriptInterface")
    private void initWebView() {
        mProgressBar.setVisibility(View.VISIBLE);
        mCookieManager = CookieManager.getInstance();
        mCookieManager.setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mCookieManager.setAcceptThirdPartyCookies(mWebView,true);
        }
        //劫持意图事件
        mWebChromeClient = new AndroidWebChromeClient(this);
        AndroidWebClient androidWebClient = new AndroidWebClient();
        androidWebClient.setWebViewClientListener(this);
        mWebView.setWebChromeClient(mWebChromeClient);
        mWebView.setWebViewClient(androidWebClient);
        // 与js交互
        ThreadLocal<AndroidJavascriptInteraace> javascriptInterfaceThreadLocal = new ThreadLocal<>();
        AndroidJavascriptInteraace clJavascriptInterface = new AndroidJavascriptInteraace();
        clJavascriptInterface.setJavascriptListener(this);
        mWebView.addJavascriptInterface(javascriptInterfaceThreadLocal, "injectedObject");
        //监听下载事件
        mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().sync();
    }

    /**
     * 进度条 假装加载到maxProgress
     * @param toProgress 目标进度
     */
    public void startProgressToMax(int toProgress) {
        if(null!=mProgressBar){
            //如果是直接到达最大数
            if(toProgress>=mMaxProgress){
                mProgressBar.removeCallbacks(progressRunnable);
                mProgressBar.setProgress(mMaxProgress);
                ObjectAnimator animator = ObjectAnimator.ofFloat(mProgressBar, "alpha", 1.0f, 0.0f).setDuration(260);
                animator.setInterpolator(new LinearInterpolator());
                animator.start();
                mToMaxProgress=toProgress;
                return;
            }
            //缓慢加载至期望进度
            mProgressBar.setVisibility(View.VISIBLE);
            mCurrentProgress=0;
            mToMaxProgress=toProgress;
            mProgressBar.postDelayed(progressRunnable,50);
        }
    }

    /**
     * 时间到 移除自己
     */
    private Runnable progressRunnable=new Runnable() {
        @Override
        public void run() {
            if(null!=mProgressBar){
                mCurrentProgress+=5;
                mProgressBar.setProgress(mCurrentProgress);
                if(mCurrentProgress>=mMaxProgress){
                    mProgressBar.setProgress(mMaxProgress);
                    mProgressBar.removeCallbacks(progressRunnable);
                    ObjectAnimator animator = ObjectAnimator.ofFloat(mProgressBar, "alpha", 1.0f, 0.0f).setDuration(260);
                    animator.start();
                    animator.setInterpolator(new LinearInterpolator());
                    return;
                }
                if(mCurrentProgress<mToMaxProgress){
                    mProgressBar.postDelayed(progressRunnable,50);
                }
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(null!=mWebChromeClient){
            mWebChromeClient.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onPageStart(WebView webView, String url, String title) {
        startProgressToMax(900);
        if(null!=mTitleView&&!TextUtils.isEmpty(title)){
            mTitleView.setTitle(title);
        }
    }

    @Override
    public void onPageFinish(WebView webView, String url, String title) {
        startProgressToMax(mMaxProgress);
        if(null!=mRefreshLayout&&mRefreshLayout.isShown()){
            mRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    mRefreshLayout.setRefreshing(false);
                }
            });
        }
        if(null!=mTitleView&&!TextUtils.isEmpty(title)){
            mTitleView.setTitle(title);
        }
    }

    @Override
    public void onPageError(WebView webView, String url) {
        if(null!=mRefreshLayout&&mRefreshLayout.isShown()){
            mRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    mRefreshLayout.setRefreshing(false);
                }
            });
        }
        startProgressToMax(mMaxProgress);
    }

    /**
     * JS通信
     * @param action 事件意图
     * @param event 事件参数
     */
    @Override
    public void setJsContent(final String action, final String event) {
        Logger.d(TAG,"setJsContent-->action:"+action+",event:"+event);
        //刷新开关 0：禁用刷新 1：开启刷新
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if("refresh".equals(action)){
                    if(null!=mRefreshLayout){
                        if("1".equals(event)){
                            mRefreshLayout.setEnabled(true);
                        }else if("0".equals(event)){
                            mRefreshLayout.setEnabled(false);
                        }
                    }
                }else if("closeWebview".equals(action)){
                    finish();
                }
            }
        });
    }

    /**
     * 拦截返回和菜单事件
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if(TextUtils.isEmpty(mUrl)){
            if(null!=mWebView){
                mWebView.loadUrl("about:blank");
            }
            finish();
            return;
        }
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return;
        }
        if(null!=mWebView) {
            mWebView.loadUrl("about:blank");
        }
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        //如果window上view获取焦点 && view不为空
        if(imm.isActive()&&getCurrentFocus()!=null){
            if (getCurrentFocus().getWindowToken()!=null) {
                //表示软键盘窗口总是隐藏，除非开始时以SHOW_FORCED显示。
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null!=mRefreshLayout){
            mRefreshLayout.setRefreshing(false);
        }
        if(null!=mProgressBar){
            mProgressBar.removeCallbacks(progressRunnable);
        }
        if(null!=mCookieManager){
            mCookieManager.removeAllCookie();
        }
        if (mWebView != null) {
            ViewGroup parent = (ViewGroup) mWebView.getParent();
            if (parent != null) {
                parent.removeView(mWebView);
            }
            mWebView.removeAllViews();
            mWebView.loadUrl("about:blank");
            mWebView.stopLoading();
            mWebView.setWebChromeClient(null);
            mWebView.setWebViewClient(null);
            mWebView.destroy();
        }
        mWebChromeClient=null;mWebView=null;
    }
}