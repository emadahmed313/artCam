package ir.app.artcam.artcam.activities.mainActivity;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;


public interface MainContract {

interface View extends MvpView {

void setData();

}


interface Presenter extends MvpPresenter<View>{

void start();

}


}
