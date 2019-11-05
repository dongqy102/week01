package com.bawei.dongyong20191105;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.dongyong20191105.bace.BaceActivity;
import com.bawei.dongyong20191105.fragment.BlankFragment;
import com.bawei.dongyong20191105.fragment.ShowFragment;

import java.util.ArrayList;

public class MainActivity extends BaceActivity {


    private ViewPager vp;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioGroup rg;
    private ArrayList<Fragment> list;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
       vp=findViewById(R.id.vp);
       rg=findViewById(R.id.rg);
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        ShowFragment showFragment = new ShowFragment();
        BlankFragment blankFragment = new BlankFragment();
        BlankFragment my = new BlankFragment();

        list.add(showFragment);
        list.add(blankFragment);
        list.add(my);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
            rg.check(rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        vp.setCurrentItem(0);break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);break;
                }

            }
        });

    }


}
