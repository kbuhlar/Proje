package e.kaan.proje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Berkay Corleone on 30.12.2017.
 */

public class KitapListAdapter extends BaseAdapter {

    ArrayList<Kitap> kitaplar;
    Context context;
    LayoutInflater layoutInflater;

    public KitapListAdapter(ArrayList<Kitap> kitaplar,Context context) {
        this.kitaplar = kitaplar;
        this.context = context;
    }

    @Override
    public int getCount() {
        return kitaplar.size();
    }

    @Override
    public Object getItem(int i) {
        return kitaplar.get(i);
    }

    @Override
    public long getItemId(int i) {
        return kitaplar.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout lyt = (LinearLayout) li.inflate(R.layout.satir_tasarimi, null);

        try {


            Kitap kitap = kitaplar.get(i);
            TextView tvkitapAd = (TextView) lyt.findViewById(R.id.tvkitapAd);
            TextView tvbasimYili = (TextView) lyt.findViewById(R.id.tvbasimYili);
            TextView tvyayinEvi = (TextView) lyt.findViewById(R.id.tvyayinEvi);
            tvkitapAd.setText(kitap.getKitapAdi());
            tvbasimYili.setText(kitap.getBasımYılı());
            tvyayinEvi.setText(kitap.getYayinEvi());


        }
        catch (Exception e){
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return lyt;
    }
}
