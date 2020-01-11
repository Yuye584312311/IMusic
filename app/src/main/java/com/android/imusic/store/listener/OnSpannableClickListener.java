package com.android.imusic.store.listener;

/**
 * TinyHung@outlook.com
 * 2017/6/27 18:43
 * 点击 Despz中##，《》, @a 等特殊内容
 */
public abstract class OnSpannableClickListener {
    public void onTopicClick(String topic){}
    public void onUrlClick(String url){}
    public void onUserClick(String authorID){}
    public void onServiceClick(String service){}
}