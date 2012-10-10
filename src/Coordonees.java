
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
	 * crÃ©e les coordonées d'un objet (perso / ennemis / competences)
	 * @param x (abscisse)
	 * @param y (ordonnée)
	 */
	public Coordonees(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
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

	/**
	 * ajout la valeur du param x à la position actuel en x
	 * @param x (abscisse)
	 */
	public void changePosX(int x) {
		this.x = this.x + x;
	}

	/**
	 * ajout la valeur du param y à la position actuel en y 
	 * @param y (ordonnée)
	 */
	public void changePosY(int y) {
		this.y = this.y + y;
	}
	
}
