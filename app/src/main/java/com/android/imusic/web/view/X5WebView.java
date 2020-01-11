package com.android.imusic.web.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.android.imusic.BuildConfig;

/**
 * Created by TinyHung@outlook.com
 * 2019/10/12
 * 腾讯X5内核WebView(暂未开启)
 */

public class X5WebView extends WebView {

	public X5WebView(Context context) {
		this(context,null);
	}

	public X5WebView(Context context, AttributeSet attributeSet) {
		this(context, attributeSet,0);
	}

	@SuppressLint("SetJavaScriptEnabled")
	public X5WebView(Context context, AttributeSet attributeSet, int i) {
		super(context, attributeSet, i);
		// WebStorage webStorage = WebStorage.getInstance();
		initWebViewSettings();
		setClickable(true);
	}

	private void initWebViewSettings() {
		WebSettings webSetting = this.getSettings();
		webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
		webSetting.setAllowFileAccess(true);
		// 排版适应屏幕
		webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
		webSetting.setBuiltInZoomControls(true);
		webSetting.setSupportMultipleWindows(true);
		// webSetting.setLoadWithOverviewMode(true);
		webSetting.setAppCacheEnabled(true);
		// webSetting.setDatabaseEnabled(true);
		webSetting.setDomStorageEnabled(true);
		webSetting.setGeolocationEnabled(true);
		webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
		// webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
		webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
		// webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
		webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
		// this.getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
		// settings 的设计
		// 网页内容的宽度是否可大于WebView控件的宽度
		webSetting.setLoadWithOverviewMode(false);
		// 保存表单数据
		webSetting.setSaveFormData(true);
		// 是否应该支持使用其屏幕缩放控件和手势缩放
		webSetting.setSupportZoom(true);
		webSetting.setDisplayZoomControls(false);
		// setDefaultZoom  api19被弃用
		// 设置此属性，可任意比例缩放。
		webSetting.setUseWideViewPort(true);
		// 缩放比例 1
		setInitialScale(1);
		// 告诉WebView启用JavaScript执行。默认的是false。
		webSetting.setJavaScriptEnabled(true);
		//  页面加载好以后，再放开图片
		webSetting.setBlockNetworkImage(false);
		// 使用localStorage则必须打开
		webSetting.setDomStorageEnabled(true);
		// WebView是否支持多个窗口。
		webSetting.setSupportMultipleWindows(true);
		//文字缩放大小
		//webSetting.setTextZoom(100);
		// 仅在 debuggable 为 true 时启用 WebView 调试，请在运行时测试标志。本地无效
		if (BuildConfig.DEBUG&& Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			if (0 != (getContext().getApplicationContext().getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE)) {
				X5WebView.setWebContentsDebuggingEnabled(true);
			}
		}
		//允许WebView加载Https资源
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			webSetting.setMixedContentMode(android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
		}
	}

	/**
	 * 直接布局内绘制canvas
	 * @param arg0
	 */
//	@Override
//	protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
//		boolean ret = super.drawChild(canvas, child, drawingTime);
//		canvas.save();
//		Paint paint = new Paint();
//		paint.setColor(0x7fff0000);
//		paint.setTextSize(24.f);
//		paint.setAntiAlias(true);
//		if (getX5WebViewExtension() != null) {
//			canvas.drawText(this.getContext().getPackageName() + "-pid:"
//					+ android.os.Process.myPid(), 10, 50, paint);
//			canvas.drawText(
//					"X5  Core:" + QbSdk.getTbsVersion(this.getContext()), 10,
//					100, paint);
//		} else {
//			canvas.drawText(this.getContext().getPackageName() + "-pid:"
//					+ android.os.Process.myPid(), 10, 50, paint);
//			canvas.drawText("Sys Core", 10, 100, paint);
//		}
//		canvas.drawText(Build.MANUFACTURER, 10, 150, paint);
//		canvas.drawText(Build.MODEL, 10, 200, paint);
//		canvas.restore();
//		return ret;
//	}
}