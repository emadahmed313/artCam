package ir.app.artcam.artcam.activities.mainActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.app.artcam.artcam.R;
import ir.app.artcam.artcam.adapters.NvAdapter;
import ir.app.artcam.artcam.adapters.NvAdapterClickCallBAck;
import ir.app.artcam.artcam.fragments.FragmentCallBAck;
import ir.app.artcam.artcam.fragments.defaults.DefaultFragment;
import ir.app.artcam.artcam.fragments.season.SeasonFragment;

public class MainActivity extends MvpActivity<MainContract.View, MainContract.Presenter> implements MainContract.View, NvAdapterClickCallBAck, FragmentCallBAck {

    @BindView(R.id.constrain_drawer)
    ConstraintLayout constraintLayoutDrawer;

    @BindView(R.id.recycler_view_drawer)
    RecyclerView recyclerViewDrawer;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getPresenter().start();
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new DefaultFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                drawerLayout.openDrawer(Gravity.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void setData() {

        ArrayList<String> list = new ArrayList<>();
        list.add("فصل");

        recyclerViewDrawer.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDrawer.setAdapter(new NvAdapter(this, list, recyclerViewDrawer));

    }

    @Override
    public void onPartClicked(int season) {

        switch (season) {
            case 1: {
                handleChangeFragment(SeasonFragment.newInstance());
                drawerLayout.closeDrawers();
            }

        }


    }

    @Override
    public void handleChangeFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction().replace(R.id.content_frame, fragment)
                .addToBackStack(fragment.getClass().getName())
                .commit();
    }
}
