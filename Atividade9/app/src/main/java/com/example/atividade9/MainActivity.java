package com.example.atividade9;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewDataHora;
    private Calendar calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewDataHora = findViewById(R.id.textViewDataHora);
        Button botaoData = findViewById(R.id.buttonData);
        Button botaoHora = findViewById(R.id.buttonHora);
        setSupportActionBar(findViewById(R.id.toolbar));


        calendario = Calendar.getInstance();
        atualizarTexto();

        botaoData.setOnClickListener(v -> {
            new DatePickerDialog(this,
                    (view, year, month, dayOfMonth) -> {
                        calendario.set(Calendar.YEAR, year);
                        calendario.set(Calendar.MONTH, month);
                        calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        atualizarTexto();
                    },
                    calendario.get(Calendar.YEAR),
                    calendario.get(Calendar.MONTH),
                    calendario.get(Calendar.DAY_OF_MONTH)).show();
        });

        botaoHora.setOnClickListener(v -> {
            new TimePickerDialog(this,
                    (view, hourOfDay, minute) -> {
                        calendario.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendario.set(Calendar.MINUTE, minute);
                        atualizarTexto();
                    },
                    calendario.get(Calendar.HOUR_OF_DAY),
                    calendario.get(Calendar.MINUTE),
                    true).show();
        });
    }

    private void atualizarTexto() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", new Locale("pt", "BR"));
        textViewDataHora.setText(sdf.format(calendario.getTime()));
    }

}
