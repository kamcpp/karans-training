package karans.s16.calculator.engine;

public interface Operation<T1, T2, T3> {

	T3 perform(T1 a, T2 b);
	
}
