/**
 * @author colasr
 * Classe principale, fait tourner le jeu
 */
public class Combat
{
	public static Coordonees InitPositionJoueur(byte[][] map) {
		int x,y;
		for (x=0; x<map.length;x++) {
		    for(y=0; y<map[x].length; y++) {
			if (map[x][y]==2){
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
				 {1,0,0,0,0,1},
				 {1,0,1,1,0,1},
				 {1,0,0,0,0,1},
				 {1,0,0,0,2,1},
				 {1,1,1,1,1,1}
		 };
		
		String nom = "bobo";
		byte profession = 1; //1 pour avoir la profession Gladiateur
		
		Competences[] comp={new Competences("Attaque", 1, 1, 0, 0, 1)};
		
		PersonnageEnCombat persoEnCombat = new PersonnageEnCombat(nom, profession, InitPositionJoueur(map),comp);

		

	}
}

/**
 * retourne la position du perso dans un objet Coordonees (cherche 2) 
 *@param map (tableau  double)
 */	

