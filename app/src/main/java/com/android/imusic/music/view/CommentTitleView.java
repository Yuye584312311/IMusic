package com.android.imusic.music.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.imusic.R;
import com.android.imusic.music.utils.StatusUtils;
import com.music.player.lib.util.MusicUtils;

/**
 * TinyHung@outlook.com
 * 2018/5/29
 * 通用的标题栏
 */

public class CommentTitleView extends LinearLayout implements View.OnClickListener {

    public static final int STYLE_LIGHT=0;//白底
    public static final int STYLE_COLOR=1;//彩底
    private static final String TAG = "CommentTitleView";
    private TextView mTitleView,mSubTitle;
    private long[] clickCount = new long[2];
    private int mTitleStyle=STYLE_LIGHT;
    private Drawable mBackGround;

    public CommentTitleView(Context context) {
        super(context);
        init(context,null);
    }

    public CommentTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    @SuppressLint("WrongViewCast")
    private void init(Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.lib_comment_title_layout,this);
        ImageView btnback = (ImageView) findViewById(R.id.view_btn_back);
        ImageView btnClose = (ImageView) findViewById(R.id.view_btn_close);
        ImageView btnMenu = (ImageView) findViewById(R.id.view_btn_menu);
        mTitleView = (TextView) findViewById(R.id.view_title);
        mSubTitle = (TextView) findViewById(R.id.view_sub_title);
        if(null!=attrs){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommentTitleView);
            Drawable backDrawable = typedArray.getDrawable(R.styleable.CommentTitleView_commentBackRes);
            Drawable menuDrawable = typedArray.getDrawable(R.styleable.CommentTitleView_commentMenuRes);
            Drawable closeDrawable = typedArray.getDrawable(R.styleable.CommentTitleView_commentCloseRes);
            mBackGround = typedArray.getDrawable(R.styleable.CommentTitleView_commentBackGroundRes);
            if(null!=mBackGround){
                findViewById(R.id.root_top_bar).setBackground(mBackGround);
            }
            boolean showBack = typedArray.getBoolean(R.styleable.CommentTitleView_commentShowBack,true);
            boolean showClose = typedArray.getBoolean(R.styleable.CommentTitleView_commentShowClose,true);
            btnback.setVisibility(showBack?VISIBLE:GONE);
            btnClose.setVisibility(showClose?VISIBLE:GONE);
            btnback.setImageDrawable(backDrawable);
            btnMenu.setImageDrawable(menuDrawable);
            btnClose.setImageDrawable(closeDrawable);
            //标题
            String titleText = typedArray.getString(R.styleable.CommentTitleView_commentTitle);
            int titleColor = typedArray.getColor(R.styleable.CommentTitleView_commentTitleColor,
                    Color.parseColor("#000000"));
            int titleSize = typedArray.getDimensionPixelSize(R.styleable.CommentTitleView_commentTitleSize, 18);
            //副标题
            String subTitleText = typedArray.getString(R.styleable.CommentTitleView_commentSubTitle);
            int subTitleColor = typedArray.getColor(R.styleable.CommentTitleView_commentSubTitleColor,
                    Color.parseColor("#666666"));
            int subTitleSize = typedArray.getDimensionPixelSize(R.styleable.CommentTitleView_commentSubTitleSize, 14);
            //标题
            mTitleView.setText(titleText);
            mTitleView.setTextColor(titleColor);
            mTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX,titleSize);
            String string = typedArray.getString(R.styleable.CommentTitleView_commentTitleTextStyle);
            if(TextUtils.isEmpty(string)){
                string="0";
            }
            if(string.endsWith("0")){
                mTitleView.getPaint().setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }else if(string.endsWith("1")){
                mTitleView.getPaint().setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }else if(string.endsWith("2")){
                mTitleView.getPaint().setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            }
            if(!TextUtils.isEmpty(subTitleText)){
                btnMenu.setVisibility(GONE);
                //副标题
                mSubTitle.setText(subTitleText);
                mSubTitle.setTextColor(subTitleColor);
                mSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,subTitleSize);
            }
            mTitleStyle = typedArray.getInt(R.styleable.CommentTitleView_commentTitleStyle, STYLE_LIGHT);
            View viewLine = findViewById(R.id.view_line);
            boolean showLine = typedArray.getBoolean(R.styleable.CommentTitleView_commentShowLine, false);
            int lineColor = typedArray.getColor(R.styleable.CommentTitleView_commentLineColor, ContextCompat.getColor(getContext(), R.color.style));
            viewLine.setBackgroundColor(lineColor);
            viewLine.setVisibility(showLine?VISIBLE:GONE);

            typedArray.recycle();
        }
        btnback.setOnClickListener(this);
        mTitleView.setOnClickListener(this);
        mSubTitle.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        View statusBar = findViewById(R.id.statusbar_view);
        statusBar.getLayoutParams().height= MusicUtils.getInstance().getStatusBarHeight(getContext());
        //用户未指定自定义样式，使用默认的
        if(mTitleStyle==STYLE_LIGHT){
            if((Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP)){
                statusBar.setBackgroundColor(Color.parseColor("#777777"));
            }
            mTitleView.setTextColor(Color.parseColor("#000000"));
            this.setBackgroundColor(Color.parseColor("#FFFFFF"));
            StatusUtils.getInstance().setStatusTextColor1(true,(Activity) getContext());//白色背景，黑色字体
            return;
        }
        setTitleBarStyle(mTitleStyle);
    }

    /**
     * 设置标题栏样式
     * @param titleStyle 0：白色黑字 1：彩底白字
     */
    public void setTitleBarStyle(int titleStyle) {
        ImageView btnback = (ImageView) findViewById(R.id.view_btn_back);
        ImageView btnMenu = (ImageView) findViewById(R.id.view_btn_menu);
        TextView titleView = (TextView) findViewById(R.id.view_title);
        TextView viewSubTitle = (TextView) findViewById(R.id.view_sub_title);
        if(titleStyle==STYLE_LIGHT){//白底黑字
            if(null!=btnback) btnback.setImageResource(R.drawable.btn_nav_menu_back_selector_black);
            if(null!=btnMenu) btnMenu.setColorFilter(Color.parseColor("#666666"));
            if(null!=titleView) titleView.setTextColor(Color.parseColor("#333333"));
            if(null!=viewSubTitle) viewSubTitle.setTextColor(Color.parseColor("#666666"));
            StatusUtils.getInstance().setStatusTextColor1(true,(Activity) getContext());//白色背景，黑色字体
        }else if(titleStyle==STYLE_COLOR){//彩底白字
            if(null!=btnback) btnback.setImageResource(R.drawable.btn_nav_menu_back_selector_white);
            if(null!=btnMenu) btnMenu.setColorFilter(Color.parseColor("#DDDDDD"));
            if(null!=titleView) titleView.setTextColor(Color.parseColor("#FFFFFF"));
            if(null!=viewSubTitle) viewSubTitle.setTextColor(Color.parseColor("#DDDDDD"));
            StatusUtils.getInstance().setStatusTextColor1(false,(Activity) getContext());//透明背景，白色字体
        }
        this.mTitleStyle=titleStyle;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.view_btn_back){
            if(null!=mOnTitleClickListener) mOnTitleClickListener.onBack(v);
        }else if(id==R.id.view_sub_title){
            if(null!=mOnTitleClickListener) mOnTitleClickListener.onSubTitleClick(v);
        }else if(id==R.id.view_btn_menu){
            if(null!=mOnTitleClickListener) mOnTitleClickListener.onMenuClick(v);
        }else if(id==R.id.view_title){
            if(null!=clickCount&&null!=mOnTitleClickListener){
                System.arraycopy(clickCount,1,clickCount,0,clickCount.length - 1);
                clickCount[clickCount.length - 1] = SystemClock.uptimeMillis();
                if (clickCount[0] >= (clickCount[clickCount.length - 1] - 1000)) {
                    if(null!=mOnTitleClickListener) mOnTitleClickListener.onTitleClick(v,true);
                    return;
                }
                if(null!=mOnTitleClickListener) mOnTitleClickListener.onTitleClick(v,false);
            }
        }else if(id==R.id.view_btn_close){
            if(null!=mOnTitleClickListener) mOnTitleClickListener.onClose(v);
        }
    }

    public void setTitle(String title){
        if(null!=mTitleView){
            if(TextUtils.isEmpty(title)){
                mTitleView.setText("");
            }else{
                mTitleView.setText(Html.fromHtml(title));
            }
        }
    }

    public void setTitleSize(int textSize){
        if(null!=mTitleView){
            mTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
        }
    }

    public void setSubTitle(String subTitle) {
        if(null!=mSubTitle){
            mSubTitle.setVisibility(VISIBLE);
            findViewById(R.id.view_btn_menu).setVisibility(GONE);
            mSubTitle.setText(subTitle);
        }
    }

    public abstract static class OnTitleClickListener{
        public void onBack(View view){}
        public void onTitleClick(View view, boolean doubleClick){}
        public void onSubTitleClick(View v){}
        public void onMenuClick(View v){}
        public void onClose(View v) {}
    }

    private OnTitleClickListener mOnTitleClickListener;

    public void setOnTitleClickListener(OnTitleClickListener onTitleClickListener) {
        mOnTitleClickListener = onTitleClickListener;
    }
}