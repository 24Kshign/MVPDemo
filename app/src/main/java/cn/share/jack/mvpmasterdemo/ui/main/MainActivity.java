package cn.share.jack.mvpmasterdemo.ui.main;

import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import cn.share.jack.cygwidget.recyclerview.PtrRecyclerViewUIComponent;
import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.recyclerview.divider.RecyclerViewDivider;
import cn.share.jack.cygwidget.refersh.OnPullToRefreshListener;
import cn.share.jack.cygwidget.titlebar.TitleBarUIComponent;
import cn.share.jack.mvpmasterdemo.R;
import cn.share.jack.mvpmasterdemo.model.main.MainInfo;
import cn.share.jack.mvpmasterdemo.presenter.main.MainPresenter;
import cn.share.jack.mvpmasterdemo.ui.BaseActivity;
import cn.share.jack.mvpmasterdemo.ui.main.adapter.MainAdapter;
import cn.share.jack.mvpmasterdemo.ui.main.adapter.MainViewHolder;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView, CygBaseRecyclerAdapter.OnItemClickListener<MainViewHolder> {

    @BindView(R.id.am_titlebar)
    TitleBarUIComponent titleBarUIComponent;
    @BindView(R.id.am_ptr_framelayout)
    PtrRecyclerViewUIComponent ptrRecyclerViewUIComponent;
    private MainAdapter mAdapter;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        titleBarUIComponent.initTitle("首页");
        titleBarUIComponent.setBackgroundResource(R.color.colorPrimary);
        mAdapter = new MainAdapter(this, this);
        ptrRecyclerViewUIComponent.setLayoutManager(new LinearLayoutManager(this));
        ptrRecyclerViewUIComponent.setRecyclerViewDivider(new RecyclerViewDivider(this));
        ptrRecyclerViewUIComponent.setAdapter(mAdapter);

        ptrRecyclerViewUIComponent.delayRefresh(100);
        ptrRecyclerViewUIComponent.setOnPullToRefreshListener(new OnPullToRefreshListener() {
            @Override
            public void onPullToRefresh() {
                mPresenter.getArticleData(MainActivity.this);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        moveTaskToBack(true);
        return super.onKeyDown(keyCode, event);
    }

    private void runOnMainThread() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ptrRecyclerViewUIComponent.refreshComplete();
            }
        });
    }

    @Override
    public void getArticleDataSuccess(List<MainInfo> data) {
        mAdapter.setDataList(data);
        runOnMainThread();
    }

    @Override
    public void getArticleDataFailure(Throwable t) {
        runOnMainThread();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "点击了第" + (position + 1) + "个Item", Toast.LENGTH_SHORT).show();
    }
}