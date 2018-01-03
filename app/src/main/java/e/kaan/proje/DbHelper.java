package e.kaan.proje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Berkay Corleone on 30.12.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final int Version = 1;
    private Context context;




    private static final String DATABASE_ISMI = "Kitaplik.db";

    public static final String TABLE_KİTAPLAR = "Kitaplar";
    public static final String COLKITAP_ID = "id";
    public static final String COL_KITAPID = "KitapId";
    public static final String COL_KITAPADI = "KitapAdi";
    public static final String COL_BASIMYILI = "BasımYılı";
    public static final String COL_YAYINEVIADI = "YayinEvi";
    public static final String COL_YAZAR = "Yazar";
    public static final String COL_TUR = "Tür";
    public static final String COL_SAYFA = "SayfaSayisi";

    public DbHelper(Context context) {
        super(context, DATABASE_ISMI, null, Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String tabloOlustur = "CREATE TABLE " + TABLE_KİTAPLAR + "("
                + COLKITAP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + COL_KITAPID + " INTEGER,"
                + COL_KITAPADI + " TEXT,"
                + COL_BASIMYILI + " TEXT,"
                + COL_YAYINEVIADI + " TEXT,"
                + COL_YAZAR + " TEXT,"
                + COL_TUR + " TEXT,"
                + COL_SAYFA + " TEXT" + ")";

        db.execSQL(tabloOlustur);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Kitaplar");
        onCreate(db);

    }


    public boolean kitapEkle(Kitap kitap) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Kitap.COL_KITAPADI, kitap.getKitapAdi());
        cv.put(Kitap.COL_BASIMYILI, kitap.getBasımYılı());
        cv.put(Kitap.COL_YAYINEVIADI, kitap.getYayinEvi());
        cv.put(Kitap.COL_YAZAR, kitap.getYazar());
        cv.put(Kitap.COL_TUR, kitap.getTür());
        cv.put(Kitap.COL_SAYFA, kitap.getSayfaSayisi());
        long result = db.insert(Kitap.TABLE_KİTAPLAR, null, cv);
        if (result > 0)
            return true;
        else
            return false;
    }


    public ArrayList<Kitap> getKitapListesi(){
        ArrayList<Kitap> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = new String[]{
                Kitap.COLKITAP_ID,
                Kitap.COL_KITAPID,
                Kitap.COL_KITAPADI,
                Kitap.COL_BASIMYILI,
                Kitap.COL_YAYINEVIADI,
                Kitap.COL_YAZAR,
                Kitap.COL_TUR,
                Kitap.COL_SAYFA
        };
        //db.rawQuery("Select * From Filmler",null);
        Cursor cursor = db.query(Kitap.TABLE_KİTAPLAR,columns,null,null,null,null,null);
        if(cursor != null && cursor.getCount() > 0){
            while (cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex(Kitap.COLKITAP_ID));
                int KitapId = cursor.getInt(cursor.getColumnIndex(Kitap.COL_KITAPID));
                String KitapAdi = cursor.getString(cursor.getColumnIndex(Kitap.COL_KITAPADI));
                String BasımYılı = cursor.getString(cursor.getColumnIndex(Kitap.COL_BASIMYILI));
                String YayinEvi = cursor.getString(cursor.getColumnIndex(Kitap.COL_YAYINEVIADI));
                String Yazar = cursor.getString(cursor.getColumnIndex(Kitap.COL_YAZAR));
                String Tür = cursor.getString(cursor.getColumnIndex(Kitap.COL_TUR));
                String Sayfa = cursor.getString(cursor.getColumnIndex(Kitap.COL_SAYFA));
                Kitap kitap = new Kitap(id,KitapId,KitapAdi,BasımYılı,YayinEvi,Yazar,Tür,Sayfa);
                list.add(kitap);
            }
        }
        return list;
    }
}

