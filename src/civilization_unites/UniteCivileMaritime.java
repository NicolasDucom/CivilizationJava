package civilization_unites;

import civilization_joueurs.Joueur;

public abstract class UniteCivileMaritime extends UniteCivile
{
    boolean peutNaviguer = true;
    
    public UniteCivileMaritime(Joueur joueur)
    {
        super(joueur);
    }
}