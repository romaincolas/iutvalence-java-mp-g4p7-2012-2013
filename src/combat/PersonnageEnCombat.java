package combat;


/**
 * correspond a la description d'un personnage (contient toutes les informations utiles au combat)
 * @author colasr
 *
 */
public class PersonnageEnCombat extends Acteur
{
	
	/**
	 * indice de la profession
	 */
	private final byte idProfession;
	
	/**
	 * liste de toutes les competences utilisable par le personnage
	 */
	private Competences[] competences;
	
	/**
	 * Cree un personnage
	 * @param nom
	 * @param stats
	 * @param coordonees
	 * @param idProfession
	 * @param competences
	 */
	public PersonnageEnCombat(String nom, Stats stats, Coordonees coordonees, byte idProfession, Competences[] competences)
	{
		super(nom, stats, coordonees, (byte)2);
		this.idProfession=idProfession;
		this.competences = competences;
	}

	
	/**
	 * @return indice profession
	 */
	public byte getIdProfession()
	{
		return this.idProfession;
	}

	/***
	 * Cherche une cometences dans la liste
	 * @param numCompetences
	 * @return competences recherché
	 */
	public Competences getCompetences(int numCompetences)
	{
		return this.competences[numCompetences];
	}

	/**
	 * consomme une utilisation de la competence entre en param
	 * @param numCompetences
	 */
	public void utilisationCompetences(int numCompetences)
	{
		this.competences[numCompetences].utilisationCompetences();
	}
	
	

}
