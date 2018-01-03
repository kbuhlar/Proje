package e.kaan.proje;

/**
 * Created by Berkay Corleone on 30.12.2017.
 */

public class Kitap {




    public static final String TABLE_KİTAPLAR = "Kitaplar";
    public static final String COLKITAP_ID = "id";
    public static final String COL_KITAPID = "KitapId";
    public static final String COL_KITAPADI = "KitapAdi";
    public static final String COL_BASIMYILI = "BasımYılı";
    public static final String COL_YAYINEVIADI = "YayinEvi";
    public static final String COL_YAZAR = "Yazar";
    public static final String COL_TUR = "Tür";
    public static final String COL_SAYFA = "SayfaSayisi";

    private int id;
    private int KitapId;
    private String KitapAdi;
    private String BasımYılı;
    private String YayinEvi;
    private String Yazar;
    private String Tür;
    private String SayfaSayisi;

    public Kitap(String kitapAdi, String basımYılı, String yayinEvi, String yazar, String tür, String sayfaSayisi) {
        KitapAdi = kitapAdi;
        BasımYılı = basımYılı;
        YayinEvi = yayinEvi;
        Yazar = yazar;
        Tür = tür;
        SayfaSayisi = sayfaSayisi;
    }

    public Kitap(int id, int kitapId, String kitapAdi, String basımYılı, String yayinEvi, String yazar, String tür, String sayfaSayisi) {

        this.id = id;
        KitapId = kitapId;
        KitapAdi = kitapAdi;
        BasımYılı = basımYılı;
        YayinEvi = yayinEvi;
        Yazar = yazar;
        Tür = tür;
        SayfaSayisi = sayfaSayisi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKitapId() {
        return KitapId;
    }

    public void setKitapId(int kitapId) {
        KitapId = kitapId;
    }

    public String getKitapAdi() {
        return KitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        KitapAdi = kitapAdi;
    }

    public String getBasımYılı() {
        return BasımYılı;
    }

    public void setBasımYılı(String basımYılı) {
        BasımYılı = basımYılı;
    }

    public String getYayinEvi() {
        return YayinEvi;
    }

    public void setYayinEvi(String yayinEvi) {
        YayinEvi = yayinEvi;
    }

    public String getYazar() {
        return Yazar;
    }

    public void setYazar(String yazar) {
        Yazar = yazar;
    }

    public String getTür() {
        return Tür;
    }

    public void setTür(String tür) {
        Tür = tür;
    }

    public String getSayfaSayisi() {
        return SayfaSayisi;
    }

    public void setSayfaSayisi(String sayfaSayisi) {
        SayfaSayisi = sayfaSayisi;
    }



}
