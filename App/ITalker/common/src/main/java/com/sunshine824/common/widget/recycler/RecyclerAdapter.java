package com.sunshine824.common.widget.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunshine824.common.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author chenxin
 * @date 2018\9\29 0029 14:26
 */
public abstract class RecyclerAdapter<Data>
        extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder<Data>>
        implements View.OnClickListener, View.OnLongClickListener {
    private final List<Data> mDataList = new ArrayList<>();

    /**
     * 创建一个ViewHolder
     *
     * @param viewGroup RecyclerView
     * @param i         界面的类型，约定为XML布局的Id
     * @return ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder<Data> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //得到LayoutInflater用于把XML初始化为View
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //把XML id为viewType的文件初始化为一个root View
        View root = inflater.inflate(i, viewGroup, false);
        //通过子类必须实现的方法，得到一个ViewHolder
        ViewHolder<Data> holder = onCreateViewHolder(root, i);

        //设置时间点击
        root.setOnClickListener(this);
        root.setOnLongClickListener(this);
        //设置View的Tag为ViewHolder，进行双向绑定
        root.setTag(R.id.tag_recycler_holder,holder);

        //进行界面注解绑定
        holder.unbinder = ButterKnife.bind(holder,root);

        return null;
    }

    protected abstract ViewHolder<Data> onCreateViewHolder(View root, int viewType);

    /**
     * 绑定数据到一个Holder上
     *
     * @param dataViewHolder
     * @param i              坐标
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder<Data> dataViewHolder, int i) {
        //得到需要绑定的数据
        Data data = mDataList.get(i);
        //触发Holder的绑定方法
        dataViewHolder.bind(data);
    }

    /**
     * 得到当前集合的数据量
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static abstract class ViewHolder<Data> extends RecyclerView.ViewHolder {
        private Data mData;
        private Unbinder unbinder;
        private AdapterCallback callback;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        /**
         * 用于绑定数据的触发
         *
         * @param data 绑定的数据
         */
        void bind(Data data) {
            this.mData = data;
            onBind(data);
        }

        /**
         * 当触发绑定数据的时候的回掉，必须复写
         *
         * @param data
         */
        protected abstract void onBind(Data data);

        /**
         * Holder自己对自己对应的Data进行更新操作
         * @param data
         */
        public void updateData(Data data) {
            if(this.callback != null){
                this.callback.update(data,this);
            }
        }
    }
}