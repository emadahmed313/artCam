package ir.app.artcam.artcam.fragments.season;

import android.content.Context;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import ir.app.artcam.artcam.models.MainItem;

public interface SeasonContract {

    interface View extends MvpView {

        void setData(MainItem mainItem);
    }

    interface Presenter extends MvpPresenter<View> {

        void createData(int season, Context context);

    }
}
