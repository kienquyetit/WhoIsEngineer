package com.quyetdostudio.whoisengineer.utils;

import android.content.OperationApplicationException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.quyetdostudio.whoisengineer.R;

import java.util.Calendar;

/**
 * Created by QUYET on 5/25/2017.
 */

public class FragmentHelper {

    public static String LAST_FRAGMENT_TAG;

    public static void switchFragment(FragmentManager fm, Fragment fragment, boolean IsAddToBackStack) {
        try {
            if (fragment == null || fm == null) {
                throw new OperationApplicationException("FragmentManager null or fragment null");
            }

            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            Calendar c = Calendar.getInstance();
            String tag = fragment.getTag() + c.get(Calendar.MILLISECOND);
            Fragment lastFragment = fm.findFragmentByTag(LAST_FRAGMENT_TAG);

            if (IsAddToBackStack) {
                fragmentTransaction.addToBackStack(null);
            } else {
                if (lastFragment != null) {
                    fragmentTransaction.remove(lastFragment);
                }
            }

            fragmentTransaction.replace(R.id.root, fragment, tag);
            LAST_FRAGMENT_TAG = tag;
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {

        }
    }

    public static void RemoveLastFragment(FragmentManager fm)
    {
        Fragment lastFragment = fm.findFragmentByTag(LAST_FRAGMENT_TAG);
        if (lastFragment != null)
        {
            fm.beginTransaction().remove(lastFragment).commitAllowingStateLoss();
        }
        LAST_FRAGMENT_TAG = fm.findFragmentById(R.id.root).getTag();
    }
}
