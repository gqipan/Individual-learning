#include <stdio.h>
#include <malloc.h>

void func(int n);

int main()
{  
    printf("begin...\n");
    
    printf("func(1)\n");
    
    func(1);
    
    printf("func(-1)\n");
    
    func(-1); //发生段错误
    
    printf("end...\n");
    
    return 0;
}


void func(int n)
{
    int* p = NULL;

    if(  n < 0 )
    {
        goto STATUS; /
    }

    p = (int*)malloc(sizeof(int) * n);
    
STATUS:
    p[0] = n;   //如果是goto过来的，没有申请内存就去使用内存并且释放内存 
    
    free(p);	//段错误
}