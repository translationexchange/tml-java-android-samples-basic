package com.translationexchange.samples.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.translationexchange.android.TmlAndroid;
import com.translationexchange.samples.ExampleContent;
import com.translationexchange.samples.R;

public class ViewExampleFragment extends Fragment {
    public static final String ARG_POSITION = "position";

    private int position;

    public static ViewExampleFragment newInstance(int position) {
        ViewExampleFragment fragment = new ViewExampleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_example, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView exampleView = (TextView) view.findViewById(R.id.text_example);
        TextView resultView = (TextView) view.findViewById(R.id.text_result);
        ExampleContent.ExampleItem exampleItem = ExampleContent.ITEMS.get(position);


        if (exampleItem.isSpannable) {
            exampleView.setText("TmlAndroid.translateSpannableString(" + "\"" + exampleItem.label + "\"" + ", " + exampleItem.tokens + ")");
            resultView.setText(TmlAndroid.translateSpannableString(exampleItem.label, exampleItem.tokens));
        } else {
            if (exampleItem.tokens == null) {
                exampleView.setText("TmlAndroid.translate(" + "\"" + exampleItem.label + "\")");
            } else {
                exampleView.setText("TmlAndroid.translate(" + "\"" + exampleItem.label + "\"" + ", " + exampleItem.tokens + ")");
            }
            resultView.setText(TmlAndroid.translate(exampleItem.label, exampleItem.tokens));
        }
    }
}
