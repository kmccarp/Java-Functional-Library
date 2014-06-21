package functional;

import java.util.function.BiFunction;

public class Tuple<L, R> {
	public final L left;
	public final R right;
	
	public Tuple(L left, R right) {
		this.left = left;
		this.right = right;
	}
	
	public <A> A match(BiFunction<L, R, A> fun) {
		return fun.apply(left, right);
	}
	
	@Override
	public String toString() {
		return "(" + left + ", " + right + ")";
	}
}
