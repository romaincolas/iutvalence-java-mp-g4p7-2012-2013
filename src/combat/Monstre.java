package combat;

public class Monstre extends Acteur{
	
	private final Competences competences;
	
	public Monstre(String nom,Stats stats, Coordonees coordonees, Competences competences){
		super(nom, stats, coordonees);
		this.competences = competences;
	}

	public Competences getCompetences() {
		return competences;
	}
	

}
