package e.kaan.proje;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Berkay Corleone on 3.1.2018.
 */

public class Liste extends AppCompatActivity {

    ArrayList<Kitap> kitaplar;
    KitapListAdapter adapter;
    DbHelper dbhelper = new DbHelper(this);
    ListView lvList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        lvList = (ListView) findViewById(R.id.lvList);
        ListeyiDoldur();
        lvList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view,
                                           final int position, long id) {
                // TODO Auto-generated method stub
                try {

                    AlertDialog.Builder builder = new AlertDialog.Builder(Liste.this);
                    builder.setTitle("Silinsin mi?");
                    builder.setMessage("Bu List elemanını silmek istediğinize emin misiniz?");
                    builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {



                        }
                    });


                    builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            try {
                                kitaplar.remove(id);
                                adapter.notifyDataSetChanged();

                                Toast.makeText(Liste.this, "Silindi", Toast.LENGTH_LONG).show();
                            }
                            catch (Exception b){
                                Toast.makeText(Liste.this, b.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.show();
                }
                catch (Exception e){
                    Toast.makeText(Liste.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });




    }



    private void ListeyiDoldur(){

        try {
            ArrayList<Kitap> kitaplar = dbhelper.getKitapListesi();
            KitapListAdapter adp = new KitapListAdapter(kitaplar, this);
            lvList.setAdapter(adp);

        }
        catch (Exception e){
            Toast.makeText(Liste.this,e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

}

