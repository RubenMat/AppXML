package com.example.dm2.appxml;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Actividad1 extends AppCompatActivity {

    ListView listaRSS;
    List<Noticia> datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        NuevaTarea tarea = new NuevaTarea();
        tarea.execute("http://www.europapress.es/rss/rss.aspx");

        listaRSS=(ListView)findViewById(R.id.listaRSS);


    }

    class NuevaTarea extends AsyncTask<String,Void,Boolean>{

        @Override
        protected Boolean doInBackground(String... params) {

            RssParserSax parseador = new RssParserSax(params[0]);

            datos = parseador.parse();


            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            AdaptadorNoticia adaptador = new AdaptadorNoticia(Actividad1.this,datos);
            listaRSS.setAdapter(adaptador);
        }
    }

    class AdaptadorNoticia extends ArrayAdapter<Noticia> {
        public AdaptadorNoticia(Context context, List<Noticia> datos) {
            super(context, R.layout.listanoticias, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listanoticias, null);

            TextView lblTitulo= (TextView) item.findViewById(R.id.noticiaTitulo);
            lblTitulo.setText(getItem(position).getTitulo());
            TextView lblURL = (TextView)item.findViewById(R.id.noticiaLink);
            lblURL.setText(getItem(position).getUrl());
            TextView lblDesc =(TextView)item.findViewById(R.id.noticiaDesc);
            lblDesc.setText(getItem(position).getDescripcion());
            TextView indice = (TextView)item.findViewById(R.id.noticiaFecha);
            indice.setText(getItem(position).getFecha());
            return (item);
        }
    }
}
