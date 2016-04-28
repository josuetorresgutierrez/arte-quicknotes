package com.arte.quicknotes.models;

import java.io.Serializable;

/**
 * Created by arte on 27/04/2016.
 */
public class Note implements Serializable {

    private String titulo;
    private String contenido;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
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
