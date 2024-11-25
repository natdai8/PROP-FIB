package FONTS.src.main.domain.classes;
import java.util.ArrayList;
import java.util.*;

/**
 * Clase Ranking sirve para guardar la información de todas las puntuaciones de las partidas,
 * devolver el ranking global y devolver el record personal de un jugador determinado
 */

public class Ranking {
    private  List<Record> records;

    /**
     * Constructora de la clase Ranking
     */
    public Ranking (){
        this.records = new Vector<Record>();
    }

    /**
     * @return Inidica si el ranking se ha cargado de persistencia
     */
    public boolean IsRankingCharged(){
        return !records.isEmpty();
    }

    /**
     *  Funcion para añadir un record a la lista de records de todos las partidas jugadas
     * @param username nombre del usuario
     * @param puntuacion puntuacion del usuario
     */
    public void AddRecord(String username, int puntuacion){
        Record record = new Record(username,puntuacion);
        this.records.add(record);
    }

    /**
     * Devuelve los 5 mejores records personales de un jugador determinado
     * @param user nombre del juagdor
     * @return 5 mejores records del user
     */
    public ArrayList<Record> getRecords(String user){
        ArrayList<Record> PersonalRecord = new ArrayList<>();
        records.sort(Collections.reverseOrder());

        for (Record record : records) {
            if (Objects.equals(record.getRecordName(), user)) {
                PersonalRecord.add(record);
                if (PersonalRecord.size() == 5) return PersonalRecord;
            }
        }
        return PersonalRecord;
    }

    /**
     * Devuelve el ranking global de las 5 mejores puntuaciones
     * @return 5 mejores records globales
     */
    public ArrayList<Record> getRanking(){
        ArrayList<Record> GlobalRanking = new ArrayList<>();
        records.sort(Collections.reverseOrder());
            for(int i = 0; i < 5 && i < records.size(); i++){
                GlobalRanking.add(records.get(i));
            }
        return GlobalRanking;
    }


}
