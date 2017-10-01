package kodluyoruz.com.bveritasimafragmentactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


//Verileri almak için public class MainActivity extends AppCompatActivity ifadesinden sonra
// implements NewFragment.OnFragmentInteractionListener diyerek fragmentta veri gönderdiğimiz interface'i implement ediyoruz.


public class MainActivity extends AppCompatActivity implements NewFragment.OnFragmentInteractionListener {

    //Tanımlamalar
    TextView activity_main_textName, activity_main_textSurname, activity_main_textNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //id eşleştirme
        activity_main_textName = (TextView) findViewById(R.id.activity_main_textName);
        activity_main_textSurname = (TextView) findViewById(R.id.activity_main_textSurname);
        activity_main_textNumber = (TextView) findViewById(R.id.activity_main_textNumber);

    }


    //Fragment'ta gönderdiğimiz değişkenleri buraya parametre olarak veriyoruz
    @Override
    public void onFragmentInteraction(String name, String surname, String number) {


        //activity üzerindeki textView'ların yazı alanlarını fragment'tan gelen verilerle değiştiriyoruz
        activity_main_textName.setText(name);
        activity_main_textSurname.setText(surname);
        activity_main_textNumber.setText(number);
    }
}
