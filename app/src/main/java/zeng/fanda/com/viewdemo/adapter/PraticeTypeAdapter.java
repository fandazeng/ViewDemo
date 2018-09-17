package zeng.fanda.com.viewdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import javax.inject.Inject;

import zeng.fanda.com.viewdemo.R;
import zeng.fanda.com.viewdemo.model.TypeBean;

/**
 * @author 曾凡达
 * @date 2018/9/4
 */
public class PraticeTypeAdapter extends BaseQuickAdapter<TypeBean, BaseViewHolder> {

    @Inject
    public PraticeTypeAdapter() {
        super(R.layout.item_pratice_type);
    }

    @Override
    protected void convert(BaseViewHolder helper, TypeBean item) {
        helper.setText(R.id.tv_pratice_name, item.name);
    }
}
