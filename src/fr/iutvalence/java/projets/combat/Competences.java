// FIXME (FIXED) renommer le paquetage (fr.iutvalence.java.projets.(nom))
package fr.iutvalence.java.projets.combat;

// FIXME (FIXED) détailler le commentaire
/**
 * description des competences (avec les statistiques permettant de determiner leur puissance // leur nombre d'utilisation //
 *  leur portée sur la carte // leur nom // leur consommation en points d'action)
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
	// FIXME (FIXED) renommer l'attribut (orthographe)
	private final int consommation;

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
	// FIXME (FIXED) renommer l'attribut
	private int nombreUtilisationMaxParCombat;
	
	// FIXME (FIXED) compléter et détailler le commentaire
	/**
	 * Cree une competence avec toutes ses statistiques necessaires pour son utilisation
	 * @param nom
	 * @param portee
	 * @param consommation
	 * @param bonusPuissance
	 * @param bonusDefense
	 * @param nombreUtilisation 
	 */
	public Competences(String nom, int portee, int consommation, int bonusPuissance, int bonusDefense, int nombreUtilisation)
	{
		this.nom = nom;
		this.portee = portee;
		this.consommation= consommation;
		this.bonusPuissance=bonusPuissance;
		this.bonusDefense=bonusDefense;
		this.nombreUtilisationMaxParCombat=nombreUtilisation;
	}

	// FIXME (FIXED) compléter le commentaire
	/**
	 * donne le nom de la competence
	 * @return nom (le nom de la competence)
	 */
	public String getNom() 
	{
		return this.nom;
	}

	// FIXME (FIXED) compléter le commentaire
	/**
	 * donne la portee de la competence
	 * @return portee (portee de la competence)
	 */
	public int getPortee()
	{
		return this.portee;
	}

	// FIXME (FIXED) compléter le commentaire
	/**
	 * donne la consommation en points d'action de la competence
	 * @return consommation (consomation en point d'action)
	 */
	// FIXME (FIXED) renommer la méthode (orthographe)
	public int getConsommation() 
	{
		return this.consommation;
	}

	// FIXME (FIXED) compléter le commentaire
	/**
	 * donne le bonus de puissance de la competence
	 * @return bonuspuissance
	 */
	public int getBonusPuissance()
	{
		return this.bonusPuissance;
	}

	// FIXME (FIXED) compléter le commentaire
	/**
	 * donne le bonus de defense de la competence
	 * @return bonusdefense
	 */
	public int getBonusDefense() 
	{
		return this.bonusDefense;
	}


	// FIXME (FIXED) compléter le commentaire
	/**
	 * donne le nombre d'utilisation de la competence pour un combat
	 * @return nombreUtilisation (nombre d'utilisation de la competence pour 1 combat)
	 */
	// FIXME (FIXED) renommer la méthode
	public int getNombreUtilisationMaxParCombat() 
	{
		return this.nombreUtilisationMaxParCombat;
	}


	/**
	 * décroit le nombre d'utilisation de la competence de 1
	 */
	public void utilisationCompetences()
	{
		this.nombreUtilisationMaxParCombat = (this.nombreUtilisationMaxParCombat - 1);
	}
	
	
	
}
