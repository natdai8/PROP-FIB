package FONTS.src.main.domain.classes;

import java.util.*;

public class Genetic implements Maquina {
    static List<int[]> posiblescodigos = new ArrayList<>();
    static List<int[]> population = new ArrayList<>();
    List<List<Integer>> respuestasCB;
    List<int[]> responsesCM;
    static List<List<int[]>> guesses = new ArrayList<>();
    static int MAX_POP_SIZE = 60;
    static int MAX_GENERATIONS = 100;
    int maxSteps;
    static double CROSSOVER_PROBABILITY = 0.5;
    static double MUTATION_PROBABILITY = 0.03;
    static double PERMUTATION_PROBABILITY = 0.03;
    int currentStep, currentGen;
    Boolean isDuplicated;
    Boolean isBlankAllowed;
    static int numColors;
    int[] intento;
    static Random randomGenerator = new Random();

    /**
     * Creadora
     * @param maxSteps Maximo de pasos que puede hacer el algoritmo para intentar encontrar el resultado correcto.
     * @param isDuplicated indica si se permiten duplicados
     * @param isBlankAllowed inidica si se permiten espacios en blanco
     * @param extraColors indica si hay colores extras
     */
    public Genetic(int maxSteps, boolean isDuplicated, boolean isBlankAllowed, int extraColors) {
        population = new ArrayList<>();
        respuestasCB = new ArrayList<>();
        guesses = new ArrayList<>();
        posiblescodigos = new ArrayList<>();
        responsesCM = new ArrayList<>();
        this.maxSteps = maxSteps;
        this.isBlankAllowed = isBlankAllowed;
        this.isDuplicated = isDuplicated;
        numColors = 6 + extraColors;
        currentStep = 1;
        currentGen = 1;

        if (isBlankAllowed) ++numColors;

        if (isDuplicated) allCombinationsWithRepetitions(numColors);
        else allCombinationsWithoutRepetitions(numColors);
    }

    /**
     * Metodo que genera un Set de colores con todas las posibles combinaciones aceptando repeticiones
     * @param maxColours maximo de colores a usar
     */
    public void allCombinationsWithRepetitions(int maxColours) {
        for (int i = 0; i < maxColours; ++i) {
            for (int j = 0; j < maxColours; ++j) {
                for (int k = 0; k < maxColours; ++k) {
                    for (int l = 0; l < maxColours; ++l) {
                        int[] number = new int[]{i, j, k, l};
                        posiblescodigos.add(number);

                    }
                }
            }
        }
    }

