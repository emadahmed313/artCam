package ir.app.artcam.artcam.fragments.defaults;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

import butterknife.ButterKnife;
import ir.app.artcam.artcam.R;


public class DefaultFragment
        extends MvpFragment<DefaultContract.View,DefaultContract.Presenter>
        implements DefaultContract.View {

    Context context ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_default, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public DefaultContract.Presenter createPresenter() {
        return new DefaultPresenter();
    }
}
