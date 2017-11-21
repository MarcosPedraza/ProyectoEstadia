package com.example.marcospedraza.proyectoestadia;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.security.auth.Subject;

import static android.widget.Toast.*;

/**
 * Created by Marcos Pedraza on 23/09/2016.
 */
public class AdaptadorCardview extends RecyclerView.Adapter<AdaptadorCardview.CardViewHolder> {

    private final Context context;

 //   private OnItemClickListener escucha;

    private List<Lugares> items;


    public static class CardViewHolder extends RecyclerView.ViewHolder {


        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre, descrip;
        public Button btn_saber;



        public CardViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.foto);
            nombre = (TextView) v.findViewById(R.id.nombre);
            descrip = (TextView)v.findViewById(R.id.descripcion);
            btn_saber = (Button)v.findViewById(R.id.button_saber);


        }

    }

    //constructor de mi clase AdaptadorCardview
    public AdaptadorCardview(Context context, List<Lugares> items) {
        this.context = context;

        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista, viewGroup, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder viewHolder, final int i)      {


        Glide.with(viewHolder.imagen.getContext())
                .load(items.get(i).getImagen())
                .centerCrop()
                .into(viewHolder.imagen);

        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.descrip.setText(items.get(i).getDescripcion());



       // el Onclick actua sobre la instancia de de viewHolder no sobre la view principal jaja que pendejo estoy :v
        viewHolder.btn_saber.setOnClickListener(new View.OnClickListener() {
            @



                    Override
            public void onClick(View v) {

                //el nuevo intent le pasamos como parametros el contexto de la ctivity padre del fragment PlaceHolderFragmet
                Intent star = new Intent(context,ActividadDetalle.class);

               // Pair<View, String> pair1 = Pair.create((View) viewHolder.nombre, "txtTitulo");


                star.putExtra("imag",items.get(i).getImagen());


                star.putExtra("titulo",items.get(i).getNombre());
                star.putExtra("descr",items.get(i).getDescripcion());

                /*

                //ANIMAR ITEMS--------------
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {

                    viewHolder.imagen.setTransitionName("myImaTran");
                    Pair<View, String> pair2 = Pair.create((View) viewHolder.imagen, viewHolder.imagen.getTransitionName());
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,pair2);

                    //iniciamos activity sobre nuestro contexto
                    context.startActivity(star,optionsCompat.toBundle());

                }
                else
                {
                    context.startActivity(star);
                }

                */

                context.startActivity(star);

               // Toast.makeText(context,"posicion de click:" + i,Toast.LENGTH_SHORT).show();

            }
        });


    }

}


