package se.uu.ub.cora.alvin;

import java.util.Map;

import se.uu.ub.cora.alvin.extendedfunctionality.AlvinExtendedFunctionalityProvider;
import se.uu.ub.cora.spider.extended.ExtendedFunctionalityProvider;
import se.uu.ub.cora.therest.initialize.TheRestDependencyProvider;

public class AlvinDependencyProvider extends TheRestDependencyProvider {

	public AlvinDependencyProvider(Map<String, String> initInfo) {
		super(initInfo);
	}

	@Override
	public ExtendedFunctionalityProvider getExtendedFunctionalityProvider() {
		return new AlvinExtendedFunctionalityProvider(this);
	}

}
