package com.example.g03;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.g03.databinding.ActivityElegirTipoTrabajadorBinding;

public class ElegirTipoTrabajadorActivity extends AppCompatActivity {
   ;

    private ActivityElegirTipoTrabajadorBinding binding;
    private Bundle bundle;
    private int idEleccion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityElegirTipoTrabajadorBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        binding.rbTHora.setOnClickListener(v -> idEleccion = 1); // En caso de que el usuario elija libro
        binding.rbTTCompleto.setOnClickListener(v -> idEleccion = 2); // En caso de que el usuario elija revista

        binding.btnSiguiente.setOnClickListener(v -> {
            bundle = new Bundle();
            bundle.putInt("tipoEleccion", idEleccion);
            Intent intent = new Intent(this, AgregarTrabajadorActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
