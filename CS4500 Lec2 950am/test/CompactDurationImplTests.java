public class CompactDurationImplTests extends AbstractTestClassIDuartion{

  @Override
  protected IDuration makeDuration(long seconds) {
    return new CompactDuration(seconds);
  }
}
