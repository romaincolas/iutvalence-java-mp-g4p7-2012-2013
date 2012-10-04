// FIXME déplacer dans un paquetage

/**
 * Stats de base de chaque Profession
 * @author colasr
 */
public class StatsProfession
{
	/**
	 * nom de la profession
	 */
	private final String nom;
	
	/**
	 * puissance de base
	 */
	private int puissance;

	/**
	 * defense de base
	 */
	private int defense;
	
	/**
	 * Pv de base
	 */
	private int pv;
	
	/**
	 * Pm de base
	 */
	private int pm;

	/**
	 * Fixe les stats de base du perso pour la profession choisie
	 * @param nom
	 */

	public StatsProfession(String nom)
	{
		super();
		this.nom = nom;
		if (nom == "Gladiateur")
		{
			// FIXME définir les valeurs par défaut sous forme de constantes
			this.puissance = 8;
			this.defense = 5;
			this.pv = 45;
			this.pm = 4;
		}
		else if (nom == "Templier")
		{
			// FIXME définir les valeurs par défaut sous forme de constantes
			this.puissance = 7;
			this.defense = 6;
			this.pv = 50;
			this.pm = 4;
		}
		else if (nom == "Rodeur")
		{
			// FIXME définir les valeurs par défaut sous forme de constantes
			this.puissance = 8;
			this.defense = 4;
			this.pv = 40;
			this.pm = 3;
		}
		else
		{
			// FIXME définir les valeurs par défaut sous forme de constantes
			this.puissance = 8;
			this.defense = 4;
			this.pv = 40;
			this.pm = 4;
		}
		
		// FIXME méthodes ?
	}


	/**
	 * @return le nom de la profession
	 */
	public String getNom()
	{
		return nom;
	}
	
}
