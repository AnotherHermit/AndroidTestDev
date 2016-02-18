package io.anotherhermit.materialanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgStar;
    private TextView tvShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindControl();
        setupToolbar();
        setUpWindowAnimation();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setUpWindowAnimation() {
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(1000);
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);

        getWindow().setAllowReturnTransitionOverlap(false);
    }

    private void bindControl() {
        Button btnExplodeJava = (Button) findViewById(R.id.explodeJava);
        Button btnExplodeXML = (Button) findViewById(R.id.explodeXML);
        Button btnSlideJava = (Button) findViewById(R.id.slideJava);
        Button btnSlideXML = (Button) findViewById(R.id.slideXML);
        Button btnFadeJava = (Button) findViewById(R.id.fadeJava);
        Button btnFadeXML = (Button) findViewById(R.id.fadeXML);

        TextView tvRippleWithBorder          = (TextView) findViewById(R.id.tvRippleWithBorder);
        TextView tvRippleWithoutBorder       = (TextView) findViewById(R.id.tvRippleWithoutBorder);
        TextView tvCustomRippleWithBorder    = (TextView) findViewById(R.id.tvCustomRippleWithBorder);
        TextView tvCustomRippleWithoutBorder = (TextView) findViewById(R.id.tvCustomRippleWithoutBorder);

        LinearLayout layoutSharedElement = (LinearLayout) findViewById(R.id.shared_element);
        imgStar     = (ImageView) findViewById(R.id.imgStarSharedElement);
        tvShared    = (TextView) findViewById(R.id.tvSharedElement);

        layoutSharedElement.setOnClickListener(this);
        btnExplodeJava.setOnClickListener(this);
        btnExplodeXML.setOnClickListener(this);
        btnSlideJava.setOnClickListener(this);
        btnSlideXML.setOnClickListener(this);
        btnFadeJava.setOnClickListener(this);
        btnFadeXML.setOnClickListener(this);

        tvRippleWithBorder.setOnClickListener(this);
        tvRippleWithoutBorder.setOnClickListener(this);
        tvCustomRippleWithBorder.setOnClickListener(this);
        tvCustomRippleWithoutBorder.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.explodeJava:
                ActivityOptions optionsEJ = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent iEJ = new Intent(MainActivity.this, TransitionActivity.class);
                iEJ.putExtra(Constants.KEY_TYPE, Constants.AnimType.ExplodeJava);
                iEJ.putExtra(Constants.KEY_TITLE, "Explode Animation");
                iEJ.putExtra(Constants.KEY_NAME, "Explode by Code");
                startActivity(iEJ, optionsEJ.toBundle());
                break;

            case R.id.explodeXML:
                ActivityOptions optionsEX = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent iEX = new Intent(MainActivity.this, TransitionActivity.class);
                iEX.putExtra(Constants.KEY_TYPE, Constants.AnimType.ExplodeXML);
                iEX.putExtra(Constants.KEY_TITLE, "Explode Animation");
                iEX.putExtra(Constants.KEY_NAME, "Explode by XML");
                startActivity(iEX, optionsEX.toBundle());
                break;

            case R.id.slideJava:
                ActivityOptions optionsSJ = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent iSJ = new Intent(MainActivity.this, TransitionActivity.class);
                iSJ.putExtra(Constants.KEY_TYPE, Constants.AnimType.SlideJava);
                iSJ.putExtra(Constants.KEY_TITLE, "Slide Animation");
                iSJ.putExtra(Constants.KEY_NAME, "Slide by Code");
                startActivity(iSJ, optionsSJ.toBundle());
                break;

            case R.id.slideXML:
                ActivityOptions optionsSX = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent iSX = new Intent(MainActivity.this, TransitionActivity.class);
                iSX.putExtra(Constants.KEY_TYPE, Constants.AnimType.SlideXML);
                iSX.putExtra(Constants.KEY_TITLE, "Slide Animation");
                iSX.putExtra(Constants.KEY_NAME, "Slide by XML");
                startActivity(iSX, optionsSX.toBundle());
                break;

            case R.id.fadeJava:
                ActivityOptions optionsFJ = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent iFJ = new Intent(MainActivity.this, TransitionActivity.class);
                iFJ.putExtra(Constants.KEY_TYPE, Constants.AnimType.FadeJava);
                iFJ.putExtra(Constants.KEY_TITLE, "Fade Animation");
                iFJ.putExtra(Constants.KEY_NAME, "Fade by Java");
                startActivity(iFJ, optionsFJ.toBundle());
                break;
            case R.id.fadeXML:
                ActivityOptions optionsFX = ActivityOptions.makeSceneTransitionAnimation(this);
                Intent iFX = new Intent(MainActivity.this, TransitionActivity.class);
                iFX.putExtra(Constants.KEY_TYPE, Constants.AnimType.FadeXML);
                iFX.putExtra(Constants.KEY_TITLE, "Fade Animation");
                iFX.putExtra(Constants.KEY_NAME, "Fade by XML");
                startActivity(iFX, optionsFX.toBundle());
                break;

            case R.id.shared_element:
                Pair[] pairs = new Pair[2];

                pairs[0] = new Pair<View, String>(imgStar, "star");
                pairs[1] = new Pair<View, String>(tvShared, "text_shared");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);
                Intent i = new Intent(this, SharedElementActivity.class);
                startActivity(i, options.toBundle());
        }
    }
}
