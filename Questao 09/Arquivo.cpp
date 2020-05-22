#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void escreverReal(double numeroReal){
    char numeroRealTemporario[10];
    char numeroRealSimples[10];
    bool findPoint = false;
    int pointPosicion;
    int i, j;
    int lastCaractere = 0;

    //Transformar o numero real recebido em um vetor de caracteres
    sprintf(numeroRealTemporario, "%.3lf", numeroReal);

    i = 0;

    while(!findPoint && i < strlen(numeroRealTemporario)){
        //Verificar se o caractere e o ponto
        if(numeroRealTemporario[i] == '.'){
            findPoint = true;
            pointPosicion = i;
        }else{
            i++;
        }
    }

    for(int i = 0; i <= pointPosicion; i++){
        //Criar novo vetor do caracteres
        numeroRealSimples[i] = numeroRealTemporario[i];
    }

    j = pointPosicion + 1;

    //Verificar ate onde podera ser simplificado o vetor de caracteres

    if(numeroRealTemporario[j+2] != '0'){
        numeroRealSimples[j] = numeroRealTemporario[j];
        numeroRealSimples[j+1] = numeroRealTemporario[j+1];
        numeroRealSimples[j+2] = numeroRealTemporario[j+2];
        lastCaractere = j +2;
    
    } else if (numeroRealTemporario[j+1] != '0') {
        numeroRealSimples[j] = numeroRealTemporario[j];
        numeroRealSimples[j+1] = numeroRealTemporario[j+1];
        lastCaractere = j + 1;
    
    } else if(numeroRealTemporario[j] != '0') {
        numeroRealSimples[j] = numeroRealTemporario[j];
        lastCaractere = j;
    }

    for (int i = 0; i <= lastCaractere; i++){
        //Escrever vetor ate ultimo caractere
        printf("%c", numeroRealSimples[i]);
    }

    printf("\n\n");
}

int main() {
    int totalNumReais;
    double numRealTemporario;
    double numerosReais;
    FILE *numeros;
    int j;

    //Ler total de numeros reais
    scanf("%d", &totalNumReais);

    //Abrir arquivo txt
    numeros = fopen("NumerosReais_2.txt", "wb");

    for(int i = 0; i < totalNumReais; i++){
        //Ler numero
        scanf("%lf", &numRealTemporario);

        //Armezenar numero no arquivo txt
        fwrite(&numRealTemporario, sizeof(double),1,numeros);
    }

    //Fechar arquivo txt
    fclose(numeros);

    //Abrir arquivo para leitura 
    numeros = fopen("NumeroReais_2.txt", "rb");

    j = totalNumReais -1;

    //Cada numero real ocupa 8 bytes, assim deve-se busca-los por meio da
    //posicao em que eles se localizam no arquivo

    for(int i = 0; i < totalNumReais; i++){
        //Buscar numero
        fseek(numeros, sizeof(double) * j, SEEK_SET);

        //Ler o numero do arquivo txt
        fread(&numerosReais, sizeof(double), 1, numeros);

        //Verificar se o numero pode ser um inteiro
        if(numerosReais != (int)numerosReais) {
            //Escrever real
            escreverReal(numerosReais);
        } else {
            //Escrever inteiro
            printf("%d\n", (int)numerosReais);
        }

        j--;
    }

    //Fechar arquivo txt
    fclose(numeros);

    return 0;
}
