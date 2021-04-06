public class ModelCreator {
  public static void populateModel(IModel model){
    model.addUser("user1");
    try {
      Thread.sleep(1000);
    }catch(InterruptedException e){

    }
    model.addUser("user2");
    try {
      Thread.sleep(1000);
    }catch(InterruptedException e){

    }
    model.addUser("user3");
    try {
      Thread.sleep(1000);
    }catch(InterruptedException e){

    }
  }
}
