package com.armandocl.dev.sisinfov2.FragmentsViews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.armandocl.dev.sisinfov2.MainActivity;
import com.armandocl.dev.sisinfov2.R;


public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_about, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Acerca de");

        //¡Lógica aqui!

        return view;
    }

}