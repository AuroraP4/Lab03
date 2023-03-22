package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.*;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	Dictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCleanText;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private ComboBox<String> cbLingua;

    @FXML
    private Label txtNumeroErrori;

    @FXML
    private TextArea txtParoleSbagliate;

    @FXML
    private TextArea txtTesto;

    @FXML
    private Label txtTime;

    @FXML
    void doCleanText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	List<RichWord> listaParole;
    	List<RichWord> listaParoleSbagliate;
    	
    	String[] testoDiviso;
    	List<String> listaTestoDiviso = new LinkedList<String>();
   

    	String testo = txtTesto.getText().toLowerCase().replaceAll("[.,\\?/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	
    	//(cbLingua.getValue() == null || testo.isEmpty()) {
    	//	txtNumeroErrori.setText("Bisogna la lingua o inserire il testo!");  }
    	    	
    	testoDiviso = testo.split(" ");
    	for(int i=0; i<testoDiviso.length; i++) {
    		listaTestoDiviso.add(testoDiviso[i]);  }
    	
 
    	model.loadDictionary(cbLingua.getValue());
    	
    	listaParole = model.spellCheckText(listaTestoDiviso);
    	
    	for(RichWord rw: listaParole) {
    		if(rw.isCorretta()==false) {
    			this.txtParoleSbagliate.appendText(rw.getParola());
    		}
    	}
    	
    }

    @FXML
    void initialize() {
        assert btnCleanText != null : "fx:id=\"btnCleanText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cbLingua != null : "fx:id=\"cbLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumeroErrori != null : "fx:id=\"txtNumeroErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParoleSbagliate != null : "fx:id=\"txtParoleSbagliate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

        cbLingua.getItems().clear();
        cbLingua.getItems().add("English");
        cbLingua.getItems().add("Italiano");
    }

	public void setModel(Dictionary model) {
		this.model = model;
		
	}

}
