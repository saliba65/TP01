class PalindromoRecursivo {

    public static void main(String[] args) {
        String[] palavra = new String[1000];
        int totalEntradas = 0;

        // Ler as entradas ate "FIM"
        do {
            palavra[totalEntradas] = MyIO.readLine();
        } while (!ehFIM(palavra[totalEntradas++]));

        // Desconsiderar entrada "FIM"
        totalEntradas--;

        for (int i = 0; i < totalEntradas; i++) {
            // Escrever resultado
            if (ehPalindromo(palavra[i])) {
                MyIO.println("SIM");
            }

            else {
                MyIO.println("NAO");
            }
        }
    }

    public static boolean ehPalindromo(String palavra, int i, int j) {
        boolean ehPalindromo = true;

        // Verificar se o contador corresponde ao tamanho da entrada
        if (i == palavra.length() / 2) {
            ehPalindromo = true;

            // Verificar se o caractere i e diferente do j, fim de recursividade

        } else if (palavra.charAt(i) != palavra.charAt(j)) {
            ehPalindromo = false;
        } else {
            ehPalindromo = ehPalindromo(palavra, i + 1, j - 1);
        }

        return ehPalindromo;
    }

    public static boolean ehPalindromo(String palavra) {
        // Inicializar os contadores da funcao como 0
        return ehPalindromo(palavra, 0, palavra.length() - 1);
    }

    public static boolean ehFIM(String palavra) {
        // Verificar se a entrada e 'FIM'
        return (palavra.length() >= 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I'
                && palavra.charAt(2) == 'M');
    }

}