class Algebra_BooleanaRecursivo {
    // Varrer a expressão booleana simplificada do tipo "and" para obter um valor
    // booleano final
    public static boolean executarVarreduraAnd(String entrada, int i) {
        boolean ehVerdadeiro = true;

        // Verificar se o contador 'i' é igual à "entrada.length() - 1", indicando o fim
        // da função recursiva
        if (i == entrada.length() - 1) {
            ehVerdadeiro = true;
            // Verificar se um caractere é igual à 0, indicando o fim da função recursiva
        } else if (entrada.charAt(i) == '0') {
            ehVerdadeiro = false;
        } else {
            ehVerdadeiro = executarVarreduraAnd(entrada, i + 1);
        }

        return ehVerdadeiro;
    }

    // Varrer a expressão booleana simplificada do tipo "or" para obter um valor
    // booleano final
    public static boolean executarVarreduraOr(String entrada, int i) {
        boolean ehVerdadeiro = false;

        // Verificar se o contador 'i' é igual à "entrada.length() - 1", indicando o fim
        // da função recursiva
        if (i == entrada.length() - 1) {
            ehVerdadeiro = false;
            // Verificar se um caractere é igual à 1, indicando o fim da função recursiva
        } else if (entrada.charAt(i) == '1') {
            ehVerdadeiro = true;
        } else {
            ehVerdadeiro = executarVarreduraOr(entrada, i + 1);
        }

        return ehVerdadeiro;
    }

    public static boolean executarVarredura(String entrada) {
        boolean ehVerdadeiro = false;

        // Verificar se o primeiro caractere é igual à 'n', indicando uma expressão
        // "not(A)"
        if (entrada.charAt(50) == 'n') {
            if (entrada.charAt(54) == '0') {
                ehVerdadeiro = true;
            }
            // Verificar se o primeiro caractere é igual à 'o', indicando uma expressão
            // "or(A , B)"
        } else if (entrada.charAt(50) == 'o') {
            ehVerdadeiro = executarVarreduraOr(entrada, 53);
            // Verificar se o primeiro caractere é igual à 'o', indicando uma expressão
            // "and(A , B)"
        } else {
            ehVerdadeiro = executarVarreduraAnd(entrada, 54);
        }

        return ehVerdadeiro;
    }

    // Contar o total de letras de uma expressão booleana para verificar se ela é a
    // expressão booleana simplificada
    public static int contarTotalLetras(String entrada, int i) {
        int totalLetras = 0;

        // Verificar se o contador 'i' é igual ao tamanho da entrada, indicando o fim da
        // função recursiva
        if (i == entrada.length()) {
            totalLetras += 0;
            // Verificar se um caractere é uma letra
        } else if (entrada.charAt(i) >= 'a' && entrada.charAt(i) <= 'z') {
            totalLetras += 1 + contarTotalLetras(entrada, i + 1);
        } else {
            totalLetras += contarTotalLetras(entrada, i + 1);
        }

        return totalLetras;
    }

    // Substituir na expressão booleana uma operação simples por apenas um único
    // valor booleano
    public static String substituirString(String entrada, char valor, int posicao, int incremento, int i) {
        String novaEntrada = "";

        // Verificar se o contador 'i' é igual ao tamanho da entrada, indicando o fim da
        // função recursiva
        if (i == entrada.length()) {
            novaEntrada += "";
        } else if (posicao == i) {
            // Verificar se a posição que o valor booleana ocupará é igual ao contador 'i'
            novaEntrada += valor + substituirString(entrada, valor, posicao, incremento, i + incremento + 1);
        } else {
            novaEntrada += entrada.charAt(i) + substituirString(entrada, valor, posicao, incremento, i + 1);
        }

        return novaEntrada;
    }

    public static String substituirString(String entrada, char valor, int posicao, int incremento) {
        // Inicializar o contador como 0, para uso na função recursiva
        return substituirString(entrada, valor, posicao, incremento, 0);
    }

    // Substituir na expressão booleana um erro de digitação para efeito de
    // padronização
    public static String tratarExcecao(String entrada, int posicao, int i) {
        String novaEntrada = "";

        // Verificar se o contador 'i' é igual ao tamanho da entrada, indicando o fim da
        // função recursiva
        if (i == entrada.length()) {
            novaEntrada += "";
        } else if (posicao == i) {
            novaEntrada += entrada.charAt(i) + " " + tratarExcecao(entrada, posicao, i + 1);
        } else {
            novaEntrada += entrada.charAt(i) + tratarExcecao(entrada, posicao, i + 1);
        }

        return novaEntrada;
    }

