import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UtilityTestWithHexParameters {
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "5", 5 }, { "A", 10 }, { "B", 11 }, { "C", 12 }, { "D", 13 }, 
                 { "E", 14 },{ "F", 15 }, { "10", 16 }, { "A5", 165 },
                 { "FF", 255 }, { "FF0", 4080 }, {"FFFFFF", 16777215 },
                 { "0", 0}
           });
    }
	
	@Parameter
	public String input;
	
	@Parameter(value = 1)
	public int expectedInt;
	
	@Test
	public void hexToInt_WhenGivenHex_ShouldReturnCorrespondingNumber() {
		assertThat(Utility.hexToInt(input), is(expectedInt));
	}
	
	@Test
	public void intToHex_WhenGivenInt_ShouldReturnCorrespondingHex(){
		assertThat(Utility.intToHex(expectedInt), is(input));
	}
	
}
