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

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se.uu.ub.cora.spider.data.SpiderDataAtomic;
import se.uu.ub.cora.spider.data.SpiderDataGroup;
import se.uu.ub.cora.spider.dependency.SpiderDependencyProvider;
import se.uu.ub.cora.spider.dependency.SpiderInstanceProvider;

public class RecordBeforeDeleteUpdaterTest {
	SpiderDependencyProvider dependencyProvider;
	private SpiderInstanceFactorySpy spiderInstanceFactory;

	@BeforeMethod
	public void setUp() {
		spiderInstanceFactory = new SpiderInstanceFactorySpy();
		SpiderInstanceProvider.setSpiderInstanceFactory(spiderInstanceFactory);

	}

	@Test
	public void testInit() {
		RecordBeforeDeleteUpdater updater = new RecordBeforeDeleteUpdater();
		String authToken = "someAuthToken";
		SpiderDataGroup dataGroup = createDataGroup();
		updater.useExtendedFunctionality(authToken, dataGroup);
		SpiderRecordUpdaterSpy factoredUpdater = (SpiderRecordUpdaterSpy) spiderInstanceFactory.factoredRecordUpdaters
				.get(0);

		assertEquals(authToken, factoredUpdater.authToken);
		assertSame(dataGroup, factoredUpdater.record);
		assertEquals("someRecordType", factoredUpdater.type);
		assertEquals("someRecordId", factoredUpdater.id);
	}

	private SpiderDataGroup createDataGroup() {
		SpiderDataGroup dataGroup = SpiderDataGroup.withNameInData("someNameInData");
		SpiderDataGroup recordInfo = createRecordInfo();
		dataGroup.addChild(recordInfo);
		return dataGroup;
	}

	private SpiderDataGroup createRecordInfo() {
		SpiderDataGroup recordInfo = SpiderDataGroup.withNameInData("recordInfo");
		SpiderDataGroup type = createType();
		recordInfo.addChild(type);
		recordInfo.addChild(SpiderDataAtomic.withNameInDataAndValue("id", "someRecordId"));
		return recordInfo;
	}

	private SpiderDataGroup createType() {
		SpiderDataGroup type = SpiderDataGroup.withNameInData("type");
		type.addChild(SpiderDataAtomic.withNameInDataAndValue("linkedRecordType", "recordType"));
		type.addChild(SpiderDataAtomic.withNameInDataAndValue("linkedRecordId", "someRecordType"));
		return type;
	}

}
