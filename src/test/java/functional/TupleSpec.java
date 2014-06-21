package functional;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void tupleN() {
		// given
		Tuple<Integer, String> tuple = new Tuple<Integer, String>(4, "Kevin");
		
		// when
		Integer match = tuple.match((Integer a, String b) -> a + b.length());
		
		// then
		Assert.assertEquals((Integer) 9, match);
	}
	
	
	@Test
	public void buildTupleN() {
		List<Integer> list = new ArrayList<Integer>() {/**
			 * 
			 */
			private static final long serialVersionUID = -3244060663635490582L;
			

		{
			for (int i = 0; i < 10; i++) {
				add(i);
			}
			
		}};
		
		Tuple<?, ?> tuplen = new TupleNBuilder().withElements(list).build();
		String string = tuplen.toString();
		assertEquals("(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)", string);
	}
	
	@Test
	public void buildTupleNWithMultipleTypes() {
		List<Integer> list = new ArrayList<Integer>() {
		{
			for (int i = 0; i < 4; i++) {
				add(i);
			}
			
		}};
		
		List<String> list2 = new ArrayList<String>() {
		{
			for (int i = 0; i < 4; i++) {
				add(i + "K");
			}
			
		}};
		
		Tuple<?, ?> tuplen = new TupleNBuilder().withElements(list).withElements(list2).build();
		String string = tuplen.toString();
		assertEquals("(0, 1, 2, 3, 0K, 1K, 2K, 3K)", string);
	}

}
