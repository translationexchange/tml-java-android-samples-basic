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

    private final List<ExampleItem> mValues;
    private final MainFragment.OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<ExampleItem> items, MainFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        if (holder.mItem.isSpannable) {
            holder.mIdView.setText(TmlAndroid.translateSpannableString(holder.mItem.label, holder.mItem.tokens));
        } else {
            holder.mIdView.setText(TmlAndroid.translate(holder.mItem.label, holder.mItem.tokens));
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem, holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mIdView;
        ExampleItem mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
        }
    }
}
