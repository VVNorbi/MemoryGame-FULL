package com.example.memorygame_all;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView p1,p2,soccerView1,soccerView2;
    TextView soccerend;
    ImageView im1,im2,im3,im4,im5,im6,im7,im8,im9,im10,im11,im12;
    Button playagain;

    int image10,image11,image12,image13,image14,image15,image20,image21,image22,image23,image24,image25;

    int[] imageViewIds = {R.id.im1, R.id.im2, R.id.im3, R.id.im4, R.id.im5,
            R.id.im6, R.id.im7, R.id.im8, R.id.im9, R.id.im10, R.id.im11, R.id.im12};

    int[] pairsofnumber={10,11,12,13,14,15,20,21,22,23,24,25};

    int Card1,Card2;
    int valuetag1,valuetag2;
    int nrcard = 1;
    int turn = 1;

    int P1points =  0;
    int P2points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        soccerView1 = findViewById(R.id.soccerView1);
        soccerView2 = findViewById(R.id.soccerView2);

        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        im4 = findViewById(R.id.im4);
        im5 = findViewById(R.id.im5);
        im6 = findViewById(R.id.im6);
        im7 = findViewById(R.id.im7);
        im8 = findViewById(R.id.im8);
        im9 = findViewById(R.id.im9);
        im10 = findViewById(R.id.im10);
        im11 = findViewById(R.id.im11);
        im12 = findViewById(R.id.im12);

        soccerView2.setTextColor(Color.GRAY);
        soccerView1.setTextColor(Color.BLACK);
        p2.setTextColor(Color.GRAY);
        p1.setTextColor(Color.BLACK);

        // przetasowanie listy, umożliwia zmiane położenia kart, co rundę
        shufflevalues();

        //przypisanie zmiennym obrazów do wyświetlania w aplikacji
        drawablecard();

        //metoda setOnClickListener dla kazdego przycisku
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(view.getTag().toString());// wartość tag klikniętego ImageView
                setImage(im1, position);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im2, position);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im3, position);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im4, position);
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im5, position);
            }
        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im6, position);
            }
        });
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im7, position);
            }
        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im8, position);
            }
        });
        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im9, position);
            }
        });
        im10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im10, position);
            }
        });
        im11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im11, position);
            }
        });
        im12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(String.valueOf(view.getTag()));
                setImage(im12, position);
            }
        });
    }
    //instrukcja switch, która sprawdza jaki element z jaką wartością listy został kliknięty
    private void setImage(ImageView iv, int card) {
        switch (pairsofnumber[card]) {
            case 10:
                iv.setImageResource(image10);
                break;
            case 11:
                iv.setImageResource(image11);
                break;
            case 12:
                iv.setImageResource(image12);
                break;
            case 13:
                iv.setImageResource(image13);
                break;
            case 14:
                iv.setImageResource(image14);
                break;
            case 15:
                iv.setImageResource(image15);
                break;
            case 20:
                iv.setImageResource(image20);
                break;
            case 21:
                iv.setImageResource(image21);
                break;
            case 22:
                iv.setImageResource(image22);
                break;
            case 23:
                iv.setImageResource(image23);
                break;
            case 24:
                iv.setImageResource(image24);
                break;
            case 25:
                iv.setImageResource(image25);
                break;
        }

        if(nrcard == 1){
            Card1 = pairsofnumber[card];
            if(Card1 >= 20){
                //przypsianie wartości Card1, jęzeli większe od 20 odjąc, w celu porównania z drugą kartą
                Card1 = Card1 - 10;
            }
            nrcard = 2;
            //zmienna która zapisuje wartość taga obrazka
            valuetag1 = card;
            //przycisk dezaktywowany
            iv.setEnabled(false);

        }else if(nrcard == 2){
            Card2 = pairsofnumber[card];
            if(Card2 >=20){
                Card2 = Card2 - 10;
            }
            nrcard = 1;
            valuetag2 = card;
            iv.setEnabled(false);

            //umożliwia nam odczekanie sekundy zanim przejdzie do wywołania metody points_remove, daje możliwość odkrycia się drugiej karty i potem dopiero metoda points_remove()
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    points_remove();
                }
            },1000);
        }
    }
    //metoda porównująca karty (wartości listy, czy są takie same (dlatego trzeba było wcześniej odejmować))
    private void points_remove() {
        //sprawdza czy wartości kart kliknięty jest równa sobie
        if (Card1 == Card2) {
            //kliknięty ImageView znika
            if (valuetag1 == 0) {
                im1.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 1) {
                im2.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 2) {
                im3.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 3) {
                im4.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 4) {
                im5.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 5) {
                im6.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 6) {
                im7.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 7) {
                im8.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 8) {
                im9.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 9) {
                im10.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 10) {
                im11.setVisibility(View.INVISIBLE);
            } else if (valuetag1 == 11) {
                im12.setVisibility(View.INVISIBLE);
            }
            //kliknięty ImageView znika
            if (valuetag2 == 0) {
                im1.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 1) {
                im2.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 2) {
                im3.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 3) {
                im4.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 4) {
                im5.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 5) {
                im6.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 6) {
                im7.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 7) {
                im8.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 8) {
                im9.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 9) {
                im10.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 10) {
                im11.setVisibility(View.INVISIBLE);
            } else if (valuetag2 == 11) {
                im12.setVisibility(View.INVISIBLE);
            }

            //punktacja graczy
            if (turn == 1) {
                P1points++;
                soccerView1.setText(String.valueOf(P1points));
            } else if (turn == 2) {
                P2points++;
                soccerView2.setText(String.valueOf(P2points));
            }

        } else {
            //jeżeli obrazki(wartości listy nie są równe wszystkie obrazki mają pokazać Image znak_zapytania
            for (int imageViewId : imageViewIds) {
                ImageView imageView = findViewById(imageViewId);
                imageView.setImageResource(R.drawable.znak_zapytania);
            }
            //instrukcja warunkowa, ltóra określa jaki gracz w danej chwili ma ruch
            if (turn == 1) {
                turn = 2;
                soccerView1.setTextColor(Color.GRAY);
                soccerView2.setTextColor(Color.BLACK);
                p1.setTextColor(Color.GRAY);
                p2.setTextColor(Color.BLACK);

            } else if (turn == 2) {
                turn = 1;
                soccerView2.setTextColor(Color.GRAY);
                soccerView1.setTextColor(Color.BLACK);
                p2.setTextColor(Color.GRAY);
                p1.setTextColor(Color.BLACK);
            }
        }
        //uaktywnienie każdego ImageView, oczywiście te wszystkie co jescze nie zniknęły
        for (int imageViewId : imageViewIds) {
            ImageView imageView = findViewById(imageViewId);
            imageView.setEnabled(true);
        }
        //instrukcja warunkowa sprawdzająca czy wszystkie obrazki zniknęły
        checkall();
    }

    private void checkall(){
        if(im1.getVisibility() == View.INVISIBLE &&
                im2.getVisibility() == View.INVISIBLE &&
                im3.getVisibility() == View.INVISIBLE &&
                im4.getVisibility() == View.INVISIBLE &&
                im5.getVisibility() == View.INVISIBLE &&
                im6.getVisibility() == View.INVISIBLE &&
                im7.getVisibility() == View.INVISIBLE &&
                im8.getVisibility() == View.INVISIBLE &&
                im9.getVisibility() == View.INVISIBLE &&
                im10.getVisibility() == View.INVISIBLE &&
                im11.getVisibility() == View.INVISIBLE &&
                im12.getVisibility() == View.INVISIBLE){
            soccerView1.setVisibility(View.INVISIBLE);
            soccerView2.setVisibility(View.INVISIBLE);
            p1.setVisibility(View.INVISIBLE);
            p2.setVisibility(View.INVISIBLE);

            //sprawdzamy zwycięzca
            checkwinner();

            //ponowne uruchomienie gry za pomoca przycisku
            playAgain();
        }
    }



    private void drawablecard() {
        image10 = R.drawable.dog1;
        image11 = R.drawable.pig1;
        image12 = R.drawable.tiger1;
        image13 = R.drawable.lion1;
        image14 = R.drawable.jellyfish1;
        image15 = R.drawable.penguin1;
        image20 = R.drawable.dog2;
        image21 = R.drawable.pig2;
        image22 = R.drawable.tiger2;
        image23 = R.drawable.lion2;
        image24 = R.drawable.jellyfish2;
        image25 = R.drawable.penguin2;
    }

    private void shufflevalues(){

        Random random = new Random();

        for (int i = 0; i <pairsofnumber.length; i++){
            int randomIndex = random.nextInt(pairsofnumber.length);
            int temp = pairsofnumber[randomIndex];
            pairsofnumber[randomIndex] = pairsofnumber[i];
            pairsofnumber[i] = temp;
        }
    }


    private void checkwinner() {
        soccerend = findViewById(R.id.soccerend);
        if (P1points > P2points) {
            soccerend.setText("P1 WYGRYWA");
        } else if (P2points > P1points) {
            soccerend.setText("P2 WYGRYWA");
        } else {
            soccerend.setText("REMIS!!!!!!");
        }
        soccerend.setVisibility(View.VISIBLE);

        playagain = findViewById(R.id.playagain);
        playagain.setVisibility(View.VISIBLE);
    }


    private void playAgain(){
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shufflevalues();
                P1points = 0;
                P2points = 0;
                turn = 1;
                p1.setTextColor(Color.BLACK);
                soccerView1.setTextColor(Color.BLACK);
                p2.setTextColor(Color.GRAY);
                soccerView2.setTextColor(Color.GRAY);
                soccerend.setVisibility(View.INVISIBLE);
                playagain.setVisibility(View.INVISIBLE);

                soccerView1.setText("0");
                soccerView2.setText("0");
                soccerView1.setVisibility(View.VISIBLE);
                soccerView2.setVisibility(View.VISIBLE);
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.VISIBLE);

                for (int imageViewId : imageViewIds) {
                    ImageView imageView = findViewById(imageViewId);
                    imageView.setEnabled(true);
                }
                for (int imageViewId : imageViewIds) {
                    ImageView imageView = findViewById(imageViewId);
                    imageView.setImageResource(R.drawable.znak_zapytania);
                }
                im1.setVisibility(View.VISIBLE);
                im2.setVisibility(View.VISIBLE);
                im3.setVisibility(View.VISIBLE);
                im4.setVisibility(View.VISIBLE);
                im5.setVisibility(View.VISIBLE);
                im6.setVisibility(View.VISIBLE);
                im7.setVisibility(View.VISIBLE);
                im8.setVisibility(View.VISIBLE);
                im9.setVisibility(View.VISIBLE);
                im10.setVisibility(View.VISIBLE);
                im11.setVisibility(View.VISIBLE);
                im12.setVisibility(View.VISIBLE);
            }
        });
    }
}