//Importando bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

//Verificar se a entrada eh um palindromo
bool ehPalindromo(char entrada[])
{
    int i = 0;
    int j = strlen(entrada) - 2;
    bool ehPalindromo = true;

    while (ehPalindromo && i < strlen(entrada) / 2)
    {
        //Comparar primeiras e ultimas letras da string
        if (entrada[i] != entrada[j])
        {
            //Interromper comparacao caso, as primeiras letras nao sejam iguais
            ehPalindromo = false;
        }

        else
        {
            //Comparar demais letras, caso as anteriores sejam iguais
            i++;
            j--;
        }
    }

    return ehPalindromo;
}

//Verificar se a entrada eh FIM
bool ehFIM(char entrada[])
{
    return (strlen(entrada) >= 3 && entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M');
}

int main()
{
    //Ler array de char, ja que nao existe string em C
    char entradas[1000][1000];
    int totalEntradas = 0;

    //Ler as entradas ate FIM
    do
    {
        fgets(entradas[totalEntradas], 1000, stdin);
    } while (!ehFIM(entradas[totalEntradas++]));

    //Desconsiderar a entrada FIM
    totalEntradas--;

    for (int i = 0; i < totalEntradas; i++)
    {
        if (ehPalindromo(entradas[i]))
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