package com.arte.quicknotes.models;

/**
 * Created by arte on 27/04/2016.
 */
public class Note {
    private String titulo;
    private String contenido;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getExcerpt() {
        if (contenido == null ) {
            return "";
        }

        if (contenido.length() < 100)  {
            return contenido;
        }

        return contenido.substring(0,100);
    }
}
