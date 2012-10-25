// FIXME (FIXED) renommer le paquetage (fr.iutvalence.java.projets.(nom))
package fr.iutvalence.java.projets.test;


// FIXME cette classe ne doit pas contenir de main et ne pas être dépendante de l'affichage : à reprendre entièrement

import fr.iutvalence.java.projets.combat.Acteur;
import fr.iutvalence.java.projets.combat.Competences;
import fr.iutvalence.java.projets.combat.Coordonnees;
import fr.iutvalence.java.projets.combat.PersonnageEnCombat;
import fr.iutvalence.java.projets.combat.Monstre;
import fr.iutvalence.java.projets.combat.Stats;
import fr.iutvalence.java.projets.combat.Carte;
/**
 * @author colasr
 * Classe principale, fait tourner le jeu
 */
public class Test
{

	

	/* 0 pour un emplacement libre , 1 pour un obstacle, 2 pour  l'emplcement 
	 du joueur, 3+ pour le(s) monstre(s)*/


    
	/**
	 * Fait tourner le jeu
	 * @param args 
	 */
	public static void main(String[] args)
	{
		String carteAscii;
		int profession;
		String nom;
		// La premiere competences de la liste de cometences à un nombre d'utilisation infinie )
		Competences[] compPerso={new Competences("Attaque", 1, 1, 5, 0, 1),new Competences("Coup puissant", 1, 2, 15, 0, 5)};
		Competences compMonstre=new Competences("Attaque",1,1,5,0,1);
		int[][] map1={
				 {1,1,1,1,1,1},
				 {1,2,0,0,0,1},
				 {1,0,0,0,0,1},
				 {1,0,1,1,0,1},
				 {1,0,0,0,0,1},
				 {1,0,0,0,3,1},
				 {1,1,1,1,1,1}
		 };
		
		
		Carte carte = new Carte(map1);

		
		nom = "bobo";
		profession = 1; //1 pour avoir la profession Gladiateur
		Acteur[] acteur = {new PersonnageEnCombat(nom,new Stats(profession), carte.CherchePositionActeur(2), profession, compPerso),
						   new Monstre("Monstro",new Stats(2), carte.CherchePositionActeur(3),compMonstre,3)    
						  };
		carteAscii = carte.toString();
		System.out.println(carteAscii);
		
		acteur[0].getPosition().changePosY(1);
		carte.ActualiseCarte(acteur);	
		carteAscii = carte.toString();
		System.out.println(carteAscii);
		
		//Acteur persoEnCombat = new PersonnageEnCombat(nom, new Stats(profession), Carte.CherchePositionActeur(carte, 2), profession, comp);
		

	}
}

