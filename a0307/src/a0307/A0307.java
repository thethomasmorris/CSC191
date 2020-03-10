
package a0307;

class Recursion{
    private int[] a;
    
    //constructor
    public Recursion(int[] array){
        a = array;
    }
    
    // print array forward
    // n in the these methods is the num of elements to affect
    public void printF(int n){
        if(n>0){
            printF(n-1);
            System.out.print(a[n-1]);
        }
    }
    
    //print array backward
    public void printB(int n){
        if(n>0){
            System.out.print(a[n-1]);
            printB(n-1);
        }
    }
    
    //largest element
    public int maxA(int n){
        if(n==1)
            return a[0];
        return Math.max(maxA(n-1), a[n-1]);
    }
    
    //reversing the array
    private void reverseA(int l, int r){
        if(l<r){
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            reverseA(l+1, r-1);
        }
    }
    //the public helper method hides the need for l & r from user
    public void reverseA(){
        reverseA(0, a.length-1);
    }
    
    //mode of the int array - int that appears most often
    public int mode(int n){
        if (n==1)
            return a[0];
        int m = mode(n-1);
        int c1 = 0, c2 = 1;
        for (int i = 0; i<n-1; i++){
            if(a[i]==m)
                c1++;
            else if(a[i]==a[n-1])
                c2++;
        }
        if(c1>c2)
            return m;
        return a[n-1];
    }
    
    // recursive sorts and searches
    
    // bubble sort (version 1 - long way)
    public void bubble(int n){
        if(n>1){
            for(int i=0; i<= n-2; i++){
                if(a[i]>a[i+1]){
                    int t = a[i];
                    a[i] = a[i+1];
                    a[i+1] = t;
                }
                bubble(n-1);
            }//close for loop
        }
    }
    
    // bubble sort (version 2 - fast way)
    public void bubbleFast(int n){
        if(n>1){
            boolean isSwap = false;
            for(int i=0; i<= n-2; i++){
                if(a[i]>a[i+1]){
                    int t = a[i];
                    a[i] = a[i+1];
                    a[i+1] = t;
                    isSwap = true;
                }
                if(isSwap)
                    bubbleFast(n-1);
            }//close for loop
        }
    }
    
    //insertion sort recursively
    public void insertion(int n){
        if(n>1){
            insertion(n-1);
            int t = a[n-1];
            int i;
            for (i = n-2; i >= 0; i--) {
                if(a[i]>t)
                    a[i+1] = a[i];
                else
                    break;
            }//close for
            a[i+1] = t;
        }
    }
    
    //selection sort 
    public void selection(int n){
        if(n>1){
            int maxind = 0;
            for(int i=1; i<n; i++){
                if(a[i]>a[maxind])
                    maxind = i;
            }//close for
            int temp = a[n-1];
            a[n-1] = a[maxind];
            a[maxind] = temp;
            selection(n-1);
        }
    }
    
    // sequential search - return index of 1st occurance
    public int sequential(int n, int key){
        //base case
        if(n==0)
            return -1; //not found
        int t = sequential(n-1,key);
        if(t != -1)
            return t;
        if(a[n-1] == key)
            return n-1;
        return -1;
    }
    
    //what if we wanted to return the last occurrance of key???
    public int sequentialLast(int n, int key){
        //base case
        if(n==0)
            return -1; //not found
        if(a[n-1] == key)
            return n-1;
        int t = sequentialLast(n-1,key);
        if(t != -1)
            return t;
        
        return -1;
    }
    
    //binary search - must be sorted first
    //we can't predict which occurance will be returned
    //it depends on the array and how the m falls
    public int binary(int key){
        return binary(0,a.length-1, key);
    }
    private int binary(int left, int r, int key){
        if(left>r) //base case
            return -1;
        int m = (left+r)/2;
        if(key==a[m])
            return m;
        if(key<a[m])
            return binary(left,m-1,key);
        return binary(m+1, r, key);
    }
    
} //close class

public class A0307 {
     
    public static void main(String[] args) {
        int a[] = {1,1,6,4,1,6,7};
        Recursion r = new Recursion(a);
        r.printF(5);
        System.out.println();
        r.printB(5);
        System.out.println("");
        System.out.println(r.maxA(a.length));
        System.out.println();
        System.out.println(r.mode(5));
        System.out.println();
        //r.bubble(7);
        //r.bubbleFast(7);
        //r.insertion(7);
        r.selection(7);
        r.printF(7);
        System.out.println();
        System.out.println(r.sequential(7, 1));
        System.out.println(r.sequentialLast(7, 1));
        System.out.println(r.binary(1));
    }
    
}
