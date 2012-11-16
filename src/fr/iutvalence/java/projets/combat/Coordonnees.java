
package fr.iutvalence.java.projets.combat;

/**
 * gere les coordonées sur la map (X,Y) (sert pour les gestions de colision / les deplacements / les competences)
 * 
 * @author colasr
 */
public class Coordonnees
{
	/**
	 * coordonnée X (abscisse)
	 */
	private int x;

	/**
	 * coordonnée Y (ordonnée)
	 */
	private int y;

	/**
	 * crée les coordonées d'un objet (perso / ennemis / competences)
	 * 
	 * @param x
	 *            (abscisse)
	 * @param y
	 *            (ordonnée)
	 */
	public Coordonnees(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Crée un nouveau objet coordonnees a partir d'un objet coordonnees
	 * @param coordonnees
	 */
	public Coordonnees(Coordonnees coordonnees)
	{
		this.x = coordonnees.getX();
		this.y = coordonnees.getY();
	}
	

	/**
	 * Cree un nouveau objet coordonnees a partie de l'adition de 2 coordonnees
	 * @param coordonnees1 premier coordonnees a aditionner
	 * @param coordonnees2 deuxieme coordonnees a aditionner
	 */
	public Coordonnees(Coordonnees coordonnees1, Coordonnees coordonnees2)
	{
		this.x = coordonnees1.getX()+coordonnees2.getX();
		this.y =coordonnees1.getY()+coordonnees2.getY();
	}

	/**
	 * retourne la position x de l'acteur (sa position horizontale)
	 * 
	 * @return x
	 */
	public int getX()
	{
		return this.x;
	}

	/**
	 * retourne la position y de l'acteur (position verticale)
	 * 
	 * @return y
	 */
	public int getY()
	{
		return this.y;
	}

	/**
	 * ajout la valeur du param x à la position actuel en x
	 * 
	 * @param x
	 *            (abscisse)
	 */
	public void changePosX(int x)
	{
		this.x = this.x - x;
	}

	/**
	 * ajout la valeur du param y à la position actuel en y
	 * 
	 * @param y
	 *            (ordonnée)
	 */
	public void changePosY(int y)
	{
		this.y = this.y - y;
	}

	// FIXME (FIXED) redéfinir toString
	public String toString()
	{
		String coordonnees = "";
		coordonnees = "(" + this.x + "," + this.y + ")";
		return coordonnees;
	}

	// FIXME (FIXED) redéfinir equals et hashcode
	/**
	 * Teste l'egalite entre une coordonnee et l'objet
	 * @param coor
	 * @return Si les 2 coordonnees sont egales alors on retourne vrai sinon faux
	 */
	public boolean equals(Coordonnees coor)
	{
		if (coor.x == this.x)
		{
			if (coor.y == this.y)
				return true;
		}
		return false;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
}
