import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class UtilityTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void intToHex_WhenGivenNumberLessThan0_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The number can't be less than 0");
		Utility.intToHex(-32);
	}
	
	@Test
	public void hexToInt_WhenGivenSevenDigitHex_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Hexadecimal string too long. Maximum supported length is 6. Length was 7");
		Utility.hexToInt("1000000");
	}
	
	@Test
	public void hexToInt_WhenGivenIllegalCharacters_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("String contains illegal characters. Supported pattern is [^0-9A-Fa-f]");
		Utility.hexToInt("h1k");
	}
	
	@Test
	public void hexToInt_WhenGivenNull_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("String cannot be null");
		Utility.hexToInt(null);
	}
	
	@Test
	public void binToInt_WhenGivenMoreThan24Digits_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Binary string too long. Maximum supported length is 24. Length was 25");
		Utility.binToInt("1111111111111111111111111");
	}
	
	@Test
	public void binToInt_WhenGivenIllegalCharacters_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("String contains illegal characters. Supported pattern is [^01]");
		Utility.binToInt("910");
	}
	
	@Test
	public void intToBin_WhenGivenValueOver16777215_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Number higher than 24 bits can support");
		Utility.intToBin(167772155);
	}
	
	@Test
	public void bitwise_WhenGiven2_ShouldPerformBitwiseOR(){
		assertThat(Utility.bitwise("2", "110101000100101010101011", "100101001100101010101111"),
				is("110101001100101010101111"));
	}
	
	@Test
	public void bitwise_WhenGiven1_ShouldPerformBitwiseAND(){
		assertThat(Utility.bitwise("1", "110101000100101010101011", "100101000100101010101111"),
				is("100101000100101010101011"));
	}
	
	@Test
	public void bitwise_WhenGivenStringLongerThan24_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Binary string too long. Maximum supported length is 24. Length was 47");
		Utility.bitwise("1", "00000000000000000000000000000000000000000000000", "101010101010101010101010101010");
	}
	
	@Test
	public void bitwise_WhenGivenNullAsOperation_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Operation cannot be null");
		Utility.bitwise(null, "100101000100101010101011", "100101000100101010101011");
	}
	
	@Test
	public void bitwise_WhenGivenNullAsSecondArgument_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("String cannot be null");
		Utility.bitwise("1", null, "100101000100101010101011");
	}
	
	@Test
	public void bitwise_WhenGivenNullAsThirdArgument_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("String cannot be null");
		Utility.bitwise("1", "100101000100101010101011", null);
	}
	
	@Test
	public void bitwise_WhenGivenIllegalOperator_ShouldThrowIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("");
		Utility.bitwise("3", "100101000100101010101011", "100101000100101010101011");
	}
	
	@Test
	public void utility_WhenRunningDefaultConstructor_ShouldInstantiateProperly(){
		@SuppressWarnings("unused")
		Utility u = new Utility();
	}
}
