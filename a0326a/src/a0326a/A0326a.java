package a0326a;
/*
Thomas Morris
March 26th, 2019
 */
public class A0326a {
    //print all substrings of s if s = abcd
    //4 recursive mthods to do this - each one printing in different order
    
    //print a ab abc abcd b bc bcd c cd d
    static void substrings1(String s){
        if(s.length() > 0){
            for (int i = 1; i <= s.length(); i++)
                System.out.println(s.substring(0, i));
            substrings1(s.substring(1, s.length()));
        }
    }
    
    //print d cd bcd abcd c bc abc b ab a 
    static void substrings2(String s){
        if(s.length() > 0){
            for (int i = s.length()-1; i >= 0; i--) 
                System.out.println(s.substring(i,s.length()));
            substrings2(s.substring(0,s.length()-1));
        }
    }
    
    //print a b c d ab bc cd abc bcd abcd
    static void substrings3(String s){
        substrings3(s, s.length());
    }
    
    static  void substrings3(String s, int n){
        if(n>0){
            substrings3(s, n-1);
            for (int i = 0; i <= s.length()-n; i++)
                System.out.println(s.substring(i,i+n));
        }
    }
    
    //print abcd bcd abc cd bc ab d c b a
    static void substrings4(String s){
        substrings4(s, s.length());
    }
    static  void substrings4(String s, int n){
        if(n>0){
            for (int i = s.length()-n; i >= 0; i--)
                System.out.println(s.substring(i,i+n));
            substrings4(s, n-1);
        }
    }
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println("\u001B[1m Substring 1");
        System.out.println();
        substrings1(s);
        System.out.println();
        System.out.println("\u001B[1m Substring 2");
        System.out.println();
        substrings2(s);
        System.out.println();
        System.out.println("\u001B[1m Substring 3");
        System.out.println();
        substrings3(s);
        System.out.println();
        System.out.println("\u001B[1m Substring 4");
        System.out.println();
        substrings4(s);
        System.out.println();
    } 
}
