package com.bawei.dongyong20191105.contates;
/*
 *@auther:董青勇
 *@Date: 2019/11/5
 *@Time:9:30
 *@Description:${DESCRIPTION}
 **/

public interface Contates {

    interface MyCallBack{
        void  onSccess(String json);
        void  onFilad(String error);
    }
     interface  Imodel{
        void getInfo(String url,MyCallBack myCallBack);
        void postInfo(String url,MyCallBack myCallBack);
     }
     interface  Iview{
         void  onSccess(String json);
         void  onError(String error);
     }
     interface  Ipresenter{
        void attch(Iview iview);
         void start(String url);
      void  deattch();
     }



}
