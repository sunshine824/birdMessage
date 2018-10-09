package com.sunshine824.italker.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sunshine824.common.Common;
import com.sunshine824.common.app.Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends Activity implements IView{

    @BindView(R.id.txt_result)
    TextView mResultText;
    @BindView(R.id.edit_query)
    EditText mInputText;

    private IPresenter mPresenter;

    @Override
    protected int getConentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter = new Presenter(this);
    }

    @OnClick(R.id.btn_submit)
    void onSubmit() {
        mPresenter.search();
    }

    @Override
    public String getInputString() {
        return mInputText.getText().toString();
    }

    @Override
    public void setResultString(String string) {
        mResultText.setText(string);
    }
}
