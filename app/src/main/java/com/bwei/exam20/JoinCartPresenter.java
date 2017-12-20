package com.bwei.exam20;

import com.bwei.exam20.callBack.JoinCallBack;
import com.bwei.exam20.callBack.JoinView;

/**
 * Created by acer on 2017/12/20.
 */

public class JoinCartPresenter {
    JoinView joinView;
    JoinModel joinModel;
    public JoinCartPresenter(JoinView joinView) {
        this.joinView=joinView;
        this.joinModel=new JoinModel();
    }

    public void joinCart(String pid){

        joinModel.joinCart(new JoinCallBack() {
            @Override
            public void success(JoinBean bean) {
                if(joinView!=null){
                    joinView.success(bean);
                }
            }
        },pid);

    }
}
