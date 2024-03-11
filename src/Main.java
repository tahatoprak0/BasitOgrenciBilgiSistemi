public class Main {
    public static void main(String[] args) {
        Ogrenci[] ogrenciler = {new Ogrenci("Taha", "Bilgisayar Mühendisliği", "2023", "20", 5, "104"), new Ogrenci("Yusuf Tekin", "Elektrik Elektronik Mühendisliği", "2022", "54", 1.98, "121"), new Ogrenci("Muhammet Balta", "Elektrik Elektronik Mühendisliği", "2023", "12", 2.4, "121"), new Ogrenci("Mahmut Bağlama", "Yazılım Mühendisliği", "2022", "45", 1.5, "156"),};

        Ogrenci[] student = ogrenciler;
        Ogrenci foundOgrenci = null;
        String ogrenciAdi = "Yususf Tekin";
        for (int i = 0; i < ogrenciler.length; i++) {
            Ogrenci s = ogrenciler[i];
            if (s.getAd().equals(ogrenciAdi)) {
                foundOgrenci = s;
                break;
            }
        }

        if (foundOgrenci == null) {
            throw new IllegalArgumentException("KAYITLI ÖĞRENCİ YOK!!");
        } else {
            System.out.println("Öğrenci Bilgileri");
            Ogrenci[] student2 = ogrenciler;
            int k = 1;
            for (int i1 = 0; i1 < ogrenciler.length; i1++) {
                Ogrenci s1 = student[i1];
                int t = 0;
                if (t < ogrenciler.length) {
                    System.out.println("OGR-" + k + " " + s1.getAd() + " " + s1.getBolum() + " " + s1.ogrNoOlustur() + " " + s1.getGano());
                    k++;

                }

            }
            for (int i2 = 1; i2 < ogrenciler.length; i2++) {

                //uzatılan yıl dönemlik olarak hesaplanacak. 0.5, 1, 1.5 dönem ...
                System.out.println(i2 + "." + "Öğrencinin Ödeyeceği Harç:" + student2[i2].harcHesapla(5, 0.5));
            }
        }


    }
}


class Ogrenci {
    private String ad;
    private String bolum;
    private String girisYili;
    private String girisSirasi;
    private double gano;
    private String bolumKodu;


    public Ogrenci() {
    }

    public Ogrenci(String ad, String bolum, String girisYili, String girisSirasi, double gano, String bolumKodu) {
        this.ad = ad;
        this.bolum = bolum;
        this.girisYili = girisYili;
        this.girisSirasi = girisSirasi;
        this.gano = gano;
        this.bolumKodu = bolumKodu;
    }

    public Ogrenci(String ad, String bolum, String girisYili) {
        this.ad = ad;
        this.bolum = bolum;
        this.girisYili = girisYili;
    }

    public Ogrenci(String ad, String bolum, int ogrNo, double gano) {
        this.ad = ad;
        this.bolum = bolum;
        this.gano = gano;
    }

    public double getGano() {
        if (gano < 0 || gano > 4) {
            throw new IllegalArgumentException("Girdiğiniz Gano Geçersiz,0-4 Arasında Gano Girin!");
        }

        return gano;

    }

    public String getAd() {
        return ad;
    }

    public String getBolum() {
        return bolum;
    }

    public double harcHesapla(int dersSayisi) {
        double harc = (dersSayisi * 300) - getGano() * 100;
        return harc;
    }

    public double harcHesapla(int dersSayisi, double uzatilanYil) {
        //aldığı ders sayı ve kafamdan belirlediğim bir mikarla çarpıp + uzatlan dönemi kafamdan belirlediğim
        //bir sayıyıla çarptım-öğrenci başarı ortalamasına göre vereceği miktardan azaltan fonksiyon yazdım
        //dönem 0.5,1,1,5 olacak şekilde hesaplandı
        double harcUzun = (dersSayisi * 300) + (uzatilanYil * 200.0) - getGano() * 100;
        return harcUzun;
    }

    public String ogrNoOlustur() {
        return this.girisYili + this.bolumKodu + this.girisSirasi;
    }
}