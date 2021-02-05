import static org.junit.Assert.assertEquals;

import org.junit.Test;

public abstract class AbstractIDurationTest {

  protected abstract IDuration makeDuration(long seconds);

  @Test
  public void test1(){
    IDuration dur1 = makeDuration(10);
    assertEquals(10, dur1.inSeconds());
  }

  @Test
  public void test2(){
    IDuration dur1 = makeDuration(30);
    assertEquals(30, dur1.inSeconds());
  }

  @Test
  public void test3(){
    IDuration dur1 = makeDuration(50);
    assertEquals(50, dur1.inSeconds());
  }
}
