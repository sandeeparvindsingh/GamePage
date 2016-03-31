package app.anonymous.sunny.gamepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by DELL1 on 3/31/2016.
 */
class MyPageAdapter extends FragmentPagerAdapter {
private int i;
    private List<Fragment> fragments;
    public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    i=0;
    }
    @Override
    public Fragment getItem(int position) {

        Log.d("getItem","called");
        return this.fragments.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
     Log.d("Instantiate","called");
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
   }