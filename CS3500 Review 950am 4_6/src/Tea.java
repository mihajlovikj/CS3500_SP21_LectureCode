public class Tea extends AbstractDrink{

  public Tea( IDrink delegate){
    super("Tea", 2.5, delegate);
  }

  public Tea(){
    this(null);
  }

}
