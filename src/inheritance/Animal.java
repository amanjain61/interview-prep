package inheritance;

public class Animal extends BaseClass{

  public Animal(){
    System.out.println("In the default Animal Constructor...");
  }
  public Animal(int legs,String sound,String name){
    System.out.println("In the Animal Constructor...");
    this.legs = legs;
    this.sound = sound;
    this.name = name;
  }
  private int legs;
  private String sound;
  private String name;

  public int getLegs() {
    return legs;
  }

  public void setLegs(int legs) {
    this.legs = legs;
  }

  public String getSound() {
    return sound;
  }

  public void setSound(String sound) {
    this.sound = sound;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void sayHello(){
    System.out.println("Hi I'm a "+name+" and I "+sound);
  }
}
