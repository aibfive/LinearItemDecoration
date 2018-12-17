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

public class StickySectionFragment extends Fragment {

    List<String> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_layout, null);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        list.add("A1--------->");
        list.add("A2--------->");
        list.add("A3--------->");
        list.add("B1--------->");
        list.add("B2--------->");
        list.add("C1--------->");
        list.add("C2--------->");
        list.add("C3--------->");
        list.add("C4--------->");
        list.add("C5--------->");
        list.add("D1--------->");
        list.add("D2--------->");

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new StickySectionDecoration(
                getResources().getDimensionPixelSize(R.dimen.section_height), Color.BLUE, Color.BLACK,
                getResources().getDimensionPixelSize(R.dimen.section_text_size), getResources().getDimensionPixelSize(R.dimen.section_padding_left),
                new StickySectionDecoration.DecorationCallback(){
                    @Override
                    public String getSectionInGroup(int position) {
                        return list.get(position).substring(0, 1).toUpperCase();
                    }
                }
        ));
        recyclerView.addItemDecoration(new LinearItemDecoration(getResources().getDimensionPixelSize(R.dimen.divider_height), Color.BLUE, LinearItemDecoration.VERTICAL));
        recyclerView.setAdapter(new RecyclerViewAdapter(getActivity(), list, R.layout.item_vertical));

        return view;
    }

}

