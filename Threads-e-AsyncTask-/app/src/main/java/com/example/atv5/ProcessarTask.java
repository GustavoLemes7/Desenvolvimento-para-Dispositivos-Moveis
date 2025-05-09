package com.example.atv5;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask <Integer, Integer, Void>{
    private Button btnProcessar;
    private TextView txtContador;

    public ProcessarTask(Button btnProcessar, TextView txtContador) {
        this.btnProcessar = btnProcessar;
        this.txtContador = txtContador;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        btnProcessar.setEnabled(false);
        txtContador.setVisibility(View.VISIBLE);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int min = integers[0];
        for(int i=10; i>=min; i--){
            SystemClock.sleep(1000);
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int progresso = values[0];
        txtContador.setText(String.valueOf(progresso));
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        txtContador.setVisibility(View.INVISIBLE);
        btnProcessar.setEnabled(true);
    }
}
