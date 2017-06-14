package cn.share.jack.mvpmasterdemo.ui.main.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerViewHolder;
import cn.share.jack.mvpmasterdemo.R;
import cn.share.jack.mvpmasterdemo.model.main.MainInfo;


/**
 * Created by jack on 2017/6/14
 */

public class MainViewHolder extends CygBaseRecyclerViewHolder<MainInfo> {

    private ImageView ivAvatar;
    private TextView tvTitle;
    private TextView tvContent;

    public MainViewHolder(View view) {
        super(view);
        ivAvatar = findView(R.id.im_iv_avatar);
        tvTitle = findView(R.id.im_tv_title);
        tvContent = findView(R.id.im_tv_content);
    }

    @Override
    protected void onItemDataUpdated(@Nullable MainInfo mainInfo) {
        if (null != mainInfo) {
            Glide.with(getContext()).load(String.valueOf(mainInfo.getArticlePic()))
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round).into(ivAvatar);
            tvTitle.setText(String.valueOf(mainInfo.getArticleTitle()));
            tvContent.setText(String.valueOf(mainInfo.getArticleContent()));
        }
    }
}
