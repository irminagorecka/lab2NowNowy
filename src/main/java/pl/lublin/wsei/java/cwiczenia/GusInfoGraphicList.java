package pl.lublin.wsei.java.cwiczenia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GusInfoGraphicList {
    public ArrayList<Infografika> infografiki; //deklaracja arraylist

    public GusInfoGraphicList(String gusFileName){
        infografiki=new ArrayList<>();//utworzenie pustej arraylist
        String contents;
        try{
            contents=new String(Files.readAllBytes(Paths.get(gusFileName)));

        } catch (IOException e) {
            System.out.println("Błąd wczytywania pliku gisInfoGraphic.xml => "+e.getLocalizedMessage());
            e.printStackTrace();
            contents= "";
        }
        String[] items=contents.split("<item>");//operacja podziału tekstu na tokeny z tekstem <item> jako separatorem
        for (int i = 0; i < items.length; i++) { //utworzenie kolejnych instancji klasy Infografika na podstawie kolejnych fragmentów podzielonego tekstu
            infografiki.add(new Infografika(items[i]));
        }


    }




}
