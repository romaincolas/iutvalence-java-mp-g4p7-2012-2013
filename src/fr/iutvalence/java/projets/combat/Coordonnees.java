
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

	/**
	 * Cree un nouveau objet coordonnees a partie de la soustraction de 2 coordonnees
	 * @param coord coordonnees a soustraire 
	 * @return soustre 2 coordonnees
	 */
	public Coordonnees SoustractionCoordonnees(Coordonnees coord)
	{
		return new Coordonnees(this.x-coord.getX(),this.y-coord.getY());
	}
	
	public String toString()
	{
		String coordonnees = "";
		coordonnees = "(" + this.x + "," + this.y + ")";
		return coordonnees;
	}

	// (FIXED) FIXME ce n'est pas une redéfinition de equals (voir http://www.artima.com/lejava/articles/equality.html)	
	/**
	 * Teste l'egalite entre une coordonnee et l'objet
	 * @param object un objet a comparer
	 * @return Si les 2 coordonnees sont egales alors on retourne vrai sinon faux
	 */
	public boolean equals(Object object)
	{
		boolean result= false;
		if (object instanceof Coordonnees)
		{
			Coordonnees coor = (Coordonnees) object;
			result = (this.getX() == coor.getX() && this.getY() == coor.getY());
		}
		return result;
	}
	
	
	

	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + this.x;
		result = prime * result + this.y;
		return result;
	}
}
