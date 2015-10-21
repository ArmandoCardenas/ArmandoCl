package com.armandocl.dev.sisinfov2.FragmentsViews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.armandocl.dev.sisinfov2.MainActivity;
import com.armandocl.dev.sisinfov2.R;


public class InicioFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("¡Bienvenido lince!");

        //¡Lógica aqui!

        return view;
    }

}