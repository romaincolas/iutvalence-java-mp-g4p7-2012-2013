// FIXME renommer le paquetage (fr.iutvalence.java.projets.(nom))
package combat;

/**
 * gere les coordonées sur la map (X,Y) (sert pour les gestions de colision / les deplacements / 
 * les competences)
 * @author colasr
 */
// FIXME corriger le nom de la classe (orthographe)
public class Coordonees
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
	 * @param x (abscisse)
	 * @param y (ordonnée)
	 */
	public Coordonees(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	// FIXME compléter le commentaire
	/**
	 * retourne la position x de l'acteur
	 * @return x
	 */
	public int getX()
	{
	    return this.x;
	}

	// FIXME compléter le commentaire
	/**
	 * retourne la position y de l'acteur
	 * @return y
	 */
	public int getY()
	{
	    return this.y;
	}

	/**
	 * ajout la valeur du param x à la position actuel en x
	 * @param x (abscisse)
	 */
	public void changePosX(int x)
	{
		this.x = this.x + x;
	}

	/**
	 * ajout la valeur du param y à la position actuel en y 
	 * @param y (ordonnée)
	 */
	public void changePosY(int y)
	{
		this.y = this.y + y;
	}
	
	// FIXME redéfinir toString
	
	// FIXME redéfinir equals et hashcode
	
}
