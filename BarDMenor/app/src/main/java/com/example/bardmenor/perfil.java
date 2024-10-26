package com.example.bardmenor;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class perfil extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.perfil_bottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home_bottom) {
                    startActivity(new Intent(perfil.this, Cardapio.class));
                    finish();
                    return true;
                } else if (itemId == R.id.endereco_bottom) {
                    startActivity(new Intent(perfil.this, paginaPrincipal.class));
                    finish();
                    return true;
                } else if (itemId == R.id.cupons_bottom){
                    Toast.makeText(perfil.this, "Por enquanto ainda não temos cupons de desconto!", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.perfil_bottom) {
                    Toast.makeText(perfil.this, "Você já se encontra em perfil!", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}