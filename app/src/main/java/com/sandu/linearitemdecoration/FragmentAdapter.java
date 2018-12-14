package com.sandu.linearitemdecoration;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */

public class FragmentAdapter<T extends Fragment> extends FragmentPagerAdapter {

    private List<T> list = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm, List<T> list) {
        super(fm);
        this.list.addAll(list);
    }

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    /**
     * 添加全部
     * @param list
     */
    public void addAll(List<T> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 添加
     * @param fragment
     */
    public void add(T fragment){
        this.list.add(fragment);
        notifyDataSetChanged();
    }

    /**
     * 通过索引移除
     * @param position
     */
    public void remove(int position){
        this.list.remove(position);
        notifyDataSetChanged();
    }

    /**
     * 通过Fragment移除
     * @param fragment
     */
    public void remove(Fragment fragment){
        this.list.remove(fragment);
        notifyDataSetChanged();
    }
}
