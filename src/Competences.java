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
	
	public Competences (String nom, int portee, int consomation, int bonusPuissance, int bonusDefense, int duree) {
		this.nom = nom;
		this.portee = portee;
		this.consomation= consomation;
		this.bonusPuissance=bonusPuissance;
		this.bonusDefense=bonusDefense;
		this.duree=duree;
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
	
	
}
