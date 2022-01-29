#include <stdio.h>

void swap(int* a, int* b) {
    *b = *a - *b;
    *a = -(*b - *a);
    *b += *a;
}

int main() {
    int c=0;
    scanf("%d", &c);
    int * array = (int*) malloc(c * sizeof(int));
    for(int i=0;i<c;i++) {
        scanf("%x", &array[i]);
    }
    
    for(int j=0;j<c;j++) {
        for(int k=j;k<c;k++) {
            if(array[j] > array[k])
                swap(&array[j], &array[k]);
        }
    }
    
    for(int i=0;i<c;i++) {
        printf("%x ", array[i]);
    }
    
    return 0;
}
