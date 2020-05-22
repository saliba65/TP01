import java.util.Random;

class AlteracaoAleatoria {
    public static void main(String[] args) {
        String[] frase = new String[1000];
        int totalEntradas = 0;
        Random gerador = new Random();
        // Semente para geracao de numeros aleatorios
        gerador.setSeed(4);

        // Ler as entradas ate FIM
        do {
            frase[totalEntradas] = MyIO.readLine();
        } while (!ehFIM(frase[totalEntradas++]));

        // Desconsiderar a entrada FIM
        totalEntradas--;

        // Chamando funcao para alterar frase
        for (int i = 0; i < totalEntradas; i++) {
            MyIO.println(fraseFinal(frase[i], gerador));
        }
    }

    // Verificar se a entrada eh FIM
    public static boolean ehFIM(String entrada) {
        return (entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I'
                && entrada.charAt(2) == 'M');
    }

    // Trocar as letras aleatorias da entrada
    public static String fraseFinal(String frase, Random gerador) {

        // Variavel para armazenar frase alterada temporariamente
        char[] fraseTemporaria = new char[frase.length()];
        char letraAleatoria_1;
        char letraAleatoria_2;
        String fraseFinal;

        // Sorteando letras aleatorias para alteracao de string
        letraAleatoria_1 = ((char) ('a' + Math.abs(gerador.nextInt() % 26)));
        letraAleatoria_2 = ((char) ('a' + Math.abs(gerador.nextInt() % 26)));

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letraAleatoria_1) {
                // Trocando letras na string
                fraseTemporaria[i] = letraAleatoria_2;
            }

            else {
                // Mantendo a string caso nao seja a letra sorteada
                fraseTemporaria[i] = frase.charAt(i);
            }
        }

        fraseFinal = new String(fraseTemporaria);
        // Retornando string ja alterada
        return fraseFinal;
    }
}