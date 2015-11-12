import org.junit.Before;
import org.junit.Test;

public class UtilityTest {
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void intToHex_WhenGivenNumberLessThan0_ShouldThrowIllegalArgumentException(){
		Utility.intToHex(-32);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hexToInt_WhenGivenSevenDigitHex_ShouldThrowIllegalArgumentException(){
		Utility.hexToInt("1000000");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hexToInt_WhenGivenIllegalCharacters_ShouldThrowIllegalArgumentException(){
		Utility.hexToInt("h1k");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void binToInt_WhenGivenMoreThan24Digits_ShouldThrowIllegalArgumentException(){
		Utility.binToInt("1111111111111111111111111");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void binToInt_WhenGivenIllegalCharacters_ShouldThrowIllegalArgumentException(){
		Utility.binToInt("910");
	}
}
