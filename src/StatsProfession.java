 /**
  * @author colasr
  * parametres de bases de chaque statsProfession
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
	 * constructeur des 4 statsProfession de base
	 * @param nom
	 */
	public StatsProfession(String nom)
	{
		super();
		this.nom = nom;
		if (nom == "Gladiateur")
		{
			this.puissance = 8;
			this.defense = 5;
			this.pv = 45;
			this.pm = 4;
		}
		else if (nom == "Templier")
		{
			this.puissance = 7;
			this.defense = 6;
			this.pv = 50;
			this.pm = 4;
		}
		else if (nom == "Rodeur")
		{
			this.puissance = 8;
			this.defense = 4;
			this.pv = 40;
			this.pm = 3;
		}
		else
		{
			this.puissance = 8;
			this.defense = 4;
			this.pv = 40;
			this.pm = 4;
		}
	}

	/**
	 * @return le nom de la profession
	 */
	public String getNom()
	{
		return nom;
	}
	
	
	
}
