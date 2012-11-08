package fr.iutvalence.java.projets.test;


import fr.iutvalence.java.projets.combat.Acteur;
import fr.iutvalence.java.projets.combat.Competences;
import fr.iutvalence.java.projets.combat.Coordonnees;
import fr.iutvalence.java.projets.combat.PersonnageEnCombat;
import fr.iutvalence.java.projets.combat.Monstre;
import fr.iutvalence.java.projets.combat.Stats;
import fr.iutvalence.java.projets.combat.Carte;
import fr.iutvalence.java.projets.combat.Competences;
import java.util.Scanner;
/**
 * @author colasr Classe principale, fait tourner le jeu
 */
public class Test
{

	/*
	 * 0 pour un emplacement libre , 1 pour un obstacle, 2 pour l'emplcement du joueur, 3+ pour le(s) monstre(s)
	 */

	/**
	 * Fait tourner le jeu
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		char touche;
		String carteAscii;
		int profession;
		String nom;
		// La premiere competences de la liste de cometences à un nombre d'utilisation infinie )
		Competences[] compPerso={new Competences("Attaque", 1, 1, 5, 0, 1),new Competences("Coup puissant", 1, 2, 15, 0, 5)};
		Competences compMonstre=new Competences("Attaque", 1, 1, 5, 0, 1);
		int[][] map1={
				 {1,1,1,1,1,1,1,1,1},
				 {1,2,0,0,0,0,0,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,1,1,0,0,0,0,1},
				 {1,0,0,0,0,0,0,5,1},
				 {1,0,0,0,1,0,1,1,1},
				 {1,0,0,0,1,0,0,1,1},
				 {1,0,0,0,0,0,0,1,1},
				 {1,0,0,0,3,0,0,0,1},
				 {1,0,0,0,0,0,1,0,1},
				 {1,0,0,1,0,0,0,0,1},
				 {1,0,0,0,0,0,0,1,1},
				 {1,0,0,0,0,0,4,0,1},
				 {1,0,1,1,0,0,0,0,1},
				 {1,0,0,0,0,0,0,1,1},
				 {1,1,1,1,1,1,1,1,1}
		 };
		
		
		Carte carte = new Carte(map1);

		
		nom = "bobo";
		profession = 1; //1 pour avoir la profession Gladiateur
		Acteur[] acteur = {new PersonnageEnCombat(nom,new Stats(profession), carte.CherchePositionActeur(2), profession, compPerso),
						   new Monstre("Monstro",new Stats(2), carte.CherchePositionActeur(3),compMonstre,3)    
						  };

		carteAscii = carte.toString();
		System.out.println(carteAscii);
		
		//Mouvement d'un acteur
		Coordonnees mouvementTemp = new Coordonnees(acteur[0].getPosition());
		mouvementTemp.changePosX(-2);
		mouvementTemp.changePosY(-1);
		acteur[0].MouvementDeLActeur(carte, mouvementTemp);

		carte.ActualiseCarte(acteur);
		carteAscii = carte.toString();
		System.out.println(carteAscii);

		// Acteur persoEnCombat = new PersonnageEnCombat(nom, new Stats(profession), Carte.CherchePositionActeur(carte,
		// 2), profession, comp);

	}
}
