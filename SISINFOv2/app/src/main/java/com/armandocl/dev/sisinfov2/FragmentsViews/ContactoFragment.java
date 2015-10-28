package com.armandocl.dev.sisinfov2.FragmentsViews;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.armandocl.dev.sisinfov2.MainActivity;
import com.armandocl.dev.sisinfov2.R;


public class ContactoFragment extends Fragment{
    Context context = null;
    AutoCompleteTextView To;
    EditText Subject, Body;
    String Receptor, Asunto, Cuerpo;
    Intent i;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacto, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Contacto");

        context = view.getContext();

        Button login = (Button) view.findViewById(R.id.btnEnviarCorreo);
        To = (AutoCompleteTextView) view.findViewById(R.id.edtPara);
        Subject = (EditText) view.findViewById(R.id.edtAsunto);
        Body = (EditText) view.findViewById(R.id.edtBody);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Receptor = To.getText().toString();
                Asunto = Subject.getText().toString();
                Cuerpo = Body.getText().toString();
                i=new Intent();
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, Receptor);
                i.setData(Uri.parse("mailto:"+Receptor));
                i.putExtra(Intent.EXTRA_SUBJECT, Asunto);
                i.putExtra(Intent.EXTRA_TEXT, Cuerpo);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_FROM_BACKGROUND);
                try {
                    startActivity(i);
                } catch (android.content.ActivityNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Log.d("Email error:", e.toString());
                }

            }
        });
        return view;
    }



}