    // Verificar se a expressão booleana necessita se um tratamento de excessão
    // devido à um erro de digitação
    public static int precisaTratarExcecao(String entrada, int i) {
        int posicao = -1;

        // Verificar se o contador 'i' é igual ao tamanho da entrada, indicando o fim da
        // função recursiva
        if (i == entrada.length()) {
            posicao = -1;
        } else if (entrada.charAt(i - 1) != ' ' && entrada.charAt(i) == ',') {
            posicao = i - 1;
        } else {
            posicao = precisaTratarExcecao(entrada, i + 1);
        }

        return posicao;
    }

    // Substituir na expressão booleana as variáveis por seus respectivos valores
    // booleanos
    public static String criarEntradaBooleana(String entrada, char A, char B, char C, int i) {
        String novaEntrada = "";

        // Verificar se o contador 'i' é igual ao tamanho da entrada, indicando o fim da
        // função recursiva
        if (i == entrada.length()) {
            novaEntrada += "";
        } else if (entrada.charAt(i) == 'A') {
            novaEntrada += A + criarEntradaBooleana(entrada, A, B, C, i + 1);
        } else if (entrada.charAt(i) == 'B') {
            novaEntrada += B + criarEntradaBooleana(entrada, A, B, C, i + 1);
        } else if (entrada.charAt(i) == 'C') {
            novaEntrada += C + criarEntradaBooleana(entrada, A, B, C, i + 1);
        } else {
            novaEntrada += entrada.charAt(i) + criarEntradaBooleana(entrada, A, B, C, i + 1);
        }

        return novaEntrada;
    }

    // Criar espaços na expressão booleana para não ultrapassar o limite do arranjo
    public static String criarEspacos(String entrada, int i) {
        String novaEntrada = "";

        // Verificar se o contador 'i' é igual à 51, indicando o fim da função recursiva
        if (i == 51) {
            novaEntrada += "";
        } else if (i < 50) {
            novaEntrada += ' ' + criarEspacos(entrada, i + 1);
        } else {
            novaEntrada += entrada + criarEspacos(entrada, i + 1);
        }

        return novaEntrada;
    }

