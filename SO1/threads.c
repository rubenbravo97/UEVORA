#include <pthread.h>
#include <stdio.h>

/* Prints x’s to stderr. The parameter is unused. Does not return. */
void* print_xs (void* unused)
{
    int i = 0;
    while (i < 100 ) 
    {
        fputc ('x', stderr);
        i++;
    }

    return NULL;
}

void* print_os( void* unused)
{   
    int i = 0;
    /* Print o’s continuously to stderr. */
    while (i < 100 ) 
    {
        fputc ('o', stderr);
        i++;
    }

    return NULL;

}

/* The main program. */
int main ()
{
    pthread_t  thread_id;
    /* Create a new thread. The new thread will run the print_xs() function. */
    pthread_create (&thread_id, NULL, &print_xs, NULL);
    
    pthread_t  thread_id2;
    /* Create a new thread. The new thread will run the print_xs() function. */
    pthread_create (&thread_id2, NULL, &print_os, NULL);

    pthread_join(thread_id, NULL);
    pthread_join(thread_id2, NULL);

    return 0;
}