package atguigu.com.exer321;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;

import atguigu.com.exer321.fragment.BaseFragment;
import atguigu.com.exer321.paper.LocalAudioPaper;
import atguigu.com.exer321.paper.LocalVideoPaper;
import atguigu.com.exer321.paper.NetAudioPaper;
import atguigu.com.exer321.paper.NetVideoPaper;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl_content;
    private RadioGroup rg_main;
    private int position;
    private ArrayList<BaseFragment> fragments;
    private Fragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        initDate();

        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_local_video:
                        position = 0;
                        break;
                    case R.id.rb_local_audio:
                        position = 1;
                        break;
                    case R.id.rb_net_audio:
                        position = 2;
                        break;
                    case R.id.rb_net_video:
                        position = 3;
                        break;
                }
                BaseFragment baseFragment = fragments.get(position);
                showFragment(baseFragment);
            }
        });
        rg_main.check(R.id.rb_local_video);

    }

    private void showFragment(BaseFragment baseFragment) {
        if (tempFragment != baseFragment) {
            FragmentManager sm = getSupportFragmentManager();
            FragmentTransaction ft = sm.beginTransaction();
            if(!baseFragment.isAdded()){
                if(tempFragment != null){
                    ft.hide(tempFragment);
                }
                ft.add(R.id.fl_content,baseFragment);
            }else {
                if(tempFragment != null){
                    ft.hide(tempFragment);
                }
                ft.show(baseFragment);
            }

            ft.commit();
            tempFragment =baseFragment;
        }

    }

    private void initDate() {
        fragments = new ArrayList<>();
        fragments.add(new LocalVideoPaper());
        fragments.add(new LocalAudioPaper());
        fragments.add(new NetAudioPaper());
        fragments.add(new NetVideoPaper());
    }
}
