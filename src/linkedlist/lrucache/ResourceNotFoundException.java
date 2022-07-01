package linkedlist.lrucache;

public class ResourceNotFoundException extends RuntimeException{

  private String errorMessage;
  public ResourceNotFoundException(String errorMessage){
    this.errorMessage = errorMessage;
  }
  @Override
  public String getMessage(){
    return errorMessage;
  }

}
