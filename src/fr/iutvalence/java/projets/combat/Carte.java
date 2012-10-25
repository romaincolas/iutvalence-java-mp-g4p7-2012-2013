package fr.iutvalence.java.projets.combat;
/**
 * Zone de combat avec la position de tout les acteurs et les obstacles 
 */
public class Carte
{
	/**
	 * La carte (double tableau d'entier)
	 */
	int[][] carte;

	/**
	 * Crée unee carte (double tableau d'entier)
	 * @param carte (double tableau avec 0 pour zone vide,1 pour obstacle, 
	 * 2 pour le personnage, 3+ pour les monstres)
	 */
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
	
	public Coordonnees CherchePositionActeur(int numActeur)
	{
		int x,y;
		for (x=0; x<this.carte.length;x++)
		{
		    for(y=0; y<this.carte[x].length; y++)
		    {
		    	if (this.carte[x][y]==numActeur)
				{
			    	return new Coordonnees(x,y);
			    }
			}	    
		}
		return new Coordonnees(1,1);
	}
	
	/**
	 * actualise la carte et change la position des acteurs.
	 * @param acteur une liste d'acteurs qui participent au combat
	 */
	public void ActualiseCarte(Acteur[] acteur)
	{
		int x;
		Coordonnees coordonnees;
		for	(x=0;x<acteur.length;x++)
		{	
			coordonnees=CherchePositionActeur(acteur[x].getNumActeur());
			this.carte[coordonnees.getX()][coordonnees.getY()]=0;
			this.carte[acteur[x].getPosition().getX()][acteur[x].getPosition().getY()] = acteur[x].getNumActeur();			
		}
	}
	
	public String toString()
	{
		int x,y;
		String carteAscii = "";

		for (x=0; x<this.carte.length;x++)
		{
		    for(y=0; y<this.carte[x].length; y++)
		    {
		    	if (this.carte[x][y] == 0)
		    	{
					carteAscii = carteAscii + "░";
		    	}
		    	else if (this.carte[x][y] == 1)
		    	{
		    		carteAscii = carteAscii + "█";
		    	}
		    	else if (this.carte[x][y] == 2)
		    	{
		    		carteAscii = carteAscii + "☺";
		    	}
		    	else
		    	{
		    		carteAscii = carteAscii + "☻";
		    	}
			}
			carteAscii = carteAscii + "\n";
		}
		
		return carteAscii;
	}
}
