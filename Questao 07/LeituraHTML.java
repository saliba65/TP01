import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

class LeituraHTML {
    public static boolean ehVogal(char letra) {
        boolean ehVogal = false;
        int i = 0;
        char[] vogal = { 'a', 'e', 'i', 'o', 'u' };

        while (!ehVogal && i < 5) {
            // Verificar se o caractere � uma vogal
            if (letra == vogal[i]) {
                ehVogal = true;
            } else {
                i++;
            }
        }

        return ehVogal;
    }

    public static boolean ehLetra(char letra) {
        // Verificar se o caractere � uma letra
        return (letra >= 'a' && letra <= 'z');
    }

    public static boolean ehFIM(String entrada) {
        // Verificar se a entrada � "FIM"
        return (entrada.length() >= 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I'
                && entrada.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        String[] entrada = new String[1000];
        int totalEntrada = 0;
        String linha = "";
        String linhaHTML = "";
        int[] contador = new int[25];
        String[] solicitado = { "a", "e", "i", "o", "u", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
                "�", "�", "�", "�", "�", "consoante", "<br>", "<table>" };

        // Ler as entradas at� se digitar "FIM"
        do {
            entrada[totalEntrada] = ler.nextLine();
        } while (!ehFIM(entrada[totalEntrada++]));

        // Desconsiderar a entrada "FIM"
        totalEntrada--;

        for (int i = 0; i < totalEntrada; i++) {
            // Verificar se o primeiro caractere da entrada � 'h', indicando que ela � um
            // link em HTML
            if (entrada[i].charAt(0) == 'h') {
                try {
                    URL linkHTML = new URL(entrada[i]);
                    BufferedReader bR = new BufferedReader(new InputStreamReader(linkHTML.openStream()));
                    linha = bR.readLine();

                    // Definir o c�digo em HTML como uma �nica linha
                    while (linha != null) {
                        linhaHTML += linha;
                        linha = bR.readLine();
                    }

                    bR.close();

                    // Verificar se um caractere corresponde � palavra solicitado ou ao caractere
                    // solicitado para som�-lo ao contador correspondente
                    for (int j = 0; j < linhaHTML.length(); j++) {
                        if (linhaHTML.charAt(j) == '<' && linhaHTML.charAt(j + 1) == 'b'
                                && linhaHTML.charAt(j + 2) == 'r' && linhaHTML.charAt(j + 3) == '>') {
                            contador[23]++;
                            // Somar '3' � 'j' para desconsiderar os caracteres dentro das �spas francesas
                            j += 3;
                        } else if (linhaHTML.charAt(j) == '<' && linhaHTML.charAt(j + 1) == 't'
                                && linhaHTML.charAt(j + 2) == 'a' && linhaHTML.charAt(j + 3) == 'b'
                                && linhaHTML.charAt(j + 4) == 'l' && linhaHTML.charAt(j + 5) == 'e'
                                && linhaHTML.charAt(j + 6) == '>') {
                            contador[24]++;
                            // Somar '6' � 'j' para desconsiderar os caracteres dentro das �spas francesas
                            j += 6;
                        } else if (linhaHTML.charAt(j) == 'a') {
                            contador[0]++;
                        } else if (linhaHTML.charAt(j) == 'e') {
                            contador[1]++;
                        } else if (linhaHTML.charAt(j) == 'i') {
                            contador[2]++;
                        } else if (linhaHTML.charAt(j) == 'o') {
                            contador[3]++;
                        } else if (linhaHTML.charAt(j) == 'u') {
                            contador[4]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[5]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[6]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[7]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[8]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[9]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[10]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[11]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[12]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[13]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[14]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[15]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[16]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[17]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[18]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[19]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[20]++;
                        } else if (linhaHTML.charAt(j) == '�') {
                            contador[21]++;
                        } else if (ehLetra(linhaHTML.charAt(j)) && !ehVogal(linhaHTML.charAt(j))) {
                            contador[22]++;
                        }
                    }
                } catch (MalformedURLException excecao) {
                    excecao.printStackTrace();
                } catch (IOException excecao) {
                    excecao.printStackTrace();
                }

                for (int j = 0; j < 25; j++) {
                    // Escrever o caractere solicitado junto da quantidade de vezes que ele aparece
                    // no c�digo em HTML
                    System.out.print(solicitado[j] + "(" + contador[j] + ")" + " ");
                }

                // Escrever o nome da p�gina solicitada
                System.out.println(entrada[i - 1]);

                // Definir a linha que ser� preenchida como uma "String" vazia
                linha = "";
                // Definir a linha preenchida como uma "String" vazia
                linhaHTML = "";

                for (int j = 0; j < 25; j++) {
                    // Zerar todos os contadores dos caracteres solicitados
                    contador[j] = 0;
                }
            }
        }
    }
}