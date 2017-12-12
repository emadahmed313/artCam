package ir.app.artcam.artcam.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.app.artcam.artcam.R;
import ir.app.artcam.artcam.activities.mainActivity.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.lytGetStarted)
    LinearLayout linearLayout  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SplashActivity.this,MainActivity.class));

            }
        });

    }
}
