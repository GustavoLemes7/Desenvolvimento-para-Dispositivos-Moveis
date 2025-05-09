package com.example.avaliacao;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.net.URL;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BaixarImagemTask {
    private Button btnProcessar;
    private ImageView imagem;
    private ProgressBar pgbProgresso;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public BaixarImagemTask(Button btnProcessar, ImageView imagem, ProgressBar pgbProgresso) {
        this.btnProcessar = btnProcessar;
        this.imagem = imagem;
        this.pgbProgresso = pgbProgresso;
    }

    public void iniciarProcessamento(int max, String url){
        btnProcessar.setEnabled(false);
        pgbProgresso.setProgress(0);
        pgbProgresso.setVisibility(View.VISIBLE);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = null;
                try {
                    //faz o download da imagem
                    InputStream in = new URL(url).openStream();
                    //converte a InputStream do Java para Bitmap
                    bitmap = BitmapFactory.decodeStream(in);
                    in.close();
                    //atualiza a view com a imagem
                    imagem.setImageBitmap(bitmap);

                    int i = 0;
                    while (i < max) {
                        SystemClock.sleep(1000);
                        final int progresso = i;
                        mainHandler.post(() -> pgbProgresso.setProgress(progresso));
                        i++;
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    mainHandler.post(() -> {
                        pgbProgresso.setVisibility(View.INVISIBLE);
                        btnProcessar.setEnabled(true);
                    });
                    return;
                }
                mainHandler.post(() -> {
                    pgbProgresso.setVisibility(View.INVISIBLE);
                    btnProcessar.setEnabled(true);
                });
            }
        });
    }
}
