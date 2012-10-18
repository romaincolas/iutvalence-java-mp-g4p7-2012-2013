// FIXME renommer le paquetage (fr.iutvalence.java.projets.(nom))
package fr.iutvalence.java.projets.combat;


/**
 * correspond a la description d'un personnage (contient toutes les informations utiles au combat)
 * @author colasr
 *
 */
// FIXME écrire un commentaire
public class PersonnageEnCombat extends Acteur
{
	
	/**
	 * indice de la profession
	 */
	// FIXME écrire un commentaire
	private final byte idProfession;
	
	/**
	 * liste de toutes les competences utilisable par le personnage
	 */
	// FIXME écrire un commentaire
	private Competences[] competences;
	
	/**
	 * Cree un personnage
	 * @param nom
	 * @param stats
	 * @param coordonees
	 * @param idProfession
	 * @param competences
	 */
	// FIXME écrire un commentaire
	public PersonnageEnCombat(String nom, Stats stats, Coordonees coordonees, byte idProfession, Competences[] competences)
	{
		super(nom, stats, coordonees, (byte)2);
		this.idProfession=idProfession;
		this.competences = competences;
	}

	
	/**
	 * @return indice profession
	 */
	// FIXME écrire un commentaire
	public byte getIdProfession()
	{
		return this.idProfession;
	}

	/***
	 * Cherche une cometences dans la liste
	 * @param numCompetences
	 * @return competences recherché
	 */
	// FIXME écrire un commentaire
	public Competences getCompetences(int numCompetences)
	{
		return this.competences[numCompetences];
	}

	/**
	 * consomme une utilisation de la competence entre en param
	 * @param numCompetences
	 */
	// FIXME écrire un commentaire
	public void utilisationCompetences(int numCompetences)
	{
		this.competences[numCompetences].utilisationCompetences();
	}

}
