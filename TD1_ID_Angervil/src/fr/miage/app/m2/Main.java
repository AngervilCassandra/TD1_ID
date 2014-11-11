package fr.miage.app.m2;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	
	public static void main(String[] args){
		XML x = new XML();
		Oracle o = new Oracle();
		Mediateur m = new Mediateur(o, x);
		/*try {
			x.lire_XML("Univ_BD_3.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		m.recherche();
		
		
	}
	

}
