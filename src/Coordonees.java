
/**
 * gere les coordonées sur la map (X,Y) (sert pour les gestions de colision / les deplacements / 
 * les competences)
 * @author colasr
 */
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
		this.x = y;
	}

	
	//Obtenir les coordonees
	public int getX() {
	    return x;
	}

	public int getY() {
	    return y;
	}

	//Changer les coordonees
	public void setX(int x) {
	    this.x = x;
	}

	public void setY(int y) {
	    this.y = y;
	}
	
	
}
