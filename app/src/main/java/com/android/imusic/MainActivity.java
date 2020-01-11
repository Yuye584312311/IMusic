package com.android.imusic;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.imusic.base.BaseActivity;
import com.android.imusic.base.BasePresenter;
import com.android.imusic.music.activity.MusicLockActivity;
import com.android.imusic.music.activity.MusicPlayerActivity;
import com.android.imusic.music.adapter.MusicFragmentPagerAdapter;
import com.android.imusic.music.dialog.QuireDialog;
import com.android.imusic.store.fragment.IndexSettingFragment;
import com.android.imusic.music.utils.TextViewSpannable;
import com.android.imusic.net.Constants;
import com.android.imusic.store.listener.OnSpannableClickListener;
import com.android.imusic.web.ui.activity.WebViewActivity;
import com.music.player.lib.manager.SqlLiteCacheManager;
import com.android.imusic.music.manager.VersionUpdateManager;
import com.android.imusic.music.ui.fragment.IndexMusicFragment;
import com.android.imusic.music.utils.MediaUtils;
import com.android.imusic.net.OkHttpUtils;
import com.android.imusic.video.activity.VideoPlayerActviity;
import com.music.player.lib.bean.BaseAudioInfo;
import com.music.player.lib.constants.MusicConstants;
import com.music.player.lib.listener.MusicInitializeCallBack;
import com.music.player.lib.listener.MusicPlayerInfoListener;
import com.music.player.lib.manager.MusicPlayerManager;
import com.music.player.lib.model.MusicPlayerConfig;
import com.music.player.lib.util.Logger;
import com.music.player.lib.util.MusicRomUtil;
import com.music.player.lib.util.MusicUtils;
import com.video.player.lib.manager.VideoPlayerManager;
import com.video.player.lib.manager.VideoWindowManager;
import java.util.ArrayList;
import java.util.List;

/**
 * TinyHung@Outlook.com
 * 2019/3/17
 * iMusic
 * Main
 */

public class MainActivity extends BaseActivity {

