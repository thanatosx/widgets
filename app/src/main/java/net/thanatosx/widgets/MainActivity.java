package net.thanatosx.widgets;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import net.thanatosx.widgets.fragment.ChartsFragment;
import net.thanatosx.widgets.fragment.LoadingFragment;
import net.thanatosx.widgets.fragment.PreviewFragment;
import net.thanatosx.widgets.fragment.SolarFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.layout_drawer) DrawerLayout mDrawerLayout;
    @Bind(R.id.view_nav) NavigationView mDrawerNavView;
    @Bind(R.id.layout_coordinator) CoordinatorLayout mLayoutCoordinator;

    private MenuItem mCurItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initWidgets();
        initData();
    }

    private void initWidgets() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0X00000000);
        }
        mToolbar.setTitle("");
        mToolbar.setSubtitle("Android Widgets");
        setSupportActionBar(mToolbar);

        mDrawerNavView.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mDrawerNavView.setNavigationItemSelectedListener(this);
        setupFragment(ChartsFragment.class);
        mDrawerNavView.setCheckedItem(R.id.menu_chart_pie);
    }

    private void setupFragment(Class<? extends Fragment> fc) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fc.getName());
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (fragment == null) {
            fragment = Fragment.instantiate(this, fc.getName());
            ft.add(fragment, fc.getName());
        }
        ft.replace(R.id.frame_container, fragment);
        ft.commit();
    }

    private void initData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_search:
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (mCurItem != null && mCurItem.getItemId() == item.getItemId()) return true;
        int iid = item.getItemId();
        switch (iid) {
            case R.id.menu_chart_pie:
                setupFragment(ChartsFragment.class);
                break;
            case R.id.menu_chart_line:
                setupFragment(ChartsFragment.class);
                break;
            case R.id.menu_loading:
                setupFragment(LoadingFragment.class);
                break;
            case R.id.menu_previewer:
                setupFragment(PreviewFragment.class);
                break;
            case R.id.menu_solar:
                setupFragment(SolarFragment.class);
                break;
        }
        mDrawerNavView.setCheckedItem(iid);
        mCurItem = item;
        mDrawerLayout.closeDrawer(mDrawerNavView);
        return false;
    }

    private static class PagerItem {
        String title;
        Class<? extends Fragment> clazz;
        int rid;

        PagerItem(String title, Class<? extends Fragment> clazz, int rid) {
            this.title = title;
            this.clazz = clazz;
            this.rid = rid;
        }
    }
}
