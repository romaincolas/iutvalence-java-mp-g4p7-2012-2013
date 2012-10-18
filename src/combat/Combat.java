// FIXME renommer le paquetage (fr.iutvalence.java.projets.(nom))
package combat;


// FIXME cette classe ne doit pas contenir de main et ne pas être dépendante de l'affichage : à reprendre entièrement
import javax.swing.JFrame;
/**
 * @author colasr
 * Classe principale, fait tourner le jeu
 */
public class Combat
{
	/**
	 * Cherche la position d'un acteur en fonction de son numero (numActeur !=  0 et 1)
	 * @param map 
	 * @param numActeur
	 * @return les coordonees de depart de l'acteur sur la carte de base
	 */
	public static Coordonees CherchePositionActeur(byte[][] map, byte numActeur)
	{
		int x,y;
		for (x=0; x<map.length;x++) {
		    for(y=0; y<map[x].length; y++) {
			if (map[x][y]==numActeur){
			    return new Coordonees(x,y);
			    }
			}	    
		}
		return new Coordonees(0,0);
	}
	

	/* 0 pour un emplacement libre , 1 pour un obstacle, 2 pour  l'emplcement 
	 du joueur, 3+ pour le(s) monstre(s)*/


    
	/**
	 * Fait tourner le jeu
	 * @param args 
	 */
	public static void main(String[] args)
	{
		byte[][] map={
				 {1,1,1,1,1,1},
				 {1,0,0,0,0,1},
				 {1,0,3,0,0,1},
				 {1,0,1,1,0,1},
				 {1,0,0,0,0,1},
				 {1,0,0,0,2,1},
				 {1,1,1,1,1,1}
		 };
		
		String nom = "bobo";
		byte profession = 1; //1 pour avoir la profession Gladiateur
		
		Competences[] comp={new Competences("Attaque", 1, 1, 5, 0, (byte)1)};
		
		Acteur persoEnCombat = new PersonnageEnCombat(nom, new Stats(profession), CherchePositionActeur(map, (byte)2), profession, comp);
				
		JFrame fenetre = new JFrame();
		
		fenetre.setTitle("Combat");
		fenetre.setSize(map[1].length*120, map.length*90);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		

	}
}

