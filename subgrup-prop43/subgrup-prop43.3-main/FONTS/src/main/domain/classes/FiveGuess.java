package FONTS.src.main.domain.classes;

import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Clase FiveGuess es la clase que ejecuta el algoritmo FiveGuess para adivinar el codigo secreto del Codemaker.
 */
public class FiveGuess implements Maquina {
    HashSet<Integer> posiblescodigos = new HashSet<>();
    int MaxSteps;
    int currentStep = 1;
    Boolean win = false;
    Boolean isDuplicated;
    Boolean isBlankAllowed;

    /**
     * Constructora de la clase
     * @param MaxSteps Número de intentos del Codebreaker para adivinar el código
     * @param isDuplicated Boolean que indica si puede haber repeticiones en el código
     * @param isBlankAllowed Boolean que indica si puede haber espacios en blanco en el código
     * @param extraColors Número de colores extra que quiere usar el usuario
     */
    public FiveGuess(int MaxSteps, boolean isDuplicated, boolean isBlankAllowed, int extraColors) {
        this.MaxSteps = MaxSteps;
        this.isBlankAllowed = isBlankAllowed;
        this.isDuplicated = isDuplicated;

        int colours_number = 6+extraColors;

        if (isBlankAllowed) ++colours_number;

        if (isDuplicated)
            allCombinationsWithRepetitions(colours_number);
        else
            allCombinationsWithoutRepetitions(colours_number);
    }

    /**
     * Función que genera todas las posibles combinaciones dados MaxColours colores, sin repeticiones en un código
     * @param MaxColours Número de colores que se pueden usar
     */
    public void allCombinationsWithRepetitions(int MaxColours) {
        for (int i = 0; i < MaxColours; ++i) {
            for (int j = 0; j < MaxColours; ++j) {
                for (int k = 0; k < MaxColours; ++k) {
                    for (int l = 0; l < MaxColours; ++l) {
                        int number = (i * 1000) + (j * 100) + (k * 10) + l;
                        posiblescodigos.add(number);

                    }
                }
            }
        }
    }

