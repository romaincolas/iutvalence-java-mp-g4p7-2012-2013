package fr.iutvalence.java.projets.combat;

/**
 * correspond a la description d'un personnage (contient toutes les informations utiles au combat)
 * 
 * @author colasr
 * 
 */
public class PersonnageEnCombat extends Acteur
{

	/**
	 * indice de la profession
	 */
	private final int idProfession;

	/**
	 * liste de toutes les competences utilisable par le personnage
	 */
	private Competences[] competences;

	/**
	 * Cree un objet personnage avec tout attribut necessaire a sa gestion.
	 * 
	 * @param nom (nom du personnage)
	 * @param stats (objet stats regroupe les stats du personnage)
	 * @param coordonnees (position du personnage)
	 * @param idProfession (id de la profession)
	 * @param competences (liste des competences disponible pour le personnage)
	 */
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
	public int getIdProfession()
	{
		return this.idProfession;
	}

	/***
	 * Cherche une competences dans la liste de competence
	 * @param numCompetences numero de la competence dans la liste
	 * @return competences recherchée
	 */
	public Competences getCompetences(int numCompetences)
	{
		return this.competences[numCompetences];
	}

	/**
	 * consomme une utilisation de la competence entre en param
	 * 
	 * @param numCompetences numero de la competence a utilise
	 */
	public void utilisationCompetences(int numCompetences)
	{
		this.competences[numCompetences].utilisationCompetences();
	}

}
