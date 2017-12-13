package in.co.madhur.chatbubblesdemo;

import android.Manifest;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;

public class Tabs extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;


    //int[] colorIntArray = {R.color.walking,R.color.running,R.color.biking,R.color.paddling,R.color.golfing};
    //int[] iconIntArray = {R.drawable.ic_walk_white,R.drawable.ic_run_white,R.drawable.ic_bike_white,R.drawable.ic_add_white,R.drawable.ic_arrow_back_white};

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    static FloatingActionButton fab;
     static FloatingActionButton fab2;
    static FloatingActionButton fab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.hide();

        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab3.hide();
        EnableRuntimePermission();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
       openChat();

            }
        });

    }

    protected void animateFab(final int position) {
        fab.clearAnimation();
        // Scale down animation
        ScaleAnimation shrink =  new ScaleAnimation(1f, 0.2f, 1f, 0.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        shrink.setDuration(150);     // animation duration in milliseconds
        shrink.setInterpolator(new DecelerateInterpolator());
        shrink.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Change FAB color and icon
           //     fab.setBackgroundTintList(getResources().getColorStateList(555555));
           //     fab.setImageDrawable(getResources().getDrawable(iconIntArray[position], null));

                // Scale up animation
                ScaleAnimation expand =  new ScaleAnimation(0.2f, 1f, 0.2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                expand.setDuration(100);     // animation duration in milliseconds
                expand.setInterpolator(new AccelerateInterpolator());
                fab.startAnimation(expand);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fab.startAnimation(shrink);
    }

    public void openChat(){
        startActivity(new Intent(this,MainActivity.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabs, menu);
        return true;
    }
    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                Tabs.this,
                Manifest.permission.READ_CONTACTS))
        {

            Toast.makeText(Tabs.this,"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(Tabs.this,new String[]{
                    Manifest.permission.READ_CONTACTS}, 1);

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            if (getArguments().getInt(ARG_SECTION_NUMBER)==1){
                show1();
                View rootView = inflater.inflate(R.layout.fragment_f1,container,false);
                return rootView;

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER)==2){
                View rootView = inflater.inflate(R.layout.fragment_f2,container,false);
                show2();
                return rootView;

            }
            if (getArguments().getInt(ARG_SECTION_NUMBER)==3){
                View rootView = inflater.inflate(R.layout.fragment_f3,container,false);
                show3();
                return rootView;

            }
else
            {View rootView = inflater.inflate(R.layout.fragment_main2,container,false);
                return rootView;
            }}

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

   static void show1(){
   fab2.hide();
   fab3.hide();
   fab.show();
    }


    static void show2(){
        fab.hide();
        fab3.hide();
        fab2.show();
    }

    static void show3(){
        fab2.hide();
        fab.hide();
        fab3.show();
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
