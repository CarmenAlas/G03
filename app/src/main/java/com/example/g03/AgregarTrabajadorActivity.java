package com.example.g03;

import static com.example.g03.MainActivity.lstTrabajadores;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.g03.databinding.ActivityAgregarTrabajadorBinding;
import com.example.g03.models.TrabajadorHora;
import com.example.g03.models.TrabajadorTiempoCompleto;
import com.google.android.material.textfield.TextInputLayout;

public class AgregarTrabajadorActivity extends AppCompatActivity {



    private ActivityAgregarTrabajadorBinding binding;
    private Bundle bundle;
    private int idEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgregarTrabajadorBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        if(idEleccion == 1){
            // Trabajador hora
            binding.txtLyoutSalario.setVisibility(View.GONE);


        }else{
            // Tiempo completo
            binding.txtLyoutValue.setVisibility(View.GONE);
            binding.txtLyoutHour.setVisibility(View.GONE);
        }

        binding.btnAgregar.setOnClickListener(v -> {
            if(idEleccion == 1){
                // Trabajador hora
                AgregarTrabajadorHora();

            }else{
                // Tiempo completo
                AgregarTrabajadorTiempoCompleto();

            }


            new AlertDialog.Builder(this).setMessage("REGISTRADO!!  " +
                            "Registro con exito")
                .setPositiveButton("ACEPTAR", (dialog, which) -> finish()).show();

        });

    }

    private void AgregarTrabajadorTiempoCompleto() {
            if(binding.edtID.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el codigo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtSalario.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el salario", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorTiempoCompleto(
                        binding.edtID.getText().toString(),
                        binding.edtNombre.getText().toString(),
                        binding.edtApellido.getText().toString(),
                        Float.valueOf(binding.edtValor.getText().toString())
                )
        );
    }

    private void AgregarTrabajadorHora() {
        if(binding.edtID.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el codigo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtValor.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el valor de la hora", Toast.LENGTH_SHORT).show();
            return;
        }
        if(binding.edtHora.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar las horas trabajadas", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorHora(
                        binding.edtID.getText().toString(),
                        binding.edtNombre.getText().toString(),
                        binding.edtApellido.getText().toString(),
                        Integer.parseInt(binding.edtHora.getText().toString()),
                        Float.valueOf(binding.edtValor.getText().toString()))
        );
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
