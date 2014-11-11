package fr.miage.app.m2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Mediateur {
	private XML S3;
	private Oracle S2;
	

	private int [][] Enseigne = {{0,0,1,1},{0,0,1,1},{0,0,1,1},{0,0,0,1}} ; 
	/* 1ére ligne => IdEnseigne
	 2éme ligne => ID-Cours
	 3éme ligne => Annee 
	 4eme ligne => Heures */
	 
	private int [][] Etudiant = {{0,0,1,1},{0,0,1,1},{0,0,1,0},{0,0,1,1},{0,0,1,1},{0,0,1,1},{0,0,1,1},{0,0,1,1}} ; 
	/* 1ere ligne => ID-Etudiant
	2éme ligne => Nom
	3éme ligne => Prenom
	4éme ligne => FormationPrecedente
	5éme ligne => PaysFormationPrecedente
	6éme ligne => AnneeDebut
	7éme ligne => NiveauInsertion
	8éme ligne => Age */
	
	private int [][] Cours ={{0,0,1,1},{0,0,1,0},{0,0,1,1},{0,0,1,1},{0,0,0,1}};
	/* 1ere ligne => ID-Cours
	2éme ligne => Libele
	3éme ligne => Type
	4éme ligne => Niveau
	5éme ligne => Heures */

	private int [][] Enseignant = {{0,0,1,1},{0,0,1,1},{0,0,1,1},{0,0,0,1}} ;
	/* 1ere ligne => ID-Enseignant
	2éme ligne => Nom
	3éme ligne => Prenom
	4éme ligne => adresseMail */

	private int [][] Inscription = {{0,0,1,1},{0,0,1,1},{0,0,1,1},{0,0,1,1}} ;
	/* 1ere ligne => ID-Etudiant
	2éme ligne => ID-Cours
	3éme ligne => Annee
	4éme ligne => Note */

	
	public Mediateur(Oracle s2,XML s3){
		this.S2=s2;
		this.S3=s3;
	}
	public void recherche(){
		HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();
		int r2 =0;
		int rs3 = 0;
		int rs2 = 0;
		for (int i = 1; i <Enseigne[3].length;i++){
			if(Enseigne[3][i] == 1){
				
				if(i == 1){
				}
				
				if(i == 2){
				}
				if( i == 3){
					try {
						map = S3.R1("Univ_BD_3.xml");
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
					}
					Set listKeys=map.keySet();  // Obtenir la liste des clés
		    		Iterator iterateur=listKeys.iterator();
		    		// Parcourir les clés et afficher les entrées de chaque clé;
		    		while(iterateur.hasNext())
		    		{
		    			Object key= iterateur.next();
		    			System.out.println (key+"=>"+map.get(key));
		    		}
				}
			}
				
		}
		for(int e =0;e<Etudiant[3].length;e++){
			if(e == 1){
				
			}
			if(e == 2){
				try {
					rs2 = S2.R2();
					System.out.println(rs2 + " étudiant provient de la france dans s2 ");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e == 3){
				try {
					rs3 = S3.R2("Univ_BD_3.xml");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
		r2 = rs3+rs2;
		System.out.println("Il y a donc "+r2 +" étudiant français");
	}
		
}
