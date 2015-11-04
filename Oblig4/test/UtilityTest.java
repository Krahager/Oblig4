import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class UtilityTest {
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void hexToInt_WhenGivenSingleDigitHex_ShouldReturnCorrespondingNumber() {
		assertThat(Utility.hexToInt("5"), is(5));
		assertThat(Utility.hexToInt("a"), is(10));
		assertThat(Utility.hexToInt("b"), is(11));
		assertThat(Utility.hexToInt("c"), is(12));
		assertThat(Utility.hexToInt("d"), is(13));
		assertThat(Utility.hexToInt("e"), is(14));
		assertThat(Utility.hexToInt("f"), is(15));
	}
	
	@Test
	public void hexToInt_WhenGivenDoubleDigitHex_ShouldReturnCorrespondingNumber(){
		assertThat(Utility.hexToInt("10"), is(16));
		assertThat(Utility.hexToInt("25"), is(37));
		assertThat(Utility.hexToInt("62"), is(6*16+2));
		assertThat(Utility.hexToInt("a5"), is(165));
		assertThat(Utility.hexToInt("f0"), is(240));
	}
	
	@Test
	public void hexToInt_WhenGivenTripleDigitHex_ShouldReturnCorrespondingInt(){
		assertThat(Utility.hexToInt("100"), is(256));
		assertThat(Utility.hexToInt("350"), is(848));
		assertThat(Utility.hexToInt("a00"), is(2560));
	}
	
	@Test
	public void hexToInt_WhenGivenQuadrupleDigitHex_ShouldReturnCorrespondingInt(){
		assertThat(Utility.hexToInt("1000"), is(4096));
		assertThat(Utility.hexToInt("a010"), is(40976));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hexToInt_WhenGivenSevenDigitHex_ShouldThrowIllegalArgumentException(){
		Utility.hexToInt("1000000");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hexToInt_WhenGivenIllegalCharacters_ShouldThrowIllegalArgumentException(){
		Utility.hexToInt("k");
	}
}
