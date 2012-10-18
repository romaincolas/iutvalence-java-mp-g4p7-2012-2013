// FIXME renommer le paquetage (fr.iutvalence.java.projets.(nom))
package combat;

// FIXME écrire un commentaire
public class PersonnageEnCombat extends Acteur
{

	// FIXME écrire un commentaire
	private final byte idProfession;
	
	// FIXME écrire un commentaire
	private Competences[] competences;
	
	// FIXME écrire un commentaire
	public PersonnageEnCombat(String nom, Stats stats, Coordonees coordonees, byte idProfession, Competences[] competences)
	{
		super(nom, stats, coordonees, (byte)2);
		this.idProfession=idProfession;
		this.competences = competences;
	}

	// FIXME écrire un commentaire
	public byte getIdProfession()
	{
		return idProfession;
	}

	// FIXME écrire un commentaire
	public Competences getCompetences(int numCompetences)
	{
		return competences[numCompetences];
	}

	// FIXME écrire un commentaire
	public void utilisationCompetences(int numCompetences)
	{
		this.competences[numCompetences].utilisationCompetences();
	}

}
