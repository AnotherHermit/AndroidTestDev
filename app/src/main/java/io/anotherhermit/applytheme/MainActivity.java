package io.anotherhermit.applytheme;

import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import io.anotherhermit.applytheme.adapter.RecyclerAdapter;
import io.anotherhermit.applytheme.model.Landscape;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        setUpDrawer();

        setUpRecyclerView();
    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home page");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(this);
    }

    private void setUpDrawer() {
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drwr_fragment);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, toolbar);
    }

    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, Landscape.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.linearViewHorizontal:
                LinearLayoutManager mLinearLayoutManagerHorizontal = new LinearLayoutManager(this);
                mLinearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(mLinearLayoutManagerHorizontal);
                break;
            case R.id.linearViewVertical:
                LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
                mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
                break;
            case R.id.gridView:
                GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2);
                recyclerView.setLayoutManager(mGridLayoutManager);
                break;
            case R.id.staggeredViewHorizontal:
                StaggeredGridLayoutManager mStaggeredLayoutManagerHorizontal = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(mStaggeredLayoutManagerHorizontal);
                break;
            case R.id.staggeredViewVertical:
                StaggeredGridLayoutManager mStaggeredLayoutManagerVertical = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mStaggeredLayoutManagerVertical);
                break;
            default:
                break;
        }
        return true;
    }
}
