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
public class UtilityTestWithBinParameters {
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "1", 1 }, { "10", 2 }, { "1001", 9 }, { "1100", 12 }, { "110101", 53 }, 
                 { "0111110", 62 },{ "10100101", 165 },{ "11111111", 255 }, 
                 { "100000000", 256 }, {"111111111111111111111111", 16777215 }  
           });
    }
	
	@Parameter
	public String input;
	
	@Parameter(value = 1)
	public int expectedInt;
	
	@Test
	public void binToInt_WhenGivenBinaryInput_ShouldReturnCorrespondingIntValue(){
		assertThat(Utility.binToInt(input), is(expectedInt));
	}

	@Test
	public void intToBin_WhenGivenIntInput_ShouldReturnCorrespondingBinaryString(){
		assertThat(Utility.intToBin(expectedInt), is(input));
	}
}
