class IsRecursivo {
    public static boolean ehVirgulaOuPonto(char letra) {

        // Verificar se um caractere é uma vírgula ou um ponto
        return (letra == ',' || letra == '.');
    }

    public static int contarVirgulaOuPonto(String entrada, int i) {
        int contadorVirgulaOuPonto = 0;

        // Verificar se o contador 'i' é igual ao tamanho da entrada
        if (i == entrada.length()) {
            contadorVirgulaOuPonto += 0;
            // Verificar se um caractere é uma vírgula ou um ponto
        } else if (ehVirgulaOuPonto(entrada.charAt(i))) {
            contadorVirgulaOuPonto += 1 + contarVirgulaOuPonto(entrada, i + 1);
        } else {
            contadorVirgulaOuPonto += contarVirgulaOuPonto(entrada, i + 1);
        }

        return contadorVirgulaOuPonto;
    }

    public static int contarVirgulaOuPonto(String entrada) {
        // Inicializar o contador como 0
        return contarVirgulaOuPonto(entrada, 0);
    }

    public static boolean ehReal(String entrada) {
        boolean ehReal = false;

        // Verificar se o contador de vírgula ou ponto é menor ou igual à 1, indicando
        // que o número é real
        if (contarVirgulaOuPonto(entrada) <= 1) {
            ehReal = true;
        }

        return ehReal;
    }

    public static boolean ehInteiro(String entrada, int i) {
        boolean ehInteiro = true;

        // Verificar se o contador 'i' é igual ao tamanho da entrada
        if (i == entrada.length()) {
            ehInteiro = true;
            // Verificar se um caractere é uma vírgula ou um ponto
        } else if (ehVirgulaOuPonto(entrada.charAt(i))) {
            ehInteiro = false;
        } else {
            ehInteiro = ehInteiro(entrada, i + 1);
        }

        return ehInteiro;
    }

    public static boolean ehInteiro(String entrada) {
        // Inicializar o contador como 0
        return ehInteiro(entrada, 0);
    }

    public static boolean ehLetra(char letra) {
        // Verificar se um caractere é uma letra
        return ((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'Z'));
    }

    public static boolean ehApenasNumero(String entrada, int i) {
        boolean ehApenasNumero = true;

        // Verificar se o contador 'i' é igual ao tamanho da entrada
        if (i == entrada.length()) {
            ehApenasNumero = true;
            // Verificar se um caractere é uma letra
        } else if (ehLetra(entrada.charAt(i))) {
            ehApenasNumero = false;
        } else {
            ehApenasNumero = ehApenasNumero(entrada, i + 1);
        }

        return ehApenasNumero;
    }

    public static boolean ehApenasNumero(String entrada) {
        // Inicializar o contador como 0
        return ehApenasNumero(entrada, 0);
    }

    public static boolean ehVogal(char letra, int i) {
        boolean ehVogal = false;
        char[] vogais = { 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' };

        // Verificar se o contador 'i' é igual ao tamanho do arranjo de vogais
        if (i == vogais.length) {
            ehVogal = false;
            // Verificar se um caractere é uma vogal
        } else if (letra == vogais[i]) {
            ehVogal = true;
        } else {
            ehVogal = ehVogal(letra, i + 1);
        }

        return ehVogal;
    }

    public static boolean ehVogal(char letra) {
        // Inicializar o contador como 0
        return ehVogal(letra, 0);
    }

    public static boolean ehApenasConsoante(String entrada, int i) {
        boolean ehApenasConsoante = true;

        // Verificar se o contador 'i' é igual ao tamanho da entrada
        if (i == entrada.length()) {
            ehApenasConsoante = true;
            // Verificar se um caractere é uma vogal
        } else if (ehVogal(entrada.charAt(i))) {
            ehApenasConsoante = false;
        } else {
            ehApenasConsoante = ehApenasConsoante(entrada, i + 1);
        }

        return ehApenasConsoante;
    }

    public static boolean ehApenasConsoante(String entrada) {
        // Inicializar o contador como 0, para uso na função recursiva
        return ehApenasConsoante(entrada, 0);
    }

    public static boolean ehApenasVogal(String entrada, int i) {
        boolean ehApenasVogal = true;

        // Verificar se o contador 'i' é igual ao tamanho da entrada
        if (i == entrada.length()) {
            ehApenasVogal = true;
            // Verificar se um caractere não é uma vogal
        } else if (!ehVogal(entrada.charAt(i))) {
            ehApenasVogal = false;
        } else {
            ehApenasVogal = ehApenasVogal(entrada, i + 1);
        }

        return ehApenasVogal;
    }

    public static boolean ehApenasVogal(String entrada) {
        // Inicializar o contador como 0, para uso na função recursiva
        return ehApenasVogal(entrada, 0);
    }

    public static boolean ehApenasLetra(String entrada, int i) {
        boolean ehApenasLetra = true;

        // Verificar se o contador 'i' é igual ao tamanho da entrada
        if (i == entrada.length()) {
            ehApenasLetra = true;
            // Verificar se um caractere não é uma letra
        } else if (!ehLetra(entrada.charAt(i))) {
            ehApenasLetra = false;
        } else {
            ehApenasLetra = ehApenasLetra(entrada, i + 1);
        }

        return ehApenasLetra;
    }

    public static boolean ehApenasLetra(String entrada) {
        // Inicializar o contador como 0, para uso na função recursiva
        return ehApenasLetra(entrada, 0);
    }

    public static boolean ehFIM(String entrada) {
        // Verificar se a entrada e "FIM"
        return (entrada.length() >= 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I'
                && entrada.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int totalEntrada = 0;

        // Ler ate "FIM"
        do {
            entrada[totalEntrada] = MyIO.readLine();
        } while (!ehFIM(entrada[totalEntrada++]));

        // Desconsiderar a entrada "FIM"
        totalEntrada--;

        for (int i = 0; i < totalEntrada; i++) {
            // Verificar se a entrada e composta apenas por letras e apenas por vogais
            if (ehApenasLetra(entrada[i]) && ehApenasVogal(entrada[i])) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }

            // Verificar se a entrada e composta apenas por letras e apenas por consoantes
            if (ehApenasLetra(entrada[i]) && ehApenasConsoante(entrada[i])) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }

            // Verificar se a entrada e um número e ele e inteiro
            if (ehApenasNumero(entrada[i]) && ehInteiro(entrada[i])) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }

            // Verificar se a entrada e um número e ele e real
            if (ehApenasNumero(entrada[i]) && ehReal(entrada[i])) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
        }
    }
}