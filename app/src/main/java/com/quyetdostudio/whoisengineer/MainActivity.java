package com.quyetdostudio.whoisengineer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.quyetdostudio.whoisengineer.ui.HomeFragment;
import com.quyetdostudio.whoisengineer.utils.FragmentHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentHelper.switchFragment(getSupportFragmentManager(), new HomeFragment(), false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FragmentHelper.RemoveLastFragment(getSupportFragmentManager());
    }
}
