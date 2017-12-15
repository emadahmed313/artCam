package ir.app.artcam.artcam.fragments.season;


import android.content.Context;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import java.util.ArrayList;

import ir.app.artcam.artcam.R;
import ir.app.artcam.artcam.models.MainItem;
import ir.app.artcam.artcam.models.Part;

public class SeasonPresenter
        extends MvpBasePresenter<SeasonContract.View>
        implements SeasonContract.Presenter {

    @Override
    public void attachView(SeasonContract.View view) {
        super.attachView(view);
    }


    @Override
    public void createData(int season, Context context) {

        switch (season) {
            case 1:

                ifViewAttached(view -> view.setData(createSeason1(context)));
        }
    }

    private MainItem createSeason1(Context context) {

        String title1 = " ۱- ورود به نرم افزار و باز کردن فایل جدید";
        String title2 = "2- معرفی بخش های نرم افزار";
        String title3 = "3- اضافه کردن ابزارها";
        String title4 = "4- معرفی درخت های طراحی";
        String title5 = "5- معرفی Vector,Bitmap, Relief";

        final String URL1 = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";



        String[] countries = context.getResources().getStringArray(R.array.season_1_part_1);

        Part part1 = new Part(R.drawable.image11, title1, countries, URL1);

        Part part2 = new Part(R.drawable.image12, title2, countries, "http://s8.picofile.com/d/8314156026/380a748b-64af-4245-aeb5-37def3264d38/1.flv");
        Part part3 = new Part(R.drawable.image13, title3, countries, "http://s8.picofile.com/d/8314156026/380a748b-64af-4245-aeb5-37def3264d38/1.flv");
        Part part4 = new Part(R.drawable.image14, title4, countries, "http://s8.picofile.com/d/8314156026/380a748b-64af-4245-aeb5-37def3264d38/1.flv");
        Part part5 = new Part(R.drawable.image15, title5, countries, URL1);

        ArrayList<Part> parts = new ArrayList<>();
        parts.add(part1);
        parts.add(part2);
        parts.add(part3);
        parts.add(part4);
        parts.add(part5);

        return new MainItem(parts);

    }
}
