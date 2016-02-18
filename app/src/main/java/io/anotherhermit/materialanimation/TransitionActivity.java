package io.anotherhermit.materialanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class TransitionActivity extends AppCompatActivity {
    Constants.AnimType type;
    String toolbarTitle, animName;
    TextView mTvAnimName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Enable transitions between activities, if not already enabled in the XML file.
        // Must be called before super.onCreate() and setContentView();
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        type = (Constants.AnimType) getIntent().getSerializableExtra(Constants.KEY_TYPE);
        toolbarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);
        animName = getIntent().getExtras().getString(Constants.KEY_NAME);

        setUpAnimation();

        bindControl();

        setUpToolbar();

        getWindow().setAllowEnterTransitionOverlap(false);
    }

    private void bindControl() {
        findViewById(R.id.exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTvAnimName = (TextView) findViewById(R.id.animName);
        mTvAnimName.setText(animName);
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }

    private void setUpAnimation() {
        switch (type) {

            case ExplodeJava:
                Explode enterTransitionExplode = new Explode();
                enterTransitionExplode.setDuration(1000);
                getWindow().setEnterTransition(enterTransitionExplode);

                break;

            case ExplodeXML:
                Transition enterAnimationExplode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                enterAnimationExplode.setDuration(1000);
                getWindow().setEnterTransition(enterAnimationExplode);

                break;

            case SlideJava:
                Slide enterTransitionSlide = new Slide();
                enterTransitionSlide.setSlideEdge(Gravity.RIGHT);
                enterTransitionSlide.setDuration(1000);
                getWindow().setEnterTransition(enterTransitionSlide);

                break;

            case SlideXML:
                Transition enterAnimationSlide = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                enterAnimationSlide.setDuration(1000);
                getWindow().setEnterTransition(enterAnimationSlide);
                break;

            case FadeJava:
                Fade enterTransitionFade = new Fade();
                enterTransitionFade.setDuration(1000);
                getWindow().setEnterTransition(enterTransitionFade);
                break;

            case FadeXML:
                Transition enterAnimationFade = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                enterAnimationFade.setDuration(1000);
                getWindow().setEnterTransition(enterAnimationFade);
                break;

        }
    }
}
