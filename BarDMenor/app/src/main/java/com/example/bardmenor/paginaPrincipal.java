package com.example.bardmenor;

import static com.example.bardmenor.R.layout.activity_pagina_principal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bardmenor.Adapter.AdapterLocalizacao;
import com.example.bardmenor.model.Localizacao;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class paginaPrincipal extends AppCompatActivity {

    private FrameLayout frameLayout;
    private DrawerLayout drawerLayout;
    private ImageButton buttonDrawerToggle;
    private NavigationView navigationView; // Nova variável para NavigationView
    private BottomNavigationView bottomNavigationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_pagina_principal);

        drawerLayout = findViewById(R.id.drawerLayout);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
        navigationView = findViewById(R.id.navigationView); // Inicialize a NavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });

        // Definindo o listener para os itens do NavigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                // Verifique qual item foi selecionado
                if (itemId == R.id.navHome) {
                    Intent intent = new Intent(paginaPrincipal.this, paginaPrincipal.class);
                    startActivity(intent);
                    finish(); // Fecha a PaginaPrincipal
                    return true;
                }if (itemId == R.id.navCardapio) {
                    Intent intent = new Intent(paginaPrincipal.this, Cardapio.class);
                    startActivity(intent);
                    finish(); // Fecha a PaginaPrincipal
                    return true;
                }
                return false;
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home_bottom) {
                    startActivity(new Intent(paginaPrincipal.this, paginaPrincipal.class));
                    finish();
                    return true;
                } else if (itemId == R.id.cardapio_bottom) {
                    startActivity(new Intent(paginaPrincipal.this, Cardapio.class));
                    finish();
                    return true;
                }
                return false;
            }
        });

        // Configure o RecyclerView
        RecyclerView recyclerViewLocalizacoes = findViewById(R.id.recyclerView_localizacoes);
        recyclerViewLocalizacoes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLocalizacoes.setHasFixedSize(true);

        // Configuração do adapter
        List<Localizacao> listaLocalizacao = new ArrayList<>();
        AdapterLocalizacao adapterLocalizacao = new AdapterLocalizacao(this, listaLocalizacao);
        recyclerViewLocalizacoes.setAdapter(adapterLocalizacao);

        Localizacao localizacao1 = new Localizacao(
                R.drawable.localizazao1,
                "Bar Diolima para menores",
                "Alameda Casa Branca, 92 - Jardim Paulista \nSão Paulo - SP, 01408-001 \nReferência: em frente ao My Fucking Comedy Club",
                "Marcar localização"
        );

        listaLocalizacao.add(localizacao1);
        adapterLocalizacao.notifyDataSetChanged();
    }
}