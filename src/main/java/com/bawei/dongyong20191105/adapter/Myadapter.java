package com.bawei.dongyong20191105.adapter;
/*
 *@auther:董青勇
 *@Date: 2019/11/5
 *@Time:9:46
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dongyong20191105.R;
import com.bawei.dongyong20191105.bean.JsonBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class Myadapter extends BaseAdapter {
   private Context context;
   private List<JsonBean.GriddataBean>list;

    public Myadapter(Context context, List<JsonBean.GriddataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JsonBean.GriddataBean griddataBean = list.get(position);
        ViewHolder holder;
        holder=new ViewHolder();
        if(convertView==null){
            convertView=View.inflate(context, R.layout.layout,null);
            holder.imgg=convertView.findViewById(R.id.imgg);
            holder.name=convertView.findViewById(R.id.name);
            holder.price=convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
            holder.name.setText(griddataBean.getTitle());
        holder.price.setText(griddataBean.getPrice());
        Glide.with(context).load(griddataBean.getImageurl()).into(holder.imgg);

        return convertView;
    }

    class ViewHolder{
        ImageView imgg;
        TextView name,price;
    }

}
