package atguigu.com.exer321.paper;

import android.view.View;
import android.widget.TextView;

import atguigu.com.exer321.fragment.BaseFragment;

/**
 * 作者：李银庆 on 2017/5/25 11:33
 */
public class NetVideoPaper extends BaseFragment{
    @Override
    public View initView() {
       TextView tv =  new TextView(context);
        tv.setText("网络视频");
        return tv;
    }

    @Override
    public void initData() {
        super.initData();
    }
}