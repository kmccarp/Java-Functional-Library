package functional;

import java.util.Iterator;

public class TupleN<L> extends Tuple<L, Tuple<?, ?>> {
	public TupleN(L left, Tuple<?, ?> right) {
		super(left, right);
	}
	
	@Override
	public String toString() {
		return "(" + asString() + ")";
	}
	
	protected String asString() {
		return left + ", " + right.asString();
	}
	
	@Override
	public int size() {
		return 1 + this.right.size();
	}
}
