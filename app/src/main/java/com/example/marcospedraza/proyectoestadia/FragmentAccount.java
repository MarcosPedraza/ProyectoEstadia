package com.example.marcospedraza.proyectoestadia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Marcos Pedraza on 25/10/2017.
 */

public class FragmentAccount extends Fragment {

    CircleImageView profileImg;
    Button btnLogOut;

    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_account, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Cuenta de Usuario");

        mAuth = FirebaseAuth.getInstance();


        btnLogOut = (Button)view.findViewById(R.id.btn_logout);


        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });






        return view;

    }


}
