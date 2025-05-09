package com.example.atividade3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import com.example.atividade3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLimpar.setOnClickListener(this);
        binding.btnExibir.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLimpar){
            binding.edtNome.setText("");
            binding.rdgSexo.clearCheck();
            binding.edtEmail.setText("");
            binding.edtTelefone.setText("");
            binding.chkMusica.setChecked(false);
            binding.chkCinema.setChecked(false);
            binding.chkEsporte.setChecked(false);
            binding.chkGastronomia.setChecked(false);
            binding.swtNotf.setChecked(false);
            binding.lblDados.setVisibility(View.INVISIBLE);

        }
        else if (view.getId() == R.id.btnExibir){
            binding.lblDados.setVisibility(View.VISIBLE);
            binding.txtNome.setText("Nome: "
                    + binding.edtNome.getText().toString());

            int idrdbSelecionado = binding.rdgSexo.getCheckedRadioButtonId();
            if(idrdbSelecionado > 0){
                RadioButton rdbSelecionado = findViewById(idrdbSelecionado);
                binding.txtSexo.setText("Sexo: "
                        + rdbSelecionado.getText().toString());
            }

            binding.txtEmail.setText("E-mail: "
                    + binding.edtEmail.getText().toString());
            binding.txtTelefone.setText("Telefone: "
                    + binding.edtTelefone.getText().toString());

            String pref="";
            if(binding.chkMusica.isChecked())
                pref = binding.chkMusica.getText().toString() ;
            if(binding.chkCinema.isChecked()){
                pref += " ";
                pref += binding.chkCinema.getText().toString() ;
            }
            if(binding.chkEsporte.isChecked()){
                pref += " ";
                pref += binding.chkEsporte.getText().toString() ;
            }
            if(binding.chkGastronomia.isChecked()){
                pref += " ";
                pref += binding.chkGastronomia.getText().toString();
            }
            binding.txtPref.setText("Preferências: " + pref);

            if(binding.swtNotf.isChecked()){
                binding.txtNotificacao.setText("Notificação: "
                        +binding.swtNotf.getTextOn());
            }else{
                binding.txtNotificacao.setText("Notificação: "
                        +binding.swtNotf.getTextOff());
            }
        }
    }
}