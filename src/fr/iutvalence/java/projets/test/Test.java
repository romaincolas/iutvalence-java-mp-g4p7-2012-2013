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
	 * Deplace un acteur sur une carte en fonction de x y
	 * 
	 * @param carte carte ou l'acteur se deplace
	 * @param acteur Acteur qui subit le deplacement
	 * @param y Deplcement en y
	 * @param x Deplcement en x
	 */
	public static void DeplacementActeur(Carte carte, Acteur acteur, int y,int x)
	{
		//Mouvement d'un acteur
		Coordonnees mouvementTemp = new Coordonnees(acteur.getPosition());
		mouvementTemp.changePosX(x);
		mouvementTemp.changePosY(y);
		acteur.MouvementDeLActeur(carte, mouvementTemp);		
		
	}
	
	/**
	 * @param carte carte du combat
	 * @param acteur liste des acteurs present sur la carte 
	 */
	public static void AfficheCarte(Carte carte,Acteur[] acteur)
	{
		String carteAscii;
		carte.ActualiseCarte(acteur);
		carteAscii = carte.toString();
		System.out.println(carteAscii);
	}
	
	/**
	 * Fait tourner le jeu
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		
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

		AfficheCarte(carte,acteur);
		
		DeplacementActeur(carte,acteur[0],-2,-2);
		
		AfficheCarte(carte,acteur);
		// Acteur persoEnCombat = new PersonnageEnCombat(nom, new Stats(profession), Carte.CherchePositionActeur(carte,
		// 2), profession, comp);

	}
}
