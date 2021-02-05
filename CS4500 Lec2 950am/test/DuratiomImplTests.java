import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DuratiomImplTests extends AbstractTestClassIDuartion {

  @Override
  protected IDuration makeDuration(long seconds) {
    return new DurationImpl(seconds);
  }
}
