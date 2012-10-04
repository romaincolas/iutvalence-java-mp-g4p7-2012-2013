/**
 * @author colasr
 * classe coordonées (X,Y)
 */
public class Coordonees
{
	/**
	 * coordonée X (abscisses)
	 */
	private int X;
	
	/**
	 * coordonée Y (ordonnées)
	 */
	private int Y;

	/**
	 * crée les coordonées d'un objet (perso / ennemis / competences)
	 * @param x
	 * @param y
	 */
	public Coordonees(int x, int y)
	{
		super();
		this.X = x;
		this.Y = y;
	}
}
