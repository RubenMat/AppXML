package com.example.dm2.appxml;



public class Noticia {

    String titulo,url,descripcion,fecha;

    public Noticia(){

        this.titulo=null;
        this.url=null;
        this.descripcion=null;
        this.fecha=null;
    }

    public Noticia(String titulo, String url, String descripcion, String fecha){

        this.titulo=titulo;
        this.url=url;
        this.descripcion=descripcion;
        this.fecha=fecha;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
