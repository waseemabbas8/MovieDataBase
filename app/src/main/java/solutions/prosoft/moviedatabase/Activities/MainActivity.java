package solutions.prosoft.moviedatabase.Activities;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import solutions.prosoft.moviedatabase.Adapters.Pager;
import solutions.prosoft.moviedatabase.Fragments.LatestMoviesFragment;
import solutions.prosoft.moviedatabase.Fragments.TopRatedMoviesFragment;
import solutions.prosoft.moviedatabase.R;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener,TopRatedMoviesFragment.OnFragmentInteractionListener, LatestMoviesFragment.OnFragmentInteractionListener{

    //This is our tablayout
    private TabLayout mTabLayout;

    //This is our viewPager
    private ViewPager mViewPager;
    private Toolbar mTloolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setSupportActionBar(mTloolBar);
        //Now we have to set the Tabs in the TabLayout
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB2"));
        //mTabLayout.addTab(mTabLayout.newTab().setText("TAB3"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        Pager pagerAdapter=new Pager(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setOnTabSelectedListener(this);
    }

    private void bindViews(){
         mTloolBar =findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager=findViewById(R.id.pager);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
