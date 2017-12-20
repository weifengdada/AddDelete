package com.bwei.exam20;

import com.bwei.exam20.callBack.MainView;
import com.bwei.exam20.callBack.ModelCallBack;

/**
 * Created by acer on 2017/12/20.
 */

public class MainPresenter {
    MainView mainView;
    MainModel mainModel;

    public MainPresenter(MainView mainView) {
        this.mainView=mainView;
        this.mainModel=new MainModel();
    }
    public void get(){
         mainModel.getData(new ModelCallBack() {
             @Override
             public void success(CartBean bean) {
                 if(mainView!=null){
                     mainView.success(bean);
                 }
             }
         });


    }
}
