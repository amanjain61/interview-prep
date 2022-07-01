package usermodule;

import java.util.ArrayList;
import java.util.List;

import usermodule.User;

public class UserService {

  // userId && User ==> user detail
  List<User> userList = new ArrayList<>();

  Integer lastUsedId = 1;

  public User checkIfUserExists(String firstName,String lastName){
    User lastUserAdded = null;
    for(User user:userList){
      if(user.firstName.equalsIgnoreCase(firstName) && user.lastName.equalsIgnoreCase(lastName)){
        return user;
      }
    }
    return lastUserAdded;

  }

  public String generateUserId(String firstName,String lastName){

    // take the first character of the firstName & take the whole of last name
    // Min chars 3 , Max chars 6
    // make sure the last name is atLeast two characters long
    //Integer first_name_characters = 1;
    //Integer last_name_characters = lastName.length();

    // Raja Ram == rram@...
    // RajaRam ==  rram1...
    // Raja Ram == rram2
    // Raja Ram == rra50
    //
        /*

        Raja Ram
        Hare Krishna, Sreeram Bhuva, Sairam Chenna, Krishna Bala, Ram Ganna, Raja Ram
         */

    String userId = firstName.charAt(0) + lastName.substring(0,3);

    User existingUser = checkIfUserExists(firstName,lastName);

    if(existingUser!=null){
      userId = userId + String.valueOf(lastUsedId);
    }


    User user = new User(firstName, lastName, userId.toLowerCase());
    userList.add(user);

    lastUsedId++;

    return user.userId;

  }

  public static void main(String args[]){

    UserService service = new UserService();

    String[] strArr = {"Raja Ram", "Hare Krishna", "Sreeram Bhuva", "Sairam Chenna", "Krishna Bala", "Ram Ganna", "Raja Ram"};
    for(String str:strArr){
      String[] arr = str.split(" ");
      System.out.println(service.generateUserId(arr[0],arr[1]));
    }

  }
}
