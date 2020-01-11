package com.android.imusic.web.inteface;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.music.player.lib.util.Logger;

/**
 * Created by TinyHung@outlook.com
 * 2019/7/30
 * APP与H5交互,选择本地图片
 */

public class AndroidWebChromeClient extends WebChromeClient {

    private static final String TAG = "CPAWebChromeClient";
    private Activity mActivity;
    private ValueCallback<Uri[]> onReceiveValue;
    //照片选择
    public static int FILECHOOSER_REQUST_CODE = 1001;
    //视频录制
    public static int RECORD_VIDEO_REQUST_CODE = 1002;
    //文件
    public static int FILE_REQUST_CODE = 1003;
    //录制的视频存储路径
    //private File mOutVideoFile;

    public AndroidWebChromeClient(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * >=5.0图片选择
     * @param webView
     * @param callback
     * @param fileChooserParams
     * @return
     */
    @Override
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> callback, FileChooserParams fileChooserParams) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            openFileChooser(callback,fileChooserParams.getAcceptTypes());
        }
        return true;
    }

    /**
     * 访问本地图片
     * @param callback
     * @param acceptTypes
     */
    private void openFileChooser(ValueCallback<Uri[]> callback, String[] acceptTypes) {
        Logger.d(TAG,"openFileChooser-->");
        if(null!=acceptTypes){
            for (String acceptType : acceptTypes) {
                Logger.d(TAG,"openFileChooser-->acceptTypes:"+acceptType);
            }
        }
        onReceiveValue = callback;
        if(null!=mActivity&&null!=acceptTypes&&acceptTypes.length>0){
            String acceptType = acceptTypes[0];
            if(acceptType.equals("image/*")){
                try {
                    Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
                    contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
                    contentSelectionIntent.setType("image/*");
                    Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
                    chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
                    chooserIntent.putExtra(Intent.EXTRA_TITLE, "选择图片");
                    mActivity.startActivityForResult(chooserIntent, FILECHOOSER_REQUST_CODE);
                }catch (RuntimeException e){
                    e.printStackTrace();
                }
            }else if(acceptType.equals("recomend/*")){
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                //指定保存位置
                //String outPathFileName = AppUtils.getInstance().getOutPutFileName(ApplicationManager.getInstance().getVideoCacheDir(),2);
                //mOutVideoFile = new File(outPathFileName);
                //intent.putExtra(MediaStore.EXTRA_OUTPUT, FileUtils.getInstance().getUriForFile(mActivity.getApplicationContext(),mOutVideoFile));
                //设置拍摄的质量 0：低质量 1：高质量
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
                //限制持续时长,单位秒
                intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 60);
                try {
                    //启动摄像头应用程序
                    mActivity.startActivityForResult(intent, RECORD_VIDEO_REQUST_CODE);
                }catch (RuntimeException e){
                    e.printStackTrace();
                }
            }else {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                try {
                    mActivity.startActivityForResult(intent, FILE_REQUST_CODE);
                }catch (RuntimeException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * WebView组件所在Activity调用
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Logger.d(TAG,"onActivityResult-->requestCode:"+requestCode+",resultCode:"+resultCode);
        if(null!=onReceiveValue){
            if(null!=data){
                Logger.d(TAG,"onActivityResult-->data:"+data.toString());
            }
            //照片选择回执
            if(requestCode==FILECHOOSER_REQUST_CODE){
                Uri result = (null == data || resultCode != Activity.RESULT_OK) ? null : data.getData();
                if (result != null) {
                    onReceiveValue.onReceiveValue(new Uri[]{result});
                } else {
                    onReceiveValue.onReceiveValue(new Uri[]{});
                }
            //视频录制回执
            }else if(requestCode==RECORD_VIDEO_REQUST_CODE){
                Uri result = (null == data || resultCode != Activity.RESULT_OK) ? null : data.getData();
                if (result != null) {
                    onReceiveValue.onReceiveValue(new Uri[]{result});
                } else {
                    onReceiveValue.onReceiveValue(new Uri[]{});
                }
             //文件选择回执
            }else if(requestCode==FILE_REQUST_CODE){
                Uri result = (null == data || resultCode != Activity.RESULT_OK) ? null : data.getData();
                if (result != null) {
                    onReceiveValue.onReceiveValue(new Uri[]{result});
                } else {
                    onReceiveValue.onReceiveValue(new Uri[]{});
                }
            }
        }
    }
}