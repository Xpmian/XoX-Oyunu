package com.example.oyun3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private final List<int[]> combinationslist = new ArrayList<>();
    private int [] boxPositions = {0,0,0,0,0,0,0,0,0};
    private int playertun = 1;
    private int totalselectioBoxex=1;


   private TextView BirinciOyuncuismi,ikinciOyuncuismi;
    private LinearLayout BirinciOyuncuLayo,ikinciOyuncuLayo;
    private ImageView im1,im2,im3,im4,im5,im6,im7,im8,im9;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BirinciOyuncuismi=findViewById(R.id.BirinciOyuncuisim);
        ikinciOyuncuismi=findViewById(R.id.İkinciOyuncuisim);

        BirinciOyuncuLayo=findViewById(R.id.BirinciOyuncuLayout);
        ikinciOyuncuLayo=findViewById(R.id.ikinciOyuncuLayout);

        im1=findViewById(R.id.image1);
        im2=findViewById(R.id.image2);
        im3=findViewById(R.id.image3);
        im4=findViewById(R.id.image4);
        im5=findViewById(R.id.image5);
        im6=findViewById(R.id.image6);
        im7=findViewById(R.id.image7);
        im8=findViewById(R.id.image8);
        im9=findViewById(R.id.image9);

        combinationslist.add(new int[]{0,1,2});
        combinationslist.add(new int[]{3,4,5});
        combinationslist.add(new int[]{6,7,8});
        combinationslist.add(new int[]{0,3,6});
        combinationslist.add(new int[]{1,4,7});
        combinationslist.add(new int[]{2,5,8});
        combinationslist.add(new int[]{2,4,6});
        combinationslist.add(new int[]{0,4,8});

        final String birincioyuncuisim = getIntent().getStringExtra("BirinciOyuncu");
        final String ikincioyuncuisim=getIntent().getStringExtra("ikinciOyuncu");

        BirinciOyuncuismi.setText(birincioyuncuisim);
        ikinciOyuncuismi.setText(ikincioyuncuisim);

        im1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(kutudolubos(0))
                {
                    oynanis((ImageView) view ,0 );
                }
            }
        });

        im2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(kutudolubos(1))
                {
                    oynanis((ImageView) view ,1 );
                }
            }
        });

        im3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(kutudolubos(2))
                {
                    oynanis((ImageView) view ,2 );
                }
            }
        });

        im4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(kutudolubos(3))
                {
                    oynanis((ImageView) view ,3 );
                }
            }
        });

        im5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(kutudolubos(4))
                {
                    oynanis((ImageView) view ,4 );
                }
            }
        });

        im6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(kutudolubos(5))
                {
                    oynanis((ImageView) view ,5 );
                }
            }
        });

        im7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(kutudolubos(6))
                {
                    oynanis((ImageView) view ,6 );
                }
            }
        });

        im8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(kutudolubos(7))
                {
                    oynanis((ImageView) view ,7 );
                }
            }
        });

        im9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(kutudolubos(8))
                {
                    oynanis((ImageView) view ,8 );
                }
            }
        });
    }

    private void oynanis(ImageView imageView,int selectedBoxPosition)
    {
        boxPositions[selectedBoxPosition] = playertun;

        if(playertun == 1)
        {
            imageView.setImageResource(R.drawable.icon1);

            if(kazanma())
            {
                Kazanma kazanma1 = new Kazanma(MainActivity.this,BirinciOyuncuismi.getText().toString() + " Kazandın",MainActivity.this);
                kazanma1.setCancelable(false);
                kazanma1.show();
            }
            else if(totalselectioBoxex == 9)
            {
                    Kazanma kazanma = new Kazanma(MainActivity.this,"Berabere",MainActivity.this);
                    kazanma.setCancelable(false);
                    kazanma.show();
            }
            else
            {
                int a = 2;
                OyuncuDegisimi(a);
                totalselectioBoxex++;
            }
        }
        else
        {
            imageView.setImageResource(R.drawable.icon2);

            if(kazanma())
            {
                Kazanma kazanma1 = new Kazanma(MainActivity.this,ikinciOyuncuismi.getText().toString() + " Kazandın",MainActivity.this);
                kazanma1.setCancelable(false);
                kazanma1.show();
            }
            else if(selectedBoxPosition == 9)
            {
                Kazanma kazanma = new Kazanma(MainActivity.this,"Berabere",MainActivity.this);
                kazanma.setCancelable(false);
                kazanma.show();
            }
            else
            {
                int b = 1;
                OyuncuDegisimi(b);
                totalselectioBoxex++;
            }
        }
    }

    private void OyuncuDegisimi(int oyuncu)
    {
        playertun = oyuncu;

        if(playertun == 1)
        {
            BirinciOyuncuLayo.setBackgroundResource(R.drawable.tasarim4);
            ikinciOyuncuLayo.setBackgroundResource(R.drawable.tasarim3);
        }
        else
        {
            BirinciOyuncuLayo.setBackgroundResource(R.drawable.tasarim3);
            ikinciOyuncuLayo.setBackgroundResource(R.drawable.tasarim4);
        }
    }

    private  boolean kazanma()
    {
        boolean cevap = false;

        for(int i =0;i<combinationslist.size();i++)
        {
            final int [] combination = combinationslist.get(i);

            if(boxPositions[combination[0]] == playertun && boxPositions[combination[1]] == playertun && boxPositions[combination[2]] == playertun)
            {
                cevap=true;
            }
        }
        return cevap;
    }

    private boolean kutudolubos(int boxPosition)
    {
        boolean cevap = false;
        if(boxPositions[boxPosition] == 0)
        {
            cevap=true;
        }
        return cevap;
    }

    public void tekraroyna()
    {
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0};
        playertun = 1;
        totalselectioBoxex = 1;

        im1.setImageResource(R.drawable.icon3);
        im2.setImageResource(R.drawable.icon3);
        im3.setImageResource(R.drawable.icon3);
        im4.setImageResource(R.drawable.icon3);
        im5.setImageResource(R.drawable.icon3);
        im6.setImageResource(R.drawable.icon3);
        im7.setImageResource(R.drawable.icon3);
        im8.setImageResource(R.drawable.icon3);
        im9.setImageResource(R.drawable.icon3);


    }
}