package com.translationexchange.samples.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.translationexchange.samples.ExampleContent;
import com.translationexchange.samples.ExampleContent.ExampleItem;
import com.translationexchange.samples.R;
import com.translationexchange.samples.SimpleDividerItemDecoration;
import com.translationexchange.samples.activity.ViewExampleActivity;
import com.translationexchange.samples.adapter.MyItemRecyclerViewAdapter;

public class MainFragment extends Fragment {

    private OnListFragmentInteractionListener mListener = new OnListFragmentInteractionListener() {
        @Override
        public void onListFragmentInteraction(ExampleItem item, int position) {
            ViewExampleActivity.openExample(getContext(), position);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(ExampleContent.ITEMS, mListener));
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(ExampleItem item, int position);
    }

}
