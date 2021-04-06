public class NetworkApp {
  public static void processModel(IModel model){
    model.addUser("Network user1");
    try {
      Thread.sleep(3000);
    }catch(InterruptedException e){

    }
    model.addUser("Network user2");
  }
}
