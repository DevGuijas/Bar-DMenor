package com.example.bardmenor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormLogin extends AppCompatActivity {

    private EditText editUsuario, editSenha;
    private Button btnEntrar;
    private TextView textTelaCadastro;
    private ProgressBar progressBar;

    // Definindo dados fixos de usuário e senha
    private final String USERNAME = "Sara";
    private final String PASSWORD = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        iniciarComponentes();

        // Ajustando as bordas para o modo imersivo
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Listener para redirecionar para a tela de cadastro
        textTelaCadastro.setOnClickListener(view -> {
            Intent intent = new Intent(FormLogin.this, FormCadastro.class);
            startActivity(intent);
        });

        // Listener para o botão de login
        btnEntrar.setOnClickListener(view -> {
            String usuario = editUsuario.getText().toString();
            String senha = editSenha.getText().toString();

            if (usuario.isEmpty() || senha.isEmpty()) {
                Toast.makeText(FormLogin.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                validarLogin(usuario, senha);
            }
        });
    }

    // Função para iniciar os componentes da interface
    private void iniciarComponentes() {
        editUsuario = findViewById(R.id.edit_usuario);
        editSenha = findViewById(R.id.edit_senha);
        btnEntrar = findViewById(R.id.btn_entrar);
        textTelaCadastro = findViewById(R.id.text_tela_cadastro);
        progressBar = findViewById(R.id.progressbar);
    }

    // Função para validar o login
    private void validarLogin(String usuario, String senha) {
        progressBar.setVisibility(View.VISIBLE);

        // Simulando verificação simples de login
        if (usuario.equals(USERNAME) && senha.equals(PASSWORD)) {
            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
            abrirPaginaPrincipal();
        } else {
            Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
        }

        progressBar.setVisibility(View.INVISIBLE);
    }

    // Função para abrir a página principal após o login
    private void abrirPaginaPrincipal() {
        Intent intent = new Intent(FormLogin.this, Cardapio.class);
        startActivity(intent);
        finish(); // Opcional, para remover a activity de login da pilha
    }
}