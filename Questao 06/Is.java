class Is {
    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int totalEntrada = 0;

        // Ler as entradas ate "FIM"
        do {
            entrada[totalEntrada] = MyIO.readLine();
        } while (!ehFIM(entrada[totalEntrada++]));

        // Desconsiderar a entrada "FIM"
        totalEntrada--;

        for (int i = 0; i < totalEntrada; i++) {
            // Verificar se a entrada é composta apenas por letras e apenas por vogais
            if (soLetra(entrada[i]) && soVogal(entrada[i])) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }

            // Verificar se a entrada é composta apenas por letras e apenas por consoantes
            if (soLetra(entrada[i]) && soConsoante(entrada[i])) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }

            // Verificar se a entrada é um número e ele é inteiro
            if (soNumero(entrada[i]) && inteiro(entrada[i])) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }

            // Verificar se a entrada é um número e ele é real
            if (soNumero(entrada[i]) && real(entrada[i])) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
        }
    }

    public static boolean ehFIM(String entrada) {
        // Verificar se a entrada é "FIM"
        return (entrada.length() >= 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I'
                && entrada.charAt(2) == 'M');
    }

    public static boolean pontoOuVirgula(char num) {
        // Verificar se o caractere é uma vírgula ou um ponto
        return (num == ',' || num == '.');
    }

    public static boolean real(String entrada) {
        boolean ehReal = true;
        int i = 0;
        int contadorVirgulaOuPonto = 0;

        while (ehReal && i < entrada.length()) {
            // Verificar se a entrada possui uma vírgula ou um ponto, indicando que ele é
            // real
            if (pontoOuVirgula(entrada.charAt(i))) {
                contadorVirgulaOuPonto++;
            }

            // Verificar se a entrada possui apenas uma vírgula ou um ponto, indicando que
            // ele é um número
            if (contadorVirgulaOuPonto > 1) {
                ehReal = false;
            } else {
                i++;
            }
        }

        return ehReal;
    }

    public static boolean inteiro(String entrada) {
        boolean ehInteiro = true;
        int i = 0;

        while (ehInteiro && i < entrada.length()) {
            // Verificar se a entrada possui uma vírgula ou um ponto, indicando que ele não
            // é inteiro
            if (pontoOuVirgula(entrada.charAt(i))) {
                ehInteiro = false;
            } else {
                i++;
            }
        }

        return ehInteiro;
    }

    public static boolean ehLetra(char letra) {
        // Verificar se o caractere é uma letra
        return ((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'Z'));
    }

    public static boolean soNumero(String entrada) {
        boolean ehApenasNumero = true;
        int i = 0;

        while (ehApenasNumero && i < entrada.length()) {
            // Verificar se a entrada possui alguma letra, indicando que a entrada não
            // possui apenas números
            if (ehLetra(entrada.charAt(i))) {
                ehApenasNumero = false;
            } else {
                i++;
            }
        }

        return ehApenasNumero;
    }

    public static boolean soLetra(String entrada) {
        boolean ehApenasLetra = true;
        int i = 0;

        while (ehApenasLetra && i < entrada.length()) {
            // Verificar se o caractere não é uma letra, indicando que a entrada não possui
            // apenas letras
            if (!ehLetra(entrada.charAt(i))) {
                ehApenasLetra = false;
            } else {
                i++;
            }
        }

        return ehApenasLetra;
    }

    public static boolean ehVogal(char letra) {
        boolean ehVogal = false;
        int i = 0;
        char[] vogal = { 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' };

        while (!ehVogal && i < 10) {
            // Verificar se o caractere é uma vogal
            if (letra == vogal[i]) {
                ehVogal = true;
            } else {
                i++;
            }
        }

        return ehVogal;
    }

    public static boolean soConsoante(String entrada) {
        boolean ehApenasConsoante = true;
        int i = 0;

        while (ehApenasConsoante && i < entrada.length()) {
            // Verificar se o caractere é uma vogal, indicando que a entrada não possui
            // apenas consoantes
            if (ehVogal(entrada.charAt(i))) {
                ehApenasConsoante = false;
            } else {
                i++;
            }
        }

        return ehApenasConsoante;
    }

    public static boolean soVogal(String entrada) {
        boolean ehApenasVogal = true;
        int i = 0;

        while (ehApenasVogal && i < entrada.length()) {
            // Verificar se o caractere não é uma vogal, indicando que a entrada não possui
            // apenas vogais
            if (!ehVogal(entrada.charAt(i))) {
                ehApenasVogal = false;
            } else {
                i++;
            }
        }

        return ehApenasVogal;
    }
}
