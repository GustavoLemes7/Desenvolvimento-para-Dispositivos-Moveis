package com.example.atividade4;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.atividade4.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonAplicar.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {


        int progress = binding.skbTamanho.getProgress();
        if (progress < 10) progress = 10;
        if (progress > 85) progress = 85;
        binding.edtText.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress);

        String edtText = binding.edtText.getText().toString();
        if (binding.chkMaiusculas.isChecked()) {
            edtText = edtText.toUpperCase();
            binding.edtText.setText(edtText);
        }
        int estilo = Typeface.NORMAL;
        if (binding.chkNegrito.isChecked() && binding.chkItalico.isChecked()) {
            estilo = Typeface.BOLD_ITALIC;
        } else if (binding.chkNegrito.isChecked()) {
            estilo = Typeface.BOLD;
        } else if (binding.chkItalico.isChecked()) {
            estilo = Typeface.ITALIC;
        }
        binding.edtText.setTypeface(null, estilo);

        int rdgCor = binding.rdgCor.getCheckedRadioButtonId();
        if (rdgCor == R.id.rdbVermelho) {
            binding.edtText.setTextColor(Color.RED);
        } else if (rdgCor == R.id.rdbAzul) {
            binding.edtText.setTextColor(Color.BLUE);
        } else if (rdgCor == R.id.rdbVerde) {
            binding.edtText.setTextColor(Color.GREEN);
        }


    }
}