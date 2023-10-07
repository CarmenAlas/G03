package com.example.g03;

import static com.example.g03.MainActivity.lstTrabajadores;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.g03.models.TrabajadorHora;
import com.example.g03.models.TrabajadorTiempoCompleto;
import com.google.android.material.textfield.TextInputLayout;

public class AgregarTrabajadorActivity extends AppCompatActivity {
    Button btnAgregar;
    EditText edtSalario, edtCodigo, edtNombre, edtApellido, edtEdad, edtValor, edtHora;
    private TextInputLayout edtSal, edtValr, edtHor;
    private Bundle bundle;
    private int idEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_trabajador);

        btnAgregar = findViewById(R.id.btnAgregar);

        edtSalario = findViewById(R.id.edtSalario);
        edtCodigo = findViewById(R.id.edtID);
        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtEdad = findViewById(R.id.edtEdad);
        edtValor = findViewById(R.id.edtValor);
        edtHora = findViewById(R.id.edtHora);

        edtSal = findViewById(R.id.txtLyoutSalario);
        edtValr = findViewById(R.id.txtLyoutValue);
        edtHor= findViewById(R.id.txtLyoutHour);

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        if(idEleccion == 1){
            // Trabajador hora
           edtSal.setVisibility(View.GONE);


        }else{
            // Tiempo completo
            edtValr.setVisibility(View.GONE);
            edtHor.setVisibility(View.GONE);

        }

        btnAgregar.setOnClickListener(view -> {
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
        if(edtCodigo.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el codigo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtSalario.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el salario", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorTiempoCompleto(
                        edtCodigo.getText().toString(), edtNombre.getText().toString(),
                        edtApellido.getText().toString(), Float.valueOf(edtSalario.getText().toString()))
        );
    }

    private void AgregarTrabajadorHora() {
        if(edtCodigo.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el codigo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtNombre.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtApellido.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el apellido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtEdad.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar la edad", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtValor.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar el valor de la hora", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtHora.getText().toString().equals("")){
            Toast.makeText(this, "Debe ingresar las horas trabajadas", Toast.LENGTH_SHORT).show();
            return;
        }

        lstTrabajadores.add(
                new TrabajadorHora(
                        edtCodigo.getText().toString(), edtNombre.getText().toString(),
                        edtApellido.getText().toString(), Integer.parseInt(edtHora.getText().toString()),
                        Float.valueOf(edtValor.getText().toString()))
        );
    }
}
