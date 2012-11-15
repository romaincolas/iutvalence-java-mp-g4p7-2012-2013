package fr.iutvalence.java.projets.combat;

public class GestionCombat
{
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
	
}
