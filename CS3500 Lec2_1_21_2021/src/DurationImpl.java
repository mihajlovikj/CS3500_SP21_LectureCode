import java.util.Objects;

public class DurationImpl extends AbstractDuration{
  //How do we want to represent the data?
  final private int hours;
  final private int minutes;
  final private int seconds;

  //We have to enforce our constraints and validity of our data.
  public DurationImpl(int hours, int minutes, int seconds){
    if ( hours < 0 || minutes < 0 || seconds < 0 ){
      throw new IllegalArgumentException("Args cannot be negative");
    }

    //Fixing the arguments so they are in the correct form.
    //(2, 65, 361)
    if ( seconds > 59 ){
      minutes += seconds/60; // 65 + (361/60) = 71;
      seconds = seconds % 60; //361%60 = 1
    }

    if ( minutes > 59 ){
      hours += minutes/60; //hours = 2 + 71/60 = 3
      minutes = minutes % 60;//minutes = 11;
    }

    this.seconds = seconds;
    this.minutes = minutes;
    this.hours = hours;
  }

  public DurationImpl(long totalSeconds){
    if ( totalSeconds < 0 ){
      throw new IllegalArgumentException("value cannot be negative.");
    }

   this.seconds = (int)(totalSeconds % 60);
   this.minutes = (int)totalSeconds/60 % 60;
    if ( totalSeconds / 3600 > Integer.MAX_VALUE ){
      throw new IllegalArgumentException("Overflow from plus.");
    }
    this.hours = (int)(totalSeconds/3600);
  }

  @Override
  public long inSeconds() {
    return 3600 * this.hours + 60 * this.minutes + this.seconds;
  }

  @Override
  public String asHms() {
    return String.format("%d:%02d:%02d", this.hours, this.minutes, this.seconds);
  }

  protected IDuration makeDuration(long seconds){
    return new DurationImpl(seconds);
  }






}
