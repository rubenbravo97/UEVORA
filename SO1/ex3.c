#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int fatorial_rec(int n)
{
    pid_t pid; 
    pid= fork();
    int temp=1;


    if (pid == 0 && n!= 1) 
    {
        return  n* fatorial_rec(n-1); 
    }

    else if (n==1)
    {
        return temp;
    }
    
    
    return 1;

}

void main(void)
{
    int n;
    scanf("%d", &n);
    fatorial_rec(n);
    printf("O fatorial de %d é %d\n", n,fatorial_rec(n));
}

