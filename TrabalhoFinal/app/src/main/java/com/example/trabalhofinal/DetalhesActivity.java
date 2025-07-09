package com.example.trabalhofinal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trabalhofinal.databinding.ActivityDetalhesBinding;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetalhesBinding binding = ActivityDetalhesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Sobre");

        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String versao = "Versão " + pInfo.versionName;
            binding.txtVersao.setText(versao);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            binding.txtVersao.setText("Versão 1.0");
        }
    }
}