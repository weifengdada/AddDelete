package com.bwei.exam20;

import com.bwei.exam20.callBack.JoinCallBack;
import com.bwei.exam20.okhttp.AbstractUiCallBack;
import com.bwei.exam20.okhttp.OkhttpUtils;

/**
 * Created by acer on 2017/12/20.
 */

public class JoinModel {

    public void joinCart(final JoinCallBack joinCallBack, String pid) {

        String path="http://120.27.23.105/product/addCart?source=android&uid=100&pid="+pid;
        OkhttpUtils.getInstance().asy(null, path, new AbstractUiCallBack<JoinBean>() {
            @Override
            public void success(JoinBean bean) {

                joinCallBack.success(bean);

            }

            @Override
            public void failure(Exception e) {


            }
        });

    }
}
