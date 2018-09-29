package com.sunshine824.common.widget.recycler;


/**
 * @author chenxin
 * @date 2018\9\29 0029 14:25
 */
public interface AdapterCallback<Data> {
    void update(Data data, RecyclerAdapter.ViewHolder<Data> holder);
}
