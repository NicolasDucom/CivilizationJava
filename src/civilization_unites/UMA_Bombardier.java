package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UMA_Bombardier extends UniteMilitaireAerien
{    
    public UMA_Bombardier(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Bombardier", 6, 0, 8, 0, 10, 12, 10, 10, 2, 8, caseParent, batimentParent, 20);
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Déplacer", Unite.class.getDeclaredMethod("setMovableTiles"));
            actions.put("Attaquer", UniteMilitaire.class.getDeclaredMethod("preAttaque"));
            actions.put("En garnison", Unite.class.getDeclaredMethod("preHeberger"));
            actions.put("Réparer", Unite.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Unite.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UMA_Bombardier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Map<String, Method> getActions() 
    {
        return actions;
    }

    @Override
    public Map<String, Constructor> getConstructions() 
    {
        return null;
    }
    
    @Override
    public boolean hebergerUnite(Unite unite) 
    {
        if (this.joueur.equals(unite.joueur)) {
            switch (unite.getClass().getSimpleName()) {
                case "UCT_Ouvrier" :
                case "UCT_Paysan" :
                case "UMT_Artillerie" :
                case "UMT_LanceGrenade" :
                case "UMT_Sentinelle" :
                case "UMT_Soldat" :
                case "UMT_Tank" :
                    this.unitesHebergees.add(unite);
                    unite.caseParent = null;
                    unite.batimentParent = null;
                    unite.changerStatut("hebergee");
                    return true;
                default :
                    return false;
            }
        } else {
            return false;
        }
    }
}