package dev.acl.armandocl.sisinfo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CorreosProfesores extends AppCompatActivity {
    ListView lstCorreos;
    Intent i;
    // declare class variables
    private ArrayList<Profesores> m_parts = new ArrayList<Profesores>();
    private Runnable viewParts;
    private CorreosAdapter m_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correos_profesores);
        lstCorreos=(ListView)findViewById(R.id.lstCorreos);
        int[] colors = {0, Color.rgb(0, 102, 0), 0};
        lstCorreos.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        lstCorreos.setDividerHeight(3);

        // instantiate our ItemAdapter class
        m_adapter = new CorreosAdapter(this, R.layout.correos, m_parts);
        lstCorreos.setAdapter(m_adapter);

        lstCorreos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Profesores Profesor = (Profesores) parent.getItemAtPosition(position);
                Uri uri = Uri.parse("mailto:"+Profesor.getCorreo());
                i = new Intent(Intent.ACTION_SENDTO, uri);
                i.putExtra(Intent.EXTRA_SUBJECT, "Para "+Profesor.getNambre());
                startActivity(i);
            }
        });
        // here we are defining our runnable thread.
        viewParts = new Runnable(){
            public void run(){
                handler.sendEmptyMessage(0);
            }
        };

        // here we call the thread we just defined - it is sent to the handler below.
        Thread thread =  new Thread(null, viewParts, "MagentoBackground");
        thread.start();
    }

    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            // create some objects
            // here is where you could also request data from a server
            // and then create objects from that data.
            m_parts.add(new Profesores("José Armando Cárdenas Lara",  "lnhcardenas@gmail.com"));
            m_parts.add(new Profesores("Jimenez Sanchez Valeria (Secretaria)",  "valeria.jimenez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Molina Castro Jose Benigno (Jefe de Departamento)", "sistemasinformatica@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Ramirez Gonzalez Elda", "elda.ramirez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Rodriguez Garcia Elso", "elsorodriguez@yahoo.com"));
            m_parts.add(new Profesores("Luna Ramos Luis Alfredo", "alfredo.luna@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Ramirez Perez Norma Veronica", "norma.ramirez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Gutierrez Vera Francisco", "francisco.gutierrez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Rojas Leon Mario", "rjsmario@gmail.com"));
            m_parts.add(new Profesores("Garcia Felix Ricardo Elpidio", "ricardo.garcia@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Villagomez Torres Donato", "donato.villagomez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Villagomez Torres Donato (Coordinador)", "coordsisinf@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Gonzalez Gonzalez Ricardo", "ricardo.gonzalez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Beltran Prieto Luis Antonio", "luis.beltran@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Euresty Uribe Carlos Gerardo", "gerardo.euresty@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Godoy Zarate Jose Emigdio", "emigdio.godoy@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Juarez Fernandez Mayolo", "mayolo.juarez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Hernandez Morales Maria de Jesus", "jesus.hernandez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Torres Frias Ruben", "isctorres@gmail.com"));
            m_parts.add(new Profesores("Flores Vazquez Juana Maria", "juana.flores@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Gomez Hidalgo Maria del Pilar", "pilar.gomez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Rodriguez Rodriuez Jose", "joserod16@hotmail.com"));
            m_parts.add(new Profesores("Rodriguez Rodriuez Jose", "jose.rodriguez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Monsivais Tovar Miguel Angel", "miguelmonsi@yahoo.com"));
            m_parts.add(new Profesores("Asato España Julio Armando", "julio.asato@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Razo Duron Evelia", "evelia.razo@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Sosa de Santiago Jose Salvador", "salvador.sosa@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Hernandez Hernandez Ana Bertha", "anabertha.hdez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Alcaraz Avendaño Claudia Mayela", "claudia.alcaraz@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Vinculacion Sistemas e Informatica", "vinculacion.sisinfo@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Fierro Mendoza Jose Guillermo", "guillermo.fierro@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Galvan Morales Patricia", "patricia.galvan@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Silva Omaña Viridiana", "viridiana.omana@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Cerca Vazquez Juan Ignacio", "nacho@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Garcia Gonzalez Franco Fabio", "franco.garcia@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Rodriguez Villafaña Jose Guillermo", "guillermo.rodriguez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Zendejas Morales Bernardo", "zendejas@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Sanchez Farias Jose Jesus", "jesus.sanchez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Gonzalez Farias Jose Porfirio", "porfirio.gonzalez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Lopez Gonzalez Luis Alberto", "luislao@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Grimaldo Aguayo Oscar", "oscar.grimaldo@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Soto Arriola Ramon", "ramon.soto@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Ortega de la Mora Guillermo", "guillermo.ortega@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Alamos Villanueva Zulma Griselda", "zulma.alamos@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Espinoza Castro Ruben", "ruben.espinoza@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Guerrero Barron Alejandro", "alejandro.guerrero@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Oyuky Maria Leon Leon", "oyuky.leon@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Ortega Gonzalez Claudia Cristina", "claudia.ortega@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Gutierrez Moreno Juana Imelda", "juana.gutierrez@itcelaya.edu.mx"));
            m_parts.add(new Profesores("Cornejo Medina Lilian", "lilian.cornejo@itcelaya.edu.mx"));

            m_adapter = new CorreosAdapter(CorreosProfesores.this, R.layout.correos, m_parts);

            // display the list.
            lstCorreos.setAdapter(m_adapter);
        }
    };

}
