package inheritance;

public class MainClass {

  public static void main(String args[]){
    Animal dog = new Dog(4,"Bark","Dog");
    dog.sayHello();

    Animal dog1 = new Dog();
    dog1.sayHello();

  Double val = null;
  double val1 = 1;
  System.out.println(val+""+val1);

  }
}
