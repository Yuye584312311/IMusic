package com.android.imusic.store.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.imusic.BuildConfig;
import com.android.imusic.R;
import com.android.imusic.base.BaseFragment;
import com.android.imusic.base.BasePresenter;
import com.android.imusic.music.manager.VersionUpdateManager;
import com.android.imusic.net.Constants;
import com.android.imusic.web.ui.activity.WebViewActivity;

/**
 * Created by TinyHung@Outlook.com
 * 2020/1/11
 */

public class IndexSettingFragment extends BaseFragment{

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initViews() {
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_version:
                        //检查版本更新
                        Toast.makeText(getContext(),"检查新版本中,请稍后...",Toast.LENGTH_LONG).show();
                        VersionUpdateManager.getInstance().checkAppVersion();
                        break;
                    case R.id.btn_server:
                        Intent intent=new Intent(getContext(),WebViewActivity.class);
                        intent.putExtra("url", Constants.SERVICE_USER);
                        intent.putExtra("title","用户协议");
                        startActivity(intent);
                        break;
                    case R.id.btn_private:
                        Intent intent1=new Intent(getContext(),WebViewActivity.class);
                        intent1.putExtra("url",Constants.SERVICE_PRIVATE);
                        intent1.putExtra("title","隐私政策");
                        startActivity(intent1);
                        break;
                }
            }
        };
        findViewById(R.id.btn_version).setOnClickListener(onClickListener);
        findViewById(R.id.btn_server).setOnClickListener(onClickListener);
        findViewById(R.id.btn_private).setOnClickListener(onClickListener);
        ((TextView) findViewById(R.id.tv_version)).setText(BuildConfig.VERSION_NAME);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
