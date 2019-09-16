package se.uu.ub.cora.alvin;

import org.testng.annotations.Test;

public class PlaceBeforeDeleteUpdaterTest {

	@Test
	public void testInit() {
		PlaceBeforeDeleteUpdater updater = new PlaceBeforeDeleteUpdater();
		updater.useExtendedFunctionality("", null);
	}

}
