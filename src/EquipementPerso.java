// FIXME déplacer dans un paquetage

// FIXME corriger le commentaire
/**
 * @author colasr
 * determine l'equipement total sur le perso
 */
// FIXME respecter les conventions d'écriture
// FIXME me justifier l'extension de la classe pieceEquipement
public class equipementPerso extends pieceEquipement
{
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant au casque équipé
	 */
	private pieceEquipement casque;
	
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant aux gants équipés
	 */
	private pieceEquipement gants;
	
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant au plastron équipé
	 */
	private pieceEquipement plastron;
	
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant aux jambieres équipées
	 */
	private pieceEquipement jambieres;
	
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant aux bottes équipées
	 */
	private pieceEquipement bottes;

	// FIXME corriger le commentaire
	/**
	 * crée l'objet equipementPerso avec les 5 pieces d'equipement
	 * @param casque
	 * @param gants
	 * @param plastron
	 * @param jambieres
	 * @param bottes
	 */
	public equipementPerso(pieceEquipement casque, pieceEquipement gants, pieceEquipement plastron,
			pieceEquipement jambieres, pieceEquipement bottes)
	{
		super();
		this.casque = casque;
		this.gants = gants;
		this.plastron = plastron;
		this.jambieres = jambieres;
		this.bottes = bottes;
	}
	
	// FIXME méthodes ?
}
