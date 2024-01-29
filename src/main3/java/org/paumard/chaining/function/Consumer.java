package org.paumard.chaining.function;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

	void accept(T t);
	
	default Consumer<T> andThen(Consumer<T> other) {
		Objects.requireNonNull(other); //ensure other object is ok
		return (T t) -> {
			this.accept(t); //this accept
			other.accept(t); //and then the other also accept
		};
	}
}
