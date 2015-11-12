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
                 { "000000000000000000000001", 1 }, { "000000000000000000000010", 2 },
                 { "000000000000000000001001", 9 }, { "000000000000000000001100", 12 }, 
                 { "000000000000000000110101", 53 }, { "000000000000000000111110", 62 },
                 { "000000000000000010100101", 165 }, { "000000000000000011111111", 255 }, 
                 { "000000000000000100000000", 256 }, {"111111111111111111111111", 16777215 }  
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
	public void intToBin_WhenGivenIntInput_ShouldReturnCorresponding24BitString(){
		assertThat(Utility.intToBin(expectedInt), is(input));
	}
}
