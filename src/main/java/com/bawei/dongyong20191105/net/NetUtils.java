package com.bawei.dongyong20191105.net;
/*
 *@auther:董青勇
 *@Date: 2019/11/5
 *@Time:9:20
 *@Description:${DESCRIPTION}
 **/

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetUtils {
    static  NetUtils netUtils=new NetUtils();

    public static NetUtils getInstance() {
        return netUtils;
    }

    private NetUtils() {
    }
    public  interface  MyCallBack{
        void onDoGetSccess(String json);
        void onErrorSccess(String error);
    }


    public void doGet(final String temUrl, final MyCallBack myCallBack){
        new AsyncTask<String, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                if(s.isEmpty()){
                    myCallBack.onErrorSccess("请求失败");
                }else {
                    myCallBack.onDoGetSccess(s);
                }
            }

            @Override
            protected String doInBackground(String... strings) {
                String json="";
                HttpURLConnection httpURLConnection=null;
                InputStream inputStream=null;
                try {
                    URL url = new URL(temUrl);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                   httpURLConnection.setConnectTimeout(5000);
                   httpURLConnection.connect();
                   if(httpURLConnection.getResponseCode()==200){
                        inputStream = httpURLConnection.getInputStream();
                       json = ioString(inputStream);
                   }

                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }

                return json;
            }
        }.execute();


    }

    public String ioString(InputStream inputStream) {
        String s="";

        try {
            byte[] bytes = new byte[1024];
            int i=-1;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ((i=inputStream.read(bytes))!=-1){
                 byteArrayOutputStream.write(bytes,0,i);
            }
            byte[] bytes1 = byteArrayOutputStream.toByteArray();
            s = new String(bytes1);

        }catch (java.io.IOException e) {
            e.printStackTrace();
        }
         return s;
    }


}
