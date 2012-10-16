package combat;


/**
 * correspond a la description d'un monstre (contient toutes les informations utiles au combat)
 * @author colasr
 */
public class Monstre extends Acteur
{
	
	/**
	 * competence du monstre (competence unique ( != du perso))
	 */
	private final Competences competences;
	
	/**
	 * cree un monstre avec toutes les infos utiles pour le combat
	 * @param nom
	 * @param stats
	 * @param coordonees
	 * @param competences
	 * @param numMonstre
	 */
	public Monstre(String nom, Stats stats, Coordonees coordonees, Competences competences, byte numMonstre)
	{
		super(nom, stats, coordonees, numMonstre);
		this.competences = competences;
	}

	/**
	 * @return la competence du monstre
	 */
	public Competences getCompetences()
	{
		return this.competences;
	}
	

}
