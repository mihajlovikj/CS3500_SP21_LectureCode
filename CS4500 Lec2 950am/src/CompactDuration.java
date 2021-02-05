public class CompactDuration extends AbstractDuration{
  private final long totalSeconds;

  public CompactDuration(long totalSeconds) {
    if ( totalSeconds < 0 ){
      throw new IllegalArgumentException("Durations cannot be negative.");
    }
    this.totalSeconds = totalSeconds;
  }


  @Override
  public long inSeconds() {
    return totalSeconds;
  }



  //TODO: Should refactor this.
  @Override
  public String asHms() {
    int seconds = (int)(totalSeconds % 60);
    int minutes = (int)((totalSeconds/60) % 60);

    if( totalSeconds / 3600 > Integer.MAX_VALUE ){
      throw new IllegalArgumentException("Overflow");
    }
    int hours = (int)(totalSeconds / 3600); //could be an overflow here. Because a long divided by 3600 can still give you a long.

    return String.format("%d:%02d:%02d", hours, minutes,seconds);
  }


  @Override
  protected IDuration makeDuration(long seconds) {
    IDuration result = new CompactDuration(seconds);
    return result;
  }
}
