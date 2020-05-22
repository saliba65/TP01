import java.util.Random;

class AlteracaoAleatoriaRecursiva {

    public static String escreverFraseAlterada(String entrada, Random gerador, char letraAleatoria_1,
            char letraAleatoria_2, int i) {
        String fraseAlterada = "";

        // Verificar se o contador 'i' é igual ao tamanho da entrada
        if (i == entrada.length()) {
            fraseAlterada += "";
            // Verificar se um caractere da entrada é igual à primeira letra gerada
        } else if (entrada.charAt(i) == letraAleatoria_1) {
            // Substituir o primeiro caractere gerado pelo segundo na frase alterada
            fraseAlterada += letraAleatoria_2
                    + escreverFraseAlterada(entrada, gerador, letraAleatoria_1, letraAleatoria_2, i + 1);
        } else {
            // Somar um caractere da entrada à frase alterada
            fraseAlterada += entrada.charAt(i)
                    + escreverFraseAlterada(entrada, gerador, letraAleatoria_1, letraAleatoria_2, i + 1);
        }

        return fraseAlterada;
    }

    public static String escreverFraseAlterada(String entrada, Random gerador) {
        // Gerar 2 letras aleatórias para trocar a primeira pela segunda
        char letraAleatoria_1 = (char) ('a' + Math.abs(gerador.nextInt() % 26));
        char letraAleatoria_2 = (char) ('a' + Math.abs(gerador.nextInt() % 26));

        // Inicializar o contador 'i' como 0
        return escreverFraseAlterada(entrada, gerador, letraAleatoria_1, letraAleatoria_2, 0);
    }

    public static boolean ehFIM(String entrada) {
        // Verificar se a entrada e "FIM"
        return (entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I'
                && entrada.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        String[] entradas = new String[1000];
        int totalEntradas = 0;
        Random gerador = new Random();

        // Definir a semente do gerador aleatório
        gerador.setSeed(4);

        // Ler ate "FIM"
        do {
            entradas[totalEntradas] = MyIO.readLine();
        } while (!ehFIM(entradas[totalEntradas++]));

        // Desconsiderar a entrada "FIM"
        totalEntradas--;

        for (int i = 0; i < totalEntradas; i++) {
            // Escrever a frase alterada final
            MyIO.println(escreverFraseAlterada(entradas[i], gerador));
        }
    }
}