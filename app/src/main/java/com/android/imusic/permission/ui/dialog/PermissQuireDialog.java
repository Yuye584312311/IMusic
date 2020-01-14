package com.android.imusic.permission.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.imusic.R;
import com.android.imusic.base.BaseDialog;
import com.android.imusic.music.utils.MediaUtils;

/**
 * TinyHung@outlook.com
 * 2019/8/21
 * 权限询问对话框
 */

public class PermissQuireDialog extends BaseDialog {

    //是否允许内部关闭弹窗
    private boolean btnClickDismiss = true;

    public static PermissQuireDialog getInstance(Context context) {
        return new PermissQuireDialog(context);
    }

    public PermissQuireDialog(@NonNull Context context) {
        super(context, R.style.CenterDialogAnimationStyle);
        setContentView(R.layout.ad_dialog_permiss_quire_layout);
        MediaUtils.getInstance().setDialogWidth(this);
    }

    @Override
    public void initViews() {
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = v.getId();
                if (i == R.id.btn_submit) {
                    if (btnClickDismiss) {
                        PermissQuireDialog.this.dismiss();
                    }
                    if (null != mOnQueraConsentListener)
                        mOnQueraConsentListener.onConsent(PermissQuireDialog.this);

                } else if (i == R.id.btn_cancel) {
                    if (btnClickDismiss) {
                        PermissQuireDialog.this.dismiss();
                    }
                    if (null != mOnQueraConsentListener)
                        mOnQueraConsentListener.onRefuse(PermissQuireDialog.this);

                }
            }
        };
        findViewById(R.id.btn_submit).setOnClickListener(onClickListener);
        findViewById(R.id.btn_cancel).setOnClickListener(onClickListener);
    }


    @Override
    public void dismiss() {
        super.dismiss();
        if(null!=mOnQueraConsentListener) mOnQueraConsentListener.onDissmiss();
    }

    /**
     * 设置标题
     * @param title
     * @return
     */
    public PermissQuireDialog setTitleText(String title) {
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        if(null!=tvTitle){
            tvTitle.setVisibility(TextUtils.isEmpty(title)? View.GONE: View.VISIBLE);
            tvTitle.setText(title);
        }
        return this;
    }

    /**
     * 设置确定按钮文字内容
     * @param submitTitle
     * @return
     */
    public PermissQuireDialog setSubmitTitleText(String submitTitle) {
        TextView tv_submit = (TextView) findViewById(R.id.btn_submit);
        if(null!=tv_submit) tv_submit.setText(submitTitle);
        return this;
    }

    /**
     * 设置取消文字按钮
     * @param cancelTitleText
     * @return
     */
    public  PermissQuireDialog setCancelTitleText(String cancelTitleText) {
        TextView tv_cancel = (TextView) findViewById(R.id.btn_cancel);
        if(null!=tv_cancel) tv_cancel.setText(cancelTitleText);
        return this;
    }
    /**
     * 设置提示内容
     * @param content
     * @return
     */
    public  PermissQuireDialog setContentText(String content) {
        TextView tv_content = (TextView) findViewById(R.id.tv_content);
        if(null!=tv_content) tv_content.setText(Html.fromHtml(content));
        return this;
    }

    /**
     * 设置标题文字颜色
     * @param color
     * @return
     */
    public  PermissQuireDialog setTitleTextColor(int color) {
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        if(null!=tvTitle) tvTitle.setTextColor(color);
        return this;
    }


    /**
     * 设置确定按钮文字颜色
     * @param color
     * @return
     */
    public PermissQuireDialog setSubmitTitleTextColor(int color) {
        TextView tv_submit = (TextView) findViewById(R.id.btn_submit);
        if(null!=tv_submit) tv_submit.setTextColor(color);
        return this;
    }

    /**
     * 设置取消文字颜色
     * @param color
     * @return
     */
    public  PermissQuireDialog setCancelTitleTextColor(int color) {
        TextView tv_cancel = (TextView) findViewById(R.id.btn_cancel);
        if(null!=tv_cancel) tv_cancel.setTextColor(color);
        return this;
    }

    /**
     * 设置提示内容文字颜色
     * @param color
     * @return
     */
    public  PermissQuireDialog setContentTextColor(int color) {
        TextView tv_content = (TextView) findViewById(R.id.tv_content);
        if(null!=tv_content) tv_content.setTextColor(color);
        return this;
    }

    public PermissQuireDialog setTopImageRes(int resID){
        ImageView imageView = (ImageView) findViewById(R.id.dialog_ic_top);
        if(null!=imageView){
            imageView.setImageResource(resID);
        }
        return this;
    }

    /**
     * 取消按钮显示、隐藏属性
     * @param visibility
     * @return
     */
    public PermissQuireDialog setCancelVisibility(int visibility){
        TextView tv_cancel = (TextView) findViewById(R.id.btn_cancel);
        tv_cancel.setVisibility(visibility);
        return this;
    }
    /**
     * 点击确认、取消按钮时是否自动关闭弹窗
     * @param dismiss 是否自动关闭
     * @return
     */
    public PermissQuireDialog setBtnClickDismiss(boolean dismiss){
        this.btnClickDismiss = dismiss;
        return this;
    }

    /**
     * 是否允许按下返回键关闭弹窗
     * @param isCancelable
     * @return
     */
    public PermissQuireDialog setDialogCancelable(boolean isCancelable){
        this.setCancelable(isCancelable);
        return this;
    }

    /**
     * 是否允许触摸边界关闭此弹窗
     * @param isCanceledOnTouchOutside
     * @return
     */
    public PermissQuireDialog setDialogCanceledOnTouchOutside(boolean isCanceledOnTouchOutside){
        this.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
        return this;
    }

    public abstract static class OnQueraConsentListener{
        public void onConsent(PermissQuireDialog dialog){}
        public void onRefuse(PermissQuireDialog dialog){}
        public void onDissmiss(){}
    }
    private OnQueraConsentListener mOnQueraConsentListener;

    public PermissQuireDialog setOnQueraConsentListener(OnQueraConsentListener onQueraConsentListener) {
        mOnQueraConsentListener = onQueraConsentListener;
        return this;
    }
}