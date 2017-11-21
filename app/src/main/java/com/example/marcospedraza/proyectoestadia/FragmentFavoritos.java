package com.example.marcospedraza.proyectoestadia;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.marcospedraza.proyectoestadia.FireClass;

/**
 * Created by Marcos Pedraza on 24/10/2016.
 */

public class FragmentFavoritos extends Fragment {

    private RecyclerView recyclerview;
    private DatabaseReference mDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_favoritos, container, false);





        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Fragment Favotitos");

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Favoritos");




        recyclerview = (RecyclerView)view.findViewById(R.id.recyclerFavoritos);
        recyclerview.setHasFixedSize(true);
        recyclerview.addItemDecoration(new DividerItemDecoration(getContext(),1));
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));




       // DatabaseReference dbref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appestadia.firebaseio.com/Favoritos");




        return view;

    }

    @Override
    public void onStart() {
            super.onStart();

        FirebaseRecyclerAdapter<FavoritosClass, FavViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<FavoritosClass, FavViewHolder>(
                FavoritosClass.class,
                R.layout.item_favoritos,
                FavViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(FavViewHolder viewHolder, FavoritosClass model, int position) {
                viewHolder.setTitulo(model.gettitulo());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImag(model.getImag());

            }
        };

        recyclerview.setAdapter(firebaseRecyclerAdapter);


    }

    public static class FavViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public FavViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setTitulo(String titulo)
        {

            TextView txt_titulo = (TextView)mView.findViewById(R.id.txt_titulo_fav);
            txt_titulo.setText(titulo);

        }

        public void setDesc(String desc)
        {

            TextView txt_Desc = (TextView)mView.findViewById(R.id.txt_desc_fav);
            txt_Desc.setText(desc);

        }

        public void setImag(String imag)
        {

            ImageView imaLug = (ImageView)mView.findViewById(R.id.imag_favoritos);

            Log.e("URL imagen: ",imag);

            if(imag != null)
            {

                Glide.with(mView.getContext()).load(imag).into(imaLug);

            } else
            {
                Glide.with(mView.getContext()).load(R.drawable.cloud_noconnection).into(imaLug);
            }


        }


    }

}
