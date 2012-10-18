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
	
	public String toString()
	{
		int x,y;
		String carteAscii = "";
		
		for (x=0; x<carte.length;x++)
		{
			carteAscii = carteAscii + "_";
		}
		
		carteAscii = carteAscii + "\n";

		
		for (x=0; x<carte.length;x++)
		{
			carteAscii = carteAscii + "|";
		    for(y=0; y<carte[x].length; y++)
		    {
		    	if (carte[x][y] == 0)
		    	{
					carteAscii = carteAscii + ".";
		    	}
		    	else if (carte[x][y] == 1)
		    	{
		    		carteAscii = carteAscii + "¤";
		    	}
		    	else if (carte[x][y] == 2)
		    	{
		    		carteAscii = carteAscii + "☺";
		    	}
		    	else
		    	{
		    		carteAscii = carteAscii + "☻";
		    	}
			}
			carteAscii = carteAscii + "|\n";
		}
		
		for (x=0; x<carte.length;x++)
		{
			carteAscii = carteAscii + "_";
		}
		
		return carteAscii;
	}
}
