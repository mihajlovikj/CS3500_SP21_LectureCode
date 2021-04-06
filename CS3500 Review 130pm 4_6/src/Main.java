public class Main {
  public static void main(String [] args){
    View view = new View();
    IModel model = new Model(); // the model is the emitter
    Controller controller = new Controller(model, System.out);
    model.subscribeDeleteUser(controller); // controller is a subscriber
    model.subscribeAddUser(view); // view is a subscriber.



    NetworkApp.start(model);//works via a socket, and the model can be updated via a remote terminal.
    TerminalWindow.start(model);//this waits for updates from the terminal window.
  }
}
