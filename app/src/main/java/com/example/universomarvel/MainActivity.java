package com.example.universomarvel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import android.view.*;


public class MainActivity extends AppCompatActivity {

    ImageSwitcher imgFoto, imgSobre;
    Button btnProximo, btnAnterior;
    int indice = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnterior = findViewById(R.id.btnAnterior);
        btnProximo = findViewById(R.id.btnProximo);



        imgFoto = (ImageSwitcher) findViewById(R.id.imgFoto);
        imgFoto.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        imgSobre = (ImageSwitcher) findViewById(R.id.imgSobre);
        imgSobre.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });


        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indice > 1){
                    indice -- ;
                    MostrarInfoPersonagem();
                }
            }
        });

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indice < 4){
                    indice ++ ;
                    MostrarInfoPersonagem();
                }
            }
        });

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        imgFoto.setImageResource(R.drawable.foto_deadpool);
        imgFoto.setInAnimation(in);
        imgFoto.setOutAnimation(out);

        imgSobre.setImageResource(R.drawable.frase_sobre_deadpool);
        imgSobre.setInAnimation(in);
        imgSobre.setOutAnimation(out);
    }
    public void MostrarInfoPersonagem(){
        switch (indice){
            case 1: {
                imgFoto.setImageResource(R.drawable.foto_deadpool);
                imgSobre.setImageResource(R.drawable.frase_sobre_deadpool);
            }break;
            case 2:{
                imgFoto.setImageResource(R.drawable.foto_colossus);
                imgSobre.setImageResource(R.drawable.frase_sobre_colossus);
            }break;
            case 3:{
                imgFoto.setImageResource(R.drawable.foto_megasonico);
                imgSobre.setImageResource(R.drawable.frase_sobre_megasonico);
            }break;
            case 4:{
                imgFoto.setImageResource(R.drawable.man);
                imgSobre.setImageResource(R.drawable.sobre_super);
            }break;
        }
    }

}