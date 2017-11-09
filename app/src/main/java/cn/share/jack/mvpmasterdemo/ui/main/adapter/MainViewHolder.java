package cn.share.jack.mvpmasterdemo.ui.main.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.share.jack.cygwidget.recyclerview.adapter.CygBaseRecyclerViewHolder;
import cn.share.jack.cygwidget.utils.CygImageLoader;
import cn.share.jack.mvpmasterdemo.R;
import cn.share.jack.mvpmasterdemo.model.main.MainInfo;


/**
 * Created by jack on 2017/6/14
 *
 * @author jack
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
            CygImageLoader.loadImage(mainInfo.getArticlePic(), ivAvatar);
            tvTitle.setText(String.valueOf(mainInfo.getArticleTitle()));
            tvContent.setText(String.valueOf(mainInfo.getArticleContent()));
        }
    }
}
