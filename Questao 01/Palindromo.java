class Palindromo {
    // Verificar se a entrada eh um palindromo
    public static boolean ehPalindromo(String entrada) {
        int i = 0;
        int j = entrada.length() - 1;
        boolean ehPalindromo = true;

        while (ehPalindromo && i < entrada.length() / 2) {
            if (entrada.charAt(i) != entrada.charAt(j)) {
                // Caso as letras forem diferentes, nao é palindromo
                ehPalindromo = false;
            }

            else {
                // Caso as letras forem iguais, continuar a comparacao com as proximas
                i++;
                j--;
            }
        }

        return ehPalindromo;
    }

    // Verificar se a entrada eh FIM
    public static boolean ehFIM(String entrada) {
        return (entrada.length() >= 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I'
                && entrada.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        String[] entradas = new String[1000];
        int totalEntradas = 0;

        // Ler as entradas ate FIM
        do {
            entradas[totalEntradas] = MyIO.readLine();
        } while (!ehFIM(entradas[totalEntradas++]));

        // Desconsiderar a entrada FIM
        totalEntradas--;

        for (int i = 0; i < totalEntradas; i++) {
            if (ehPalindromo(entradas[i])) {
                MyIO.println("SIM");
            }

            else {
                MyIO.println("NAO");
            }
        }
    }
}