import java.util.Objects;

public abstract class AbstractDrink implements IDrink{
  final protected double price;
  final protected String description;
  final protected IDrink delegate;

  protected AbstractDrink(String description, double price, IDrink delegate){
    this.description = description;
    this.price = price;
    this.delegate = delegate; //Could be null;
  }
  @Override
  public String getDescription() {
    if ( this.delegate == null )
      return this.description;
    else{
      return this.description + " " + this.delegate.getDescription();
    }
  }

  @Override
  public double getPrice() {
    if ( this.delegate == null)
      return this.price;
    else{
      return this.price + this.delegate.getPrice();
    }
  }
}
