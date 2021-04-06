public class SoyMilk extends AbstractDrink{

  protected SoyMilk(IDrink delegate) {
    super("Milk from Orginacally non gmo locally free grazed sourced soy beans", 1.5, delegate);
  }
  protected SoyMilk(){
    this(null);
  }
}