    /**
     * Función que genera todas las posibles combinaciones dados MaxColours colores, usando repeticiones en un código
     * @param NumerColors Número de colores que se pueden usar
     */
    public void allCombinationsWithoutRepetitions(int NumerColors) {
        for (int i = 0; i < NumerColors; ++i) {
            for (int j = 0; j < NumerColors; ++j) {
                if (i != j) {
                    for (int k = 0; k < NumerColors; ++k) {
                        if (k != j && k != i) {
                            for (int l = 0; l < NumerColors; ++l) {
                                if (l != k && l != j && l != i) {
                                    int number = (i * 1000) + (j * 100) + (k * 10) + l;
                                    posiblescodigos.add(number);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Genera una List<List<Integer>> que es una lista con las combinaciones necesarias para acertar el código del Codemaker.
     * @param solution solucion del codigo
     * @return lista combinaciones
     */
    public List<List<Integer>> solve(List<Integer> solution) {
        int[] inte;
        if (isDuplicated)
            inte = new int[]{1, 1, 2, 2};
        else
            inte = new int[]{1, 2, 3, 4};

        List<List<Integer>> intentos = new ArrayList<>();

        while (!win && currentStep <= MaxSteps) {
            List<Integer> intento = new ArrayList<>();

            for (int i : inte) intento.add(i);
            intentos.add(intento);

            int[] solutionArray = new int[solution.size()];
            for (int i = 0; i < solution.size(); i++)
                solutionArray[i] = solution.get(i);

            int[] res = response(inte, solutionArray);

            if (res[0] == 4)
                win = true;
            else {
                eliminarposibles(posiblescodigos, inte, res);
                inte = getNextGuess(posiblescodigos, inte, res);
            }
            ++currentStep;
        }

        return intentos;
    }

    /**
     * Genera una respuesta al intento como haría el Codemaker.
     * @param trie intento
     * @param code codigo
     * @return retorna la respuesta del genetic como CM
     */
    public int[] response(int[] trie, int[] code) {
        int[] solution = new int[2];
        int black = 0;
        int white = 0;
        int[] trie2 = trie.clone();
        int[] code2 = code.clone();

        for (int i = 0; i < 4; ++i) {
            if (code2[i] == trie2[i]) {
                ++black;
                trie2[i] = -1;
                code2[i] = -1;
            } else {
                for (int j = 0; j < 4; ++j) {
                    if (code2[i] == trie2[j] && j != i && trie2[j] != code2[j] && trie2[j] >= 0) {
                        trie2[j] = -1;
                        code2[i] = -1;
                        ++white;
                    }
                }
            }
        }

        solution[0] = black;
        solution[1] = white;

        return solution;
    }

    /**
     * Elimina los códigos del Set S que ya no pueden ser la solución
     * @param S Set del cual elimina códigos invalidos
     * @param intento Intento del Codebreaker
     * @param res Respuesta del Codemaker al intento del Codebreaker
     */
    public void eliminarposibles(HashSet<Integer> S, int[] intento, int[] res) {
        List<Integer> eliminados = new ArrayList<>();
        for (int c : S) {
            int[] Svec = new int[]{(c / 1000), (c / 100) % 10, (c / 10) % 10, c % 10};
            int[] resnew = response(intento, Svec);

            if (resnew[0] != res[0] || resnew[1] != res[1])
                eliminados.add(c);
        }

        for (int e : eliminados) {
            S.remove(e);
        }
    }

    /**
     * Función que devuelve el codigo más apto para ser el siguiente
     * @param allCodes Set con todas las posibles combinaciones
     * @param previousGuess Intento previo del Codebreaker
     * @param previousResponse Respuesta previa del codemaker al intento del Codebreaker
     * @return El siguiente codigo a usar
     */
    public int[] getNextGuess(Set<Integer> allCodes, int[] previousGuess, int[] previousResponse) {
        int[] nextGuess = new int[4];
        int minMaxScore = Integer.MAX_VALUE;

        for (int code : allCodes) {
            int currentScore = 0;
            int[] cArray = new int[]{(code / 1000), (code / 100) % 10, (code / 10) % 10, code % 10};
            for (String response : possibleResponses()) {
                String[] responseSplit = response.split("-");
                int[] responseArray = new int[]{parseInt(responseSplit[0]), parseInt(responseSplit[1])};
                Set<Integer> possibleSolutions = new HashSet<>(allCodes);
                possibleSolutions.retainAll(possibleSolutions(allCodes, previousGuess, responseArray, previousResponse, cArray));
                currentScore = Math.max(currentScore, possibleSolutions.size());
            }

            if (currentScore < minMaxScore) {
                minMaxScore = currentScore;
                nextGuess = cArray;
            }
        }
        return nextGuess;
    }

    /**
     * Funcion que devuelva las posibles respuestas que puede recibir un codigo, 4 pegs blancas, 2 blancas 1 negras...
     * @return LIsta de todas las posibles respuestas que puede recibir un codigo
     */
    public List<String> possibleResponses() {
        List<String> responses = new Vector<>();
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4 - i; ++j) {
                responses.add(i + "-" + j);
            }
        }
        return responses;
    }

    /**
     * Funcion que devuelve un Set de cuáles pueden ser los codigos válidos
     * @param allCodes Set con todas las posibles combinaciones
     * @param guess Intento del Codebreaker
     * @param response Respuesta del codemaker al intento del Codebreaker
     * @param previousResponse  Respuesta del codemaker al intento del Codebreaker
     * @param code Codigo del Codebreaker
     * @return Set de cuáles pueden ser los codigos válidos
     */
    public Set<Integer> possibleSolutions(Set<Integer> allCodes, int[] guess, int[] response, int[] previousResponse, int[] code) {
        Set<Integer> possibleSolutions = new HashSet<>();
        for (int c : allCodes) {
            int[] cArray = new int[]{(c / 1000), (c / 100) % 10, (c / 10) % 10, c % 10};
            if (Arrays.equals(response(cArray, guess), response) || Arrays.equals(response(cArray, code), previousResponse)) {
                possibleSolutions.add(c);
            }
        }
        return possibleSolutions;
    }
}
