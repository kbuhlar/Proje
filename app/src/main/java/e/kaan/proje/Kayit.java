package e.kaan.proje;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Berkay Corleone on 3.1.2018.
 */

public class Kayit extends AppCompatActivity {

    Button btnKitapKaydet;
    EditText etkitapAdi;
    EditText etbasimYili;
    EditText etyayinEvi;
    EditText etYazar;
    EditText etTur;
    EditText etsayfaSayisi;
    ListView lvList;



    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_kayit);

        dbHelper = new DbHelper(this);

        btnKitapKaydet = (Button) findViewById(R.id.btnKitapKaydet);
        etkitapAdi = (EditText) findViewById(R.id.etkitapAdi);
        etbasimYili = (EditText) findViewById(R.id.etbasimYili);
        etyayinEvi = (EditText) findViewById(R.id.etyayinEvi);
        etYazar = (EditText) findViewById(R.id.etYazar);
        etTur = (EditText) findViewById(R.id.etTur);
        etsayfaSayisi = (EditText) findViewById(R.id.etsayfaSayisi);
        lvList = (ListView) findViewById(R.id.lvList);

        btnKitapKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String kitapAdi = etkitapAdi.getText().toString();
                    String basimYili = etbasimYili.getText().toString();
                    String yayinEvi = etyayinEvi.getText().toString();
                    String yazar = etYazar.getText().toString();
                    String tur = etTur.getText().toString();
                    String sayfaSayisi = etsayfaSayisi.getText().toString();
                    Kitap kitap = new Kitap(kitapAdi, basimYili, yayinEvi, yazar, tur, sayfaSayisi);

                    boolean sonuc = dbHelper.kitapEkle(kitap);
                    if (sonuc == true) {
                        Toast.makeText(Kayit.this, "Kitabınız eklendi.", Toast.LENGTH_SHORT).show();
                        ListeyiDoldur();
                        GirisiSifirla();

                    } else {
                        Toast.makeText(Kayit.this, "İşlem başarısız.", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(Kayit.this,e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }






    private void ListeyiDoldur() {

        try {
            ArrayList<Kitap> kitaplar = dbHelper.getKitapListesi();
            KitapListAdapter adp = new KitapListAdapter(kitaplar, this);
            lvList.setAdapter(adp);

        }
        catch (Exception e){
            Toast.makeText(Kayit.this,e.toString(), Toast.LENGTH_SHORT).show();
        }

    }


    private void GirisiSifirla(){
        etkitapAdi.setText("");
        etbasimYili.setText("");
        etyayinEvi.setText("");
        etYazar.setText("");
        etTur.setText("");
        etsayfaSayisi.setText("");

    }
}
