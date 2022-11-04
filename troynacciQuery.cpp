Problem Description : https://codeforces.com/gym/100571/problem/B

#include<iostream>
#define mod 1000000007

int main(){
    long long int query,N,a,b,i,l,r,j;
    std::cin >> query >> N;
    long long int Arr[N],series[N+2],p[N+2];
    std::cin >> series[0] >> series[1];
    std::cin >> a >> b;
    for(i=0;i<N;i++){
        std::cin >> Arr[i];
        p[i] = 0;
    }
    p[i] = 0;
    p[i+1] = 0;
    for(i=2;i<N+2;i++)
        series[i] = (1LL*a*series[i-2] + 1LL*b*series[i-1])%mod;
    while(query--){
        std::cin >> l >> r;
        l--;
        r--;
        if(l<r){
            p[l] = (p[l]+series[0])%mod;
            p[l+1] = (p[l+1] + series[1])%mod;
            p[l+1] = (1LL*p[l+1] + mod - ((1LL*b*series[1])%mod))%mod;
            p[r+1] = (1LL*p[r+1] + mod - series[r-l+1])%mod;
            p[r+2] = (1LL*p[r+2] + mod - ((1LL*a*series[r-l])%mod))%mod;
        }
        else{
            p[l] = (p[l]+series[0])%mod;
            p[r+1] = (1LL*p[r+1] + mod - ((1LL*b*series[0])%mod))%mod;
            p[r+2] = (1LL*p[r+2] + mod - ((1LL*a*series[0])%mod))%mod;
        }
    }
    Arr[0] = (Arr[0]+p[0])%mod;
    for(i=1;i<N;i++){
        if(i==1)
            p[i] = (1LL*p[i] + (1LL*a*p[i-1])%mod)%mod;
        else
            p[i] = ((1LL*p[i-2]*a)%mod + (1LL*b*p[i-1])%mod + 1LL*p[i])%mod;
        Arr[i] = (p[i]+Arr[i])%mod;
    }
    for(i=0;i<N;i++)
        std::cout << Arr[i] << " ";
    std::cout << std::endl;
}

/*
6 6
1 1
1 1
0 0 0 0 0 0
1 6
1 1
4 5
2 2
4 4
5 6
*/



