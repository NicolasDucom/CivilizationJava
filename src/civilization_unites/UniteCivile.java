package civilization_unites;

import civilization_joueurs.Joueur;


public abstract class UniteCivile extends Unite
{
    boolean peutConstruire;
    boolean peutObtenirNourriture;
    boolean peutObtenirFer;
    boolean peutObtenirBois;
    boolean peutObtenirOr = false;
    boolean peutTransporter;
    
    int produitNourriture;
    int produitBois;
    int produitFer;
    int produitOr;
    
    public UniteCivile(Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense, 
            int dist) 
    {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, dist);
        this.peutObtenirNourriture = false;
        this.peutObtenirFer = false;
        this.peutObtenirBois = false;
        this.peutTransporter = false;
        this.peutConstruire = false;
    }
    
    @Override public String toString()
    {
        return this.nom + " (" + this.getClass().getSimpleName() + " >> " + this.getClass().getSuperclass().getSimpleName() + ")\n" + super.toString();
    }
}
