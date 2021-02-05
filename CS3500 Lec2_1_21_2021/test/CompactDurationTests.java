public class CompactDurationTests extends AbstractIDurationTest{

  @Override
  protected IDuration makeDuration(long seconds) {
    return new CompactDuration(seconds);
  }
}
