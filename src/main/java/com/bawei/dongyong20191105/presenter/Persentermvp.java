package com.bawei.dongyong20191105.presenter;
/*
 *@auther:董青勇
 *@Date: 2019/11/5
 *@Time:9:35
 *@Description:${DESCRIPTION}
 **/

import com.bawei.dongyong20191105.contates.Contates;
import com.bawei.dongyong20191105.model.Modelmvp;

public class Persentermvp implements Contates.Ipresenter {
     private Contates.Iview iview;
     private  Contates.Imodel imodel;

    @Override
    public void attch(Contates.Iview iview) {
         this.iview =iview;
         imodel=new Modelmvp();
    }

    @Override
    public void start(String url) {
       imodel.getInfo(url, new Contates.MyCallBack() {
           @Override
           public void onSccess(String json) {
               iview.onSccess(json);
           }

           @Override
           public void onFilad(String error) {
          iview.onError(error);
           }
       });
    }

    @Override
    public void deattch() {
        if (iview != null) {
            iview=null;
        }
        if (imodel != null) {
            imodel=null;
        }
    }
}
