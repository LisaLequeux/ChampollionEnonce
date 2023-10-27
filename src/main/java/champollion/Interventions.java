package champollion;
import java.util.*;

public class Interventions {
    private Date debut ;
    private int duree;
    private boolean annulee = false;
    private int heureDebut;
    private Enseignant enseignant ;
    private UE ue;
    private TypeIntervention typeIntervention;
    private Salle salle;


    public Interventions(Date debut, int duree, boolean annulee, int heureDebut, Enseignant enseignant, UE ue, TypeIntervention typeIntervention, Salle salle){
        this.debut=debut;
        this.duree=duree;
        this.annulee=annulee;
        this.heureDebut= heureDebut;
        this.enseignant=enseignant;
        this.ue=ue;
        this.typeIntervention=typeIntervention;
        this.salle=salle;
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

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public UE getUe() {
        return ue;
    }

    public TypeIntervention getTypeIntervention() {
        return typeIntervention;
    }

    public Salle getSalle() {
        return salle;
    }
}
