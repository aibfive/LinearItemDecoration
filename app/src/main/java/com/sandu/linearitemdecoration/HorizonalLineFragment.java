package com.sandu.linearitemdecoration;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * LinearItemDecoration
 *
 * @author lizewu
 * @date 2018/12/14
 */
public class HorizonalLineFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_layout, null);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        List<String> list = new ArrayList<>();
        list.add("数据----->1");
        list.add("数据----->2");
        list.add("数据----->3");
        list.add("数据----->4");
        list.add("数据----->5");
        list.add("数据----->6");
        list.add("数据----->6");
        list.add("数据----->6");
        list.add("数据----->6");
        list.add("数据----->6");
        list.add("数据----->6");
        list.add("数据----->6");
        list.add("数据----->6");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new LinearItemDecoration(
                getResources().getDimensionPixelSize(R.dimen.divider_height),
                Color.BLUE, LinearItemDecoration.HORIZONTAL, LinearItemDecoration.HORIZONTAL_INCLUDE_LEFT_RIGHT));
        recyclerView.setAdapter(new RecyclerViewAdapter(getActivity(), list, R.layout.item_horizonal));

        return view;
    }
}