    private long currentMillis=0;
    private TextView mBtnMusic,mBtnVideo;
    private ViewPager mViewPager;
    private MusicFragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //视频、音乐播放器初始化
        initConfig();
        mBtnMusic = (TextView) findViewById(R.id.music_btn_music);
        mBtnMusic.setSelected(true);
        mBtnVideo = (TextView) findViewById(R.id.music_btn_video);
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.music_btn_music:
                        mBtnVideo.setSelected(false);
                        mBtnMusic.setSelected(true);
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.music_btn_video:
                        mBtnMusic.setSelected(false);
                        mBtnVideo.setSelected(true);
                        mViewPager.setCurrentItem(1);
                        break;
                }
            }
        };
        mBtnMusic.setOnClickListener(onClickListener);
        mBtnVideo.setOnClickListener(onClickListener);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new IndexMusicFragment());
        fragments.add(new IndexSettingFragment());
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){

            }

            @Override
            public void onPageSelected(int position) {
                if(0==position){
                    mBtnVideo.setSelected(false);
                    mBtnMusic.setSelected(true);
                }else if(1==position){
                    mBtnMusic.setSelected(false);
                    mBtnVideo.setSelected(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mPagerAdapter = new MusicFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mPagerAdapter);

        //当APP被回收或者用户退出了APP，音乐还在后台播放，点击通知栏时会将正在播放的音频ID传到此处
        long audioID = getIntent().getLongExtra(MusicConstants.KEY_MUSIC_ID, 0);
        if(audioID>0){
            startToMusicPlayer(audioID);
        }
        initMain();
    }

    /**
     * 初始化
     */
    private void initMain() {
        if(0== MusicUtils.getInstance().getInt(Constants.SP_KEY_SERVICE,0)){
            Spanned spanned = Html.fromHtml(getServiceAgreement());
            QuireDialog instance = QuireDialog.getInstance(this);
            SpannableString formatContent = TextViewSpannable.getInstance().formatContent(spanned,instance.getContentTextView(),
                    Color.parseColor("#4DB7FF"),new OnSpannableClickListener() {
                        @Override
                        public void onServiceClick(String service) {
                            Logger.d(TAG, "service:" + service);
                            if(Constants.TEXT_USER_SERVICE.equals(service)){
                                Intent intent=new Intent(MainActivity.this,WebViewActivity.class);
                                intent.putExtra("url", Constants.SERVICE_USER);
                                intent.putExtra("title","用户协议");
                                startActivity(intent);
                            }else if(Constants.TEXT_USER_ITEM.equals(service)){
                                Intent intent1=new Intent(MainActivity.this,WebViewActivity.class);
                                intent1.putExtra("url",Constants.SERVICE_PRIVATE);
                                intent1.putExtra("title","隐私政策");
                                startActivity(intent1);
                            }
                        }
                    }, null);
            instance.setTitleText("用户协议及隐私条款")
                    .setContentText(formatContent)
                    .setContextGravity(Gravity.NO_GRAVITY)
                    .setSubmitTitleText("我同意")
                    .setCancelTitleText("不同意并退出")
                    .setContentTextSize(MusicUtils.getInstance().dpToPxInt(MainActivity.this,14f))
                    .setContentTextColor(Color.parseColor("#333333"))
                    .setDialogCancelable(false)
                    .setDialogCanceledOnTouchOutside(false)
                    .setOnQueraConsentListener(new QuireDialog.OnQueraConsentListener() {
                        @Override
                        public void onConsent(QuireDialog dialog) {
                            MusicUtils.getInstance().putInt(Constants.SP_KEY_SERVICE,1);
                            requstPermissions();
                        }

                        @Override
                        public void onRefuse(QuireDialog dialog) {
                            System.exit(0);
                        }
                    }).show();
            return;
        }
        requstPermissions();
    }

    public String getServiceAgreement(){
        String html="<font>我们依据最新法律，向您说明趣音乐软件的用户服务协议，特向您推送本提示；请阅读并充分理解相关协议。" +
                "<br/>" +
                "<br/>" +
                "<strong>我们承诺</strong>" +
                "<br/>" +
                "我们会严格按照\"网络安全法\"、\"信息网络传播保护条例\"等保护您的个人信息；" +
                "<br/>" +
                "如果未经您的授权，我们不会使用您的个人信息作为您未授权的其他的目的。" +
                "<br/>" +
                "<br/>" +
                "点击“同意”，即表示您已阅读并同意\"用户协议\"，阅读完整版" +
                "<font color='#4DB7FF'>"+ Constants.TEXT_USER_SERVICE+"</font>及"+
                "<font color='#4DB7FF'>"+ Constants.TEXT_USER_ITEM+"</font>"+
                "</font>";
        return html;
    }

    /**
     * 完整的初始化
     */
    private void initConfig() {
        //视频播放器初始化
        VideoPlayerManager.getInstance()
                //循环模式
                .setLoop(true)
                //悬浮窗中打开播放器的绝对路径
                .setPlayerActivityClassName(VideoPlayerActviity.class.getCanonicalName());

        //音乐播放器配置
        MusicPlayerConfig config=MusicPlayerConfig.Build()
                //设置默认的闹钟定时关闭模式，优先取用户设置
                .setDefaultAlarmModel(MusicConstants.MUSIC_ALARM_MODEL_0)
                //设置默认的循环模式，优先取用户设置
                .setDefaultPlayModel(MusicConstants.MUSIC_MODEL_LOOP);

        //音乐播放器初始化
        MusicPlayerManager.getInstance()
                //内部存储初始化
                .init(getApplicationContext())
                //应用播放器配置
                .setMusicPlayerConfig(config)
                //通知栏交互，默认开启
                .setNotificationEnable(true)
                //常驻进程开关，默认开启
                .setLockForeground(true)
                //设置点击通知栏跳转的播放器界面,需开启常驻进程开关
                .setPlayerActivityName(MusicPlayerActivity.class.getCanonicalName())
                //设置锁屏界面，如果禁用，不需要设置或者设置为null
                .setLockActivityName(MusicLockActivity.class.getCanonicalName())
                //监听播放状态
                .setPlayInfoListener(new MusicPlayerInfoListener() {
                    //此处自行存储播放记录
                    @Override
                    public void onPlayMusiconInfo(BaseAudioInfo musicInfo, int position) {
                        SqlLiteCacheManager.getInstance().insertHistroyAudio(musicInfo);
                    }
                })
                //重载方法，初始化音频媒体服务,成功之后如果系统还在播放音乐，则创建一个悬浮窗承载播放器
                .initialize(MainActivity.this, new MusicInitializeCallBack() {

                    @Override
                    public void onSuccess() {
                        //如果系统正在播放音乐
                        if(null!=MusicPlayerManager.getInstance().getCurrentPlayerMusic()){
                            MusicPlayerManager.getInstance().createWindowJukebox();
                        }
                    }
                });

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void onRequstPermissionResult(int resultCode) {
        super.onRequstPermissionResult(resultCode);
        if(resultCode==PREMISSION_SUCCESS){
            if(null!=mPagerAdapter&&mPagerAdapter.getCount()>0){
                try {
                    if(mPagerAdapter.getItem(0) instanceof IndexMusicFragment){
                        ((IndexMusicFragment) mPagerAdapter.getItem(0)).queryLocationMusic(MainActivity.this);
                    }
                }catch (RuntimeException e){
                    e.printStackTrace();
                }
            }
        }
        //检查并获取通知权限
        boolean premission = MusicUtils.getInstance().hasNiticePremission(getApplicationContext());
        if(!premission){
            QuireDialog.getInstance(MainActivity.this)
                    .setTitleText(getString(R.string.text_sys_tips))
                    .setContentText(getString(R.string.text_tips_notice))
                    .setSubmitTitleText(getString(R.string.text_start_open))
                    .setCancelTitleText(getString(R.string.music_text_cancel))
                    .setTopImageRes(R.drawable.ic_setting_tips4)
                    .setOnQueraConsentListener(new QuireDialog.OnQueraConsentListener() {
                        @Override
                        public void onConsent(QuireDialog dialog) {
                            try {
                                Intent intent = new Intent();
                                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                Uri uri = Uri.fromParts("package", getPackageName(), null);
                                intent.setData(uri);
                                startActivity(intent);
                            }catch (RuntimeException e){
                                e.printStackTrace();
                            }
                        }
                    }).show();
        }else{
            if(MusicUtils.getInstance().getInt(MusicConstants.SP_FIRST_START,0)==0){
                //使用提示
                QuireDialog.getInstance(MainActivity.this)
                        .setTitleText(getString(R.string.text_action_tips))
                        .setContentText(getString(R.string.text_action_content))
                        .setSubmitTitleText(getString(R.string.text_start_now_open))
                        .setCancelTitleText(getString(R.string.text_yse))
                        .setTopImageRes(R.drawable.ic_setting_tips1)
                        .setBtnClickDismiss(false)
                        .setOnQueraConsentListener(new QuireDialog.OnQueraConsentListener() {
                            @Override
                            public void onConsent(QuireDialog dialog) {
                                MediaUtils.getInstance().setLocalImageEnable(true);
                                Toast.makeText(MainActivity.this, getString(R.string.text_start_open_success),
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }

                            @Override
                            public void onRefuse(QuireDialog dialog) {
                                dialog.dismiss();
                            }

                            @Override
                            public void onDissmiss() {
                                Logger.d(TAG,"onDissmiss--->");
                                if(MusicRomUtil.getInstance().isMiui()){
                                    showXiaoMiTips();
                                }else{
                                    //检查版本更新
                                    VersionUpdateManager.getInstance().checkAppVersion();
                                }
                            }
                        }).show();
                MusicUtils.getInstance().putInt(MusicConstants.SP_FIRST_START,1);
            }else{
                //检查版本更新
                VersionUpdateManager.getInstance().checkAppVersion();
            }
        }
    }

    /**
     * 小米用户使用提示
     */
    private void showXiaoMiTips() {
        QuireDialog.getInstance(MainActivity.this)
                .setTitleText(getString(R.string.text_xiao_tips_title))
                .setContentText(getString(R.string.text_xiao_tips_content))
                .setSubmitTitleText(getString(R.string.text_xiao_tips_close))
                .setCancelTitleText(getString(R.string.text_yse))
                .setTopImageRes(R.drawable.ic_setting_tips2)
                .setOnQueraConsentListener(new QuireDialog.OnQueraConsentListener() {
                    @Override
                    public void onDissmiss() {
                        VersionUpdateManager.getInstance().checkAppVersion();
                    }
                }).show();
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
        //第一遍只是退出全屏、迷你窗口播放器至常规状态
        if(VideoPlayerManager.getInstance().isBackPressed(false)){
            long millis = System.currentTimeMillis();
            if(0 == currentMillis | millis-currentMillis > 2000){
                Toast.makeText(MainActivity.this,getString(R.string.text_back_tips)+getResources().getString(R.string.app_name),Toast.LENGTH_SHORT).show();
                currentMillis=millis;
                return;
            }
            currentMillis=millis;
            //第二遍才是结束播放
            if(VideoPlayerManager.getInstance().isBackPressed(true)){
                super.onBackPressed();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        VideoPlayerManager.getInstance().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        VideoPlayerManager.getInstance().onPause();
    }

    /**
     * 悬浮窗释放
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        VideoPlayerManager.getInstance().onDestroy();
        VideoWindowManager.getInstance().onDestroy();
        //播放器反初始化。此方法为重载方法，请阅读内部入参说明
        MusicPlayerManager.getInstance().unInitialize(MainActivity.this);
        OkHttpUtils.getInstance().onDestroy();
        if(null!=mPagerAdapter){
            mPagerAdapter.onDestroy();
            mPagerAdapter=null;
        }
    }
}