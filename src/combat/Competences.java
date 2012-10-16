package combat;
// FIXME déplacer dans un paquetage

/**
 * description des competences
 * @author colasr
 */
public class Competences

{
	/**
	 * nom de la competence
	 */
	private final String nom;

	/**
	 * portÃ©e de la competence (en nombre de case)
	 */
	private final int portee;
	
	/**
	 * consomation de la competence en points d'action
	 */
	private final int consomation;

	/**
	 * bonus de puissance donnÃ© par la competence
	 */
	private final int bonusPuissance;

	/**
	 * bonus de defense donnÃ© par la competence
	 */
	private final int bonusDefense;

	/**
	 * nombre d'utilisation maximum de la competence en un combat
	 */
	private byte nombreUtilisation;
	
	/**
	 * Cree une competence
	 * @param nom
	 * @param portee
	 * @param consomation
	 * @param bonusPuissance
	 * @param bonusDefense
	 * @param nombreUtilisation 
	 */
	public Competences(String nom, int portee, int consomation, int bonusPuissance, int bonusDefense, byte nombreUtilisation)
	{
		this.nom = nom;
		this.portee = portee;
		this.consomation= consomation;
		this.bonusPuissance=bonusPuissance;
		this.bonusDefense=bonusDefense;
		this.nombreUtilisation=nombreUtilisation;
	}

	
	/**
	 * @return nom (le nom de la competence)
	 */
	public String getNom() 
	{
		return this.nom;
	}

	/**
	 * @return portee (portee de la competence)
	 */
	public int getPortee()
	{
		return this.portee;
	}

	/**
	 * @return consomation (consomation en point d'action)
	 */
	public int getConsomation() 
	{
		return this.consomation;
	}

	/**
	 * @return bonuspuissance
	 */
	public int getBonusPuissance()
	{
		return this.bonusPuissance;
	}

	
	/**
	 * @return bonusdefense
	 */
	public int getBonusDefense() 
	{
		return this.bonusDefense;
	}


	/**
	 * @return nombreUtilisation (nombre d'utilisation de la competence pour 1 combat)
	 */
	public int getNombreUtilisation() 
	{
		return this.nombreUtilisation;
	}


	/**
	 * décroit le nombre d'utilisation de la competence de 1
	 */
	public void utilisationCompetences()
	{
		this.nombreUtilisation = (byte) (this.nombreUtilisation - 1);
	}
	
	
	
}
