package ir.app.artcam.artcam.fragments.partDetails;


import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

public class PartDetailsPresenter
        extends MvpBasePresenter<PartDetailsContract.View>
        implements PartDetailsContract.Presenter {

    @Override
    public void attachView(PartDetailsContract.View view) {
        super.attachView(view);

    }
}
