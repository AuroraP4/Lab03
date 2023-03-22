package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	LinkedList<String> dizionario;

	public void loadDictionary(String language)  {
	
		dizionario = new LinkedList<String>();
		
		if(language.compareTo("English")==0) {
	try {
		 FileReader fr = new FileReader("src/main/resources/English.txt");
		 BufferedReader br = new BufferedReader(fr);
		 String word;
		 
		 while ((word = br.readLine()) != null) {
		dizionario.add(word.toLowerCase());  }
		 
		br.close();

		 } catch (IOException e)   {
		 System.out.println("Errore nella lettura del file");   } }
		
		
		else if(language.compareTo("src/main/resources/Italiano")==0) {
			try {
				 FileReader fr = new FileReader("Italian.txt");
				 BufferedReader br = new BufferedReader(fr);
				 String word;
				 
				 while ((word = br.readLine()) != null) {
				dizionario.add(word.toLowerCase());  }
				 
				br.close();

				 } catch (IOException e)   {
				 System.out.println("Errore nella lettura del file");   } }
		
	}

		public List<RichWord> spellCheckText(List<String> inputTextList) {
			
			List<RichWord> parole= new LinkedList<RichWord>();
			
			for (String s : inputTextList) {

				RichWord richWord = new RichWord (s);
				
				if (dizionario.contains(s)) {
					richWord.setCorretta(true);    } 
				
				parole.add(richWord);  }

			return parole;   }
}
