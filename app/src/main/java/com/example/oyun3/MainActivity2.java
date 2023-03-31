package com.example.oyun3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
{
    private EditText Oyuncu1,Oyuncu2;
    private Button basla;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        basla=findViewById(R.id.oyunbasla);
        Oyuncu1=findViewById(R.id.BirinciOyuncu);
        Oyuncu2=findViewById(R.id.ikinciOyuncu);

        basla.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final String o1,o2;
                o1= Oyuncu1.getText().toString();
                o2= Oyuncu2.getText().toString();

                if(o1.isEmpty() || o2.isEmpty())
                {
                    Toast.makeText(MainActivity2.this, "isimleri Giriniz...", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                    intent.putExtra("BirinciOyuncu",o1);
                    intent.putExtra("ikinciOyuncu",o2);
                    startActivity(intent);
                }

            }
        });

    }
}