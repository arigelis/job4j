package ru.job4j.calculate;
/**
*CalculateTest  class
*/
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Fedor Teslyuk (workstance@mail.ru)
 * @version $1$
 * @since 29.03.2019
 */
public class CalculateTest {
/**
/*Test echo!
*/
	@Test
	 public void whenTakeNameThenThreeEchoPlusName() {
		String input = "fedor";
		String expect = "Echo, echo, echo : fedor"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	 }
}
