package com.example.g03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.g03.databinding.ActivityMainBinding;
import com.example.g03.models.Trabajador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    public static ArrayList<Trabajador> lstTrabajadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        lstTrabajadores = new ArrayList<Trabajador>();

        binding.btnAgregar.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, ElegirTipoTrabajadorActivity.class));
        });

        binding.btnMostrar.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, MostrarListaActivity.class));
        });

        binding.btnAcercaDe.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AcercaDeActivity.class));
        });
    }
}