package com.bawei.dongyong20191105.model;
/*
 *@auther:董青勇
 *@Date: 2019/11/5
 *@Time:9:33
 *@Description:${DESCRIPTION}
 **/

import com.bawei.dongyong20191105.contates.Contates;
import com.bawei.dongyong20191105.net.NetUtils;

public class Modelmvp implements Contates.Imodel {
    @Override
    public void getInfo(String url, final Contates.MyCallBack myCallBack) {
        NetUtils.getInstance().doGet(url, new NetUtils.MyCallBack() {
            @Override
            public void onDoGetSccess(String json) {
                myCallBack.onSccess(json);
            }

            @Override
            public void onErrorSccess(String error) {
             myCallBack.onFilad(error);
            }
        });
    }

    @Override
    public void postInfo(String url, Contates.MyCallBack myCallBack) {

    }
}
