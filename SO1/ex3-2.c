#include <pthread.h>
#include <stdio.h>
#include <math.h>
#define N 2

int x = N/2;

void *somaRaiz(void* unused)
{
    double raiz = 0;
    for(int i = 1; i < x; i++)
    {
        raiz = raiz + sqrt(i);
    }   
    
    pthread_exit(&raiz);
   

}

void *somaRaiz2(void* unused)
{
    double raiz2 = 0;
    for(int i = x ; i <= N; i++)
    {
        raiz2 = raiz2 + sqrt(i);
    }   
    
    pthread_exit(&raiz2);
   
}


int main()
{   
    void *x;
    void *y;


    pthread_t thread_id;
    pthread_t  thread_id2;

    pthread_create (&thread_id, NULL, &somaRaiz, NULL);
    pthread_create (&thread_id2, NULL, &somaRaiz2, NULL);
    
    pthread_join(thread_id, &x);
    pthread_join(thread_id2, &y);
 
    printf("%lf\n",*(double*)x + *(double*)y);

    return 0;

}