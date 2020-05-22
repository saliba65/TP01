
class Ciframento_de_Cesar {
    public static void main(String[] args) {

        String[] fraseCodificada = new String[1000];
        int totalEntradas = 0;
        String[] fraseFinal;

        // Ler entradas ate 'FIM'
        do {
            fraseCodificada[totalEntradas] = MyIO.readLine();
        } while (!ehFIM(fraseCodificada[totalEntradas++]));

        // Desconsiderar a entrada FIM
        totalEntradas--;

        for (int i = 0; i < totalEntradas; i++) {
            MyIO.println(criptografada(fraseCodificada[i]));
        }
    }

    // Verificar se a entrada eh 'FIM'
    public static boolean ehFIM(String entrada) {
        return (entrada.length() >= 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I'
                && entrada.charAt(2) == 'M');
    }

    public static String criptografada(String fraseCodificada) {
        // Inicializacao resultado
        String fraseFinal = "";

        for (int i = 0; i < fraseCodificada.length(); i++) {
            // mudando letras da String recebida
            fraseFinal += (char) (fraseCodificada.charAt(i) + 3);
        }
        // retornando resultado
        return fraseFinal;
    }
}
