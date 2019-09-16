package se.uu.ub.cora.alvin.extendedfunctionality;

import se.uu.ub.cora.spider.data.SpiderDataGroup;
import se.uu.ub.cora.spider.dependency.SpiderDependencyProvider;
import se.uu.ub.cora.spider.dependency.SpiderInstanceProvider;
import se.uu.ub.cora.spider.extended.ExtendedFunctionality;
import se.uu.ub.cora.spider.record.SpiderRecordUpdater;

public class PlaceBeforeDeleteUpdater implements ExtendedFunctionality {

	private SpiderDependencyProvider dependencyProvider;

	public PlaceBeforeDeleteUpdater(SpiderDependencyProvider dependencyProvider) {
		this.dependencyProvider = dependencyProvider;
	}

	@Override
	public void useExtendedFunctionality(String authToken, SpiderDataGroup spiderDataGroup) {
		// SpiderDataGroup recordInfo = spiderDataGroup.extractGroup("recordInfo");
		// SpiderDataGroup type = recordInfo.extractGroup("type");
		// String recordType = type.extractAtomicValue("linkedRecordId");
		//
		SpiderRecordUpdater spiderRecordUpdater = SpiderInstanceProvider.getSpiderRecordUpdater();
		spiderRecordUpdater.updateRecord(authToken, "", "", SpiderDataGroup.withNameInData(""));
	}

	public SpiderDependencyProvider getDependencyProvider() {
		// needed for test
		return dependencyProvider;
	}

}
