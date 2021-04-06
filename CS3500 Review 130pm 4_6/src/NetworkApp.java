public class NetworkApp {
  public static void start(IModel model){
    try {
      Thread.sleep(1000);
      model.addUser("Network user1");;
    }catch(InterruptedException e){

    }

    try {
      Thread.sleep(1000);
      model.addUser("Network user2");;
    }catch(InterruptedException e){

    }

    try {
      Thread.sleep(1000);
      model.addUser("Network user3");;
    }catch(InterruptedException e){

    }
  }
}
