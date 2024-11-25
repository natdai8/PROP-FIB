package FONTS.src.main.domain.classes;

import java.util.List;

/**
 * Iterface para aplicar los distintos algoritmos según cual se use (Startegy)
 */
public interface Maquina{
    /**
     *
      * @param solution
     * @return Dado el parametro inicial 'solution', la funcion usa uno de los dos algortimos (genetic o fiveguess) para crear
     * la lista de intentos que hace para llegar a 'solution' si es que consigue llegar en menos que el maximo numero de intentos (maxSteps)
     */
    public List<List<Integer>>  solve (List<Integer> solution) throws Exception;
}

