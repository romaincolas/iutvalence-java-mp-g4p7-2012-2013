// FIXME (FIXED) renommer le paquetage (fr.iutvalence.java.projets.(nom))
package fr.iutvalence.java.projets.test;


// FIXME cette classe ne doit pas contenir de main et ne pas être dépendante de l'affichage : à reprendre entièrement

import fr.iutvalence.java.projets.combat.Acteur;
import fr.iutvalence.java.projets.combat.Competences;
import fr.iutvalence.java.projets.combat.Coordonnees;
import fr.iutvalence.java.projets.combat.PersonnageEnCombat;
import fr.iutvalence.java.projets.combat.Stats;
/**
 * @author colasr
 * Classe principale, fait tourner le jeu
 */
public class Combat
{

	

	/* 0 pour un emplacement libre , 1 pour un obstacle, 2 pour  l'emplcement 
	 du joueur, 3+ pour le(s) monstre(s)*/


    
	/**
	 * Fait tourner le jeu
	 * @param args 
	 */
	public static void main(String[] args)
	{
		int[][] map={
				 {1,1,1,1,1,1},
				 {1,0,0,0,0,1},
				 {1,0,3,0,0,1},
				 {1,0,1,1,0,1},
				 {1,0,0,0,0,1},
				 {1,0,0,0,2,1},
				 {1,1,1,1,1,1}
		 };
		
		String nom = "bobo";
		byte profession = 1; //1 pour avoir la profession Gladiateur
		
		Competences[] comp={new Competences("Attaque", 1, 1, 5, 0, 1)};
		
		Acteur persoEnCombat = new PersonnageEnCombat(nom, new Stats(profession), CherchePositionActeur(map, 2), profession, comp);
		

	}
}

