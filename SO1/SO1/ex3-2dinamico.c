#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <pthread.h>

#define MAX 100000000
#define NUMTHREADS 2

typedef struct tdata
{
	int tid;
	long double result;
}tdata;

void *sumsqrt(void *data)
{
  int i;
  long double *sum = (long double *) malloc (sizeof (long double));
  
  *sum = 0;
  
  int start = * (int *) data; /* cast do arg para int e desreferenciação */

  for (i = start + 1; i <= MAX; i += NUMTHREADS) {
    *sum = *sum + sqrtl(i);
  }

  pthread_exit((void *) sum); /* devolve o somatório, para o _join() */
}


int main()
{
  int i, s;
  struct tdata *ARGS[NUMTHREADS];
  pthread_t TH[NUMTHREADS];

  void *res;

  long double TOTAL = 0;
  
  for (i = 0; i < NUMTHREADS; i++) {
    ARGS[i] = (struct tdata *) malloc (sizeof (struct tdata));

    ARGS[i]->tid = i;

    s = pthread_create(&TH[i], NULL, &sumsqrt, ARGS[i]);
    
    if (s != 0) { printf ("Error creating thread %d!\n", i); }
  }

  for (i = 0; i < NUMTHREADS; i++) {
    pthread_join(TH[i], &res);

    //printf("T-%d: %Lf\n", i, *(long double *) res);
    TOTAL = TOTAL + *(long double *) res;
    free(ARGS[i]);
  }

  printf("TOTAL: %Lf\n", TOTAL);
  
}
