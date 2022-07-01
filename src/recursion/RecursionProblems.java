package recursion;

public class RecursionProblems {

  public static void printName(int n, String name){
    if(n==5) return;
    printName(n+1,name);
    System.out.print(n+" "+name+" --> ");
  }

  public static void print1ToN(int printval,int n){
    if(n<printval) return;
    System.out.print(printval+" --> ");
    print1ToN(printval+1,n);
  }

  public static void printNTo1(int printval,int n){
    if(n<printval) return;
    printNTo1(printval+1,n);
    System.out.print(printval+" --> ");
  }

  public static void sumNNumbers(int i,int sum){
    if(i<1) {
      System.out.print("summation : "+sum);
      return;
    }
     sumNNumbers(i-1,sum+i);
  }

  public static int sumNNumbers(int n){
    if(n==0) return 0;
    return n + sumNNumbers(n-1);
  }

  public static int factorial(int n){
    if(n==0) return 1;
    return n * factorial(n-1);
  }

  public static void reverseArray(int arr[],int len){
    // base condition
    if(len<0) return;
    int val = arr[len];
    reverseArray(arr,len-1);
    arr[(arr.length -1) - len] = val;
  }

  public static void reverseArrayBySwap(int arr[],int l, int r){
    if(l >= r) return;
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
    reverseArrayBySwap(arr,l+1,r-1);
  }

  public static boolean isPalindrome(String str,int i){
    if(i >= str.length()/2) return true;
    if(str.charAt(i) != str.charAt(str.length() - i-1)) return false;
    return isPalindrome(str,i+1);
  }

  public static int findNthFibonacciNumber(int n){
    if(n<=1) return n;
    return findNthFibonacciNumber(n-1) + findNthFibonacciNumber(n-2);
  }

  public static void main(String args[]){
    // 1. print name 5 times
    printName(0,"aman");
    System.out.print("\n");
    //2. print linearly from 1 to n
    print1ToN(1,10);
    System.out.print("\n");
    //3. print linearly from 1 to n
    printNTo1(1,10);
    System.out.print("\n");
    // 4. sum first n numbers
    sumNNumbers(3,0);
    System.out.print("\n");
    // 5. sum first n numbers
    System.out.print("summation : "+sumNNumbers(4));
    // 6. factorial
    System.out.print("\nfactorial : "+factorial(4));
    System.out.print("\n");
    // 7. reverse an array using recursion
    int[] arr = {2,3,3,2,1};
    reverseArray(arr,arr.length-1);
    for(int val:arr){
      System.out.print(val+" --> ");
    }
    System.out.print("\n");
    // 8. reverse an array using recursion
    reverseArrayBySwap(arr,0,arr.length-1);
    for(int val:arr){
      System.out.print(val+" --> ");
    }
    System.out.print("\n");
    //9. palindrome
    String isPalindromeStr = "madam";
    System.out.print(isPalindromeStr+" "+(isPalindrome(isPalindromeStr,0)?" is a palindrome"
        :" is not a palindrome"));
    System.out.print("\n");
    isPalindromeStr = "madsm";
    System.out.print(isPalindromeStr+" "+(isPalindrome(isPalindromeStr,0)?" is a palindrome"
        :" is not a palindrome"));
    System.out.print("\n");
    //10. Fibonacci number
    int n = 8;
    System.out.print("The fibonacci number at "+n+" position is :: "+findNthFibonacciNumber(n));
  }
}
