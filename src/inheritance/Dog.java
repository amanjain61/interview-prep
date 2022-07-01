package inheritance;

public class Dog extends Animal{


  public Dog(int legs, String sound,String name) {

    super(legs, sound,name);
    System.out.println("In the constructor calling super...");
  }
  public Dog(){
    super();
    System.out.println("In the default constructor of Dog class...");
  }
  @Override
  public void sayHello(){
    System.out.println("Hi I'm a "+super.getName()+" and I "+super.getSound());
  }

}
