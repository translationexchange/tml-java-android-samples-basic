package com.translationexchange.samples.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.translationexchange.android.TmlAndroid;
import com.translationexchange.android.TmlSession;
import com.translationexchange.android.activities.LanguageSelectorActivity;
import com.translationexchange.samples.ExampleContent;
import com.translationexchange.samples.R;

import java.util.Observable;
import java.util.Observer;

public class ViewExampleFragment extends Fragment implements Observer {
    public static final String ARG_POSITION = "position";

    private int position;
    private TextView exampleView;
    private TextView resultView;

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
        TmlAndroid.addObserver(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TmlAndroid.deleteObserver(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_example, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        exampleView = (TextView) view.findViewById(R.id.text_example);
        resultView = (TextView) view.findViewById(R.id.text_result);
        TextView languageSelector = (TextView) view.findViewById(R.id.btn_open_selector);
        languageSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageSelectorActivity.open(getActivity());
            }
        });
        initView();
    }

    private void initView() {
        ExampleContent.ExampleItem exampleItem = ExampleContent.getExampleItems().get(position);
        if (exampleItem.isSpannable) {
            exampleView.setText("TmlAndroid.translateSpannableString(" + "\"" + exampleItem.label + "\"" + ", " + exampleItem.tokens + ")");
            TmlAndroid.translateSpannableString(resultView, exampleItem.label, exampleItem.tokens);
        } else {
            if (exampleItem.tokens == null) {
                exampleView.setText("TmlAndroid.translate(" + "\"" + exampleItem.label + "\")");
            } else {
                exampleView.setText("TmlAndroid.translate(" + "\"" + exampleItem.label + "\"" + ", " + exampleItem.tokens + ")");
            }
            TmlAndroid.translate(resultView, exampleItem.label, exampleItem.tokens);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TmlSession) {
            initView();
        }
    }
}
