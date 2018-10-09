package com.sunshine824.italker.push;


import android.text.TextUtils;

/**
 * @author chenxin
 * @date 2018\10\8 0008 15:25
 */
public class Presenter implements IPresenter {
    private IView mView;

    public Presenter(IView view){
        mView = view;
    }

    @Override
    public void search() {
        String inputString = mView.getInputString();
        if(TextUtils.isEmpty(inputString)){
            //为空直接返回
            return;
        }

        int hashCode = inputString.hashCode();

        IUserService service = new UserService();
        String serviceResult = service.search(hashCode);
        String result = "Result:" + inputString + "-" + serviceResult;
        mView.setResultString(result);
    }


}
