package com.bawei.dongyong20191105.net;
/*
 *@auther:董青勇
 *@Date: 2019/11/5
 *@Time:9:17
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetStates {
    static  NetStates netStates=new NetStates();

    public static NetStates getInstance() {
        return netStates;
    }

    private NetStates() {
    }

    public  boolean  hasNet(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()) {
            return  true;
        }else {
            return false;
        }

    }
    public  boolean  isWifi(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()&&activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI) {
            return  true;
        }else {
            return false;
        }

    }
    public  boolean  isMpbile(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()&&activeNetworkInfo.getType()==ConnectivityManager.TYPE_MOBILE) {
            return  true;
        }else {
            return false;
        }

    }

}
