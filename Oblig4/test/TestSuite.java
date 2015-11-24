import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	DataTest.class,
	UtilityTest.class,
	UtilityTestWithBinParameters.class,
	UtilityTestWithHexParameters.class
})
public class TestSuite {

}
