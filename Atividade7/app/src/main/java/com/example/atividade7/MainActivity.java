package com.example.atividade7;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar myToobar = findViewById(R.id.toolbar);
        myToobar.setBackgroundColor(Color.parseColor("#6200EE"));
        setSupportActionBar(myToobar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.act_add){
            Toast.makeText(this, getString(R.string.msg_add), Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.act_edit){
            Toast.makeText(this, getString(R.string.msg_edit), Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.act_delete){
            Toast.makeText(this, getString(R.string.msg_delete), Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.act_help){
            Toast.makeText(this, getString(R.string.act_help), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}