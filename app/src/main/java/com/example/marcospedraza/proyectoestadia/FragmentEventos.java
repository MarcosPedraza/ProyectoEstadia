package com.example.marcospedraza.proyectoestadia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Marcos Pedraza on 23/09/2016.
 */
public class FragmentEventos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_eventos, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Fragment Eventos");




        return view;

    }

}
