package com.bawei.dongyong20191105.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.dongyong20191105.R;
import com.bawei.dongyong20191105.adapter.Myadapter;
import com.bawei.dongyong20191105.bace.BaceFragment;
import com.bawei.dongyong20191105.bean.JsonBean;
import com.bawei.dongyong20191105.contates.Contates;
import com.bawei.dongyong20191105.net.NetStates;
import com.bawei.dongyong20191105.net.NetUtils;
import com.bawei.dongyong20191105.presenter.Persentermvp;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends BaceFragment implements Contates.Iview {

 private String urls="http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
    private XBanner xbanner;
    private GridView gv;
   private Persentermvp persentermvp;
    private List<JsonBean.GriddataBean>list=new ArrayList<>();
   private Myadapter myadapter;

   @Override
    protected int provideLayoutId() {
        return R.layout.fragment_show;
    }

    @Override
    protected void initView(View inflate) {
      //初始化控件
        xbanner= inflate.findViewById(R.id.xbanner);
        gv= inflate.findViewById(R.id.gv);
    }

    @Override
    protected void initData() {
       persentermvp = new Persentermvp();
       persentermvp.attch(this);
       if(NetStates.getInstance().hasNet(getActivity())){
           persentermvp.start(urls);
       }else {
           Toast.makeText(getActivity(), "没有网络", Toast.LENGTH_SHORT).show();

       }
       myadapter = new Myadapter(getActivity(),list);
       //设置适配器
       gv.setAdapter(myadapter);

    }


    @Override
    public void onSccess(String json) {
       JsonBean jsonBean = new Gson().fromJson(json, JsonBean.class);
       final List<JsonBean.BannerdataBean> bannerdata = jsonBean.getBannerdata();
       List<JsonBean.GriddataBean> griddata = jsonBean.getGriddata();
       xbanner.setBannerData(bannerdata);
       xbanner.loadImage(new XBanner.XBannerAdapter() {
          @Override
          public void loadBanner(XBanner banner, Object model, View view, int position) {
             Glide.with(getActivity()).load(bannerdata.get(position).getImageurl()).into((ImageView) view);
          }
       });
        Log.d("tag", "onSccess: "+griddata);
       //添加数据
      list.addAll(griddata);
      //刷新
      myadapter.notifyDataSetChanged();

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (persentermvp != null) {
            persentermvp.deattch();
            persentermvp=null;
        }
    }
}
