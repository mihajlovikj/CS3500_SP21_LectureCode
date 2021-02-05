import java.util.Objects;

public class CompactDuration extends AbstractDuration{
  private final long totalSeconds;

  public CompactDuration(long totalSeconds) {
    if ( totalSeconds < 0 ){
      throw new IllegalArgumentException("Duration cannot be negative.");
    }
    this.totalSeconds = totalSeconds;
  }


  @Override
  public long inSeconds() {
    return totalSeconds;
  }

  @Override
  public String asHms() {
    int seconds = (int)(totalSeconds % 60);
    int minutes = (int)totalSeconds/60 % 60;
    if ( totalSeconds / 3600 > Integer.MAX_VALUE ){
      throw new IllegalArgumentException("Overflow from plus.");
    }
    int hours = (int)(totalSeconds/3600);
    return String.format("%d:%02d:%02d", hours, minutes, seconds);
  }

  protected IDuration makeDuration(long seconds){
    return new CompactDuration(seconds);
  }



}
