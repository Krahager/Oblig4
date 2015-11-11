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
public class UtilityTestWithParameters {
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "5", 5 }, { "a", 10 }, { "b", 11 }, { "c", 12 }, { "d", 13 }, 
                 { "e", 14 },{ "f", 15 }, { "10", 16 }, { "a5", 165 },
                 { "ff", 255 }, { "ff0", 4080 }, {"ffffff", 16777215 }  
           });
    }
	
	@Parameter
	public String input;
	
	@Parameter(value = 1)
	public int expectedValue;
	
	@Test
	public void hexToInt_WhenGivenHex_ShouldReturnCorrespondingNumber() {
		assertThat(Utility.hexToInt(input), is(expectedValue));
	}
	
	
}
