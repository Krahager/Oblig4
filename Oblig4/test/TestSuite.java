import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ReaderTest.class,
	UtilityTest.class,
	UtilityTestWithBinParameters.class,
	UtilityTestWithHexParameters.class
})
public class TestSuite {

}
