package ir.app.artcam.artcam.fragments.season;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.app.artcam.artcam.R;
import ir.app.artcam.artcam.adapters.SeasonAdapter;
import ir.app.artcam.artcam.adapters.SeasonAdapterClickCallBack;
import ir.app.artcam.artcam.fragments.FragmentCallBAck;
import ir.app.artcam.artcam.fragments.partDetails.PartDetailsFragment;
import ir.app.artcam.artcam.models.MainItem;
import ir.app.artcam.artcam.models.Part;


public class SeasonFragment
        extends MvpFragment<SeasonContract.View, SeasonContract.Presenter>
        implements SeasonContract.View, SeasonAdapterClickCallBack {

    private Context context;
    private FragmentCallBAck fragmentCallBAck;

    @BindView(R.id.recycler_view_season)
    RecyclerView recyclerView;


    public static SeasonFragment newInstance() {
        return new SeasonFragment();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof FragmentCallBAck) {
            fragmentCallBAck = (FragmentCallBAck) activity;
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_season, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getPresenter().createData(1,context);

    }

    @Override
    public SeasonContract.Presenter createPresenter() {
        return new SeasonPresenter();
    }


    @Override
    public void setData(MainItem mainItem) {

        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(new SeasonAdapter(context, this, mainItem));


    }


    @Override
    public void onPartItemClicked(int pos, @NotNull Part part) {



        fragmentCallBAck.handleChangeFragment(PartDetailsFragment.newInstance(part));


    }

}
