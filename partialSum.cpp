/*  Given a sequence of elements and asked about the sum of part of its elements(without any modifying queries)
*  Algorithm:
*   1. Build an array in such a way that a[i] contains sum of all elements from 0 to i.
*   2. So for a given range(l,r) sum of parts = a[r] - a[l] 
*  Input :
*   First line contains number of queries and elements in sequence
*   Second line contains elements of the sequence
*   Subsequent line contains l,r(1<= l < r <= N)
*   5 6
*   1 2 3 4 5 6
*   1 6 
*   2 4 
*   2 3 
*   3 4 
*   3 6 
*  Output :
*   print respective sum after each query
*/

#include<iostream>
int main(){
    int N,*Arr,*sumArr,query,i,l,r;
    std::cin >> query;
    std::cin >> N;
    Arr = new int[N];
    sumArr = new int[N];
    for(i=0;i<N;i++){
        std::cin >> Arr[i];
        sumArr[i] = 0;
        if(i==0)
            sumArr[i] = Arr[i];
        else
            sumArr[i] = Arr[i] + sumArr[i-1];
    }
    while(query--){
        std::cin >> l >> r;
        if( (l == 1 && r == N) || l==1)
            std::cout << sumArr[r-1] << std::endl;
        else
            std::cout << sumArr[r-1]-sumArr[l-2] << std::endl;
    }
    delete[] Arr;
    delete[] sumArr;
    return 0;
}
