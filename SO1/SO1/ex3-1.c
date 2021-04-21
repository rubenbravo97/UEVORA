#include <stdio.h>
#include <math.h>
#define N 10000000

void somaRaiz(double n)
{
    double raiz = 0;

    for(int i = 1; i <= n; i++)
    {
        raiz = raiz + sqrt(i);
    }
    
    printf("A soma das raizes quadradas é: %lf\n", raiz);

}


int main()
{   
    somaRaiz(N);

    return 0;

}