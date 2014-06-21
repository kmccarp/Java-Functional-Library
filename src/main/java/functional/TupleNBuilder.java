package functional;

import java.util.Stack;

public class TupleNBuilder {
	
	Stack<Object> elements = new Stack<Object>();
	
	public TupleNBuilder withElement(Object element) {
		elements.push(element);
		return this;
	}
	
	public TupleNBuilder withElements(Iterable<?> elements) {
		elements.forEach(it -> this.elements.add(it));
		return this;
	}
	
	public Tuple<?, ?> build() {
		if (this.elements.size() < 2)
			throw new NotEnoughElementsException();
		Object ultimate = this.elements.pop();
		Object penultimate = this.elements.pop();
		Tuple tuple = new Tuple(penultimate, ultimate);
		
		return buildRecursively(this.elements, tuple);
	}
	
	private Tuple<?, ?> buildRecursively(Stack<Object> remainingElements, Tuple<?, ?> right) {
		if (remainingElements.size() == 0) {
			return right;
		}
		
		Object last = remainingElements.pop();
		return buildRecursively(remainingElements, new TupleN(last, right));
	}
	
	public static class NotEnoughElementsException extends RuntimeException {
		public NotEnoughElementsException() {
			super("Must have at least two elements defined.");
		}
	}
}
