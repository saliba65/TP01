class Algebra_Booleana {
    public static boolean executarVarredura(String entrada) {
        boolean ehVerdadeiro = false;

        // Verificar se a expressão booleana simplificada é um "not(A)"
        if (entrada.charAt(51) == 'n') {
            // Verificar se a expressão "not" possui '0' para torná-la verdadeira
            if (entrada.charAt(55) == '0') {
                ehVerdadeiro = true;
            }
            // Verificar se a expressão booleana simplificada é um "or(A , B)"
        } else if (entrada.charAt(51) == 'o') {
            /*
             * Começa-se no "54" pois o primeiro número está nessa posição Incrementa-se "4"
             * pois a cada 4 caracteres o primeiro deles é um número
             */
            for (int i = 54; i < entrada.length() - 1; i += 4) {
                // Verificar se a expressão "or" possui algum '1' para torná-la verdadeira
                if (entrada.charAt(i) == '1') {
                    ehVerdadeiro = true;
                }
            }
            // Verificar se a expressão booleana simplificada é um "and(A , B)"
        } else {
            ehVerdadeiro = true;

            /*
             * Começa-se no "55" pois o primeiro número está nessa posição Incrementa-se "4"
             * pois a cada 4 caracteres o primeiro deles é um número
             */
            for (int i = 55; i < entrada.length() - 1; i += 4) {
                // Verificar se a expressão "and" possui algum '0' para torná-la falsa
                if (entrada.charAt(i) == '0') {
                    ehVerdadeiro = false;
                }
            }
        }

        return ehVerdadeiro;
    }

    public static int totalLetras(String entrada) {
        int totalLetras = 0;

        for (int i = 0; i < entrada.length(); i++) {
            // Verificar se a expressão booleana possui alguma letra para somá-la ao total
            // de letras
            if (entrada.charAt(i) >= 'a' && entrada.charAt(i) <= 'z') {
                totalLetras++;
            }
        }

        return totalLetras;
    }

    public static String substituirString(String entrada, char valor, int posicao, int incremento) {
        String novaEntrada = "";

        /*
         * Simplificar uma expressão booleana do tipo "not(0)", por exemplo Obtendo-se
         * como resultado '1' Para isso, um dos parâmetros é a posição do 'n' e o outro
         * é o número de caracteres que devem ser deletados
         */
        for (int i = 0; i < entrada.length(); i++) {
            // Verificar se o 'i' é igual à posição do primeiro caractere da expressão
            // booleana simples
            if (i == posicao) {
                // Somar o resultado booleano à nova expressão booleana
                novaEntrada += valor;
                // Somar o incremento ao 'i'
                i += incremento;
            } else {
                // Somar um caractere à nova expressão booleana
                novaEntrada += entrada.charAt(i);
            }
        }

        MyIO.println(novaEntrada);

        return novaEntrada;
    }

    public static String tratarExcecao(String entrada, int posicao) {
        String novaEntrada = "";

        /*
         * Acresentar um espaço à expressão booleana que esteja escrita de forma
         * incorreta do tipo "or(A, B)", por exemplo Obtendo-se como resultado
         * "or(A , B)" Para isso, um dos parâmetros é a posição do caractere anterior à
         * vírgula
         */
        for (int i = 0; i < entrada.length(); i++) {
            // Verificar se o 'i' é igual à posição do caractere anterior à vírgula
            if (i == posicao) {
                // Somar o caractere à nova expressão booleana
                novaEntrada += entrada.charAt(i);
                // Somar um espaço à nova expressão booleana
                novaEntrada += " ";
            } else {
                // Somar um caractere à nova expressão booleana
                novaEntrada += entrada.charAt(i);
            }
        }

        return novaEntrada;
    }

    public static boolean ehVerdadeiro(String entrada) {
        boolean ehVerdadeiro = false;
        boolean simplificacaoConcluida = false;
        boolean tratarExcecao = false;
        int posicao = 0;
        String entradaTemp = "";
        String entradaBooleanaTemp = "";
        String entradaBooleana = "";
        char A;
        char B;
        char C;

        for (int i = 1; i < entrada.length(); i++) {
            // Verificar se o caractere 'i' da expressão booleana é uma vírgula e o seu
            // caractere anterior não é um espaço
            if (entrada.charAt(i - 1) != ' ' && entrada.charAt(i) == ',') {
                tratarExcecao = true;
                posicao = i - 1;
            }
        }

        // Verificar se a expressão booleana necessita de um tratamento de exceção
        if (tratarExcecao) {
            entradaTemp = tratarExcecao(entrada, posicao);
        } else {
            entradaTemp = entrada;
        }

        // Verificar se a expressão booleana possui 2 variáveis
        if (entradaTemp.charAt(0) == '2') {
            // Definir a variável booleana 'A' como o primeiro valor da expressão booleana
            A = entradaTemp.charAt(2);
            // Definir a variável booleana 'B' como o segundo valor da expressão booleana
            B = entradaTemp.charAt(4);

            for (int i = 6; i < entradaTemp.length(); i++) {
                // Verificar se o caractere 'i' da expressão booleana é igual ao caractere 'A'
                if (entradaTemp.charAt(i) == 'A') {
                    // Substituir o caractere 'A' pela variável booleana 'A'
                    entradaBooleanaTemp += A;
                    // Verificar se o caractere 'i' da expressão booleana é igual ao caractere 'B'
                } else if (entradaTemp.charAt(i) == 'B') {
                    // Substituir o caractere 'B' pela variável booleana 'B'
                    entradaBooleanaTemp += B;
                } else {
                    // Somar um caractere à nova expressão booleana
                    entradaBooleanaTemp += entradaTemp.charAt(i);
                }
            }
        } else {
            // Definir a variável booleana 'A' como o primeiro valor da expressão booleana
            A = entradaTemp.charAt(2);
            // Definir a variável booleana 'B' como o segundo valor da expressão booleana
            B = entradaTemp.charAt(4);
            // Definir a variável booleana 'C' como o terceiro valor da expressão booleana
            C = entradaTemp.charAt(6);

            for (int i = 8; i < entradaTemp.length(); i++) {
                // Verificar se o caractere 'i' da expressão booleana é igual ao caractere 'A'
                if (entradaTemp.charAt(i) == 'A') {
                    // Substituir o caractere 'A' pela variável booleana 'A'
                    entradaBooleanaTemp += A;
                    // Verificar se o caractere 'i' da expressão booleana é igual ao caractere 'B'
                } else if (entradaTemp.charAt(i) == 'B') {
                    // Substituir o caractere 'B' pela variável booleana 'B'
                    entradaBooleanaTemp += B;
                    // Verificar se o caractere 'i' da expressão booleana é igual ao caractere 'C'
                } else if (entradaTemp.charAt(i) == 'C') {
                    // Substituir o caractere 'C' pela variável booleana 'C'
                    entradaBooleanaTemp += C;
                } else {
                    // Somar um caractere à nova expressão booleana
                    entradaBooleanaTemp += entradaTemp.charAt(i);
                }
            }
        }

        MyIO.println(entradaBooleanaTemp);

        /*
         * É necessário garantir que para cada comparação o índice do arranjo não
         * ultrapasse seus limites Para isso soma-se "50" espaços ao início da expressão
         * booleana
         */
        for (int i = 0; i <= 51; i++) {
            // Verificar se o 'i' é igual ao número "51" para somar à expressão booleana aos
            // espaços
            if (i == 51) {
                entradaBooleana += entradaBooleanaTemp;
            } else {
                // Somar um espaço à nova expressão booleana
                entradaBooleana += " ";
            }
        }

        while (!(simplificacaoConcluida)) {
            /*
             * É necessário resolver todas as expressões booleanas simples primeiro para
             * resolver a expressão booleana final e transformá-la em um valor booleana Para
             * isso, é necessário buscar as expressões simples, lendo a expressão booleana
             * de trás para frente, adotando o ')' como um indicador de expressão simples
             * Adotam-se como base as seguintes informações: "not(A)": possui 6 caracteres,
             * onde o ')' encontra-se em 'i', o '(' em "i - 2" e o valor em "i - 1"
             * "or(A , B ...)": possui 9 caracteres, onde o ')' encontra-se em 'i', o '(' em
             * "i - 6", o 'r' em "i - 7" e os valores em "i - 1", "i - 5", "i - 9", "i - 13"
             * e assim por diante "and(A , B ...)": possui 10 caracteres, onde o ')'
             * encontra-se em 'i', o '(' em "i - 6", o 'd' em "i - 7" e os valores em
             * "i - 1", "i - 5", "i - 9", "i - 13" e assim por diante
             */
            for (int i = entradaBooleana.length() - 1; i >= 0; i--) {
                // Verificar se o caractere é um ')' e anterior não é um '(', além de verificar
                // se o total de letras é maior que 3, indicando que a expressão booleana não é
                // a expressão final
                if (entradaBooleana.charAt(i) == ')' && entradaBooleana.charAt(i - 1) != ')'
                        && totalLetras(entradaBooleana) > 3) {
                    // Verificar se a expressão corresponde à um "not(A)"
                    if (entradaBooleana.charAt(i - 2) == '('
                            && (entradaBooleana.charAt(i - 1) == '0' || entradaBooleana.charAt(i - 1) == '1')) {
                        // Verificar se a expressão possui '0' para torná-la verdadeira
                        if (entradaBooleana.charAt(i - 1) == '0') {
                            entradaBooleana = substituirString(entradaBooleana, '1', (i - 5), 5);
                            i -= 4;
                        } else {
                            entradaBooleana = substituirString(entradaBooleana, '0', (i - 5), 5);
                            i -= 4;
                        }
                        // Verificar se a expressão corresponde à um "or(A , B)" ou à um "and(A , B)"
                    } else if (entradaBooleana.charAt(i - 6) == '('
                            && (entradaBooleana.charAt(i - 5) == '0' || entradaBooleana.charAt(i - 5) == '1')
                            && entradaBooleana.charAt(i - 4) == ' ') {
                        // Verificar se a expressão corresponde à um "or"
                        if (entradaBooleana.charAt(i - 7) == 'r') {
                            // Verificar se a expressão possui algum '1' para torná-la verdadeira
                            if (entradaBooleana.charAt(i - 5) == '1' || entradaBooleana.charAt(i - 1) == '1') {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 8), 8);
                                i -= 7;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 8), 8);
                                i -= 7;
                            }
                        } else {
                            // Verificar se a expressão possui algum '0' para torná-la falsa
                            if (entradaBooleana.charAt(i - 5) == '0' || entradaBooleana.charAt(i - 1) == '0') {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 9), 9);
                                i -= 8;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 9), 9);
                                i -= 8;
                            }
                        }
                        // Verificar se a expressão corresponde à um "or(A , B , C)" ou à um "and(A , B
                        // , C)"
                    } else if (entradaBooleana.charAt(i - 10) == '('
                            && (entradaBooleana.charAt(i - 9) == '0' || entradaBooleana.charAt(i - 9) == '1')
                            && entradaBooleana.charAt(i - 8) == ' ') {
                        // Verificar se a expressão corresponde à um "or"
                        if (entradaBooleana.charAt(i - 11) == 'r') {
                            // Verificar se a expressão possui algum '1' para torná-la verdadeira
                            if (entradaBooleana.charAt(i - 9) == '1' || entradaBooleana.charAt(i - 5) == '1'
                                    || entradaBooleana.charAt(i - 1) == '1') {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 12), 12);
                                i -= 11;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 12), 12);
                                i -= 11;
                            }
                        } else {
                            // Verificar se a expressão possui algum '0' para torná-la falsa
                            if (entradaBooleana.charAt(i - 9) == '0' || entradaBooleana.charAt(i - 5) == '0'
                                    || entradaBooleana.charAt(i - 1) == '0') {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 13), 13);
                                i -= 12;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 13), 13);
                                i -= 12;
                            }
                        }
                        // Verificar se a expressão corresponde à um "or(A , B , C , A)" ou à um "and(A
                        // , B , C , A)"
                    } else if (entradaBooleana.charAt(i - 14) == '('
                            && (entradaBooleana.charAt(i - 13) == '0' || entradaBooleana.charAt(i - 13) == '1')
                            && entradaBooleana.charAt(i - 12) == ' ') {
                        // Verificar se a expressão corresponde à um "or"
                        if (entradaBooleana.charAt(i - 15) == 'r') {
                            // Verificar se a expressão possui algum '1' para torná-la verdadeira
                            if (entradaBooleana.charAt(i - 13) == '1' || entradaBooleana.charAt(i - 9) == '1'
                                    || entradaBooleana.charAt(i - 5) == '1' || entradaBooleana.charAt(i - 1) == '1') {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 16), 16);
                                i -= 15;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 16), 16);
                                i -= 15;
                            }
                        } else {
                            // Verificar se a expressão possui algum '0' para torná-la falsa
                            if (entradaBooleana.charAt(i - 13) == '0' || entradaBooleana.charAt(i - 9) == '0'
                                    || entradaBooleana.charAt(i - 5) == '0' || entradaBooleana.charAt(i - 1) == '0') {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 17), 17);
                                i -= 16;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 17), 17);
                                i -= 16;
                            }
                        }
                        // Verificar se a expressão corresponde à um "or(A , B , C , A , B)" ou à um
                        // "and(A , B , C , A , B)"
                    } else if (entradaBooleana.charAt(i - 18) == '('
                            && (entradaBooleana.charAt(i - 17) == '0' || entradaBooleana.charAt(i - 17) == '1')
                            && entradaBooleana.charAt(i - 16) == ' ') {
                        // Verificar se a expressão corresponde à um "or"
                        if (entradaBooleana.charAt(i - 19) == 'r') {
                            // Verificar se a expressão possui algum '1' para torná-la verdadeira
                            if (entradaBooleana.charAt(i - 17) == '1' || entradaBooleana.charAt(i - 13) == '1'
                                    || entradaBooleana.charAt(i - 9) == '1' || entradaBooleana.charAt(i - 5) == '1'
                                    || entradaBooleana.charAt(i - 1) == '1') {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 20), 20);
                                i -= 19;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 20), 20);
                                i -= 19;
                            }
                        } else {
                            // Verificar se a expressão possui algum '0' para torná-la falsa
                            if (entradaBooleana.charAt(i - 13) == '0' || entradaBooleana.charAt(i - 9) == '0'
                                    || entradaBooleana.charAt(i - 5) == '0' || entradaBooleana.charAt(i - 1) == '0') {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 21), 21);
                                i -= 20;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 21), 21);
                                i -= 20;
                            }
                        }
                        // Verificar se a expressão corresponde à um "or(A , B , C , A , B , C)" ou à um
                        // "and(A , B , C , A , B , C)"
                    } else if (entradaBooleana.charAt(i - 22) == '('
                            && (entradaBooleana.charAt(i - 21) == '0' || entradaBooleana.charAt(i - 21) == '1')
                            && entradaBooleana.charAt(i - 20) == ' ') {
                        if (entradaBooleana.charAt(i - 23) == 'r') {
                            // Verificar se a expressão possui algum '1' para torná-la verdadeira
                            if (entradaBooleana.charAt(i - 21) == '1' || entradaBooleana.charAt(i - 17) == '1'
                                    || entradaBooleana.charAt(i - 13) == '1' || entradaBooleana.charAt(i - 9) == '1'
                                    || entradaBooleana.charAt(i - 5) == '1' || entradaBooleana.charAt(i - 1) == '1') {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 24), 24);
                                i -= 23;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 24), 24);
                                i -= 23;
                            }
                        } else {
                            // Verificar se a expressão possui algum '0' para torná-la falsa
                            if (entradaBooleana.charAt(i - 21) == '0' || entradaBooleana.charAt(i - 17) == '0'
                                    || entradaBooleana.charAt(i - 13) == '0' || entradaBooleana.charAt(i - 9) == '0'
                                    || entradaBooleana.charAt(i - 5) == '0' || entradaBooleana.charAt(i - 1) == '0') {
                                entradaBooleana = substituirString(entradaBooleana, '0', (i - 25), 25);
                                i -= 24;
                            } else {
                                entradaBooleana = substituirString(entradaBooleana, '1', (i - 25), 25);
                                i -= 24;
                            }
                        }
                    }
                    // Verificar se o caractere é um ')' e o total de letras é menor ou igual à 3,
                    // indicando que a expressão booleana é a expressão final
                } else if (entradaBooleana.charAt(i) == ')' && totalLetras(entradaBooleana) <= 3) {
                    if (executarVarredura(entradaBooleana)) {
                        ehVerdadeiro = true;
                    }

                    simplificacaoConcluida = true;
                }
            }
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

        // Ler as entradas até se digitar "0"
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