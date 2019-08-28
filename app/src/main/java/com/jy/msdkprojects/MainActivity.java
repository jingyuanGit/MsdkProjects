package com.jy.msdkprojects;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jy.msdk.MSdk;
import com.jy.msdk.bean.OrderInfo;
import com.jy.msdk.bean.RoleInfo;
import com.jy.msdk.listeners.ExitListener;
import com.jy.msdk.listeners.InitListener;
import com.jy.msdk.listeners.LoginListener;
import com.jy.msdk.listeners.LogoutListener;
import com.jy.msdk.listeners.PayListener;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private static final String TAG = "MSDKLOG";
    TextView userInfoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        MSdk.onCreate(this);
    }

    private void initView() {
        Button upUserInfoBtn = findView(R.id.btn_uploadUserInfo);
        Button loginBtn = findView(R.id.btn_login);
        Button payBtn = findView(R.id.btn_pay);
        Button logoutBtn = findView(R.id.btn_logout);
        Button exitBtn = findView(R.id.btn_finish);
        userInfoTv = findView(R.id.tv_userInfo);
        upUserInfoBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        payBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // 生命周期接口调用(必接)
        MSdk.onRestart(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 生命周期接口调用(必接)
        MSdk.onStart(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 生命周期接口调用(必接)
        MSdk.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 生命周期接口调用(必接)
        MSdk.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 生命周期接口调用(必接)
        MSdk.onStop(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 生命周期接口调用(必接)
        MSdk.onDestroy(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // 生命周期接口调用(必接)
        MSdk.onNewIntent(this, intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 生命周期接口调用(必接)
        MSdk.onActivityResult(this, requestCode, resultCode, data);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 生命周期接口调用(必接)
        MSdk.onConfigurationChanged(newConfig, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MSdk.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_login:
                MSdk.login(this);
                break;
            case R.id.btn_logout:
                MSdk.logout(this);
                break;
            case R.id.btn_pay:
                doPay();
                break;
            case R.id.btn_uploadUserInfo:
                setUserInfo();
                break;
            case R.id.btn_finish:
                exit();
                break;
            default:
                break;
        }
    }

    // 如果是unity开发的游戏，需要把onBackPressed和onKeyDown注释掉
    @Override
    public void onBackPressed() {
        exit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void doPay() {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setServerId("1");// 服务器ID，其值必须为数字字符串
        roleInfo.setServerName("火星服务器");// 服务器名称
        roleInfo.setRoleName("裁决之剑");// 角色名称
        roleInfo.setRoleId("1121121");// 角色ID
        roleInfo.setRoleLevel(12);// 等级
        roleInfo.setVipLevel("Vip4");// VIP等级
        roleInfo.setRoleBalance("5000");// 角色现有金额
        roleInfo.setPartyName("");// 公会名字

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setProductName("宝宝");
        orderInfo.setProductDesc("这是用来买道具的");
        orderInfo.setAmount(100); // 总价格
        orderInfo.setExtraInfo("comsdfsdf_sdfsdfdsfsd"); // 透传参数
        MSdk.pay(this, orderInfo, roleInfo);

    }

    /**
     * 向渠道提交用户信息。 在创建游戏角色、进入游戏和角色升级3个地方调用此接口，当创建角色时最后一个参数值为true，其他两种情况为false。
     * GameRoleInfo所有字段均不能传null，游戏没有的字段请传一个默认值或空字符串。
     */
    private void setUserInfo() {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setServerId("1");// 服务器ID
        roleInfo.setServerName("火星服务器");// 服务器名称
        roleInfo.setRoleName("裁决之剑");// 角色名称
        roleInfo.setRoleId("1121121");// 角色ID
        roleInfo.setRoleLevel(12);// 等级
        roleInfo.setVipLevel("9"); // 设置当前用户vip等级，必须为整型字符串
        roleInfo.setRoleBalance("5000"); // 角色现有金额
        roleInfo.setPartyName("无敌联盟"); // 设置帮派，公会名称
        roleInfo.setRoleCreateTime(1473141432); // UC与1881渠道必传，值为10位数时间戳
        roleInfo.setPartyId("1100"); // 360渠道参数，设置帮派id，必须为整型字符串
        roleInfo.setRoleGender("男"); // 360渠道参数
        roleInfo.setRolePower("38"); // 360渠道参数，设置角色战力，必须为整型字符串
        roleInfo.setPartyRoleId("11"); // 360渠道参数，设置角色在帮派中的id
        roleInfo.setPartyRoleName("帮主"); // 360渠道参数，设置角色在帮派中的名称
        roleInfo.setProfessionId("38"); // 360渠道参数，设置角色职业id，必须为整型字符串
        roleInfo.setProfession("法师"); // 360渠道参数，设置角色职业名称
        roleInfo.setFriendList("无"); // 360渠道参数，设置好友关系列表，格式请参考：http://open.quicksdk.net/help/detail/aid/190
        MSdk.submitRoleInfo(this, roleInfo);
    }

    private void exit() {
        // 先判断渠道是否有退出框，如果有则直接调用quick的exit接口
        if (MSdk.isHaveExitDialog()) {
            MSdk.exit(this);
        } else {
            // 游戏调用自身的退出对话框，点击确定后，调用quick的exit接口
            new AlertDialog.Builder(this)
                    .setTitle("退出")
                    .setMessage("是否退出游戏?")
                    .setPositiveButton("确定",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0,
                                                    int arg1) {
                                    System.exit(0);
                                }
                            }).setNegativeButton("取消", null).show();
        }
    }

    private <T extends View> T findView(int id) {
        T view = (T) findViewById(id);
        return view;
    }

    private void initListener() {
        MSdk.setLoginListener(new LoginListener() {
            @Override
            public void onSuccess(String userId) {
                Log.d(TAG, "onSuccess: " + userId);
                userInfoTv.setText("登录成功：" + userId);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onFailed(int code, String message) {

            }
        });

        MSdk.setLogoutListener(new LogoutListener() {
            @Override
            public void onSuccess() {
                userInfoTv.setText("登出成功");
            }

            @Override
            public void onFailed(int code, String message) {

            }
        });

        MSdk.setPayListener(new PayListener() {
            @Override
            public void onSuccess(String orderId, String cpOrderId, String extraInfo) {

            }

            @Override
            public void onCancel(String cpOrderId) {

            }

            @Override
            public void onFailed(int code, String cpOrderId, String message) {

            }
        });

        MSdk.setExitListener(new ExitListener() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailed(String message) {

            }
        });
    }


}
