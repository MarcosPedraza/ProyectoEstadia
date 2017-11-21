package com.example.marcospedraza.proyectoestadia;


import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos Pedraza on 18/09/2016.
 */
public class PlaceHolderFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.section_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Lugares");


        List items = new ArrayList();

        items.add(new Lugares(R.drawable.calnali, "Calnali","Calnali es uno de esos lugares. Creciente entre las maravillas de la huasteca hidalguese, este pintoresco lugar es ideal para sumergirse en los encantos que nuestro estado tiene para ofrecer a propios y extraños. "));
        items.add(new Lugares(R.drawable.huejutla, "Huejutla","También conocida como la perla de la Huasteca, Huejutla es un sitio ideal para los amantes del ecoturismo gracias a sus espacios verdes que propician actividades en las que se entra en contacto con la naturaleza."));
        items.add(new Lugares(R.drawable.real, "Real del Monte","Hermosa ciudad que durante siglos se ha dedicado a la minería, ha pasado por épocas de bonanza, siempre conservando la belleza de sus calles y bellos callejones llenos de atractivos antiguos."));

        //recycler.setNestedScrollingEnabled(true);


        recycler = (RecyclerView) view.findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        adapter = new AdaptadorCardview(getContext(), items);
        recycler.setAdapter(adapter);




        return view;

    }
}
