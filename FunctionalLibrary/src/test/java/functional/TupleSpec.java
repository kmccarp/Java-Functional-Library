package functional;

import org.junit.Assert;
import org.junit.Test;

public class TupleSpec {
	
	@Test
	public void whenMatchingOnATuple_WeCanDecideWhatToDoWithTheTuples() {
		// given
		Tuple<Integer, String> tuple = new Tuple<Integer, String>(4, "Kevin");
		
		// when
		Integer match = tuple.match((Integer a, String b) -> a + b.length());
		
		// then
		Assert.assertEquals((Integer) 9, match);
	}
	

}
