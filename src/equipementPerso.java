
/**
 * @author colasr
 * determine l'equipement total sur le perso
 */
public class equipementPerso extends pieceEquipement
{
	/**
	 * attribut correspondant au casque équipé
	 */
	private pieceEquipement casque;
	
	/**
	 * attribut correspondant aux gants équipés
	 */
	private pieceEquipement gants;
	
	/**
	 * attribut correspondant au plastron équipé
	 */
	private pieceEquipement plastron;
	
	/**
	 * attribut correspondant aux jambieres équipées
	 */
	private pieceEquipement jambieres;
	
	/**
	 * attribut correspondant aux bottes équipées
	 */
	private pieceEquipement bottes;

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
}
