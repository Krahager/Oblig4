import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class DataTest {
	Reader mockReader;
	Data data;

	@Before
	public void setUp() throws Exception {
		mockReader = mock(Reader.class);
		data = new Data(mockReader);
	}

	@Test
	public void read_whenGivenLine_ShouldReadProperly() throws IOException{
		when(mockReader.readLine()).thenReturn("ab674 2 110000000000000000000000 "
					+ "001111111111111111111111").thenReturn(null);
		data.read();
		assertThat(data.getHashMap().get("ab674").toString(), is("ab674 2 110000000000000000000000 "
				+ "001111111111111111111111 111111111111111111111111 " + Utility.BIN_MAXSIZE));
	}
	
	@Test
	public void read_whenGivenIllegalOperator_ShouldStoreEntryInErrorLog() throws IOException{
		when(mockReader.readLine()).thenReturn("ab674 3 110000000000000000000000 "
				+ "001111111111111111111111").thenReturn(null);
		data.read();
		assertThat(data.getFailures().get(0).toString(), is("ab674 3 110000000000000000000000 "
				+ "001111111111111111111111 000000000000000000000000 " + 0));
	}

	@Test
	public void read_whenGivenDuplicateKey_ShouldPutEntryInDuplicateList(){
		when(mockReader.readLine()).thenReturn("ab674 2 110000000000000000000000 "
				+ "001111111111111111111111").thenReturn("ab674 2 110000000000000000000000 "
						+ "001111111111111111111111").thenReturn(null);
		data.read();
		assertThat(data.getDuplicates().get(0).toString(), is("ab674 2 110000000000000000000000 "
				+ "001111111111111111111111 111111111111111111111111 " + Utility.BIN_MAXSIZE));
	}
	
	@Test
	public void entryGetHexString_WhenConstuctedProperly_ShouldReturnHexString(){
		when(mockReader.readLine()).thenReturn("12cda4 1 111111111111111111111101 "
				+ "101111111111111111111111").thenReturn(null);
		data.read();
		assertThat(data.getHashMap().get("12cda4").getHexString(), is("12cda4"));
	}
	
	@Test
	public void entryGetOperation_WhenConstuctedProperly_ShouldReturnOperator(){
		when(mockReader.readLine()).thenReturn("12cda4 1 111111111111111111111101 "
				+ "101111111111111111111111").thenReturn(null);
		data.read();
		assertThat(data.getHashMap().get("12cda4").getOperation(), is("1"));
	}
	
	@Test
	public void entryGetBin1_WhenConstuctedProperly_ShouldReturnBinaryString(){
		when(mockReader.readLine()).thenReturn("12cda4 1 111111111111111111111101 "
				+ "101111111111111111111111").thenReturn(null);
		data.read();
		assertThat(data.getHashMap().get("12cda4").getBin1(), is("111111111111111111111101"));
	}
	
	@Test
	public void entryGetBin2_WhenConstuctedProperly_ShouldReturnBinaryString(){
		when(mockReader.readLine()).thenReturn("12cda4 1 111111111111111111111101 "
				+ "101111111111111111111111").thenReturn(null);
		data.read();
		assertThat(data.getHashMap().get("12cda4").getBin2(), is("101111111111111111111111"));
	}
	
	@Test
	public void entryGetResultString_WhenConstuctedProperly_ShouldReturnBinaryString(){
		when(mockReader.readLine()).thenReturn("12cda4 1 111111111111111111111101 "
				+ "101111111111111111111111").thenReturn(null);
		data.read();
		assertThat(data.getHashMap().get("12cda4").getResultString(), is("101111111111111111111101"));
	}
	
	@Test
	public void entryGetResultInteger_WhenConstuctedProperly_ShouldReturnResultAsInteger(){
		when(mockReader.readLine()).thenReturn("12cda4 1 111111111111111111111101 "
				+ "101111111111111111111111").thenReturn(null);
		data.read();
		assertThat(data.getHashMap().get("12cda4").getResultInteger(), is(Utility.binToInt("101111111111111111111101")));
	}
}
