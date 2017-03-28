package com.example.adiputra.assyst;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private java.util.List listData = new ArrayList<>();
    private ListAdapter mAdapter;

    //defineDatabaseContext
    Context CTX;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        CTX = container.getContext();
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new ListAdapter(listData);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareListData();
    }

    private void prepareListData() {
        DatabaseOperations DOP = new DatabaseOperations(CTX);
        Cursor CR = DOP.getInformation(DOP);
        CR.moveToFirst();
        String LOCATION = "";
        String LATITUDE = "";
        String LONGITUDE = "";
        do{
            LOCATION = CR.getString(0);
            LATITUDE = CR.getString(1);
            LONGITUDE = CR.getString(2);
            List l = new List(LOCATION, LATITUDE, LONGITUDE);
            listData.add(l);
            Collections.reverse(listData);
        }while(CR.moveToNext());
    }
}
