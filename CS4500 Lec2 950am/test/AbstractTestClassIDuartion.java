import static org.junit.Assert.assertEquals;

import org.junit.Test;

public abstract class AbstractTestClassIDuartion {

  protected abstract IDuration makeDuration(long seconds);


  @Test
  public void testDurationSecondsDurationImpl(){
    IDuration dur1 = makeDuration(10);
    assertEquals(dur1.inSeconds(), 10);
  }


}
