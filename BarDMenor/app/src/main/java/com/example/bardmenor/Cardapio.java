package com.example.bardmenor;

import static com.example.bardmenor.R.id.home_bottom;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bardmenor.Adapter.AdapterCardapio;
import com.example.bardmenor.model.CardapioItens;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;
import com.example.bardmenor.R;

import android.view.MenuItem;
import android.widget.Toast;

public class Cardapio extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageButton buttonDrawerToggle;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);


        drawerLayout = findViewById(R.id.drawerLayout);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
        navigationView = findViewById(R.id.navigationView); // Inicialize a NavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.home_bottom);

        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });

        /*navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                // Verifique qual item foi selecionado
                if (itemId == R.id.navHome) {
                    Intent intent = new Intent(Cardapio.this, paginaPrincipal.class);
                    startActivity(intent);
                    finish(); // Fecha a PaginaPrincipal
                    return true;
                }if (itemId == R.id.navCardapio) {
                    Intent intent = new Intent(Cardapio.this, Cardapio.class);
                    startActivity(intent);
                    finish(); // Fecha a PaginaPrincipal
                    return true;
                }
                return false;
            }
        });*/

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == home_bottom) {
                    Toast.makeText(Cardapio.this, "Você já se encontra na página Principal!", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.endereco_bottom) {
                    startActivity(new Intent(Cardapio.this, paginaPrincipal.class));
                    finish();
                    return true;
                }
                return false;
            }
        });


        RecyclerView recyclerView_cardapio = findViewById(R.id.recyclerView_cardapio);
        recyclerView_cardapio.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_cardapio.setHasFixedSize(true);

        // Configuração do adapter
        List<CardapioItens> cardapioItems = new ArrayList<>();
        AdapterCardapio adapterCardapio = new AdapterCardapio(this, cardapioItems);
        recyclerView_cardapio.setAdapter(adapterCardapio);

        // Criando os itens do cardápio usando a classe Kotlin
        CardapioItens hotdog1 = new CardapioItens(
                R.drawable.hotdog1,
                "Hot Dog",
                "Um delicioso cachorro quente paulista! Com muitooo purê de batata inglesa e um rio de molhos à sua escolha! Acompanha batata palha ou vinagrete, uma salsicha, milho e ervilha.",
                "19,00"
        );

        CardapioItens hotdog2 = new CardapioItens(
                R.drawable.hotdog2,
                "Hot Dog prensado",
                "O melhor prensado passando na sua tela! Acompanha duas salsichas, molhos a sua escolha, batata palha e queijo.",
                "14,00"
        );

        CardapioItens hamburguer1 = new CardapioItens(
                R.drawable.hamburguer1,
                "Burguer D'menor ",
                "O mais pedido dos últimos meses! O D'menor é uma explosão de sabores e cores.",
                "14,00"
        );

        CardapioItens hamburguer2 = new CardapioItens(
                R.drawable.hamburguer2,
                "X-burguer",
                "Clássico hambúrguer com carne suculenta, queijo derretido, alface e tomate, servido no pão macio.",
                "14,00"
        );

        CardapioItens hamburguer3 = new CardapioItens(
                R.drawable.hamburguer3,
                "X-egg",
                "Hambúrguer tradicional com carne, queijo e um ovo frito, trazendo uma combinação deliciosa.",
                "14,00"
        );

        CardapioItens hamburguer4 = new CardapioItens(
                R.drawable.hamburguer4,
                "X-tudo",
                "A versão completa do hambúrguer com carne, queijo, presunto, bacon, ovo e salada.",
                "14,00"
        );

        CardapioItens hamburguer5 = new CardapioItens(
                R.drawable.hamburguer5,
                "X-salada",
                "Hambúrguer leve com carne, queijo e uma porção generosa de salada fresca.",
                "14,00"
        );

        CardapioItens isca1 = new CardapioItens(
                R.drawable.iscas1,
                "Iscas de frango ao molho rosê",
                "Tiras de frango empanado crocante, acompanhadas de molho rosê cremoso.",
                "14,00"
        );

        CardapioItens fritas1 = new CardapioItens(
                R.drawable.fritas1,
                "Batata frita tradicional",
                "Batatas crocantes e douradas, perfeitas para acompanhar qualquer prato.",
                "14,00"
        );

        CardapioItens fritas2 = new CardapioItens(
                R.drawable.fritas2,
                "Batata frita com queijo e bacon",
                "Batatas fritas cobertas com queijo derretido e pedaços crocantes de bacon.",
                "14,00"
        );

        CardapioItens pastel1 = new CardapioItens(
                R.drawable.pasteis1,
                "Mini pastéis Mistos (Carne e frango)",
                "Mini Pastéis crocantes recheados com carne e frango, uma explosão de sabores.",
                "14,00"
        );

        CardapioItens bqueijo1 = new CardapioItens(
                R.drawable.bolinhadequeijo1,
                "Bolinha de queijo com Ketchup da casa",
                "Bolinhas de queijo empanadas, acompanhadas de um ketchup artesanal da casa.",
                "14,00"
        );

        CardapioItens drink1 = new CardapioItens(
                R.drawable.drink1,
                "Virgin Mary (Sem álcool)",
                "Versão sem álcool do Bloody Mary, com tomate, especiarias e um toque de limão.",
                "14,00"
        );

        CardapioItens drink2 = new CardapioItens(
                R.drawable.drink2,
                "Drink D'Menor (Sem álcool)",
                "Especialidade da casa com visual roxo, decorado com folhas aromáticas, refrescante e único.",
                "14,00"
        );

        CardapioItens drink3 = new CardapioItens(
                R.drawable.drink3,
                "Piña colada (sem álcool)",
                "Combinação cremosa de abacaxi e leite de coco, trazendo o sabor do Caribe.",
                "14,00"
        );

        CardapioItens drink4 = new CardapioItens(
                R.drawable.drink4,
                "Blueberry Mint Fizz (sem álcool)",
                "Refrescante mistura de mirtilo e hortelã com um toque efervescente.",
                "14,00"
        );

        CardapioItens drink5 = new CardapioItens(
                R.drawable.drink5,
                "Girger Ale (sem álcool)",
                "Bebida leve e refrescante com um toque de gengibre.",
                "14,00"
        );

        CardapioItens drink6 = new CardapioItens(
                R.drawable.drink6,
                "Sangria (Sem álcool)",
                "Uma versão sem álcool da tradicional bebida de frutas, leve e saborosa.",
                "14,00"
        );

        CardapioItens drink7 = new CardapioItens(
                R.drawable.drink7,
                "Virgin Mojito (sem álcool)",
                "Versão sem álcool do mojito, com hortelã, limão e um toque de gás.",
                "14,00"
        );

        // Adicionando itens à lista
        cardapioItems.add(hotdog1);
        cardapioItems.add(hotdog2);
        cardapioItems.add(hamburguer1);
        cardapioItems.add(hamburguer2);
        cardapioItems.add(hamburguer3);
        cardapioItems.add(hamburguer4);
        cardapioItems.add(hamburguer5);
        cardapioItems.add(isca1);
        cardapioItems.add(fritas1);
        cardapioItems.add(fritas2);
        cardapioItems.add(pastel1);
        cardapioItems.add(bqueijo1);
        cardapioItems.add(drink1);
        cardapioItems.add(drink2);
        cardapioItems.add(drink3);
        cardapioItems.add(drink4);
        cardapioItems.add(drink5);
        cardapioItems.add(drink6);
        cardapioItems.add(drink7);

        // Notificando o adapter sobre a atualização dos dados
        adapterCardapio.notifyDataSetChanged();
    }
}