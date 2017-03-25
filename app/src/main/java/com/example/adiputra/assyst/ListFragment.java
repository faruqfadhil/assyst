package com.example.adiputra.assyst;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private java.util.List movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);

        mAdapter = new ListAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //dividerItem
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //closeDivider
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
}

    private void prepareMovieData() {
        List movie = new List("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new List("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new List("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new List("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new List("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new List("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new List("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new List("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new List("The LEGO List", "Animation", "2014");
        movieList.add(movie);

        movie = new List("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new List("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new List("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new List("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new List("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new List("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new List("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }


}
