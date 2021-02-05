public abstract class AbstractDuration implements IDuration{
  @Override
  public boolean equals(Object obj) {
    super.equals(obj);
    //Pointer/Reference comparision. Using == on objects compares their address in memory.
    //The disadvanrage is if I have new DurationImp(1,0,0), new DurationImp(0,1,0)
    //a.equals(a);
    if ( this == obj ) return true;

    if ( ! ( obj instanceof IDuration ) ) return false;

    IDuration otherDuration = (IDuration)obj;

    boolean result = (this.inSeconds() == otherDuration.inSeconds());
    return result;
  }

  @Override
  public int hashCode() {
    return Long.hashCode( this.inSeconds() );
  }

  @Override
  public String toString() {
    return this.asHms();
  }

  @Override
  public int compareTo(IDuration o) {
    return Long.compare(this.inSeconds(), o.inSeconds() );
  }

  protected abstract IDuration makeDuration(long seconds);

  @Override
  public IDuration plus(IDuration other) {
    return makeDuration(this.inSeconds() + other.inSeconds());
  }

}
