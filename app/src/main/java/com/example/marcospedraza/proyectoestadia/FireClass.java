package com.example.marcospedraza.proyectoestadia;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Marcos Pedraza on 24/10/2016.
 */

public class FireClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
