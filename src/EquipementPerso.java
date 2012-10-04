// FIXME déplacer dans un paquetage

// FIXME corriger le commentaire
/**
 * @author colasr
 * determine l'equipement total sur le perso
 */
public class EquipementPerso extends PieceEquipement
{
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant au casque équipé
	 */
	private PieceEquipement casque;
	
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant aux gants équipés
	 */
	private PieceEquipement gants;
	
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant au plastron équipé
	 */
	private PieceEquipement plastron;
	
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant aux jambieres équipées
	 */
	private PieceEquipement jambieres;
	
	// FIXME corriger le commentaire
	/**
	 * attribut correspondant aux bottes équipées
	 */
	private PieceEquipement bottes;

	// FIXME corriger le commentaire
	/**
	 * crée l'objet equipementPerso avec les 5 pieces d'equipement
	 * @param casque
	 * @param gants
	 * @param plastron
	 * @param jambieres
	 * @param bottes
	 */
	public EquipementPerso(PieceEquipement casque, PieceEquipement gants, PieceEquipement plastron,
			PieceEquipement jambieres, PieceEquipement bottes)
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
