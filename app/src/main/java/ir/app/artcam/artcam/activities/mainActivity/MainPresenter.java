package ir.app.artcam.artcam.activities.mainActivity;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by saeed on 12/11/17.
 */

public class MainPresenter extends MvpBasePresenter<MainContract.View> implements MainContract.Presenter {


    @Override
    public void start() {

        ifViewAttached(MainContract.View::setData);

    }


}
