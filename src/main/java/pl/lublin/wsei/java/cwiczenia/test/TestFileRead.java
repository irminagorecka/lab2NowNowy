package pl.lublin.wsei.java.cwiczenia.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFileRead {
    public static void main(String[] args) {

        try{
            String contents=new String(Files.readAllBytes(Paths.get("gusInfoGraphic.xml"))); //polecenie wczytujące plik do zmiennej contents
            System.out.println("Zawartość pliku gusInfoGraphic.xml:");
            System.out.println(contents);
        } catch (IOException e) {
           System.out.println("Błąd wczytywania pliku gusInfoGraphic.xml=>"+e.getLocalizedMessage());
           e.printStackTrace();
        }
    }
}
