package com.jy.msdk.splash;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.jy.msdk.MSdk;
import com.jy.msdk.open.SdkFuns;
import com.jy.msdk.uils.LogUtils;

import java.lang.ref.WeakReference;

/**
 * 欢迎界面
 */
public abstract class MSdkSplashActivity extends Activity {

    public static final int STARTGAMEACTIVITY = 0;

    private static final String PORTRAIT_SPLASH_IMAGE_NAME = "msdk_splash_img_portrait";

    private static final String LANDSCAPE_SPLASH_IMAGE_NAME = "msdk_splash_img_landscape";

    public MH mh = new MH(this);

    private RelativeLayout content;

    private ImageView imageView;

    public int time = 2000; //默认为两秒

    private int splash_image_res_id = 0; //闪屏图片资源id

    /**
     * 设置闪屏界面持续时间，如果第三方已经有了闪屏，就闪第三方
     * 注意如果项目中没有Msdk_splash_img这张图片，这个数值就会在post延迟任务时设为0
     *
     * @param time
     */
    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return this.time;
    }

    //如果使用全局静态变量，就必须在使用finish()之后调用System.exit(0)方法退出MainActivity，不然进程里面还会保留这个变量

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        splash_image_res_id = getResources().getIdentifier(PORTRAIT_SPLASH_IMAGE_NAME, "drawable", getPackageName());
        if (MSdk.isLandscape()) {
            LogUtils.d("横屏");
            splash_image_res_id = getResources().getIdentifier(LANDSCAPE_SPLASH_IMAGE_NAME, "drawable", getPackageName());
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        //百度这家的sdk本身就自带闪屏，执行sdk初始化的时候就会自动显示闪屏，
        //如果当前sdk支持闪屏，就不用了
        if (SdkFuns.getInstance().isSupportSplash()) {
            SdkFuns.getInstance().startSplash(this, imageView);
        } else {
            startSplash();
        }
    }

    private void initView() {
        content = new RelativeLayout(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        content.setLayoutParams(lp);
        imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(lp);
        content.addView(imageView);
        setContentView(content);
    }

    /*
    微信登录Bug记录：如果有将闪屏Activity设置了主启动Activity，如果不做处理，当授权完毕后，
    会回到闪屏Activity，导致在一次启动MainActivity
   */
    public void startSplash() {
        isInSplash = true;
        if (splash_image_res_id == 0) {
            time = 0;
        }
        if (time == 0) {
            startGameActivity();
            finish();
        } else {
            //如果在任务执行时，按返回键走onDestroy 方法需要将
            imageView.setBackgroundResource(splash_image_res_id);
            goSplash();
        }
    }

    private void goSplash() {
        SplashTask task = new SplashTask();
        mh.postDelayed(task, time);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (!isInSplash) {
            goSplash();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isInSplash) {
            goSplash();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isInSplash = false;
        mh.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onStop() {
        super.onStop();
        isInSplash = false;
        mh.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mh.removeCallbacksAndMessages(null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            return true;
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 将返回键禁用
     */
    @Override
    public void onBackPressed() {

    }

    public void postTaskDelayed(Runnable task, long delayMillis) {
        mh.postDelayed(task, delayMillis);
    }

    public void postMessageDelayed(Message msg, long delayMillis) {
        mh.sendMessageDelayed(msg, delayMillis);
    }

    public abstract void startGameActivity();

    static class MH extends Handler {

        private WeakReference<Context> mContextRef;

        public MH(Context context) {
            this.mContextRef = new WeakReference<Context>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MSdkSplashActivity act = (MSdkSplashActivity) mContextRef.get();
            if (act == null)
                return;
            switch (msg.arg1) {
                case STARTGAMEACTIVITY:
                    act.startGameActivity();
                    act.finish();
                    break;
            }
        }
    }

    public boolean isInSplash = false;

    class SplashTask implements Runnable {

        @Override
        public void run() {
            startGameActivity();
            finish();
        }
    }


}
