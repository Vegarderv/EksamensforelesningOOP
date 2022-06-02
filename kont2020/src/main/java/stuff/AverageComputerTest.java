package stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AverageComputerTest {

  @Test
  public void testComputeAverage() {
    final AverageComputer ac = new AverageComputer(Arrays.asList(3, 4, 5));
    Assert.assertEquals(4.0, ac.computeAverage(), 0.0000001);
  }

  @Test
  public void testIntegerDivision() {
    final AverageComputer ac = new AverageComputer(Arrays.asList(3, 4));
    Assert.assertEquals(3.5, ac.computeAverage(), 0.0000001);  
  }

  @Test
  public void testEncapsulation() {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(3);
    numbers.add(5);
    final AverageComputer ac = new AverageComputer(numbers);
    Assert.assertEquals(4.0, ac.computeAverage(), 0.0000001);  
    numbers.add(8);
    Assert.assertEquals(4.0, ac.computeAverage(), 0.0000001);  
  }

  public static void main(String[] args) {
    AverageComputerTest test = new AverageComputerTest();
    test.testComputeAverage();
    //test.testIntegerDivision();
    test.testEncapsulation();
  }
}
