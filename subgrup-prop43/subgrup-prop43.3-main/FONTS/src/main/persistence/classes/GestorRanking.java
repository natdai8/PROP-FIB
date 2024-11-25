package FONTS.src.main.persistence.classes;

import java.io.*;
import java.util.*;

public class GestorRanking
{
    File ranking = new File("FONTS/src/main/persistence/classes/data/ranking.txt");
    private BufferedReader reader;
    private BufferedWriter writer;
    String currentLine, username, pointsString;
    int points;

    /**
     * Constructora
     */
    public GestorRanking() {

    }

    /**
     * Para guardar los récords en el fichero ranking.txt
     * @param name Nombre de usuario que quiere guardar los puntos
     * @param pointsUser La puntuación en cuestión
     */
    public void savePoints (String name, int pointsUser) {

        boolean repe = false;

        try
        {
            reader = new BufferedReader(new FileReader(ranking));
            writer = new BufferedWriter(new FileWriter(ranking, true));
            while((currentLine = reader.readLine()) != null && (!repe))
            {
                String[] user = currentLine.split(" "); //Todo antes de la coma es nombre, todo después es points
                username = user[0];
                points = Integer.parseInt(user[1]);
                if (Objects.equals(username, name) && (points == pointsUser)) repe = true;
            }
            if (!repe) { //Si no existe tal puntuación se añade, en caso contrario guardamos información duplicada
                writer.write(name + " " + pointsUser + "\n");
                writer.close();
            }
        }
        catch (IOException eWriter)
        {
            System.out.println("Algo ha ido mal...");
            eWriter.printStackTrace();
        }
    }

    /**
     * Para guardar los récords de los usuarios en memoria
     * @return Devuelve una estructura de datos que contiene información de los récords de los usuarios del juego
     */
    public ArrayList<String> getRankingPersistencia ()
    {
        ArrayList<String> userPoints = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(ranking));
            while((currentLine = reader.readLine()) != null)
            {
                String[] user = currentLine.split(" "); //Todo antes de la coma es nombre, todo después es points
                username = user[0];
                pointsString = user[1];
                userPoints.add(username);
                userPoints.add(pointsString);
            }
        }
        catch (IOException e)
        {
            System.out.println("Algo ha ido mal...");
            e.printStackTrace();
        }
        return userPoints;
    }
}