    /**
     * Metodo que genera un Set de colores con todas las posibles combinaciones sin repeticiones
     * @param numerColors maximo de colores a usar
     */
    public void allCombinationsWithoutRepetitions(int numerColors) {
        for (int i = 0; i < numerColors; ++i) {
            for (int j = 0; j < numerColors; ++j) {
                if (i != j) {
                    for (int k = 0; k < numerColors; ++k) {
                        if (k != j && k != i) {
                            for (int l = 0; l < numerColors; ++l) {
                                if (l != k && l != j && l != i) {
                                    int[] number = new int[]{i, j, k, l};
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
     * Genera la población cogiendo de forma aleatoria MAX_POP_SIZE codigos de la lista
     */
    public static void getRandomCodes() {
        population = posiblescodigos;
        Collections.shuffle(population);
        if (population.size() != 0) population = population.subList(0, MAX_POP_SIZE);
    }

    /**
     * Genera una List<List<Integer>> que es una lista con las combinaciones necesarias para acertar el código del Codemaker.
     * @param solution solucion del codigo
     * @return lista combinaciones
     */
    public List<List<Integer>> solve(List<Integer> solution) {

        int[] solutionArray = new int[solution.size()];

        //Inicial fixed guess
        if (isDuplicated) intento = new int[]{1, 1, 2, 3};

        else intento = new int[]{1, 2, 3, 4};

        currentStep = 1;

        List<Integer> inte = new ArrayList<>();

        for (int i : intento) inte.add(i);

        respuestasCB.add(inte);

        for (int i = 0; i < solution.size(); i++)
            solutionArray[i] = solution.get(i);

        //Get response X and Y
        int[] resCM = response(intento, solutionArray);
        responsesCM.add(resCM);

        List<int[]> t = new ArrayList<>();
        t.add(intento);
        t.add(resCM);

        guesses.add(t);

        while (resCM[0] != 4 && currentStep <= maxSteps) {
            List<int[]> eligibles;
            eligibles = genetic_evolution(MAX_POP_SIZE, MAX_GENERATIONS);

            while (eligibles.size() == 0) {
                eligibles = genetic_evolution(MAX_POP_SIZE * 2, MAX_GENERATIONS / 2);
            }

            int[] codeC;


            codeC = eligibles.get(eligibles.size() - 1);
            eligibles.remove(eligibles.size() - 1);

            boolean notUsedYet = true;

            while (notUsedYet) {
                for (List<int[]> guess : guesses) {
                    notUsedYet = false;
                    if (Arrays.equals(guess.get(0), codeC)) {
                        notUsedYet = true;
                        eligibles.remove(eligibles.size() - 1);
                        codeC = eligibles.get(eligibles.size() - 1);
                    }
                }
            }

            ++currentStep;
            resCM = response(codeC, solutionArray);

            List<Integer> codeCList = new ArrayList<>();

            for (int c : codeC)
                codeCList.add(c);

            respuestasCB.add(codeCList);

            t = new ArrayList<>();
            t.add(codeC);
            t.add(resCM);
            guesses.add(t);
        }

        return respuestasCB;
    }

    /**
     * Ejecución del algoritmo genético
     * @param popsize tamaño de la poblacion
     * @param generations número de generaciones maximas
     * @return Hijos optimos para ser usados como codigo
     */
    public static List<int[]> genetic_evolution(int popsize, int generations) {
        population.clear();

        getRandomCodes();

        List<int[]> chosen_ones = new ArrayList<>();

        int h = 1;

        while (chosen_ones.size() <= popsize && h <= generations) {
            List<List<int[]>> sons = new ArrayList<>();

            for (int i = 0; i < population.size(); ++i) {
                if (i == population.size() - 1) {
                    int score = calculaFitness(population.get(i));
                    int[] scoreArray = new int[]{score};
                    List<int[]> tmp = new ArrayList<>();
                    tmp.add(scoreArray);
                    tmp.add(population.get(i));
                    sons.add(tmp);
                    break;
                }
                int[] son = crossover(population.get(i), population.get(i + 1));

                if (randomGenerator.nextDouble() <= MUTATION_PROBABILITY) {
                    mutate(son);
                }
                permute(son);
                int score = calculaFitness(son);
                int[] scoreArray = new int[]{score};
                List<int[]> tmp = new ArrayList<>();
                tmp.add(scoreArray);
                tmp.add(son);
                sons.add(tmp);
            }

            sons = sortArray(sons);

            List<List<int[]>> eligibles = new ArrayList<>();

            for (List<int[]> c : sons)
                if (c.get(0)[0] == 0)
                    eligibles.add(c);

            if (eligibles.size() != 0) {
                List<int[]> new_eligibles = new ArrayList<>();

                for (List<int[]> values : eligibles)
                    new_eligibles.add(values.get(1));

                for (int[] code : new_eligibles) {
                    if (chosen_ones.contains(code)) {
                        chosen_ones.remove(code);
                        int[] newcode = new int[4];
                        for (int i = 0; i < 4; i++) {
                            int randomColor = randomGenerator.nextInt(numColors);
                            newcode[i] = randomColor;
                        }
                        chosen_ones.add(newcode);
                    }
                }

                for (int[] eligible : new_eligibles) {
                    if (chosen_ones.size() == popsize) break;

                    if (!containsIntArray(chosen_ones, eligible)) chosen_ones.add(eligible);
                }

                population = new_eligibles;

                for (int j = population.size(); j < popsize; ++j) {
                    int[] newcode = new int[4];
                    for (int i = 0; i < 4; i++) {
                        int randomColor = randomGenerator.nextInt(numColors);
                        newcode[i] = randomColor;
                    }
                    population.add(newcode);
                }
            }
            ++h;
        }

        return chosen_ones;
    }

    /**
     * Dado dos padres genera un código nuevo basándose en una probabilidad de que cada gen sea del padre o la madre.
     * @param code1 padre
     * @param code2 madre
     * @return hijo
     */
    public static int[] crossover(int[] code1, int[] code2) {
        int[] newcode = new int[4];
        for (int i = 0; i < 4; ++i) {
            if (randomGenerator.nextDouble() > CROSSOVER_PROBABILITY) newcode[i] = code1[i];
            else newcode[i] = code2[i];
        }
        return newcode;
    }

    /**
     * Genera un código mutado, es decir, modifica un gen de forma aleatoria del código que se le pasa como parámetro
     * @param code codigo a mutar
     */
    public static void mutate(int[] code) {
        int i = randomGenerator.nextInt(4);
        int v = randomGenerator.nextInt(numColors);
        code[i] = v;
    }

    /**
     * Genera un código permutado del código que se le pasa como parámetro
     * @param code codigo a permutar
     */
    public static void permute(int[] code) {
        for (int i = 0; i < 4; ++i) {
            if (randomGenerator.nextDouble() <= PERMUTATION_PROBABILITY) {
                int random_color_position_a = randomGenerator.nextInt(4);
                int random_color_position_b = randomGenerator.nextInt(4);

                int save_color_a = code[random_color_position_a];

                code[random_color_position_a] = code[random_color_position_b];
                code[random_color_position_b] = save_color_a;
            }
        }
    }

    /**
     * Hace un sort de la lista que se le pasa como parámetro.
     * @param array Array a ordenar
     * @return Array ordenada
     */
    static List<List<int[]>> sortArray(List<List<int[]>> array) {
        array.sort(new Comparator<List<int[]>>() {
            @Override
            public int compare(List<int[]> list1, List<int[]> list2) {
                // Obtener el valor específico de los arreglos de enteros para comparar
                int value1 = getValueFromIntArray(list1.get(0));
                int value2 = getValueFromIntArray(list2.get(0));


                // Comparar los valores y devolver el resultado
                return Integer.compare(value1, value2);
            }


            private int getValueFromIntArray(int[] array) {
                // Implementar aquí la lógica para obtener el valor específico del arreglo de enteros
                // en función del cual deseas ordenar
                // En este ejemplo, asumimos que el valor se encuentra en la primera posición del arreglo
                return array[0];
            }
        });


        return array;
    }

    /**
     * Devuelve cierto o falso en función de si la lista list contiene el parámetro target.
     * @param list lista a comprobar
     * @param target parametro a buscar
     * @return devuelve si se ha encontrado el target en list
     */
    private static boolean containsIntArray(List<int[]> list, int[] target) {
        for (int[] array : list) {
            if (Arrays.equals(array, target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Genera una respuesta al intento como haría el Codemaker.
     * @param trie intento
     * @param code codigo
     * @return retorna la respuesta del genetic como CM
     */
    public static int[] response(int[] trie, int[] code) {
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
     *
     * @param intento Calcula la diferencia entre el nuevo intento y los anteriores
     * @param guess nuevo intento
     * @return devuelve la diferencia
     */
    public static int[] calculaDiferencia(int[] intento, List<int[]> guess) {
        int[] guess_result = guess.get(1);
        int[] guess_code = guess.get(0);

        int[] trial_result = response(intento, guess_code);

        int[] diff = new int[]{0, 0};
        diff[0] = Math.abs(trial_result[0] - guess_result[0]);
        diff[1] = Math.abs(trial_result[1] - guess_result[1]);

        return diff;
    }

    /**
     * Calcula como de valido es un hijo
     * @param intento hijo
     * @return devuelve su validez
     */
    public static int calculaFitness(int[] intento) {
        List<int[]> differences = new ArrayList<>();
        for (List<int[]> guess : guesses)
            differences.add(calculaDiferencia(intento, guess));

        int sum_black_pin_differences = 0;
        int sum_white_pin_differences = 0;

        for (int[] diff : differences) {
            sum_black_pin_differences += diff[0];
            sum_white_pin_differences += diff[1];
        }

        return sum_black_pin_differences + sum_white_pin_differences;
    }

}