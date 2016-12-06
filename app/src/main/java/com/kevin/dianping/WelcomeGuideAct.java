package com.kevin.dianping;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.kevin.dianping.MainActivity;
import com.kevin.dianping.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */
@ContentView(R.layout.welcome_guide)
public class WelcomeGuideAct extends Activity  {
    @ViewInject(R.id.btn_jump)
    Button btn;
    @ViewInject(R.id.welcome_pager)
    ViewPager viewPager;
    private  List<View> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.welcome_guide);
        x.view().inject(this);
        initViewPager();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getBaseContext(),MainActivity.class));
//                finish();
//            }
//        });
    }
    @Event(value = R.id.btn_jump)
    private void Click(View view){
        switch (view.getId()){
            case R.id.btn_jump:
                Toast.makeText(this,"hahaha",Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(WelcomeGuideAct.this,MainActivity.class));
                break;
        }
    }

    public void initViewPager(){
        list= new ArrayList<>();
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.guide_01);
        list.add(imageView1);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.guide_02);
        list.add(imageView2);
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.drawable.guide_03 );
        list.add(imageView3);
        viewPager.setAdapter(new MyPagerAdapter());
        //监听viewPager滑动效果
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            //页卡被选中



            @Override
            public void onPageSelected(int position) {
                if(position==2){
                    btn.setVisibility(View.VISIBLE);
                }else {
                    btn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        //初始化item的实例
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }
        //item销毁的方法
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);//按钮会报错，父类要注销点
            container.removeView(list.get(position));
        }
    }
}
