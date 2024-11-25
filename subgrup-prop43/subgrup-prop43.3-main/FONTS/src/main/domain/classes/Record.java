package FONTS.src.main.domain.classes;

/**
 * Clase Record sirve para crear un record con un usuario y puntuacion determinadas y para
 * obtener la informacion de un record y para comparar records segun su puntuacion
 */
public class Record implements Comparable<Record>{
    private final String username;
    private final int puntuacion;

    /**
     * Funcion creadora de record
     * @param username nombre del usuario de record
     * @param puntuacion puntuacion del record
     */
    public Record(String username, int puntuacion) {
        this.username = username;
        this.puntuacion = puntuacion;
    }

    /**
     * @return Devuelve el nombre de ususario de un record
     */
    public String getRecordName() {
        return username;
    }

    /**
     * @return Devuelve la puntuacion de un record
     */
    public int getPoints() {
        return puntuacion;
    }

    /**
     * @param r the object to be compared.
     * @return  Comparar la puntuacion de un record con otro
     */
    @Override
    public int compareTo(Record r){
        return this.puntuacion - r.getPoints();
    }

}
