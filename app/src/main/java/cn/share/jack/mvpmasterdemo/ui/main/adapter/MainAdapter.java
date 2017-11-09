package cn.share.jack.mvpmasterdemo.ui.main.adapter;

import android.content.Context;
import android.view.ViewGroup;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerAdapter;
import cn.share.jack.cygwidget.utils.CygView;
import cn.share.jack.mvpmasterdemo.R;
import cn.share.jack.mvpmasterdemo.model.main.MainInfo;

/**
 * Created by jack on 2017/6/14
 *
 * @author jack
 */

public class MainAdapter extends CygBaseRecyclerAdapter<MainInfo, MainViewHolder> {

    public MainAdapter(Context context, OnItemClickListener<MainViewHolder> listener) {
        super(context, listener);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(CygView.inflateLayout(getContext(), R.layout.item_main, parent, false));
    }
}
