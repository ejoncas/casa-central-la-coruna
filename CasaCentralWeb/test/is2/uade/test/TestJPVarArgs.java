package is2.uade.test;

import org.junit.Test;

public class TestJPVarArgs {

	@Test
	public void testMetodo() {
		metodoQueRecibeNStrings("1", "2", "3", "4", "5", "6", "7","12","123","123121","12");
	}

	public void metodoQueRecibeNStrings(String... variosStrings) {
		for (String s : variosStrings) {
			System.out.println(s);
		}
	}

}
