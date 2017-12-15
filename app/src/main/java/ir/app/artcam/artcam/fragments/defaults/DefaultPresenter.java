package ir.app.artcam.artcam.fragments.defaults;


import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

public class DefaultPresenter
        extends MvpBasePresenter<DefaultContract.View>
        implements DefaultContract.Presenter {

    @Override
    public void attachView(DefaultContract.View view) {
        super.attachView(view);

    }
}