    /*
     * Simplificar as expressões booleanas simples até se obter uma única expressão
     * simples Adotam-se como base as seguintes informações: "not(A)": possui 6
     * caracteres, onde o ')' encontra-se em 'i', o '(' em "i - 2" e o valor em
     * "i - 1" "or(A , B ...)": possui 9 caracteres, onde o ')' encontra-se em 'i',
     * o '(' em "i - 6", o 'r' em "i - 7" e os valores em "i - 1", "i - 5", "i - 9",
     * "i - 13" e assim por diante "and(A , B ...)": possui 10 caracteres, onde o
     * ')' encontra-se em 'i', o '(' em "i - 6", o 'd' em "i - 7" e os valores em
     * "i - 1", "i - 5", "i - 9", "i - 13" e assim por diante
     */
    public static String simplificarEntradaBooleana(String entrada, int i) {
        String entradaBooleana = entrada;

        // Verificar se o contador 'i' é menor que 0, indicando o fim da função
        // recursiva
        if (i < 0) {
            entradaBooleana = entrada;
        } else if (entrada.charAt(i) == ')' && entrada.charAt(i - 1) != ')') {
            // Verificar se a expressão corresponde à um "not(A)"
            if (entrada.charAt(i - 2) == '(' && (entrada.charAt(i - 1) == '0' || entrada.charAt(i - 1) == '1')) {
                // Verificar se a expressão possui '0' para torná-la verdadeira
                if (entrada.charAt(i - 1) == '0') {
                    entrada = substituirString(entrada, '1', (i - 5), 5);
                    i -= 4;
                } else {
                    entrada = substituirString(entrada, '0', (i - 5), 5);
                    i -= 4;
                }
                // Verificar se a expressão corresponde à um "or(A , B)" ou à um "and(A , B)"
            } else if (entrada.charAt(i - 6) == '(' && (entrada.charAt(i - 5) == '0' || entrada.charAt(i - 5) == '1')
                    && entrada.charAt(i - 4) == ' ') {
                // Verificar se a expressão corresponde à um "or"
                if (entrada.charAt(i - 7) == 'r') {
                    // Verificar se a expressão possui algum '1' para torná-la verdadeira
                    if (entrada.charAt(i - 5) == '1' || entrada.charAt(i - 1) == '1') {
                        entrada = substituirString(entrada, '1', (i - 8), 8);
                        i -= 7;
                    } else {
                        entrada = substituirString(entrada, '0', (i - 8), 8);
                        i -= 7;
                    }
                } else {
                    // Verificar se a expressão possui algum '0' para torná-la falsa
                    if (entrada.charAt(i - 5) == '0' || entrada.charAt(i - 1) == '0') {
                        entrada = substituirString(entrada, '0', (i - 9), 9);
                        i -= 8;
                    } else {
                        entrada = substituirString(entrada, '1', (i - 9), 9);
                        i -= 8;
                    }
                }
                // Verificar se a expressão corresponde à um "or(A , B , C)" ou à um "and(A , B
                // , C)"
            } else if (entrada.charAt(i - 10) == '(' && (entrada.charAt(i - 9) == '0' || entrada.charAt(i - 9) == '1')
                    && entrada.charAt(i - 8) == ' ') {
                // Verificar se a expressão corresponde à um "or"
                if (entrada.charAt(i - 11) == 'r') {
                    // Verificar se a expressão possui algum '1' para torná-la verdadeira
                    if (entrada.charAt(i - 9) == '1' || entrada.charAt(i - 5) == '1' || entrada.charAt(i - 1) == '1') {
                        entrada = substituirString(entrada, '1', (i - 12), 12);
                        i -= 11;
                    } else {
                        entrada = substituirString(entrada, '0', (i - 12), 12);
                        i -= 11;
                    }
                } else {
                    // Verificar se a expressão possui algum '0' para torná-la falsa
                    if (entrada.charAt(i - 9) == '0' || entrada.charAt(i - 5) == '0' || entrada.charAt(i - 1) == '0') {
                        entrada = substituirString(entrada, '0', (i - 13), 13);
                        i -= 12;
                    } else {
                        entrada = substituirString(entrada, '1', (i - 13), 13);
                        i -= 12;
                    }
                }
                // Verificar se a expressão corresponde à um "or(A , B , C , A)" ou à um "and(A
                // , B , C , A)"
            } else if (entrada.charAt(i - 14) == '(' && (entrada.charAt(i - 13) == '0' || entrada.charAt(i - 13) == '1')
                    && entrada.charAt(i - 12) == ' ') {
                // Verificar se a expressão corresponde à um "or"
                if (entrada.charAt(i - 15) == 'r') {
                    // Verificar se a expressão possui algum '1' para torná-la verdadeira
                    if (entrada.charAt(i - 13) == '1' || entrada.charAt(i - 9) == '1' || entrada.charAt(i - 5) == '1'
                            || entrada.charAt(i - 1) == '1') {
                        entrada = substituirString(entrada, '1', (i - 16), 16);
                        i -= 15;
                    } else {
                        entrada = substituirString(entrada, '0', (i - 16), 16);
                        i -= 15;
                    }
                } else {
                    // Verificar se a expressão possui algum '0' para torná-la falsa
                    if (entrada.charAt(i - 13) == '0' || entrada.charAt(i - 9) == '0' || entrada.charAt(i - 5) == '0'
                            || entrada.charAt(i - 1) == '0') {
                        entrada = substituirString(entrada, '0', (i - 17), 17);
                        i -= 16;
                    } else {
                        entrada = substituirString(entrada, '1', (i - 17), 17);
                        i -= 16;
                    }
                }
                // Verificar se a expressão corresponde à um "or(A , B , C , A , B)" ou à um
                // "and(A , B , C , A , B)"
            } else if (entrada.charAt(i - 18) == '(' && (entrada.charAt(i - 17) == '0' || entrada.charAt(i - 17) == '1')
                    && entrada.charAt(i - 16) == ' ') {
                // Verificar se a expressão corresponde à um "or"
                if (entrada.charAt(i - 19) == 'r') {
                    // Verificar se a expressão possui algum '1' para torná-la verdadeira
                    if (entrada.charAt(i - 17) == '1' || entrada.charAt(i - 13) == '1' || entrada.charAt(i - 9) == '1'
                            || entrada.charAt(i - 5) == '1' || entrada.charAt(i - 1) == '1') {
                        entrada = substituirString(entrada, '1', (i - 20), 20);
                        i -= 19;
                    } else {
                        entrada = substituirString(entrada, '0', (i - 20), 20);
                        i -= 19;
                    }
                } else {
                    // Verificar se a expressão possui algum '0' para torná-la falsa
                    if (entrada.charAt(i - 13) == '0' || entrada.charAt(i - 9) == '0' || entrada.charAt(i - 5) == '0'
                            || entrada.charAt(i - 1) == '0') {
                        entrada = substituirString(entrada, '0', (i - 21), 21);
                        i -= 20;
                    } else {
                        entrada = substituirString(entrada, '1', (i - 21), 21);
                        i -= 20;
                    }
                }
                // Verificar se a expressão corresponde à um "or(A , B , C , A , B , C)" ou à um
                // "and(A , B , C , A , B , C)"
            } else if (entrada.charAt(i - 22) == '(' && (entrada.charAt(i - 21) == '0' || entrada.charAt(i - 21) == '1')
                    && entrada.charAt(i - 20) == ' ') {
                if (entrada.charAt(i - 23) == 'r') {
                    // Verificar se a expressão possui algum '1' para torná-la verdadeira
                    if (entrada.charAt(i - 21) == '1' || entrada.charAt(i - 17) == '1' || entrada.charAt(i - 13) == '1'
                            || entrada.charAt(i - 9) == '1' || entrada.charAt(i - 5) == '1'
                            || entrada.charAt(i - 1) == '1') {
                        entrada = substituirString(entrada, '1', (i - 24), 24);
                        i -= 23;
                    } else {
                        entrada = substituirString(entrada, '0', (i - 24), 24);
                        i -= 23;
                    }
                } else {
                    // Verificar se a expressão possui algum '0' para torná-la falsa
                    if (entrada.charAt(i - 21) == '0' || entrada.charAt(i - 17) == '0' || entrada.charAt(i - 13) == '0'
                            || entrada.charAt(i - 9) == '0' || entrada.charAt(i - 5) == '0'
                            || entrada.charAt(i - 1) == '0') {
                        entrada = substituirString(entrada, '0', (i - 25), 25);
                        i -= 24;
                    } else {
                        entrada = substituirString(entrada, '1', (i - 25), 25);
                        i -= 24;
                    }
                }
            }

            entradaBooleana = simplificarEntradaBooleana(entrada, i - 1);
        } else {
            entradaBooleana = simplificarEntradaBooleana(entrada, i - 1);
        }

        return entradaBooleana;
    }

