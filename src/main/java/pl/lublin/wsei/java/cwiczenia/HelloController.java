package pl.lublin.wsei.java.cwiczenia;


import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class HelloController {
    public Label lbFile;
    public ListView lstInfografiki;//referencja powiązana z kontrolką listy w GUI
    public ImageView imgMiniaturka;
    public TextField txtAdresStrony;
    public Button btnPokazInfografike;
    public Button btnPrzejdzDoStrony;
    private Infografika selInfografika;
    public ImageView imgView;



    ObservableList<String> tytuly= FXCollections.observableArrayList(); //deklaracja i utworzenie pustej listy typu ObservableList<String>, FXCollections.observableArrayList() implementuje interfejs ObservableList<String>

    GusInfoGraphicList igList;

    FileChooser fileChooser=new FileChooser();
    FileChooser.ExtensionFilter xmlFilter=new FileChooser.ExtensionFilter("Pliki XML(*.xml)","*.xml"); //definicja filtra dla okna wyboru
    @FXML
    private Label welcomeText;

    public void initialize(){ //kod inicjalizacji kontrolera
        fileChooser.getExtensionFilters().add(xmlFilter);
        lstInfografiki.getSelectionModel().selectedIndexProperty().addListener(//podpina procedurę obsługi zdarzenia do instancji selectedIndexProperty instancji SelectionModel (zwracanej przez getSelectionModel). Czyli: funkcjonalność zaznaczania jest realizowana w ListView przez instancję SelectionModel.
                new ChangeListener<Number>() {// realizacja interfejsu ChangeListener<> czyli powiadamiania o zmianach
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number old_val, Number new_val) {
                        int index=new_val.intValue();//konwersja na prymitywny typ int
                        if (index!=-1){//sprawdza, czy index nie jest równa -1, sytuacja taka oznacza, że nic nie jest podświetlone na liście, i w linia adresu powinna być skasowana (linia 46)
                        selInfografika=igList.infografiki.get(index);
                        txtAdresStrony.setText(igList.infografiki.get(index).adresStrony);//wprowadzenie do liniiadresu atrybutu infografiki, adresStrony
                        Image image=new Image(igList.infografiki.get(index).adresMiniaturki);//utworzenie instancji Image na podstawie adresu URL grafiki z atrybutuadresMiniaturki
                        imgMiniaturka.setImage(image);//ustawienie instancji z linii powyżej
                        }
                        else{
                        txtAdresStrony.setText("");//kasowanie linii adresu
                        imgMiniaturka.setImage(null);//wyczyszczenie zawartości
                        selInfografika=null;
                        }
                    }
                }


        );
    }

    public void btnOpenFileAction(ActionEvent actionEvent) {//okienko
        File file=fileChooser.showOpenDialog(null);
        if (file != null) {
            igList=new GusInfoGraphicList(file.getAbsolutePath()); //utworzenie instancji klasy GusInfoGraphicList na pliku wskazanym w okienku wyboru
            lbFile.setText(file.getAbsolutePath());
            for (Infografika ig: igList.infografiki) tytuly.add(ig.tytul);//wypełnia listę obserwowalną tytuly wartościami atrybutów tytul obiektów Infografika znalezionymi przez GusInfoGraphicList w podanym pliku
            lstInfografiki.setItems(tytuly);//podłącza listę tytuly do kontrolki ListView
        }
        else{
            lbFile.setText("Proszę wczytać plik...");
        }
    }

    private Stage stage;
    private HostServices hostServices;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }


    public void btnPrzejdzDoStrony(ActionEvent actionEvent){
        if (selInfografika!=null)
            hostServices.showDocument(selInfografika.adresStrony);

    }
public void btnPokaz(ActionEvent actionEvent) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("imgViewer.fxml"))
            Parent root=loader.load();
            ImgViewer viewer=loader.getController();
            if (selInfografika!=null){
                Image img=new Image(selInfografika.adresGrafiki);
                viewer.imgView.setFitWidth(img.getWidth());
                viewer.imgView.setFitHeight(img.getHeight());
                viewer.imgView.setImage(img);
            }
            Stage stage=new Stage();
            stage.setTitle("Podgląd infografiki");
            stage.setScene(new Scene(root,900,800));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


}



}