#include<iostream>
#include<algorithm>
using namespace std;

class node{
    public:
        int val,height;
        node *right,*left;
        node(int value){
            val=value;
            height=0;
        }
};

class tree{
    public:
        node *root;
        int height(node *y){
            if(y==NULL)
                return 0;
            else
                return y->height;
        }
        int getBalance(node *root){
            return height(root->left)-height(root->right);
        }
        node *leftRotate(node *z){
            node *y = z->left;
            node *T2 = y->right;

            y->right=z;
            z->left=T2;

            z->height=max(height(z->left),height(z->right))+1;
            y->height=max(height(y->left),height(y->right))+1;

            return y;
        }
        node *rightRotate(node *z){
            node *y = z->right;
            node *T4 = y->left;

            y->left=z;
            z->right=T4;

            z->height=max(height(z->left),height(z->right))+1;
            y->height=max(height(y->left),height(y->right))+1;

            return y;
        }
        node *insert(node *root,int val){
            int balance;
            if(root==NULL)
                return (new node(val));
            else if(root->val>val)
                root->right=insert(root->right,val);
            else
                root->left=insert(root->left,val);
            root->height=max(height(root->left),height(root->right))+1;
            balance=getBalance(root);
            if(balance>1 && root->left->val>val)
                return leftRotate(root);
            else if(balance<-1 && root->left->val<val){
                root->right=rightRotate(root->right);
                return leftRotate(root);
            }
            else if(balance<-1 && root->right->val<val)
                return rightRotate(root);
            else{
                root->left=leftRotate(root->left);
                return leftRotate(root);
            }
        }
};

void inorder(node *tree){
    if(tree){
        inorder(tree->left);
        cout << tree->val << endl;
        inorder(tree->right);
    }
}

int main(){
    tree AvlTree;
    AvlTree.root=AvlTree.insert(AvlTree.root,10);
    AvlTree.root=AvlTree.insert(AvlTree.root,20);
    AvlTree.root=AvlTree.insert(AvlTree.root,30);
    AvlTree.root=AvlTree.insert(AvlTree.root,40);
    AvlTree.root=AvlTree.insert(AvlTree.root,50);
    AvlTree.root=AvlTree.insert(AvlTree.root,60);
    AvlTree.root=AvlTree.insert(AvlTree.root,70);
    AvlTree.root=AvlTree.insert(AvlTree.root,80);
    inorder(AvlTree.root);
    return 0;
}
