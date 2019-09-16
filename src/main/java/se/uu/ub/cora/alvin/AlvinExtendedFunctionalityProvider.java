package se.uu.ub.cora.alvin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.uu.ub.cora.spider.dependency.SpiderDependencyProvider;
import se.uu.ub.cora.spider.extended.BaseExtendedFunctionalityProvider;
import se.uu.ub.cora.spider.extended.ExtendedFunctionality;

public class AlvinExtendedFunctionalityProvider extends BaseExtendedFunctionalityProvider {

	public AlvinExtendedFunctionalityProvider(SpiderDependencyProvider dependencyProvider) {
		super(dependencyProvider);
	}

	@Override
	public List<ExtendedFunctionality> getFunctionalityBeforeDelete(String recordType) {
		// List<ExtendedFunctionality> list =
		// super.getFunctionalityForCreateBeforeMetadataValidation(
		// recordTypeId);
		List<ExtendedFunctionality> list = new ArrayList<>();
		if ("place".equals(recordType)) {
			// list = ensureListExists(list);
			list.add(new PlaceBeforeDeleteUpdater());
			return list;

		}
		return Collections.emptyList();
	}

}
