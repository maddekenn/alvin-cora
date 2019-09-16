/*
 * Copyright 2019 Uppsala University Library
 *
 * This file is part of Cora.
 *
 *     Cora is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cora is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cora.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package se.uu.ub.cora.alvin.extendedfunctionality;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.cora.spider.data.SpiderDataGroup;
import se.uu.ub.cora.spider.dependency.SpiderDependencyProvider;
import se.uu.ub.cora.spider.dependency.SpiderInstanceProvider;

public class PlaceBeforeDeleteUpdaterTest {
	SpiderDependencyProvider dependencyProvider;
	private RecordStorageSpy recordStorage;
	private SpiderInstanceFactorySpy spiderInstanceFactory;

	@BeforeMethod
	public void setUp() {
		spiderInstanceFactory = new SpiderInstanceFactorySpy();
		SpiderInstanceProvider.setSpiderInstanceFactory(spiderInstanceFactory);

		// recordStorage = new RecordStorageSpy();
		// setUpDependencyProvider();
	}

	@Test
	public void testInit() {
		PlaceBeforeDeleteUpdater updater = new PlaceBeforeDeleteUpdater(dependencyProvider);
		String authToken = "someAuthToken";
		SpiderDataGroup dataGroup = SpiderDataGroup.withNameInData("someNameInData");
		updater.useExtendedFunctionality(authToken, null);
		SpiderRecordUpdaterSpy factoredUpdater = (SpiderRecordUpdaterSpy) spiderInstanceFactory.factoredRecordUpdaters
				.get(0);

		assertEquals(authToken, factoredUpdater.authToken);
		assertSame(dataGroup, factoredUpdater.record);
	}

	private void setUpDependencyProvider() {
		dependencyProvider = new DependencyProviderSpy(new HashMap<>());
		// dependencyProvider.authenticator = authenticator;
		// dependencyProvider.spiderAuthorizator = spiderAuthorizator;
		// dependencyProvider.dataValidator = dataValidator;
		RecordStorageProviderSpy recordStorageProviderSpy = new RecordStorageProviderSpy();
		recordStorageProviderSpy.recordStorage = recordStorage;
		dependencyProvider.setRecordStorageProvider(recordStorageProviderSpy);

		// dependencyProvider.ruleCalculator = ruleCalculator;
		// dependencyProvider.linkCollector = linkCollector;
		// dependencyProvider.extendedFunctionalityProvider = extendedFunctionalityProvider;
	}

}
