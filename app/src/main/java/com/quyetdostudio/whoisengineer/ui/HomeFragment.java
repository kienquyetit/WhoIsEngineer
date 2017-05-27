package com.quyetdostudio.whoisengineer.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.quyetdostudio.whoisengineer.R;
import com.quyetdostudio.whoisengineer.utils.FragmentHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    Button btnPlay, btnUserGuide, btnExit;
    FloatingActionButton fabInfor, fabHighScore, fabVolume;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnPlay.setOnClickListener(this);
        btnUserGuide.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        fabInfor.setOnClickListener(this);
        fabHighScore.setOnClickListener(this);
        fabVolume.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btnPlay = (Button) root.findViewById(R.id.play_button);
        btnUserGuide = (Button) root.findViewById(R.id.user_guide_button);
        btnExit = (Button) root.findViewById(R.id.exit_button);
        fabInfor = (FloatingActionButton) root.findViewById(R.id.fab_information);
        fabHighScore = (FloatingActionButton) root.findViewById(R.id.fab_high_score);
        fabVolume = (FloatingActionButton) root.findViewById(R.id.fab_volume);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play_button:
                FragmentHelper.switchFragment(getActivity().getSupportFragmentManager(), new PlayFragment(), true);
                break;
            case R.id.user_guide_button:
                FragmentHelper.switchFragment(getActivity().getSupportFragmentManager(), new GuideFragment(), true);
                break;
            case R.id.exit_button:
                getActivity().finish();
                break;
            case R.id.fab_information:
                FragmentHelper.switchFragment(getActivity().getSupportFragmentManager(), new InformationFragment(), true);
                break;
            case R.id.fab_high_score:
                FragmentHelper.switchFragment(getActivity().getSupportFragmentManager(), new HighScoreFragment(), true);
                break;
            case R.id.fab_volume:
                // empty
                break;
            default:
                break;
        }
    }
}
