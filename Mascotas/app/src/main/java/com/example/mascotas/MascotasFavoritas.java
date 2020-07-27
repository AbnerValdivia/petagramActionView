package com.example.mascotas;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {
    /*private int foto;
    private String nombre;
    private String rating;*/
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotasFavoritas;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

       // Bundle extra = getIntent().getBundleExtra("extra");
       // mascotas = (ArrayList<Mascota>) extra.getSerializable("mascotasSer");
       /* Bundle parametros = getIntent().getExtras();
        int foto = parametros.getInt("foto");
        String nombre = parametros.getString("nombre");
        String rating = parametros.getString("rating");*/

        toolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasFavoritas = findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFavoritas.setLayoutManager(llm);
        InicializarMascotas();
        InicializarAdaptador();
    }

    public void InicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotasFavoritas.setAdapter(adaptador);
    }
    public void InicializarMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"Jake M","8"));
        mascotas.add(new Mascota(R.drawable.icons8_perro_48,"Perro M","12"));
        mascotas.add(new Mascota(R.drawable.icons8_gorila_48,"Gorila M","5"));
        mascotas.add(new Mascota(R.drawable.icons8_jaguar_negro_48,"Jaguar M","2"));

    }
}
