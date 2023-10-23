package champollion;

import java.util.HashMap;
import java.util.Map;

public class Enseignant extends Personne {


    private float equivalentTD(TypeIntervention type, int volumeHoraire){
        float result = 0f;
        switch (type) {
            case CM:
                result = volumeHoraire * 1.5f;
                break;
            case TD:
                result = volumeHoraire;
                break;
            case TP:
                result = volumeHoraire * 0.75f;
                break;
        }
        return result ;
    }

    private Map<UE, ServicePrevu> lesEnseignements = new HashMap<>();
    public Enseignant(String nom, String email) {
        super(nom, email);
    }
    public static final int  HEURE_PREVUES_MINIMUM = 192;
    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        Double somme = 0.0;
        for(UE key:lesEnseignements.keySet()){
            somme = somme +
                    lesEnseignements.get(key).getVolumeCM()*1.5 +
                    lesEnseignements.get(key).getVolumeTD() +
                    lesEnseignements.get(key).getVolumeTP()*0.75;
        }
        return somme.intValue();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        Double sommeUE = 0.0;
        sommeUE = sommeUE +
                lesEnseignements.get(ue).getVolumeCM()*1.5 +
                lesEnseignements.get(ue).getVolumeTD()+
                lesEnseignements.get(ue).getVolumeTP()*0.75 ;
        return sommeUE.intValue() ;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        if(lesEnseignements.containsKey(ue)){
            ServicePrevu sp = lesEnseignements.get(ue) ;
            sp.addVolumeCM(volumeCM);
            sp.addVolumeTD(volumeTD);
            sp.addVolumeTP(volumeTP);
            return ;
        }
        this.lesEnseignements.put(ue, new ServicePrevu( volumeCM, volumeTD, volumeTP));
        return ;
    }

    public boolean enSousService(){
        return this.heuresPrevues() < HEURE_PREVUES_MINIMUM;
    }


}
