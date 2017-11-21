package com.example.marcospedraza.proyectoestadia;

/**
 * Created by Marcos Pedraza on 24/10/2016.
 */

public class FavoritosClass {
    String titulo,desc,imag;


    public FavoritosClass() {
    }
    public FavoritosClass(String titulo, String desc, String imag) {

        this.titulo = titulo;
        this.desc = desc;
        this.imag = imag;
    }

    public String gettitulo()
    {
        return titulo;

    }

    public void settitulo(String titu)
    {
        this.titulo = titu;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getImag()
    {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }


}
