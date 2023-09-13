### Bubble sort
In-place **Bubble Sorting Algorithm** for hexadecimal numbers written in **C**

In-place swap function implementation:
```C
void swap(int* a, int* b) {
  *b = *a - *b;
  *a = -(*b - *a);
  *b += *a;
}
```

Bubble sort algorithm:
```C
for(int j=0; j<c; j++)
  for(int k=j; k<c; k++)
    if(array[j] > array[k])
      swap(&array[j], &array[k]);
```
