package com.example.marcospedraza.proyectoestadia;

/**
 * Created by Marcos Pedraza on 23/09/2016.
 */
public class Lugares {

    private int imagen;
    private String nombre,descripcion;

    private String[] imgPager;


    public Lugares(int imagen, String nombre,String desc) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = desc;

    }

    public String getNombre()
    {
        return nombre;
    }

    public int getImagen()
    {
        return imagen;
    }

    public String getDescripcion()
    {
        return descripcion;
    }



}
