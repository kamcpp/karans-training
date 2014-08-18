package mockito;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MociktoTest {

	class TestClass {
		public int f(int x) {
			return 4;
		}
	}

	@Test
	public void test() {
		Iterator i = Mockito.mock(Iterator.class);
		Mockito.when(i.next()).thenReturn("Hello").thenReturn("World");
		System.out.println(i.next());
		System.out.println(i.next());
		System.out.println(i.next());
		Assert.assertTrue(true);
	}

	@Test
	public void test2() {

		TestClass obj = new TestClass();
		TestClass tc = Mockito.spy(obj);

		Object o = Mockito.mock(Object.class);
		Mockito.when(tc.f(Mockito.eq(60))).thenReturn(10);
		Mockito.when(tc.f(Mockito.eq(70))).thenReturn(6);
		Mockito.when(tc.f(Mockito.anyInt())).thenThrow(new IOException());

		System.out.println(tc.f(60));
		System.out.println(tc.f(70));
		System.out.println(tc.f(80));

		Assert.assertTrue(true);
	}
}
