
package fr.iutvalence.java.projets.combat;

/**
 * description des competences (avec les statistiques permettant de determiner leur puissance // leur nombre
 * d'utilisation // leur portée sur la carte // leur nom // leur consommation en points d'action)
 * 
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
	private int nombreUtilisationMaxParCombat;

	// FIXME (FIXED) compléter le commentaire
	/**
	 * Cree une competence avec toutes ses statistiques necessaires pour son utilisation
	 * 
	 * @param nom (nom de la competence)
	 * @param portee (portee maximal)
	 * @param consommation (consommation par utilisation [0=infinie])
	 * @param bonusPuissance (puissance a ajoute lors de l'utilisation de la competence)
	 * @param bonusDefense (defense a ajoute lors de l'utilisation de la competence)
	 * @param nombreUtilisation  (nombre d utilisation max par partie)
	 */
	public Competences(String nom, int portee, int consommation, int bonusPuissance, int bonusDefense,
			int nombreUtilisation)
	{
		this.nom = nom;
		this.portee = portee;
		this.consommation = consommation;
		this.bonusPuissance = bonusPuissance;
		this.bonusDefense = bonusDefense;
		this.nombreUtilisationMaxParCombat = nombreUtilisation;
	}

	/**
	 * donne le nom de la competence
	 * 
	 * @return nom (le nom de la competence)
	 */
	public String getNom()
	{
		return this.nom;
	}

	/**
	 * donne la portee de la competence
	 * 
	 * @return portee (portee de la competence)
	 */
	public int getPortee()
	{
		return this.portee;
	}

	/**
	 * donne la consommation en points d'action de la competence
	 * 
	 * @return consommation (consomation en point d'action)
	 */
	public int getConsommation()
	{
		return this.consommation;
	}

	/**
	 * donne le bonus de puissance de la competence
	 * 
	 * @return bonuspuissance
	 */
	public int getBonusPuissance()
	{
		return this.bonusPuissance;
	}

	/**
	 * donne le bonus de defense de la competence
	 * 
	 * @return bonusdefense
	 */
	public int getBonusDefense()
	{
		return this.bonusDefense;
	}

	/**
	 * donne le nombre d'utilisation de la competence pour un combat
	 * 
	 * @return nombreUtilisation (nombre d'utilisation de la competence pour 1 combat)
	 */
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
