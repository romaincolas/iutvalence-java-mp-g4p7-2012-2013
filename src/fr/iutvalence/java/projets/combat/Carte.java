package fr.iutvalence.java.projets.combat;
/**
 * Zone de combat avec la position de tout les acteurs et les obstacles 
 */
public class Carte
{
	int[][] carte;

	public Carte(int[][] carte)
	{
		super();
		this.carte = carte;
	}
	
	/**
	 * Cherche la position d'un acteur en fonction de son numero (numActeur !=  0 et 1)
	 * @param carte 
	 * @param numActeur
	 * @return les coordonees de depart de l'acteur sur la carte de base
	 */
	public static Coordonnees CherchePositionActeur(int[][] carte, int numActeur)
	{
		int x,y;
		for (x=0; x<carte.length;x++)
		{
		    for(y=0; y<carte[x].length; y++)
		    {
		    	if (carte[x][y]==numActeur)
				{
			    	return new Coordonnees(x,y);
			    }
			}	    
		}
		return new Coordonnees(0,0);
	}
	
	/**
	 * Change l'etat d'un coordonnees de la carte
	 * @param coordonnes (coordonnees de la carte ou changer l'etat)
	 * @param nouvEtat
	 */
	public void ChangeEtat(Coordonnees coordonnes, int nouvEtat)
	{
		carte[coordonnes.getX()][coordonnes.getY()] = nouvEtat;
		
	}
}
