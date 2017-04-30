package com.desarrollohidrocalido.llenarspinnerdesarrollohidrocalido;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.desarrollohidrocalido.llenarspinnerdesarrollohidrocalido.clasesSpinners.EjemploSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerEjemplo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llenarSpinnersEjemplo(1);
        llenarSpinnersEjemplo(2);
    }



    private void llenarSpinnersEjemplo(int numSpinner) {
        ArrayList<EjemploSpinner> list = new ArrayList<>();
        list.add(new EjemploSpinner(0,"Seleccionar..."));
        for (int i=1;i<5;i++){
            list.add(new EjemploSpinner(i,"Ejemplo "+i));
        }
        switch (numSpinner){
            case 1:
                spinnerEjemplo = (Spinner) findViewById(R.id.spinnerEjemplo1);
                break;
            case 2:
                spinnerEjemplo = (Spinner) findViewById(R.id.spinnerEjemplo2);
                break;
        }

        ArrayAdapter<EjemploSpinner> adapter =
                new ArrayAdapter<EjemploSpinner>(this, R.layout.spinner_layaout_ejemplo, list);
        adapter.setDropDownViewResource(R.layout.spinner_layaout_ejemplo);
        spinnerEjemplo.setAdapter(adapter);
        spinnerEjemplo.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        if ((pos!=0) && (id!=0)) {
                            Object item = parent.getItemAtPosition(pos);
                            int idSeleccionado = ((EjemploSpinner) item).getId();
                            String nombre = ((EjemploSpinner) item).getNombre();
                            Toast.makeText(getBaseContext(), nombre, Toast.LENGTH_SHORT).show();
                        }
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
    }
}
