package combat;
// FIXME déplacer dans un paquetage

/**
 * description des competences
 * @author colasr
 */
public class Competences

{
	// FIXME écrire un commentaire
	private final String nom;

	// FIXME écrire un commentaire
	private final int portee;
	
	// FIXME écrire un commentaire
	private final int consomation;

	// FIXME écrire un commentaire
	private final int bonusPuissance;

	// FIXME écrire un commentaire
	private final int bonusDefense;
	
	private final int duree;
	
	private int nbDeLancement;
	
	public Competences (String nom, int portee, int consomation, int bonusPuissance, int bonusDefense, int duree, int nbDeLancement) {
		this.nom = nom;
		this.portee = portee;
		this.consomation= consomation;
		this.bonusPuissance=bonusPuissance;
		this.bonusDefense=bonusDefense;
		this.duree=duree;
		this.nbDeLancement=nbDeLancement;
	}

	
	public String getNom() {
		return nom;
	}

	public int getPortee() {
		return portee;
	}

	public int getConsomation() {
		return consomation;
	}

	public int getBonusPuissance() {
		return bonusPuissance;
	}

	public int getBonusDefense() {
		return bonusDefense;
	}


	public int getDuree() {
		return duree;
	}


	public int getNbDeLancement() {
		return nbDeLancement;
	}


	public void utilisationCompetences() {
		this.nbDeLancement = this.nbDeLancement-1;
	}
	
	
	
	
}
