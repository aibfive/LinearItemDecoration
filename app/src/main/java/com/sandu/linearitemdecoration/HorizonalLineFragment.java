package com.sandu.linearitemdecoration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return view;
    }
}
