package com.jeancosta.aulapedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");

    }
    public void selecionarPapel(View view){
        verificarGanhador("papel");

    }
    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");

    }

    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int gerarNumeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaDoApp = opcoes[gerarNumeroAleatorio];
        switch (escolhaDoApp){
            case "pedra" :
                imagemApp.setImageResource(R.drawable.pedra);

                break;

            case "papel" :
                imagemApp.setImageResource(R.drawable.papel);

                break;

            case "tesoura" :
                imagemApp.setImageResource(R.drawable.tesoura);

                break;
        }

        return escolhaDoApp;
    }

    private void verificarGanhador(String escolhaUsuario){

        String escolhaDoApp = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if (
                (escolhaDoApp == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaDoApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaDoApp == "tesoura" && escolhaUsuario == "papel")
        ){
            textoResultado.setText("Você perdeu! =(");

        } else if (

                (escolhaUsuario == "pedra" && escolhaDoApp  == "tesoura") ||
                (escolhaUsuario == "papel" && escolhaDoApp  == "pedra") ||
                (escolhaUsuario == "tesoura" && escolhaDoApp  == "papel")
        ) {
            textoResultado.setText("Você ganhou! =)");

        }
        else {
            textoResultado.setText("Deu empate! =|");

        }

    }


}

