public class DurationImplTests extends AbstractIDurationTest {
  @Override
  protected IDuration makeDuration(long seconds) {
    return new DurationImpl(seconds);
  }
}
