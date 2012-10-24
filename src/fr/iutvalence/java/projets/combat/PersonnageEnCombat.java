// FIXME (FIXED) renommer le paquetage (fr.iutvalence.java.projets.(nom))
package fr.iutvalence.java.projets.combat;

/**
 * correspond a la description d'un personnage (contient toutes les informations utiles au combat)
 * 
 * @author colasr
 * 
 */
// FIXME (FIXED) écrire un commentaire
public class PersonnageEnCombat extends Acteur
{

	/**
	 * indice de la profession
	 */
	// FIXME (FIXED) écrire un commentaire
	private final int idProfession;

	/**
	 * liste de toutes les competences utilisable par le personnage
	 */
	// FIXME (FIXED) écrire un commentaire
	private Competences[] competences;

	/**
	 * Cree un personnage
	 * 
	 * @param nom
	 * @param stats
	 * @param coordonnees
	 * @param idProfession
	 * @param competences
	 */
	// FIXME (FIXED) écrire un commentaire
	public PersonnageEnCombat(String nom, Stats stats, Coordonnees coordonnees, int idProfession,
			Competences[] competences)
	{
		super(nom, stats, coordonnees, 2);
		this.idProfession = idProfession;
		this.competences = competences;
	}

	/**
	 * donne l'indice de la profession (1-gladiateur, 2-templier, 3-rodeur, 4-sorcier)
	 * 
	 * @return indice profession
	 */
	// FIXME (FIXED) écrire un commentaire
	public int getIdProfession()
	{
		return this.idProfession;
	}

	/***
	 * Cherche une competences dans la liste de competence
	 * 
	 * @param numCompetences
	 * @return competences recherchée
	 */
	// FIXME (FIXED) écrire un commentaire
	public Competences getCompetences(int numCompetences)
	{
		return this.competences[numCompetences];
	}

	/**
	 * consomme une utilisation de la competence entre en param
	 * 
	 * @param numCompetences
	 */
	// FIXME (FIXED) écrire un commentaire
	public void utilisationCompetences(int numCompetences)
	{
		this.competences[numCompetences].utilisationCompetences();
	}

}
