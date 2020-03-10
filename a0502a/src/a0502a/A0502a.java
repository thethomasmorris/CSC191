package a0502a;
/*
Final Exam Review
May 2, 2019
 */
class ArraySorts{
    private int[] a;
    
    //constructor
    public ArraySorts(int[] array){
        a = array;
    }
    
    //sort methods
    
    //bubble sort iteratively - fast way
    //n is the number of items in the array to sort
    public void bubbleSort(int n){
        for (int stage = n-2; stage>0; stage--) {
            boolean isSorted = true;
            for (int i = 0; i < n-1; i++) {
                if(a[i] > a[i+1]){
                    //make swap
                    int t = a[i];
                    a[i] = a[i+1];
                    a[i+1] = t;
                    isSorted = false;
                }    
            }
            if(isSorted)
                break;
        }
    }
    
    //bubble sort fast way using recursion
    public void bubbleRecur(int n){
        if(n>1){
            boolean isSwap = false;
            for (int i = 0; i<n; i++) {
                if(a[i]>a[i+1]){
                    int t = a[i];
                    a[i] = a[i+1];
                    a[i+1] = t;
                    isSwap = true;
                }
                if(isSwap)
                    bubbleRecur(n-1);
            }
        }
    }
    
    //insertion sort
    //we keep sorted sublist on left and insert new number exactly where it goes in sublist
    public void insertionSort(int n){
        for (int i = 1; i <n; i++) {
            int t = a[i];
            int j;
            for(j = i-1; j>=0; j--) {
                if(a[j]>t)
                    a[j+1] = a[j];
                else
                    break;
            }
            a[j+1] = t;
        }
    }
    
    //insertion sort using recursion
    public void insertionRecur(int n){
        if(n>1){
            insertionRecur(n-1); //recurse alway back to start searching from the left
            int t = a[n-1];
            int i;
            for (i = n-2; i>=0; i--) {
                if(a[i]>t)
                    a[i+1] = a[i];
                else
                    break;
            }
            a[i+1] = t;
        }
    }
    
    //selection
    //we repeatedly find the largest num and put at the end moving left each time
    public void selectoinSort(int n){
        for (int stage = n-1; stage >= 1; stage--) {
            //make the index of the max number 0
            int maxI = 0;
            for (int i = 1; i <= stage; i++) {
                if(a[i]>a[maxI])
                    maxI = i;
            }
            //swap a[maxI] with a[stage]
            int t = a[maxI];
            a[maxI] = a[stage];
            a[stage] = t;
        }
    }
    
    //selection using recursion
    public void selectionRecur(int n){
        if(n>1){
            int maxI = 0;
            for (int i = 1; i<n; i++) {
                if(a[i]>a[maxI])
                    maxI = i;
            }
            //swap a[maxI] with a[stage]
            int t = a[maxI];
            a[maxI] = a[n-1];
            a[n-1] = t;
            selectionRecur(n-1);
        }
    }
    
    public void resetA(int a[]){
        a[0] = 6;
        a[1] = 2;
        a[2] = 8;
        a[3] = 1;
        a[4] = 3;
    }
    
    public void printA(int a[]){
        int n = a.length;
        for (int i = 0; i<n ; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}

public class A0502a {
    public static void main(String[] args) {
        int[] a = {6,2,8,1,3};
        int n = a.length;
        ArraySorts aS = new ArraySorts(a);
        
        //test bubble
        aS.bubbleSort(n);
        aS.printA(a);
        //unsort a
        aS.resetA(a);
        
        //test bubbleRecur
        aS.bubbleRecur(n-1);
        aS.printA(a);
        aS.resetA(a);
        
        //test insertion
        aS.insertionSort(n);
        aS.printA(a);
        aS.resetA(a);
        
        //test insertionRecur
        aS.insertionRecur(n);
        aS.printA(a);
        aS.resetA(a);
        
        //test selection
        aS.selectoinSort(n);
        aS.printA(a);
        aS.resetA(a);
        
        //test selectionRecur
        aS.selectionRecur(n-1);
        aS.printA(a);
        aS.resetA(a);
    }    
}
