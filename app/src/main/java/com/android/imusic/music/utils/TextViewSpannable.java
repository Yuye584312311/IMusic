package com.android.imusic.music.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.android.imusic.store.listener.OnSpannableClickListener;
import com.android.imusic.store.listener.SpannableClickSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TinyHung@outlook.com
 * 2017/6/27 15:49
 * 这是一个处理包含 #XXXX# @XXX httpxxx 等关键字的辅助类
 */
public class TextViewSpannable {

	private static final String TAG = "TextViewSpannable";
	private volatile static TextViewSpannable mInstance;
	// 定义正则表达式
	private static final String AT = "@[\u4e00-\u9fa5\\w]+";// @人
	private static final String TOPIC = "#[\u4e00-\u9fa5\\w]+#";// ##话题
	private static final String SERVICE = "《[\u4e00-\u9fa5\\w]+》";// 《》协议
	private static final String EMOJI = "\\[[\u4e00-\u9fa5\\w]+\\]";// 表情
	private static final String URL = "http://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";// url
	private static final String REGEX = "(" + AT + ")|(" + TOPIC + ")|(" + SERVICE + ")|(" + EMOJI + ")|(" + URL + ")";

	public static synchronized TextViewSpannable getInstance() {
		synchronized (TextViewSpannable.class) {
			if (null == mInstance) {
				mInstance = new TextViewSpannable();
			}
		}
		return mInstance;
	}

	/**
	 * 设置内容样式
	 * @param source
	 * @param clickListener
	 * @param userID 这个不需要的可以为空
	 * @return
	 */
	public SpannableString formatContent(Spanned source, TextView textView, int color, final OnSpannableClickListener clickListener, final String userID) {
		if(TextUtils.isEmpty(source)){
			return null;
		}
		SpannableString spannableString = new SpannableString(source);
		// 设置正则
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(spannableString);
		if (matcher.find()) {
			// 要实现文字的点击效果，这里需要做特殊处理
			textView.setMovementMethod(LinkMovementMethod.getInstance());
			// 重置正则位置
			matcher.reset();
		}
		while (matcher.find()) {
			// 根据group的括号索引，可得出具体匹配哪个正则(0代表全部，1代表第一个括号)
			final String at = matcher.group(1);
			final String topic = matcher.group(2);
			final String services = matcher.group(3);
			String emoji = matcher.group(4);
			final String url = matcher.group(5);
			// 处理@符号
			if (at != null) {
				// 获取匹配位置
				int start = matcher.start(1);
				int end = start + at.length();
				SpannableClickSpan clickableSpan = new SpannableClickSpan(color) {
					@Override
					public void onClick(View widget) {
						// TODO: 2017/6/27 待传入点击@人物后的监听
						if(null!=clickListener&&!TextUtils.isEmpty(userID)){
							clickListener.onUserClick(userID);
						}
					}
				};
				spannableString.setSpan(clickableSpan, start, end,
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}

			// 处理话题##符号
			if (topic != null) {
				int start = matcher.start(2);
				int end = start + topic.length();
				SpannableClickSpan clickableSpan = new SpannableClickSpan(color) {

					@Override
					public void onClick(View widget) {
						if(null!=clickListener){
							clickListener.onTopicClick(topic);
						}
					}
				};
				spannableString.setSpan(clickableSpan, start, end,
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
			// 处理话题《》符号
			if (services != null) {
				int start = matcher.start(3);
				int end = start + services.length();
				SpannableClickSpan clickableSpan = new SpannableClickSpan(color) {

					@Override
					public void onClick(View widget) {
						if(null!=clickListener){
							clickListener.onServiceClick(services);
						}
					}
				};
				spannableString.setSpan(clickableSpan, start, end,
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
			if (emoji != null) {

			}

			// 处理url地址
			if (url != null) {
				int start = matcher.start(4);
				int end = start + url.length();
				SpannableClickSpan clickableSpan = new SpannableClickSpan(color) {
					@Override
					public void onClick(View widget) {
						// TODO: 2017/6/27 待传入点击网址的监听  url
						if(null!=clickListener){
							clickListener.onUrlClick(url);
						}
					}
				};
				spannableString.setSpan(clickableSpan, start, end,
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
		return spannableString;
	}
}
