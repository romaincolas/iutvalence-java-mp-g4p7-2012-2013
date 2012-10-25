
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

	// FIXME redéfinir toString

	// FIXME redéfinir equals et hashcode

}
