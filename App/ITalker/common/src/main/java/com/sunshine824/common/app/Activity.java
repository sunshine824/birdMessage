package com.sunshine824.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author chenxin
 * @date 2018\9\25 0025 18:11
 */
public abstract class Activity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在界面未初始化之前调用的初始化窗口
        initWindows();

        if(initArgs(getIntent().getExtras())){
            getConentLayoutId();
            initWidget();
            initData();
        }else {
            finish();
        }
    }

    /**
     * 初始化窗口
     */
    protected void initWindows(){

    }

    /**
     * 初始化相关参数
     * @param bundle  参数Bundle
     * @return 如果参数正确true，错误false
     */
    protected boolean initArgs(Bundle bundle){
        return true;
    }

    /**
     * 得到当前界面的资源文件Id
     * 注：子类必须复写
     * @return 资源文件Id
     */
    protected abstract int getConentLayoutId();

    /**
     * 初始化控件
     */
    protected void initWidget(){

    }

    /**
     * 初始化数据
     */
    protected void initData(){

    }

    @Override
    public boolean onSupportNavigateUp() {
        //当点击界面导航返回时，Finish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {


        super.onBackPressed();
        finish();
    }
}
