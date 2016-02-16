package io.anotherhermit.applytheme;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Welcome!");
        toolbar.setSubtitle("Folks !");



        // Compatibility by JAVA
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            toolbar.setElevation(10f);
//        }
//        toolbar.setLogo(R.drawable.good_day);
//        toolbar.setNavigationIcon(R.drawable.navigation_back);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = (String) item.getTitle();


        switch (item.getItemId()) {
            case R.id.discard:
                break;

            case R.id.search:
                break;

            case R.id.edit:
                break;

            case R.id.settings:
                break;

            case R.id.exit:
                break;

            default:
                break;
        }

        Toast.makeText(this, msg + " clicked!", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
