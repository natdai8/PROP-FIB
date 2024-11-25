package FONTS.src.main.domain.classes;

import FONTS.src.main.domain.classes.enums.Colour;
import java.util.*;

public class CodeMaker {

    private final boolean isHuman;
    private List<Colour> combi = new Vector<Colour>(); //Combinación creada por el Codemaker

    /**
     * Constructora
     * @param humanOrPC si es humano o es PC el CodeMaker
     */
    public CodeMaker (boolean humanOrPC)
    {
        isHuman = humanOrPC;
    }

    /**
     * Getters y setters
     * @return en caso de getter, el que corresponda
     */
    public boolean isHuman()
    {
        return isHuman;
    }

    public List<Colour> getCombi()
    {
        return combi;
    }

    /**
     * Caso en el que el PC es el CodeMaker, por lo que se genera un código aleatorio según los parámetros
     * @param colours Lista de colores que se usan para construir el código
     * @param numCode Tamaño para el código generado
     * @param isDuplicated Para saber si se pueden repetir colores o no
     * @param isBlankAllowed Para saber si se pueden usar colores vacíos o no
     */
    public void machineCM (List<Colour> colours, int numCode, boolean isDuplicated, boolean isBlankAllowed)
    {
        Random r = new Random();
        int aleatory;
        if (isBlankAllowed) colours.add(Colour.VACIO); //Si se permite se añade

        if (isDuplicated)
        {
            List<Colour> codeRepe = new Vector<Colour>();
            for (int i = 0; i < numCode; i++)
            {
                aleatory = r.nextInt(colours.size()); //Número entre 0 y colours.length
                codeRepe.add(colours.get(aleatory));
            }
            combi = codeRepe;
        }
        else
        {
            Set<Colour>codeNoRepe = new LinkedHashSet<>(); //Para que no se puedan repetir
            int auxSize = 0;
            for (int i = 0; i < numCode; i++)
            {
                auxSize = codeNoRepe.size();
                aleatory = r.nextInt(colours.size()); ///Número entre 0 y colours.length
                codeNoRepe.add(colours.get(aleatory));
                if (auxSize == codeNoRepe.size()) i--; //Si se repite auxSize no sumará, por lo tanto se hará otra vez
            }
            combi = new Vector<>(codeNoRepe);
        }
    }

    /**
     * Guarda la combinación del CodeMaker humano
     * @param colours Lo que se guarda en el private del CodeMaker
     */
    public void humanCM (List<Colour> colours)
    {
        combi = colours;
    }

    /**
     * Comprobación de un intento del CodeBreaker
     * @param attempt El intento de código del CodeBreaker
     * @return Devuelve la solución ("black" y "white") al CodeBreaker
     */
    public List<Integer> askForAnswer (List<Colour> attempt)
    {
        List<Integer> solution = new Vector<Integer>();
        int black = 0;
        int white = 0;
        List<Colour> attemptClone = new Vector<>(attempt);
        List<Colour> combiClone = new Vector<>(combi);
        for (int i = 0; i < attemptClone.size(); i++) //Comprobación de las posiciones y colores
        {
            if (combiClone.get(i) == attemptClone.get(i))
            {
                attemptClone.set(i, null);
                combiClone.set(i,null);
                ++black;
            }
            else
            {
                for (int j = 0; j < attemptClone.size(); j++)
                {
                    if ((combiClone.get(i) == attemptClone.get(j)) && (j != i) &&
                            (combiClone.get(j) != attemptClone.get(j) &&
                                    !Objects.equals(attemptClone.get(j), null)))
                    {
                        attemptClone.set(j, null);
                        combiClone.set(i,null);
                        ++white;
                    }
                }
            }
        }
        solution.add(0, black); //Cantidad de colores que están en el código del Codemaker y en posiciones correctas
        solution.add(1, white); //Cantidad de colores que están en el código del Codemaker y en posiciones incorrectas
        return solution;
    }
}