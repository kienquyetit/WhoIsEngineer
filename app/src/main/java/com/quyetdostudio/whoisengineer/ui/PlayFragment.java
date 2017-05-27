package com.quyetdostudio.whoisengineer.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.quyetdostudio.whoisengineer.R;
import com.quyetdostudio.whoisengineer.entity.Question;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment implements View.OnClickListener {

    Button btnStopGame;
    TextView tvQuestion, tvAnswerA, tvAnswerB, tvAnswerC, tvAnswerD;
    FloatingActionButton fabPercent, fabQuestion, fabChart, fabCall;

    private ArrayList<Question> questionList;
    private int sumScore;

    public PlayFragment() {
        // Required empty public constructor
        questionList = new ArrayList<>();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addOnClickListener();
        addText();
    }

    private void addText() {

    }

    private void addOnClickListener() {
        btnStopGame.setOnClickListener(this);
        tvAnswerA.setOnClickListener(this);
        tvAnswerB.setOnClickListener(this);
        tvAnswerC.setOnClickListener(this);
        tvAnswerD.setOnClickListener(this);
        fabPercent.setOnClickListener(this);
        fabQuestion.setOnClickListener(this);
        fabChart.setOnClickListener(this);
        fabChart.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_play, container, false);
        btnStopGame = (Button) root.findViewById(R.id.stop_game_button);
        tvQuestion = (TextView) root.findViewById(R.id.text_view_question);
        tvAnswerA = (TextView) root.findViewById(R.id.text_view_a);
        tvAnswerB = (TextView) root.findViewById(R.id.text_view_b);
        tvAnswerC = (TextView) root.findViewById(R.id.text_view_c);
        tvAnswerD = (TextView) root.findViewById(R.id.text_view_d);
        fabPercent = (FloatingActionButton) root.findViewById(R.id.fab_percent);
        fabQuestion = (FloatingActionButton) root.findViewById(R.id.fab_question);
        fabChart = (FloatingActionButton) root.findViewById(R.id.fab_chart);
        fabCall = (FloatingActionButton) root.findViewById(R.id.fab_call);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.stop_game_button:
                getActivity().onBackPressed();
                break;
            case R.id.text_view_a:
                break;
            case R.id.text_view_b:
                break;
            case R.id.text_view_c:
                break;
            case R.id.text_view_d:
                break;
            case R.id.fab_percent:
                break;
            case R.id.fab_question:
                break;
            case R.id.fab_chart:
                break;
            case R.id.fab_call:
                break;
            default:
                break;
        }
    }
}
