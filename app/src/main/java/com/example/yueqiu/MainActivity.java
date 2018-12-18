package com.example.yueqiu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.yueqiu.Adapter.FragmentAdapter;
import com.example.yueqiu.Fragement.FriendsFragment;
import com.example.yueqiu.Fragement.MoreFragment;
import com.example.yueqiu.Fragement.YueFragment;
import com.example.yueqiu.entity.YueEasy;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager viewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this,"954905be70d4f5e4cff3780fb2e13d3f");
        initView();//页面布局初始化
    }

    private void initView() {
        viewPager = findViewById(R.id.view_pager);
        final BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //向viewpager中添加页面
        fragments.add(new YueFragment());
        fragments.add(new MoreFragment());
        fragments.add(new FriendsFragment());
        FragmentAdapter myAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myAdapter);
        viewPager.setOffscreenPageLimit(3);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                navigation.getMenu().getItem(i).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

}
