package com.translationexchange.samples.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.translationexchange.android.TmlAndroid;
import com.translationexchange.samples.ExampleContent.ExampleItem;
import com.translationexchange.samples.R;
import com.translationexchange.samples.fragment.MainFragment;

import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private List<ExampleItem> mValues;
    private MainFragment.OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<ExampleItem> items, MainFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.initUi(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mIdView;
        ExampleItem mItem;
        MainFragment.OnListFragmentInteractionListener mListener;

        ViewHolder(View view, MainFragment.OnListFragmentInteractionListener mListener) {
            super(view);
            itemView.setOnClickListener(this);
            this.mIdView = (TextView) view.findViewById(R.id.id);
            this.mListener = mListener;
        }

        void initUi(final ExampleItem mItem) {
            this.mItem = mItem;
            if (mItem.isSpannable) {
                TmlAndroid.translateSpannableString(mIdView, mItem.label, mItem.tokens);
            } else {
                TmlAndroid.translate(mIdView, mItem.label, mItem.tokens);
            }
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onListFragmentInteraction(mItem, getAdapterPosition());
            }
        }
    }
}
