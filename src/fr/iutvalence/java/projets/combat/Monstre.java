// FIXME (FIXED) renommer le paquetage (fr.iutvalence.java.projets.(nom))
package fr.iutvalence.java.projets.combat;


/**
 * correspond à la description d'un monstre (contient toutes les informations utiles au combat)
 * @author colasr
 */
public class Monstre extends Acteur
{
	
	/**
	 * competences du monstre (competence unique ( != du perso))
	 */
	private final Competences competences;
	
	// FIXME (FIXED) compléter le commentaire
	/**
	 * cree un monstre avec toutes les infos utiles pour le combat
	 * @param nom (le nom du monstre)
	 * @param stats (les statistiques du monstre)
	 * @param coordonnees (les coordonnees du monstre sur la carte)
	 * @param competences (l'unique competence du monstre)
	 * @param numMonstre (le numero du monstre, permet de l'identifier et de le positionner sur la carte)
	 */
	public Monstre(String nom, Stats stats, Coordonnees coordonnees, Competences competences, int numMonstre)
	{
		super(nom, stats, coordonnees, numMonstre);
		this.competences = competences;
	}

	// FIXME (FIXED) compléter le commentaire
	/**
	 * donne la competence unique du monstre
	 * @return la competence du monstre
	 */
	public Competences getCompetences()
	{
		return this.competences;
	}
	

}
