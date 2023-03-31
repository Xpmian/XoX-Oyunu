package com.example.oyun3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Kazanma extends Dialog
{
    private final String mesaj;
    private final MainActivity mainActivity;

    Button tekrar;
    TextView mesaj1;

    public Kazanma(@NonNull Context context,String mesaj,MainActivity mainActivity)
    {
        super(context);
        this.mesaj=mesaj;
        this.mainActivity=mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kazanma);

        mesaj1=findViewById(R.id.mesajtext);
        tekrar=findViewById(R.id.tekrardene);

        mesaj1.setText(mesaj);
        tekrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mainActivity.tekraroyna();
                dismiss();
            }
        });

    }
}
