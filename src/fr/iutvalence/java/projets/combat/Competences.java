// FIXME renommer le paquetage (fr.iutvalence.java.projets.(nom))
package fr.iutvalence.java.projets.combat;

// FIXME détailler le commentaire
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
	 * portée de la competence (en nombre de cases)
	 */
	private final int portee;
	
	/**
	 * consommation de la competence en points d'action
	 */
	// FIXME renommer l'attribut (orthographe)
	private final int consomation;

	/**
	 * bonus de puissance donné par la competence
	 */
	private final int bonusPuissance;

	/**
	 * bonus de defense donné par la competence
	 */
	private final int bonusDefense;

	/**
	 * nombre d'utilisations maximum de la competence en un combat
	 */
	// FIXME renommer l'attribut
	private byte nombreUtilisation;
	
	// FIXME compléter et détailler le commentaire
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

	// FIXME compléter le commentaire
	/**
	 * @return nom (le nom de la competence)
	 */
	public String getNom() 
	{
		return this.nom;
	}

	// FIXME compléter le commentaire
	/**
	 * @return portee (portee de la competence)
	 */
	public int getPortee()
	{
		return this.portee;
	}

	// FIXME compléter le commentaire
	/**
	 * @return consomation (consomation en point d'action)
	 */
	// FIXME renommer la méthode (orthographe)
	public int getConsomation() 
	{
		return this.consomation;
	}

	// FIXME compléter le commentaire
	/**
	 * @return bonuspuissance
	 */
	public int getBonusPuissance()
	{
		return this.bonusPuissance;
	}

	// FIXME compléter le commentaire
	/**
	 * @return bonusdefense
	 */
	public int getBonusDefense() 
	{
		return this.bonusDefense;
	}


	// FIXME compléter le commentaire
	/**
	 * @return nombreUtilisation (nombre d'utilisation de la competence pour 1 combat)
	 */
	// FIXME renommer la méthode
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
