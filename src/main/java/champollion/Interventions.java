package champollion;
import java.util.*;

public class Interventions {
    private Date debut ;
    private int duree;
    private boolean annulee = false;
    private int heureDebut;


    public Interventions(Date debut, int duree, boolean annulee, int heureDebut){
        this.debut=debut;
        this.duree=duree;
        this.annulee=annulee;
        this.heureDebut= heureDebut;
    }


// Les méthodes d'accès
    public Date getDebut(){
        return debut;
    }

    public int getDuree(){
        return duree;
    }

    public boolean getAnnulee(){
        return annulee;
    }

    public int getHeureDebut(){
        return heureDebut;
    }
}
