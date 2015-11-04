import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class UtilityTest {
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void toInt_WhenGivenSingleDigitHex_ShouldReturnCorrespondingNumber() {
		assertThat(Utility.toInt("a"), is(10));
		assertThat(Utility.toInt("b"), is(11));
		assertThat(Utility.toInt("c"), is(12));
	}
}
