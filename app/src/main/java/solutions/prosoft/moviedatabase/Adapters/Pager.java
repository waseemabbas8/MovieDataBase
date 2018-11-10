package solutions.prosoft.moviedatabase.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import solutions.prosoft.moviedatabase.Fragments.LatestMoviesFragment;
import solutions.prosoft.moviedatabase.Fragments.TopRatedMoviesFragment;

public class Pager extends FragmentPagerAdapter {
    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                TopRatedMoviesFragment tab1 = new TopRatedMoviesFragment();
                return tab1;
            case 1:
                LatestMoviesFragment tab2 = new LatestMoviesFragment();
                return tab2;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
