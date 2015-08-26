package dev.acl.armandocl.sisinfo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {
    private ProgressBar pbIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        pbIntro=(ProgressBar)findViewById(R.id.pbIntro);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                try {
                    finish();
                    startActivity(i);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
    }, 3000);
    }


}
