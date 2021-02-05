public abstract class AbstractDuration implements IDuration {
  @Override
  public boolean equals(Object obj) {
    //this and obj both point to the same object in memory.
    if ( this == obj ) return true;

    //Is obj actually comparable to this. "this" is a Duration object.
    //However, is obj actually also a Duration object
    if ( ! ( obj instanceof IDuration) ) return false;

    IDuration other = (IDuration)(obj);
    boolean result = this.inSeconds() == other.inSeconds();//On primitive types it is ok to use ==.
    return result;

    //1. We are comparing the exact same object.
    //Duration dur1 = new DurationImpl(23); 0x100
    //Duration dur2 = new DurationImpl(23); 0x200
    //dur1.equals(dur1); //exact same reference pointer.
    //dur1 == dur1 => 0x100 == 0x100
    //dur1 == dur2 => 0x100 == 0x200
    // == does a shallow comparison
    // dur1.equals(...);
  }

  @Override
  public int compareTo(IDuration o) {
    return Long.compare(this.inSeconds(), o.inSeconds() );
  }

  @Override
  public int hashCode() {
    return Long.hashCode( this.inSeconds() );
  }

  @Override
  public String toString() {
    return this.asHms();
  }

  protected abstract IDuration makeDuration(long seconds);

  @Override
  public IDuration plus(IDuration other) {
    return makeDuration(this.inSeconds() + other.inSeconds());
  }
}
