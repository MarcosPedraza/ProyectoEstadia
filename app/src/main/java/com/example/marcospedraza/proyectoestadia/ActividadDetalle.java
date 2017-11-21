package com.example.marcospedraza.proyectoestadia;

import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
//import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.marcospedraza.proyectoestadia.pageradapters.SlidePagerAdapter;
//import com.facebook.appevents.internal.Constants;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Marcos Pedraza on 03/10/2016.
 */

public class ActividadDetalle extends AppCompatActivity {

    TextView titulo,descripcion;
    ImageView cabecera;

    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

       // supportPostponeEnterTransition();

        String[] images = {
                "https://www.elindependientedehidalgo.com.mx/wp-content/uploads/2017/04/PAG-24-CALNALI-ESPECIAL.jpg",
                "https://mw2.google.com/mw-panoramio/photos/medium/28252423.jpg",
                "http://www.azul-natour.com/imagenes/vision-global/calnali-baile-frente-palacio-municipal.jpg"
        };

        SlidePagerAdapter mPagerAdapter = new SlidePagerAdapter(this, images);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        mViewPager = (ViewPager) findViewById(R.id.pager_cabecera);
        mViewPager.setAdapter(mPagerAdapter);
        indicator.setViewPager(mViewPager);

        //cabecera = (ImageView)findViewById(R.id.cabecera);
        titulo =(TextView)findViewById(R.id.titulo_detalle);
        descripcion = (TextView)findViewById(R.id.descripcion);




        //String refStrin = "R.drawable.calnali";
       // int resource = Integer.parseInt(refStrin);


        int imag = getIntent().getIntExtra("imag",R.drawable.calnali);

        /*

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            cabecera.setTransitionName("myImaTran");
        }

        */

       //Glide.with(cabecera.getContext()).load(imag).centerCrop().into(cabecera);
       // supportStartPostponedEnterTransition();


        String detalleTitle = getIntent().getStringExtra("titulo");
        String detalleDesc = getIntent().getStringExtra("descr");

        titulo.setText(detalleTitle);
        descripcion.setText(detalleDesc);


    }
}
