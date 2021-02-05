import static org.junit.Assert.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class DurationImplTest {
  IDuration duration1;
  IDuration badDuration1;

  @org.junit.Before
  public void setUp() throws Exception {
    duration1 = new DurationImpl(1,1,1);
  }

  @Test
  public void testInvalidConsturtorNegativeSeconds(){
    try {
      badDuration1 = new DurationImpl(1, 1, -1);
      assertTrue("Should have failed since seconds is negative.", false); // supposed to fail.
    }catch(IllegalArgumentException e){
      assertTrue(true);
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConsturtorNegativeMinutes(){
    badDuration1 = new DurationImpl(1, -1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConsturtorNegativeHours(){
    badDuration1 = new DurationImpl(-1, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConsturtorNegativeAll(){
    badDuration1 = new DurationImpl(-1, -1, -1);
  }

  @Test
  public void checkSecondsConversion(){
    IDuration duration = new DurationImpl(1,1,61);
    assertEquals("1:02:01", duration.asHms());
  }
  @Test
  public void checkSecondsConversion2(){
    IDuration duration = new DurationImpl(1,1,365);
    assertEquals("1:07:05", duration.asHms());
  }

  @Test
  public void checkMinutesConversion1(){
    IDuration duration = new DurationImpl(1,61,1);
    assertEquals("2:01:01", duration.asHms());
  }

  @Test
  public void checkMinutesSecondsConversion1(){
    IDuration duration = new DurationImpl(1,61,61);
    assertEquals("2:01:01", duration.asHms());
  }

  @org.junit.Test
  public void inSeconds() {
  }

  @org.junit.Test
  public void asHms() {
  }

  @org.junit.Test
  public void plus() {
  }

  @org.junit.Test
  public void compareTo() {
  }

  @Test
  public void testEquals(){
    Set<IDuration> set = new HashSet<IDuration>();

    IDuration dur1 = new DurationImpl(23);
    IDuration dur2 = new DurationImpl(23);

    boolean same = dur1.equals(dur2);

    set.add(dur1);
    set.add(dur2);
    int size = set.size();

    int dur1HashCode = dur1.hashCode();
    int dur2HashCode = dur2.hashCode();
    boolean sameHash = dur1HashCode == dur2HashCode;
    assertTrue( same );
  }

  @Test
  public void testPlus(){
    IDuration dur1 = new DurationImpl(10);
    IDuration dur2 = new CompactDuration(20);

    IDuration dur3 = dur1.plus(dur2);
    IDuration dur4 = dur2.plus(dur1);
  }


}