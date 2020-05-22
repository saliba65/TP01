class Ciframento_de_Cesar_Recursivo {

    public static String escreverMensagemCriptografada(String entrada, int i) {
        String mensagemCriptografada = "";

        // Verificar se o contador 'i' é igual ao tamanho da entrada
        if (i == entrada.length()) {
            mensagemCriptografada += "";
        } else {
            // Somar à mensagem final a entrada + 3
            mensagemCriptografada += (char) (entrada.charAt(i) + 3) + escreverMensagemCriptografada(entrada, i + 1);
        }

        return mensagemCriptografada;
    }

    public static String escreverMensagemCriptografada(String entrada) {
        // Inicializar o contador 'i' como '0' para a função recursiva
        return escreverMensagemCriptografada(entrada, 0);
    }

    public static boolean ehFIM(String entrada) {
        // Verificar se a entrada é "FIM"
        return (entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I'
                && entrada.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        String[] entradas = new String[1000];
        int totalEntradas = 0;

        // Ler ate "FIM"
        do {
            entradas[totalEntradas] = MyIO.readLine();
        } while (!ehFIM(entradas[totalEntradas++]));

        // Desconsiderar a entrada "FIM"
        totalEntradas--;

        for (int i = 0; i < totalEntradas; i++) {
            // Escrever a mensagem final
            MyIO.println(escreverMensagemCriptografada(entradas[i]));
        }
    }
}