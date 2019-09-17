package se.uu.ub.cora.alvin;

import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import se.uu.ub.cora.alvin.extendedfunctionality.AlvinExtendedFunctionalityProvider;
import se.uu.ub.cora.spider.extended.ExtendedFunctionalityProvider;

public class AlvinDependencyProviderTest {

	@Test
	public void testInit() {
		Map<String, String> initInfo = new HashMap<>();
		initInfo.put("gatekeeperURL", "someGatekeeperURL");
		initInfo.put("solrURL", "someSolrURL");
		AlvinDependencyProvider dependencyProvider = new AlvinDependencyProvider(initInfo);

		ExtendedFunctionalityProvider extendedFunctionalityProvider = dependencyProvider
				.getExtendedFunctionalityProvider();
		assertTrue(extendedFunctionalityProvider instanceof AlvinExtendedFunctionalityProvider);
		AlvinExtendedFunctionalityProvider alvinExtended = (AlvinExtendedFunctionalityProvider) extendedFunctionalityProvider;
		assertSame(alvinExtended.getDependencyProvider(), dependencyProvider);
	}
}
