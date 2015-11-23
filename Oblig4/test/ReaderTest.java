import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.BufferedReader;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ReaderTest {
	@Mock() BufferedReader in = mock(BufferedReader.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void read_whenGivenLine_ShouldReadProperly() {
		Reader read = null;
		try {
			when(in.readLine()).thenReturn("ab674 2 110000000000000000000000 "
					+ "001111111111111111111111");
			when(in.ready()).thenReturn(true, false);
			read = new Reader(in);
		}
		catch(Exception e){
		}
		assertThat(read.getHashMap().get("ab674"), is("ab674 2 110000000000000000000000 "
				+ "001111111111111111111111 111111111111111111111111"));
		
	}

}
