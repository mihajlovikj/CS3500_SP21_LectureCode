import java.time.Duration;
import java.util.Objects;

public class DurationImpl extends AbstractDuration{
  final private int hours;
  final private int minutes;
  final private int seconds;

  public DurationImpl(long inSeconds){
    if ( inSeconds < 0 ){
      throw new IllegalArgumentException("Cannot be negative.");
    }

    this.seconds = (int)(inSeconds % 60);
    this.minutes = (int)((inSeconds/60) % 60);

    if( inSeconds / 3600 > Integer.MAX_VALUE ){
      throw new IllegalArgumentException("Overflow");
    }
    this.hours = (int)(inSeconds / 3600); //could be an overflow here. Because a long divided by 3600 can still give you a long.

  }

  /*
      What to test here:
       *for all cases that can throw the exception.
       *pass in values larger than 60 for seconds and minutes and make sure the conversion works.
   */
  public DurationImpl(int hours, int minutes, int seconds){
    if ( hours < 0 || minutes < 0 || seconds < 0 ){
      throw new IllegalArgumentException("Data must be non negative.");
    }

    if ( seconds > 59 ){ //seconds = 145 => 2minutes and 25 seconds, 5minutes
      minutes = minutes + seconds/60; // minutes = 5 + 145/60 = 5 + 2 = 7
      seconds = seconds % 60; // 145 % 60 = 25; seconds = 25;
    }
    if ( minutes > 59 ){
      hours += minutes/60;
      minutes = minutes % 60;
    }

    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

 //TODO: test this.
  @Override
  public long inSeconds() {
    return 3600 * this.hours + 60 * minutes + seconds;
  }

  @Override
  public String asHms() {// 1h 5m 2s => 1:05:02
    return String.format("%d:%02d:%02d", this.hours, this.minutes,this.seconds);
  }


  @Override
  protected IDuration makeDuration(long seconds) {
    IDuration result = new DurationImpl(seconds);
    return result;
  }
}
