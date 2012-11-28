package fr.iutvalence.java.projets.test;


import fr.iutvalence.java.projets.combat.*;
//import java.util.Scanner;
/**
 *  Classe principale, fait tourner le jeu
 * @author colasr
 */
public class Test
{

	/*
	 * 0 pour un emplacement libre , 1 pour un obstacle, 2 pour l'emplcement du joueur, 3+ pour le(s) monstre(s)
	 */

	
	/**
	 * Fait tourner le jeu
	 * 
	 * @param args arguement du main
	 */
	public static void main(String[] args)
	{
		final Interface fenetre;
		
		int profession;
		String nom;
		Monstre[] touche;
		// La premiere competences de la liste de cometences à un nombre d'utilisation infinie )
		Competences[] compPerso={new Competences("Attaque", 1, 1, 5, 0, 1),new Competences("Coup puissant", 1, 2, 15, 0, 5),new Competences("Lance epee", 1, 5, 15, 0, 5)};
		Competences compMonstre=new Competences("Attaque", 1, 1, 5, 0, 1);
		int[][] map1={
				 {1,1,1,1,1,1,1,1,1},
				 {1,0,0,0,0,2,3,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,1,1,0,0,4,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,0,0,1,0,1,1,1},
				 {1,0,0,0,1,0,0,1,1},
				 {1,0,0,0,0,0,0,1,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,0,0,0,0,0,1,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,1,1,0,0,0,0,1},
				 {1,0,0,0,0,0,0,1,1},
				 {1,1,1,1,1,1,1,1,1}
		 };
		
		
		
		
		Carte carte = new Carte(map1);

		
		nom = "bobo";
		profession = 1; //1 pour avoir la profession Gladiateur
		Monstre[] monstres = {new Monstre("Monstro1",new Stats(2), carte.CherchePositionActeur(3),compMonstre,3),
						 new Monstre("Monstro2",new Stats(2), carte.CherchePositionActeur(4),compMonstre,4)    
						  };
		PersonnageEnCombat joueur = new PersonnageEnCombat(nom,new Stats(profession), carte.CherchePositionActeur(2), profession, compPerso);

		
		GestionCombat combat = new GestionCombat(carte, joueur, monstres);
		
		fenetre = new Interface(carte);
		
		combat.AfficheCarte();
		System.out.println(combat.ZoneDePorteeJoueur(compPerso[0]).length);
	}
}
