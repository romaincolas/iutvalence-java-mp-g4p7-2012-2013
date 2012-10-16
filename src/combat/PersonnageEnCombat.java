package combat;


public class PersonnageEnCombat extends Acteur
{
	
	private final byte idProfession;
	
	private Competences[] competences;
	
	public PersonnageEnCombat(String nom, Stats stats, Coordonees coordonees, byte idProfession, Competences[] competences)
	{
		super(nom, stats, coordonees, (byte)2);
		this.idProfession=idProfession;
		this.competences = competences;
	}

	
	public byte getIdProfession()
	{
		return idProfession;
	}

	public Competences getCompetences(int numCompetences)
	{
		return competences[numCompetences];
	}

	public void utilisationCompetences(int numCompetences)
	{
		this.competences[numCompetences].utilisationCompetences();
	}
	
	

}
