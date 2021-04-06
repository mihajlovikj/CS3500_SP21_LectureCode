public class TerminalWindow {
  public static void start(IModel model){
    try {
      Thread.sleep(500);
      model.addUser("TerminalWindow user1");;
    }catch(InterruptedException e){

    }

    try {
      Thread.sleep(2000);
      model.addUser("TerminalWindow user2");;
    }catch(InterruptedException e){

    }

    try {
      Thread.sleep(3000);
      model.addUser("TerminalWindow user3");;
    }catch(InterruptedException e){

    }
  }
}