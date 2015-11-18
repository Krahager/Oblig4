import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

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
	
	@Test(expected = IllegalArgumentException.class)
	public void intToBin_WhenGivenValueOver16777215_ShouldThrowIllegalArgumentException(){
		Utility.intToBin(167772155);
	}
	
	@Test
	public void bitwise_WhenGiven2_ShouldPerformBitwiseOR(){
		assertThat(Utility.bitwise(2, "110101000100101010101011", "100101001100101010101111"),
				is("110101001100101010101111"));
	}
	
	@Test
	public void bitwise_WhenGiven1_ShouldPerformBitwiseAND(){
		assertThat(Utility.bitwise(1, "110101000100101010101011", "100101000100101010101111"),
				is("100101000100101010101011"));
	}
}
