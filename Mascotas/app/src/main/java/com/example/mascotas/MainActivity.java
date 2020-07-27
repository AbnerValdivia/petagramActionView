package com.example.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private FloatingActionButton fab;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);

        toolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
    //    getSupportActionBar().getCustomView(R.layout.actionbar);

        listaMascotas = findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        InicializarMascotas();
        InicializarAdaptador();
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_MascFav:
                Intent intent = new Intent(this,MascotasFavoritas.class);
                startActivity(intent);
                Toast.makeText(this,"Buscar",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    public void InicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }
    public void InicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.icons8_gorila_48,"Gorila","5"));
        mascotas.add(new Mascota(R.drawable.icons8_jaguar_negro_48,"Jaguar","2"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"Jake","8"));
        mascotas.add(new Mascota(R.drawable.icons8_perro_48,"Perro","12"));
        mascotas.add(new Mascota(R.drawable.icons8_gorila_48,"Gorila","5"));
        mascotas.add(new Mascota(R.drawable.icons8_jaguar_negro_48,"Jaguar","2"));
    }

    public void IniciarCamara(View v){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},100);
            return;
        }
        startActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
    }

    public void pasarFavoritas(View v){
        Intent intent = new Intent(this,MascotasFavoritas.class);
        startActivity(intent);
    }
}
