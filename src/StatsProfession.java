// FIXME déplacer dans un paquetage

// FIXME compléter et corriger le commentaire
/**
  * @author colasr
  * parametres de bases de chaque statsProfession
  */
// FIXME respecter les conventions d'écriture
public class statsProfession
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

	// FIXME corriger le commentaire
	/**
	 * constructeur des 4 statsProfession de base
	 * @param nom
	 */
	
	// FIXME remplacer le paramètre String par un paramètre de type int véhiculant une constante identifiant la profession
	// FIXME ou, mieux, utiliser l'héritage pour différencier le profil des personnages
	public statsProfession(String nom)
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
}
