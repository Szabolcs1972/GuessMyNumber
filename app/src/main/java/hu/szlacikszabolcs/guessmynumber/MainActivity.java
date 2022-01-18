package hu.szlacikszabolcs.guessmynumber;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Random random = new Random();
    int myRandom = random.nextInt(20) + 1;
    int counter = 5;
    int tippValue = 1;



    public void onBtnClick(View view) {
        counter--;
        TextView textView1 = findViewById(R.id.txt2);
        TextView textView2 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        EditText tipp = findViewById(R.id.input);

        if (counter > 0) {

            //tippValue = Integer.parseInt(tipp.toString());
            tippValue = Integer.parseInt(tipp.getText().toString());

            if (tippValue > myRandom) {

                textView1.setText("My number is less!");
                textView2.setText("Tries: " + counter + " / 5");
                textView4.setText("");
                textView5.setText("JackPot!");

            } else if (tippValue < myRandom) {
                textView1.setText("My number is greater!");
                textView2.setText("Tries: " + counter);
                textView4.setText("");
                textView5.setText("JackPot!");
            } else {
                textView1.setText("CONGRATS! YOU HIT ME!");
                textView2.setText("Number of your tries: " + (5-counter));
                switch (5-counter) {
                    case 1:
                        textView5.setText("YOU ARE GENIUS!");
                        break;
                    case 2:
                        textView5.setText("GOOD!");
                        break;
                    case 3:
                        textView5.setText("SO FAR SO GOOD!");
                        break;
                    case 4:
                        textView5.setText("TREMBLE!");
                        break;
                }

                counter = 5;
                myRandom = random.nextInt(20) + 1;
                textView4.setText("Press Enter to restart!");
                //textView2.setText("Új játék! A tippek száma: " + counter);
            }

        } else {
            textView2.setText("GAME OVER!");
            textView5.setText("GOODBYE!");
        }



    }

}