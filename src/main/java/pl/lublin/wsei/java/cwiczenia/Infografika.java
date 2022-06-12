package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {

    String tytul;
    String adresStrony;
    String adresGrafiki;
    String adresMiniaturki;
    String szerokosc;
    String wysokosc;

    /*public Infografika(String tytul, String adresStrony, String adresGrafiki, String adresMiniaturki, int szerokosc, int wysokosc) {
        this.tytul = tytul;
        this.adresStrony = adresStrony;
        this.adresGrafiki = adresGrafiki;
        this.adresMiniaturki = adresMiniaturki;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }*/

    public Infografika(String tekst){
        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]"); //utworzenie obiektu wzorca regularnego (podwójne\\)
        Matcher m = pat.matcher(tekst); //dopasowuje wzorzec do tekst
        if (m.find()) //find odpowiada za iterowanie po kolejnych dopasowaniach wzorca
            tytul=m.group(1);
        else
            tytul="";

        pat = Pattern.compile("<link>(.*)</link>");
        m = pat.matcher(tekst);
        if (m.find())
            adresStrony=m.group(1);
        else
            adresStrony="";

        pat = Pattern.compile("<media:thumbnail url=\"(.*)\"");
        m = pat.matcher(tekst);
        if (m.find())
            adresGrafiki=m.group(1);
        else
            adresGrafiki="";

        pat = Pattern.compile("<description><!\\[CDATA\\[<div><img src=\"(.*) a");
        m = pat.matcher(tekst);
        if (m.find())
            adresMiniaturki=m.group(1);
        else
            adresMiniaturki="";

        pat = Pattern.compile("width=\"(.*)\" height");
        m = pat.matcher(tekst);
        if (m.find())
            szerokosc =m.group(1);
        else
            szerokosc ="";

        pat = Pattern.compile("height=\"(.*)\"");
        m = pat.matcher(tekst);
        if (m.find())
            wysokosc=m.group(1);
        else
            wysokosc="";
        System.out.println("Tytuł: "+tytul+"\nAdres Strony: "+adresStrony+"\nAdres Grafiki: "+adresGrafiki+"\nAdres miniaturki: "+adresMiniaturki+"\nSzerokość: "+ szerokosc+"\nWysokość: "+wysokosc);

    }


    public void print() {
        System.out.println("Tytuł: "+tytul+"\nAdres Strony: "+adresStrony+"\nAdres Grafiki: "+adresGrafiki+"\nAdres miniaturki: "+adresMiniaturki+"\nSzerokość: "+ szerokosc+"\nWysokość: "+wysokosc);

    }
}
