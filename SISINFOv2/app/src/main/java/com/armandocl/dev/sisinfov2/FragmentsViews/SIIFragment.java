package com.armandocl.dev.sisinfov2.FragmentsViews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.armandocl.dev.sisinfov2.Classes.SISINFOWebClient;
import com.armandocl.dev.sisinfov2.MainActivity;
import com.armandocl.dev.sisinfov2.R;


public class SIIFragment extends Fragment {
    WebView wv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_about, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Sistema Integral");
        wv=(WebView)view.findViewById(R.id.webViewer);
        WebSettings ws=wv.getSettings();
        wv.loadUrl("https://sii.itcelaya.edu.mx/sii/index.php?r=cruge/ui/login");
        wv.setWebViewClient(new SISINFOWebClient());

        //¡Lógica aqui!

        return view;
    }


}