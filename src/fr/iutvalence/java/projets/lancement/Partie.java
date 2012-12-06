package fr.iutvalence.java.projets.lancement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutvalence.java.projets.combat.Carte;
import fr.iutvalence.java.projets.combat.Competences;
import fr.iutvalence.java.projets.combat.GestionCombat;
import fr.iutvalence.java.projets.combat.Monstre;
import fr.iutvalence.java.projets.combat.PersonnageEnCombat;
import fr.iutvalence.java.projets.combat.Stats;

/**
 * @author Florian/Romain
 */
public class Partie
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		InterfaceMenu fenetre;
		ChoixMenu choixMenu;
		int menuAffiche = 1; //menu affiche(1:Affiche menu de base , 2:affiche choix map, 3:affiche choix profession)
		int carteAffiche = 1;
		
		PersonnageEnCombat joueur;
		GestionCombat combat;
		
		String nom;
		Monstre[] touche;
		
		// La premiere competences de la liste de competences à un nombre d'utilisation infinie )
		Competences[] compPerso={new Competences("Frappe", 1, 1, 5, 0, 1),new Competences("Coup puissant", 1, 2, 15, 0, 5),new Competences("Lance epee", 2, 5, 15, 0, 5)};
		
		int[][] map={
				 {1,1,1,1,1,1,1,1,1},
				 {1,0,5,0,4,0,3,0,1},
				 {1,0,0,0,0,0,0,1,1},
				 {1,1,1,0,0,1,1,1,1},
				 {1,1,1,1,0,0,1,1,1},
				 {1,1,1,0,0,0,0,1,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,1,0,0,0,0,0,0,1},
				 {1,1,1,0,1,0,0,0,1},
				 {1,0,0,0,1,0,0,0,1},
				 {1,0,2,0,1,0,0,0,1},
				 {1,0,0,0,1,1,0,0,1},
				 {1,1,1,1,1,1,1,1,1}
		 };
		Carte carte1 = new Carte(map);
		map= new int[][]{
				 {1,1,1,1,1,1,1,1,1},
				 {1,0,5,0,4,0,3,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,1,1,1,0,0,0,0,1},
				 {1,1,0,0,0,0,0,0,1},
				 {1,0,0,0,1,1,1,1,1},
				 {1,0,0,0,1,1,1,1,1},
				 {1,1,0,0,0,0,0,1,1},
				 {1,1,1,0,0,0,6,0,1},
				 {1,1,0,0,0,0,0,0,1},
				 {1,0,0,0,0,0,0,1,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,0,0,0,2,0,0,0,1},
				 {1,1,1,1,1,1,1,1,1}
		 };
		Carte carte2 = new Carte(map);
		
		choixMenu = new ChoixMenu();
		fenetre = new InterfaceMenu(carte1,choixMenu);
		
		nom = "Player";
		
		Competences compMonstreTypeBase=new Competences("Frappe", 1, 1, 5, 0, 5);
		Competences compMonstreTypeArche=new Competences("Tir une fleche", 3, 1, 2, 0, 5);
		Competences compMonstreTypeMage=new Competences("Boule de feu", 5, 1, 0, 0, 5);
		
		
		
		Monstre[] monstresMap1 = {new Monstre("Blop",new Stats(1), carte1.CherchePositionActeur(3),compMonstreTypeBase,3),
						 new Monstre("Blip",new Stats(1), carte1.CherchePositionActeur(4),compMonstreTypeBase,4),
						 new Monstre("Blap",new Stats(1), carte1.CherchePositionActeur(5),compMonstreTypeBase,5)
						  };
		
		Monstre[] monstresMap2 = {new Monstre("Fligbluk",new Stats(1), carte2.CherchePositionActeur(3),compMonstreTypeBase,3),
				 new Monstre("Draugr",new Stats(2), carte2.CherchePositionActeur(4),compMonstreTypeArche,4),
				 new Monstre("Moufle",new Stats(1), carte2.CherchePositionActeur(5),compMonstreTypeBase,5),
				 new Monstre("Flarouge",new Stats(3), carte2.CherchePositionActeur(5),compMonstreTypeMage,6)
				  };
		
		while(choixMenu.getChoixMap() == 0 || choixMenu.getChoixProfession() == 0)
		{
			if(choixMenu.getChoixMenu() != menuAffiche)
			{
				switch(choixMenu.getChoixMenu())
				{
					case 1:
						fenetre.afficheActionBase();
						break;
					case 2:
						fenetre.afficheActionChoixMap();
						break;
					case 3:
						fenetre.afficheActionChoixProfession();
						break;
					default:
						fenetre.afficheActionBase();			
				}
				fenetre.actualiseFenetre();
				menuAffiche = choixMenu.getChoixMenu();
			}
			
			if(choixMenu.getChoixMapAAfficher() != carteAffiche)
			{
				switch(choixMenu.getChoixMapAAfficher())
				{
					case 1:
						fenetre.actualiseArene(carte1);
						break;
					case 2:
						fenetre.actualiseArene(carte2);
						break;
					default:
						fenetre.actualiseArene(carte1);	
				}
				fenetre.actualiseFenetre();
				carteAffiche = choixMenu.getChoixMapAAfficher();
			}	
		}
		
		switch(choixMenu.getChoixMapAAfficher())
		{
			case 1:
				joueur = new PersonnageEnCombat(nom,new Stats(choixMenu.getChoixProfession()), carte1.CherchePositionActeur(2), choixMenu.getChoixProfession(), compPerso);
				combat = new GestionCombat(carte1, joueur, monstresMap1);
				break;
			case 2:
				joueur = new PersonnageEnCombat(nom,new Stats(choixMenu.getChoixProfession()), carte2.CherchePositionActeur(2), choixMenu.getChoixProfession(), compPerso);
				combat = new GestionCombat(carte2, joueur, monstresMap2);
				break;
			default:
				joueur = new PersonnageEnCombat(nom,new Stats(choixMenu.getChoixProfession()), carte1.CherchePositionActeur(2), choixMenu.getChoixProfession(), compPerso);
				combat = new GestionCombat(carte1, joueur, monstresMap1);
		}
		
		combat.lancement();

	}
	
}
