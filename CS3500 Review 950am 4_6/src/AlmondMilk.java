public class AlmondMilk extends AbstractDrink{


  protected AlmondMilk(IDrink delegate) {
    super("AlmondMilk", 1, delegate);
  }

  protected AlmondMilk(){
    this(null);
  }
}
