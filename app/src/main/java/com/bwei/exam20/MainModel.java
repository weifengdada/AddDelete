package com.bwei.exam20;

import com.bwei.exam20.callBack.ModelCallBack;
import com.bwei.exam20.okhttp.AbstractUiCallBack;
import com.bwei.exam20.okhttp.OkhttpUtils;

import okhttp3.OkHttpClient;

/**
 * Created by acer on 2017/12/20.
 */

public class MainModel {

         public void getData(final ModelCallBack modelCallBack){
             //访问接口
             String path = "http://120.27.23.105/product/getCarts?source=android&uid=100";
             OkhttpUtils.getInstance().asy(null, path, new AbstractUiCallBack<CartBean>() {
                 @Override
                 public void success(CartBean cartBean) {
                     modelCallBack.success(cartBean);
                 }

                 @Override
                 public void failure(Exception e) {

                 }

             });


         }

}
