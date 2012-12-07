package fr.iutvalence.java.projets.lancement;

import javax.swing.*;

import fr.iutvalence.java.projets.combat.Carte;

import java.awt.*;

/**
 * @author Florian
 * Interface dedié à l'affichage du menu du jeu
 */
public class InterfaceMenu
{
	/**
	 * Taille en largeur de la fenetre
	 */
	private final static int FENETRE_LARGEUR = 700;
	
	/**
	 * Taille en Hauteur de la fenetre
	 */
	private final static int FENETRE_HAUTEUR = 700;
	
	/**
	 * La fenetre d un combat avec l arene et les informations
	 */
	private JFrame fenetre;
	
	//*********FENETRE DE L'ARENE ************//
	/**
	 * Grille de la carte 
	 */
	private JPanel arene;
	
	/**
	 * Zone des bouton
	 */
	private JPanel action;
	
	/**
	 * Liste de toute les cases de l'arene
	 */
	private JButton[] cases;
	
	
	//***********BOUTON****************//
	/**
	 * bouton qui permet de quitter le jeu
	 */
	private JButton boutonQuitter;
	
	
	/**
	 * bouton qui affiche le menu de base de l'interface
	 */
	private JButton boutonRetour;
	
	/**
	 * objet sur qui les boutons travaillent
	 */
	private ChoixMenu choixMenu;


	/**
	 * Cree une interface dedié au menu du jeu
	 * @param carte (carte a affiché)
	 * @param choixMenu (liste des choix que le joueur doit faire dans le menu)
	 */
	public InterfaceMenu(Carte carte, ChoixMenu choixMenu)
	{
		super();
		//******INIT VARIABLE*****//
		int x, y, largeurCarte, hauteurCarte, nbCase;
		nbCase = 0;
		largeurCarte = carte.GetDimension().getX();
		hauteurCarte = carte.GetDimension().getY();
		this.choixMenu = choixMenu;
		
		//*********DEFINIR FENETRE*****//
		this.cases = new JButton[largeurCarte*hauteurCarte];
		this.fenetre = new JFrame();
		this.fenetre.setTitle("Menu");
		this.fenetre.setSize(FENETRE_LARGEUR, FENETRE_HAUTEUR);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//*********************DEFINIR LES BOUTONS*********************//
		JButton boutonRetour = new JButton("Retour");
		boutonRetour.addActionListener(this.choixMenu);
		
		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.addActionListener(this.choixMenu);
		
		this.boutonQuitter = boutonQuitter;
		this.boutonRetour = boutonRetour;
		
		//**********************CREE LA CARTE*********************///
		this.arene = new JPanel(new GridLayout(largeurCarte,hauteurCarte));
		this.action = new JPanel(new GridLayout(0,2));
		
		for (y = 0; y < largeurCarte; y++)
		{
			for (x = hauteurCarte-1; x >= 0; x--)
			{ 
				switch (carte.getCarte()[x][y])
				{
					case 0:
						this.cases[nbCase] = new JButton(new ImageIcon("img/herbe.gif"));
						this.arene.add(this.cases[nbCase]);// Vide;
						break;
						
					case 1:
						
						this.cases[nbCase] = new JButton(new ImageIcon("img/trou.gif"));
						this.arene.add(this.cases[nbCase]);// Trou
						break;
						
					case 2:
						this.cases[nbCase] = new JButton(new ImageIcon("img/aventurier.gif"));
						this.arene.add(this.cases[nbCase]); //Le Joueur
						break;
					case -1:
						this.cases[nbCase] = new JButton(); 
						this.arene.add(this.cases[nbCase]); //Affiche "F" pour une erreur
						
					default:
						this.cases[nbCase] = new JButton(new ImageIcon("img/monstre.gif"));
						this.arene.add(this.cases[nbCase]); // Ennemie
				}
				nbCase+=1;
			}
		}		

		
		//***********CREE LES INFORMATIONS ET LES ACTIONS EN BAS DE FENETRE************//
		afficheActionBase();
		
		//*******AJOUTE LES 2 JPANEL A LA FENETRE***********//
	    Container conteneurFrame = this.fenetre.getContentPane();
	    GridLayout disposition = new GridLayout(0, 1);
	    conteneurFrame.setLayout(disposition);
	    conteneurFrame.add(this.arene);
	    conteneurFrame.add(this.action);

	    this.fenetre.setVisible(true);
	}
	



