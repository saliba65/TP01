#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool verificarPalindromo(char palavra[], int i, int j)
{
    bool ehPalindromo = true;

    //Verificar se o contador corresponde ao tamanho da entrada
    if (i == (strlen(palavra) / 2))
    {
        ehPalindromo = true;
        //Verificar se o caractere 'i' é diferente ao 'j'
    }
    else if (palavra[i] != palavra[j])
    {
        ehPalindromo = false;
    }
    else
    {
        ehPalindromo = verificarPalindromo(palavra, (i + 1), (j - 1));
    }

    return ehPalindromo;
}

bool verificarPalindromo(char palavra[])
{
    //Inicializar os contadores da função recursiva como '0'
    return verificarPalindromo(palavra, 0, (strlen(palavra) - 2));
}

bool ehFIM(char palavra[])
{
    //Verificar se a entrada e "FIM"
    return (strlen(palavra) >= 3 && palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M');
}

int main()
{
    char palavras[1000][1000];
    int totalEntradas = 0;

    //Ler ate "FIM"
    do
    {
        fgets(palavras[totalEntradas], 1000, stdin);
    } while (!ehFIM(palavras[totalEntradas++]));

    //Desconsiderar a entrada "FIM"
    totalEntradas--;

    for (int i = 0; i < totalEntradas; i++)
    {
        //Escrever se a entrada é um palíndromo ou não
        if (verificarPalindromo(palavras[i]))
        {
            printf("SIM\n");
        }

        else
        {
            printf("NAO\n");
        }
    }

    return 0;
}