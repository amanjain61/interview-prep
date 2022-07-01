package bitmanipulation;

public class BinaryString {

  /**
   * given two numbers as binary string return their sum
   */

  public String returnSum(char c1,char c2){
    if((c1=='1' && c2=='0') || (c1=='0' && c2=='1')) return "1";
    if(c1=='1' && c2=='1') return "10";
    else return "0";
  }

  /**
   * Get sum in O(M+N)
   * the idea is basic binary addition
   *  - 1 + 1 = 10
   *  - on adding two 1's we get 10 , so 0 stays and 1 is the carry that we add with next digit
   *  - 1 + 1 + 1 = 11
   */
  public static String getSum(String s1,String s2){
    int i = s1.length()-1;
    int j = s2.length()-1;
    int carry = 0;
    StringBuilder str = new StringBuilder("");

    while(i>=0 || j>=0){
      int sum=carry;
      if(i>=0) sum += s1.charAt(i)-'0';
      if(j>=0) sum += s2.charAt(j)-'0';
      str.append(sum %2);
      carry = sum/2;
      i--;
      j--;
    }
    if(carry!=0) str.append(carry);
    return str.reverse().toString();
  }

  public static void main(String args[]){
    // s1 = 1; s2 = 2 ==> return their sum
    String s1 = "101"; // 1
    String s2 = "101"; // 4
    // naive approach
    // --> split the strings into char arrays
    // --> build integer value from each string
    // --> add both integers


    System.out.println(getSum(s1,s2));

    // binary String to decimal
    int num1=0;
    char[] arr1 = s1.toCharArray();
    for(int i=arr1.length-1;i>=0;i--){
      int bit = Integer.valueOf(String.valueOf(arr1[i]));
      if(bit==1)  num1+= (bit * Math.pow(2,i));
    }

    int num2=0;
    char[] arr2 = s2.toCharArray();
    for(int i=arr2.length-1;i>=0;i--){
      int bit = Integer.valueOf(String.valueOf(arr2[i]));
      if(bit==1)  num2+= (bit * Math.pow(2,i));
    }

    // decimal to binary
    Integer intSum = num1+num2;
    String sum = "";
    // modBal = num%2;
    // num = num/2;
    // sum+=modBal;
    // return sum.reverse();
    while(intSum!=0){
      int modBal = intSum%2;
      intSum=intSum/2;
      sum+=String.valueOf(modBal);
    }


    System.out.println("String 1 : "+s1+" value :"+num1);
    System.out.println("String 2 : "+s2+" value :"+num2);

    System.out.println("Answer String : "+sum+" value "+ (num1+num2));


  }
}
