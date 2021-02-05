import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class DurationImplTest {

  @org.junit.Before
  public void setUp() throws Exception { //init() in Fundies2
  }

  @Test
  public void testInvalidCreation(){
    try {
      IDuration duration = new DurationImpl(1, 1, -1);
      assertTrue("Did not throw an exception with negative data", false);
    }catch(IllegalArgumentException e){
      assertTrue("Test passed.", true);
    }
  }
  //TODO: write more tests.
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidCreation1() {
    IDuration duration = new DurationImpl(1, 1, -1);
  }

  //TODO: test all possible conversions.
  @Test
  public void testConversionFromSecondsToMinutes(){
    IDuration duration = new DurationImpl(1, 1, 61);
    assertEquals("1:02:01", duration.asHms());
  }

  @Test
  public void someExmampleOfMutatingData(){
//    IDuration duration1 = new DurationImpl(1,1,1);
//    DurationImpl duration = (DurationImpl)duration1;
//    duration.minutes = -100;
  }

  @Test
  public void testEqualsHashCode2(){
    IDuration dur1 = new DurationImpl(0,1,6);
    IDuration dur2 = new CompactDuration(66);

    boolean sameEquals = dur1.equals(dur2);

    int dur1Hash = dur1.hashCode();
    int dur2Hash = dur2.hashCode();

    boolean same = dur1Hash == dur2Hash;
  }

  @Test
  public void testEqaulsAndHashCode(){
    IDuration dur1 = new DurationImpl(1, 1, 0); //
    IDuration dur2 = dur1; // this is not a deep copy; this is shallow assignment.

    boolean equalsSame = dur1.equals(dur2); //true
    Set durSet = new HashSet<IDuration>(); // contains only unique elements.

    int hashDur1 = dur1.hashCode();
    int hashDur2 = dur2.hashCode();

    durSet.add(dur1);
    durSet.add(dur2);

    int size = durSet.size();

    assertEquals(1, size );
  }



  @Test
  public void testEquals(){
    IDuration dur1 = new DurationImpl(10);
            //0x100
    IDuration dur2 = new DurationImpl(10);
           //0x200


    boolean booleanEqualsMethod = dur1.equals(dur2);
    assertTrue ( booleanEqualsMethod );
              // (0x100).equals( (0x200) );

    assertTrue( dur1 == dur2 );
                      //0x100 == 0x200



    //== on Objects does a shallow comparison, it only compares the addresses.
  }

  @Test
  public void test1(){
    IDuration dur1 = new DurationImpl(60);
    assertEquals(60, dur1.inSeconds());
  }

  @Test
  public void test2(){
    IDuration dur1 = new CompactDuration(60);
    assertEquals(60, dur1.inSeconds());
  }




}