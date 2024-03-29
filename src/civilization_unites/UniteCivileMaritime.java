package civilization_unites;
import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import java.util.List;

public abstract class UniteCivileMaritime extends UniteCivile
{
    boolean peutNaviguer = true;
    
    public UniteCivileMaritime(
            Joueur joueur, 
            String nom, 
            int or, int bois, int fer, int nourriture, int tpsConstruction, int defense,
            int dist,
            Case caseParent, Batiment batimentParent,
            int ptVie,
            int prodOr, int prodBois, int prodFer, int prodNourr
    ) {
        super(joueur, nom, or, bois, fer, nourriture, tpsConstruction, defense, dist, caseParent, batimentParent, ptVie, prodOr, prodBois, prodFer, prodNourr);
    }
    
    @Override
    public List<String> movableTypes()
    {
       List<String> types = new ArrayList<>();
       types.add("Eau");
       return types;
    }
}

