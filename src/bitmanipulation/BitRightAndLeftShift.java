package bitmanipulation;

public class BitRightAndLeftShift {

  public static void main(String args[]){
    int a = 8; //==> 1 0 0 0
    int b = a << 2; // ==> a left shift by 2 ==> this will add 2 zeros in the end

    printBinaryFormat(b);

    b = a >> 2; // ==> a right shift by 2 ==> this will remove 2 bits in the end

    printBinaryFormat(b);
  }

  // find nearest power of 2
  // ex: 7 is given ==> 2^3 ==> 8 is nearest ==> return 3
  // 10 is given ==> 2^4 ==> 16 is nearest ==> return 4
  //

  public static void printBinaryFormat(int n){
    int i=0;
    StringBuilder sb = new StringBuilder("");
    while( (1 << i) <=n){
      if( (n & (1<<i)) > 0){
        sb.append("1 ");
      }else{
        sb.append("0 ");
      }
      i++;
    }
    System.out.println("Binary of "+n+" ==> "+sb.reverse());
  }
}
