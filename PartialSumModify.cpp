/*
* Given a sequence a1,a2,..an and a set of queries (l,r) and value v for each i such that l<=i<=r increase ai by v and print the final output
* after performing all queries
*  Algorithm :
*   1. create a seperate array p of length n and initialise to 0.
*   2. increase p[l] by v and decrease p[r+1] by v and keep on doing for all queries
*   3. for i>1 perform p[i] = p[i]+p[i-1];
*   4. the final output is a1+p1,a2+p2,...,an+pn
*  Input :
*   First line contains number of queries and elements in sequence
*   Second line contains elements of the sequence
*   Subsequent line contains l,r and v  (1<= l < r <= N)
*   5 6
*   1 2 3 4 5 6
*   1 6 1
*   2 4 5
*   2 3 6
*   3 4 2
*   3 6 1
*  Output :
*   the final sequence after executing all queries
*/

#include<iostream>
int main(){
    int query,i,*Arr,*sumArr,N,l,r,v;
    std::cin >> query >> N;
    Arr = new int[N];
    sumArr = new int[N];
    for(i=0;i<N;i++){
        std::cin >> Arr[i];
        sumArr[i] = 0;
    }
    while(query--){
        std::cin >> l >> r >> v;
        sumArr[l-1] += v;
        if(r!=N)
            sumArr[r] -= v;
    }
    for(i=1;i<N;i++)
        sumArr[i] += sumArr[i-1];
    for(i=0;i<N;i++)
        std::cout << sumArr[i]+Arr[i] << "  " ;
    std::cout << '\n';
    delete[] Arr;
    delete[] sumArr;
    return 0;
}

