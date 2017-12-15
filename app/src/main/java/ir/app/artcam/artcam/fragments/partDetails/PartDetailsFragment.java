package ir.app.artcam.artcam.fragments.partDetails;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.app.artcam.artcam.R;
import ir.app.artcam.artcam.activities.MyPlayerActivity;
import ir.app.artcam.artcam.models.Part;
import ir.app.artcam.artcam.utils.GlideApp;


public class PartDetailsFragment
        extends MvpFragment<PartDetailsContract.View, PartDetailsContract.Presenter>
        implements PartDetailsContract.View, View.OnClickListener {


    @BindView(R.id.textView_details_subtitle)
    TextView subtitle;
    @BindView(R.id.imageView_details_image)
    ImageView image;
    @BindView(R.id.textView_details_title)
    TextView title;

    @BindView(R.id.button_details_showVideo)
    Button showButton;

    @BindView(R.id.button_details_back)
    Button backButton;


    private Context context;
    private Part part;

    public static PartDetailsFragment newInstance(Part part) {

        Bundle args = new Bundle();
        args.putParcelable("part", part);
        PartDetailsFragment fragment = new PartDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        part = getArguments().getParcelable("part");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_partdetails, container, false);
        ButterKnife.bind(this, view);

        title.setText(part.getTitle());

        for (int i = 0; i < part.getSubtitle().length; i++) {

            String s = subtitle.getText().toString();
            s += "\n" + part.getSubtitle()[i];
            subtitle.setText(s);
        }

        GlideApp
                .with(context)
                .load(part.getResID())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(image);

        showButton.setOnClickListener(this);
        backButton.setOnClickListener(this);

        return view;
    }


    @Override
    public PartDetailsContract.Presenter createPresenter() {
        return new PartDetailsPresenter();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button_details_showVideo: {

                startActivity(new Intent(context, MyPlayerActivity.class)
                        .putExtra("videoUrl", part.getVideoUrl()));
                break;
            }
            case R.id.button_details_back: {


                break;
            }

        }

    }
}
