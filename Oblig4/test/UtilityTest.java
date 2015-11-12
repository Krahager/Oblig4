import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

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
	
	@Test
	public void binToInt_WhenGiven1_ShouldReturn1(){
		assertThat(Utility.binToInt("1"), is(1));
	}
	
	@Test
	public void binToInt_WhenGiven101_ShouldReturn5(){
		assertThat(Utility.binToInt("101"), is(5));
	}
	
	@Test
	public void binToInt_WhenGiven100000000_ShouldReturn256(){
		assertThat(Utility.binToInt("100000000"), is(256));
	}
	
	@Test
	public void binToInt_WhenGiven111111111111111111111111_ShouldReturn‭16777215‬(){
		assertThat(Utility.binToInt("111111111111111111111111"), is(16777215));
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
