package e.kaan.proje;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    DbHelper dbhelper = new DbHelper(this);
    Button btnSoru;
    Button btnEkle;
    Button btnListe;
    Button btnAyarlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSoru = (Button)findViewById(R.id.btnSoru);
        btnEkle = (Button)findViewById(R.id.btnKitapEkle);
        btnListe = (Button)findViewById(R.id.btnKitapListele);
        btnAyarlar = (Button)findViewById(R.id.btnAyarlar);

        btnSoru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("PROJE SAHİPLERİ");
                builder2.setTitle("PROJE SAHİPLERİ");
                builder3.setTitle("PROJE SAHİPLERİ");
                builder.setMessage("116444023 - Ezgi Aleyna Güneş");
                builder2.setMessage("116444050- Fazilet Kalender");
                builder3.setMessage("116444060 - Kaan Buhlar");

                builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder2.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder3.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder.show();
                builder2.show();
                builder3.show();
            }
        });

        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


                    Intent ekle = new Intent(MainActivity.this, Kayit.class);
                    startActivity(ekle);

                }
                catch (Exception ee){

                    Toast.makeText(MainActivity.this, ee.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


                    Intent ana =new Intent(MainActivity.this,Liste.class);
                    startActivity(ana);


                }
                catch (Exception e){

                    Toast.makeText(MainActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAyarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


                    Intent ana =new Intent(MainActivity.this,Ayarlar.class);
                    startActivity(ana);


                }
                catch (Exception e){

                    Toast.makeText(MainActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
