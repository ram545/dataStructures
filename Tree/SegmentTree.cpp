#include<iostream>
#include<limits>
#include<algorithm>
using namespace std;

struct tree{
    int val;
    struct tree *left;
    struct tree *right;
};

struct tree *consTree(){
    tree *node = new tree;
    node->val=999999;
    node->left=NULL;
    node->right=NULL;
};


struct tree *constSegTree(int arr[],int low,int high){
    if(low==high){
        struct tree *node = consTree();
        node->val=arr[low];
        return node;
    }
    int mid=(low+high)/2;
    struct tree *node = consTree();
    node->left=constSegTree(arr,low,mid);
    node->right=constSegTree(arr,mid+1,high);
    node->val=min(node->left->val,node->right->val);
    return node;
};

void display(struct tree* node){
    struct tree *temp=node;
    if(node){
       display(node->left);
       cout << node->val << endl;
       display(node->right);
    }
}

bool isLeaf(struct tree *node){
    return (node->right==NULL && node->left==NULL);
}

void destroyTree(struct tree* node){
    if(isLeaf(node))
        delete node;
    else{
        if(node->right)
            destroyTree(node->right);
        if(node->left)
            destroyTree(node->left);
        delete node;
    }
}

int rangeQuery(struct tree *node,int l,int r,int low,int high){
    if(l<=low && high<=r){
        return node->val;
    }
    else if(l>high || r<low)
        return 999999;
    else{
        int mid=(high+low)/2;
        return min(rangeQuery(node->left,l,r,low,mid),rangeQuery(node->right,l,r,mid+1,high));
    }
}

int main(){
    struct tree *segTree=NULL;
    int N=6,arr[]={1,0,3,-1,2,4};
    segTree=constSegTree(arr,0,N-1);
    display(segTree);
    cout << "Range Query Start" << endl;
    cout << rangeQuery(segTree,2,4,0,N-1) << endl;
    cout << rangeQuery(segTree,0,2,0,N-1) << endl;
    cout << rangeQuery(segTree,2,5,0,N-1) << endl;
    destroyTree(segTree);
    return 0;
}
