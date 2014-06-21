package functional;

import java.util.ArrayList;
import java.util.List;

public class Fun {

	public static <L, R> List<Tuple<L, R>> zip(List<L> left, List<R> right) {
		List<Tuple<L, R>> list = new ArrayList<>();
		for(int i = 0; i < left.size() && i < right.size(); i++) {
			list.add(new Tuple<L, R>(left.get(i), right.get(i)));
		}
		return list;
	}
	
	public static <Type> List<Tuple<Type, Integer>> zipWithIndex(List<Type> in) {
		List<Tuple<Type, Integer>> list = new ArrayList<Tuple<Type, Integer>>();
		Integer i = 0;
		in.forEach(it -> list.add(new Tuple<Type, Integer>(it, i)));
		return list;
	}
}