    public static String simplificarEntradaBooleana(String entrada) {
        // Inicializar o contador 'i' como "entrada.length() - 1", para uso na função
        // recursiva
        return simplificarEntradaBooleana(entrada, entrada.length() - 1);
    }

    public static boolean calcularValorBooleano(String entrada) {
        boolean ehVerdadeiro = false;
        String novaEntrada;

        // Definir a nova entrada como a entrada booleana simplificada
        novaEntrada = simplificarEntradaBooleana(entrada);

        // Verificar se o contador do total de letras é igual à 2 ou à 3, indicando o
        // fim da função recursiva
        if (contarTotalLetras(novaEntrada, 0) == 2 || contarTotalLetras(novaEntrada, 0) == 3) {
            ehVerdadeiro = executarVarredura(novaEntrada);
        } else {
            ehVerdadeiro = calcularValorBooleano(novaEntrada);
        }

        return ehVerdadeiro;
    }

    public static boolean ehVerdadeiro(String entrada) {
        boolean ehVerdadeiro = false;
        int posicao;
        String entradaBooleanaTemp = "";
        String entradaBooleana = "";
        char A = '0';
        char B = '0';
        char C = '0';

        // Verificar se a entrada precisa de um tratamento de exceção por erro de
        // digitação
        posicao = precisaTratarExcecao(entrada, 1);

        if (posicao >= 0) {
            // Tratar a exceção por erro de digitação
            entradaBooleanaTemp = tratarExcecao(entrada, posicao, 0);
        } else {
            entradaBooleanaTemp = entrada;
        }

        // Verificar se a expressão booleana possui 2 variáveis
        if (entradaBooleanaTemp.charAt(0) == '2') {
            // Definir a variável booleana 'A' como o primeiro valor da expressão booleana
            A = entradaBooleanaTemp.charAt(2);
            // Definir a variável booleana 'B' como o segundo valor da expressão booleana
            B = entradaBooleanaTemp.charAt(4);

            entradaBooleana = criarEntradaBooleana(entradaBooleanaTemp, A, B, C, 6);
        } else {
            // Definir a variável booleana 'A' como o primeiro valor da expressão booleana
            A = entradaBooleanaTemp.charAt(2);
            // Definir a variável booleana 'B' como o segundo valor da expressão booleana
            B = entradaBooleanaTemp.charAt(4);
            // Definir a variável booleana 'C' como o terceiro valor da expressão booleana
            C = entradaBooleanaTemp.charAt(6);

            entradaBooleana = criarEntradaBooleana(entradaBooleanaTemp, A, B, C, 8);
        }

        entradaBooleana = criarEspacos(entradaBooleana, 0);

        // Verificar se a expressão booleana é verdadeira
        if (calcularValorBooleano(entradaBooleana)) {
            ehVerdadeiro = true;
        }

        return ehVerdadeiro;
    }

    public static boolean eh0(String entrada) {
        // Verificar se a entrada é "0"
        return (entrada.length() >= 1 && entrada.charAt(0) == '0');
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int totalEntrada = 0;

        // Ler as entradas até "0"
        do {
            entrada[totalEntrada] = MyIO.readLine();
        } while (!eh0(entrada[totalEntrada++]));

        // Desconsiderar a entrada "0"
        totalEntrada--;

        for (int i = 0; i < totalEntrada; i++) {
            // Verificar se a expressão booleana é verdadeira
            if (ehVerdadeiro(entrada[i])) {
                // Verdadeira
                MyIO.println(1);
            } else {
                // Falsa
                MyIO.println(0);
            }
        }
    }
}