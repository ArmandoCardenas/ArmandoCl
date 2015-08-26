package dev.acl.armandocl.sisinfo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    TextView txtVw;
    Intent i;

    private static final long BACK_PRESS_DELAY = 1000;

    private boolean mBackPressCancelled = false;
    private long mBackPressTimestamp;
    private Toast mBackPressToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVw=(TextView)findViewById(R.id.txtVw);
        txtVw.setShadowLayer(1, -1, -1, Color.BLACK);
        gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tecnológico de Celaya");
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_menu);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setBackgroundTintList(getResources().getColorStateList(R.color.material_blue_grey_900));
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Creará un nuevo correo", Toast.LENGTH_SHORT).show();
            }
        });

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Agregar la accion correspondiente a cada icono
                switch (position) {
                    case 0:
                        /*i = new Intent(getApplicationContext(), AddAlumn.class);
                        startActivity(i);*/
                        break;
                    case 1:
                        i = new Intent(getApplicationContext(), CorreosProfesores.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(getApplicationContext(), AcercaDe.class);
                        startActivity(i);
                        break;
                }

            }
        });

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        txtVw.setText("Mis profesores");
                        break;
                    case 1:
                        txtVw.setText("Buscar");
                        break;
                    case 2:
                        txtVw.setText("Acerca de...");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        // Do nothing if the back button is disabled.
        if (!mBackPressCancelled) {
            // Pop fragment if the back stack is not empty.
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                super.onBackPressed();
            } else {
                if (mBackPressToast != null) {
                    mBackPressToast.cancel();
                }

                long currentTimestamp = System.currentTimeMillis();

                if (currentTimestamp < mBackPressTimestamp + BACK_PRESS_DELAY) {
                    super.onBackPressed();
                } else {
                    mBackPressTimestamp = currentTimestamp;

                    Toast.makeText(this, "Presiona nuevamente para salir", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
