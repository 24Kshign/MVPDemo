package cn.share.jack.mvpmasterdemo.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import cn.share.jack.cygwidget.utils.CygImageLoader;
import cn.share.jack.mvpmasterdemo.R;
import cn.share.jack.mvpmasterdemo.base.BaseActivity;
import cn.share.jack.cygwidget.sidebar.MySideBar;

/**
 * Created by jack on 2017/6/21
 *
 * @author jack
 */

public class TestActivity extends BaseActivity {

    @BindView(R.id.sidebar)
    MySideBar mySideBar;
    @BindView(R.id.at_tv_indicate)
    TextView tvCenterIndicate;
    @BindView(R.id.at_iv_image)
    ImageView ivImage;

    @Override
    protected int layoutRes() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        CygImageLoader.loadImage("http://img.mukewang.com/551b92340001c9f206000338-300-170.jpg",ivImage);
        mySideBar.setOnTouchLetterChangeListener(new MySideBar.OnTouchLetterChangeListener() {
            @Override
            public void selected(String s) {
                tvCenterIndicate.setVisibility(View.VISIBLE);
                tvCenterIndicate.setText(s);
            }

            @Override
            public void unSelected() {
                tvCenterIndicate.setVisibility(View.GONE);
            }
        });
        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}