package com.armandocl.dev.sisinfov2.FragmentsViews;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.armandocl.dev.sisinfov2.MainActivity;
import com.armandocl.dev.sisinfov2.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ContactoFragment extends Fragment{
    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText reciep, sub, msg;
    String rec, subject, textMessage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacto, container, false);

        //((MainActivity) getActivity()).getSupportActionBar().setTitle("Contacto");

        context = view.getContext();

        Button login = (Button) view.findViewById(R.id.btnEnviarCorreo);
        reciep = (EditText) view.findViewById(R.id.edtPara);
        sub = (EditText) view.findViewById(R.id.edtAsunto);
        msg = (EditText) view.findViewById(R.id.edtBody);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rec = reciep.getText().toString();
                subject = sub.getText().toString();
                textMessage = msg.getText().toString();

                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                session = Session.getDefaultInstance(props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("massoluciones.soft@gmail.com", "abc123/*-");
                    }
                });

                pdialog = ProgressDialog.show(context, "", "Enviando correo", true);

                RetreiveFeedTask task = new RetreiveFeedTask();
                task.execute();
            }
        });
        return view;
    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("massoluciones.soft@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject(subject);
                message.setContent(textMessage, "text/html; charset=utf-8");
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
                //Toast.makeText(getContext(),"Error 1: " + e.toString(), Toast.LENGTH_LONG).show();
            } catch(Exception e) {
                e.printStackTrace();
                //Toast.makeText(getContext(),"Error 2: " + e.toString(), Toast.LENGTH_LONG).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            reciep.setText("");
            msg.setText("");
            sub.setText("");
            Toast.makeText(getContext(), "¡Correo enviado!", Toast.LENGTH_LONG).show();
        }
    }

}