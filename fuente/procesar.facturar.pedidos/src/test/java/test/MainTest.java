package test;

import proceso.Main;

import junit.framework.TestCase;

public class MainTest extends TestCase {

	public void testApp() {

		try {
			String[] args = {};
			Main.main(args);
			assertTrue(true);

		} catch (Exception e) {

			assertTrue(false);
		}

	}
}
