/**
 * @author colasr
 * classe coordonées (X,Y)
 */
public class coordonees
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
	 * crée les coordonées d'un objet (perso / enemis / competences)
	 * @param x
	 * @param y
	 */
	public coordonees(int x, int y)
	{
		super();
		this.X = x;
		this.Y = y;
	}
}