	/**
	 * affiche les nouveaux element de l'interface
	 */
	public void actualiseFenetre()
	{
	    Container conteneurFrame = new Container();
	    GridLayout disposition = new GridLayout(0, 1);
	    conteneurFrame.setLayout(disposition);
	    conteneurFrame.add(this.arene);
	    conteneurFrame.add(this.action);

	    this.fenetre.setContentPane(conteneurFrame);
	    this.fenetre.setVisible(true);
	}
	
	/**
	 * Affiche les actions du menu
	 */
	public void afficheActionBase()
	{
		this.action = new JPanel(new GridLayout(0,2));
		
		JButton boutonMap = new JButton("Choix de la Map");
		boutonMap.addActionListener(this.choixMenu);
		JButton boutonProfession = new JButton("Choix de la profession");
		boutonProfession.addActionListener(this.choixMenu);
		
		this.action.add(boutonMap);
		this.action.add(boutonProfession);
		this.action.add(this.boutonQuitter);
	}
	
	/**
	 * Affiche les actions de choix de la profession
	 */
	public void afficheActionChoixProfession()
	{
		this.action = new JPanel(new GridLayout(0,2));
		
		JButton boutonTemplier = new JButton("Templier");
		boutonTemplier.addActionListener(this.choixMenu);
		JButton boutonGladiateur = new JButton("Gladiateur");
		boutonGladiateur.addActionListener(this.choixMenu);
		JButton boutonRodeur = new JButton("Rodeur");
		boutonRodeur.addActionListener(this.choixMenu);
		JButton boutonSorcier = new JButton("Sorcier");
		boutonSorcier.addActionListener(this.choixMenu);
		
		this.action.add(boutonTemplier);
		this.action.add(boutonGladiateur);
		this.action.add(boutonRodeur);
		this.action.add(boutonSorcier);
		this.action.add(this.boutonRetour);
	}	
	
	/**
	 * Affiche le choix des deux maps
	 */
	public void afficheActionChoixMap()
	{
		this.action = new JPanel(new GridLayout(0,2));
		
		JButton boutonChoixMap1 = new JButton("Map 1");
		boutonChoixMap1.addActionListener(this.choixMenu);
		JButton boutonChoixMap2 = new JButton("Map 2");
		boutonChoixMap2.addActionListener(this.choixMenu);
		
		JButton boutonVoirMap1 = new JButton("Voir Map 1");
		boutonVoirMap1.addActionListener(this.choixMenu);
		JButton boutonVoirMap2 = new JButton("Voir Map 2");
		boutonVoirMap2.addActionListener(this.choixMenu);
		
		this.action.add(boutonChoixMap1);
		this.action.add(boutonChoixMap2);
		this.action.add(boutonVoirMap1);
		this.action.add(boutonVoirMap2);
		this.action.add(this.boutonRetour);
	}
	
	
	/**
	 * affiche une carte sur le haut de l'interface
	 * @param carte (carte a afficher)
	 */
	public void actualiseArene(Carte carte)
	{
		int x, y, largeurCarte, hauteurCarte, nbCase;
		largeurCarte = carte.GetDimension().getX();
		hauteurCarte = carte.GetDimension().getY();
		nbCase = 0;
		
		JPanel areneTemp = new JPanel(new GridLayout(largeurCarte,hauteurCarte));
		
		for (y = 0; y < largeurCarte; y++)
		{
			for (x = hauteurCarte-1; x >= 0; x--)
			{ 
				switch (carte.getCarte()[x][y])
				{
					case 0:
						this.cases[nbCase] = new JButton(new ImageIcon("img/herbe.gif"));
						areneTemp.add(this.cases[nbCase]);// Vide;
						break;
						
					case 1:
						this.cases[nbCase] = new JButton(new ImageIcon("img/trou.gif"));
						areneTemp.add(this.cases[nbCase]);// Trou
						break;
						
					case 2:
						this.cases[nbCase] = new JButton(new ImageIcon("img/aventurier.gif")); 
						areneTemp.add(this.cases[nbCase]); //Le Joueur
						break;						
					default:
							this.cases[nbCase] = new JButton(new ImageIcon("img/monstre.gif"));
							areneTemp.add(this.cases[nbCase]); // Ennemie
				}
				nbCase+=1;
			}
		}
		this.arene = areneTemp;
		this.arene.repaint();
	}
	
	/**
	 * cacher la fenetre
	 */
	public void fermerFenetre()
	{
		this.fenetre.setVisible(false);
	}
	
}
