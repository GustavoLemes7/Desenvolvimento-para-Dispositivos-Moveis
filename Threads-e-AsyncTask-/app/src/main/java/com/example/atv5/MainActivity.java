package com.example.atv5;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.atv5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnProcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        binding.txtContador.setEnabled(true);
        ProcessarTask task = new ProcessarTask(binding.btnProcessar,
                binding.txtContador);
        task.execute(0);

    }
}