package test_bst;



import java.util.*;
import java.lang.*;
import java.io.*;

class node{
    int val;
    node left,right;
    public void node(){
        left=right=null;
    }
};


class bst{
  static node root;
  public void bst(){
      root=null;
  }
  
  
static void insert(int n){
        if(root==null){
            node a=new node();
            a.val=n;
            root=a;
        }
        else{
            node parent=new node();
            parent=root;
            while(true){
                if(n<parent.val&&parent.left!=null){
                    parent=parent.left;
                }
                else if(n<parent.val){
                    node nn=new node();
                    nn.val=n;
                    parent.left=nn;
                    return;
                }
                if(n>parent.val&&parent.right!=null){
                    parent=parent.right;
                }
                else if(n>parent.val){
                    node nn=new node();
                    nn.val=n;
                    parent.right=nn;
                    return;
                }
            }
        }
}  


public static boolean deleteNode(int val){

	if(root==null){
		return false;
	}
	node current=new node();
	node parent=new node();
	parent=current=root;
	boolean isLeftChild=true;
	while(current.val!=val){
		parent=current;
		
		if(val<current.val&&current.left!=null){
			current=current.left;
		}
		else if(val>current.val&&current.right!=null){
			current=current.right;
			isLeftChild=false;
		}
		else{
			return false;
		}
	}

	
	

	//if no child
	
	if(current.left==null&&current.right==null){
		if(current==root)
			root=null;
		current=null;
		if(isLeftChild)
			parent.left=null;
		else
			parent.right=null;
		return true;
	}
	
	//if only 1 child
	if(current.left!=null&&current.right==null||current.left==null&&current.right!=null){
		if(isLeftChild){
			parent.left=current.left;
			current=null;
			return true;
		}
		else{
			parent.right=current.right;
			current=null;
			return true;
		}
	}
	
	
	//if both children
	node successor=null;
		
	if(current.left!=null&&current.right!=null){
		

		successor=getSuccessor(current);
		if(current==root){
			successor.left = current.left;
			root=successor;
			return true;
		}
	}
	if(successor==null){
		root=successor;
		successor.left=current.left;
		return true;
	}
	if(isLeftChild){
		parent.left=successor;
	}
    
    
	else{
		parent.right=successor;
	}
	successor.left=current.left;
	current=null;
	return true;

}

  
public static node getSuccessor(node n){
	
	node parent=null;
	node current=null;
	current=parent=n.right;
	while(current.left!=null){
		parent=current;
		current=current.left;
	}
	if(current!=n.right){
		parent.left=current.right;
		current.right=n.right;
	}
	
	return current;
}




};


 


/* Name of the class has to be "Main" only if the class is public. */
class test_bst
{
	
	public static int depth(node root){
	
		
		if(root==null)
			return 0;
		int lh=depth(root.left);
		int rh=depth(root.right);
		if(lh>rh)
			return lh+1;
		else 
			return rh+1;
	}
	
	
	public static node leftRotate(node root, int val){
		node rootTOReturn=root;
		node current=root;
		node parent=root;
		boolean isLeftChild=true;
		while(current.val!=val){
			parent=current;
			if(val<current.val)    //havent implemented case if val doesnt exist in tree
				current=current.left;
			if(val>current.val){
				current=current.right;
				isLeftChild=false;
			}
		}
		
		if(current==root){
			node temp=root.right;
			root.right=root.right.left;
			temp.left=root;
			root=temp;
			return root;
		}
		node temp=current.right;
		if(isLeftChild){
			parent.left=current.right;
			current.right=current.right.left;
			temp.left=current;
		}
		
		return root;
	}
	
	
	public static node mirror(node root){
		if(root==null)
			return root;
		mirror(root.left);
		mirror(root.right);
		
		node temp=new node();
		temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		return root;
	}
	
	public static node getPredecessor(node n){
		if (n.left!=null)
			n=n.left;
		while(n.right!=null)
			n=n.right;
		return n;
	}

	public static node getSuccessor(node n){
		if (n.right!=null)
			n=n.right;
		while(n.left!=null)
			n=n.left;
		return n;
	}

    
    public static void iot(node n){
        if(n!=null){
        iot(n.left);
        System.out.println(n.val);
        iot(n.right);
        }
    }
    
    
    public static node bstToDll(node root){
    	
    	if(root==null)
    		return root;
    	
    	if(root.left!=null){
    	bstToDll(root.left);
    	
    	node pre=getPredecessor(root);
    	pre.right=root;
    	root.left=pre;
    	}
    	
    	if(root.right!=null){
    	bstToDll(root.right);
    	
    	node succ=getSuccessor(root);
    	root.right=succ;
    	succ.left=root;
    	}
    	
    	while(root.left!=null)
    		root=root.left;
    	return root;
    }
    
    
   public static void bfs(node root){
	   
	   Queue<node> q=new LinkedList<node>();
	   q.add(root);
	   while(!q.isEmpty()){
		   node a=q.poll();
		   System.out.println(a.val+" ");
		   q.add(a.left);
		   q.add(a.right);
	   }
   }
    
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    
	    bst Bst=new bst();
	    bst.insert(5);
	    bst.insert(7);
	    bst.insert(2);
	    bst.insert(4);
	    bst.insert(9);
	    bst.insert(1);
	    bst.insert(12);
	    bst.insert(14);
	    bst.insert(19);
	    bst.insert(13);
	    bst.insert(8);
	    bst.insert(16);
	    
	    
	}
}
