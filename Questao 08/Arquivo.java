import java.io.RandomAccessFile;

class Arquivo {
    public static void main(String[] args) throws Exception {
        int quantidadeReais;
        double numeroReal;
        RandomAccessFile rAF;
        long k = 0;

        // Ler a qauntidade de numeros reais a serem digitados
        quantidadeReais = MyIO.readInt();

        // Abrir o arquivo txt
        rAF = new RandomAccessFile("NumerosReais_1.txt", "rw");

        for (int i = 0; i < quantidadeReais; i++) {
            // Ler um número real
            numeroReal = MyIO.readDouble();

            // Armazenar o número lido no arquivo txt
            rAF.writeDouble(numeroReal);
        }

        // Fechar o arquivo txt para escrita
        rAF.close();

        // Abrir o arquivo txt para leitura
        rAF = new RandomAccessFile("NumerosReais_1.txt", "r");

        // Cada numero real vai ocupar no max 8 bytes
        // Entao, o primeiro numero vai se encontrar entre as posicoes '0' e '7', o
        // segundo entre '8' e '15' e assim por diante...
        k = (quantidadeReais - 1) * 8;

        for (int i = 0; i < quantidadeReais; i++) {
            // Buscar a primeira posição do número real
            rAF.seek(k);
            // atribuindo o numero lido do arquivo na variavel
            numeroReal = rAF.readDouble();

            // Verificar se a forma real do número é igual a inteira
            if (numeroReal != (int) numeroReal) {
                // Escrever o número real
                MyIO.println(numeroReal);
            } else {
                // Escrever o número inteiro
                MyIO.println((int) numeroReal);
            }

            // Subtrair 8 bytes do número total de bytes para leitura do proximo numero
            k -= 8;
        }

        // Fechar o arquivo de txt
        rAF.close();
    }
}