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
 */
package se.uu.ub.cora.alvin.extendedfunctionality;

import se.uu.ub.cora.spider.data.SpiderDataGroup;
import se.uu.ub.cora.spider.dependency.SpiderInstanceProvider;
import se.uu.ub.cora.spider.extended.ExtendedFunctionality;
import se.uu.ub.cora.spider.record.SpiderRecordUpdater;

public class RecordBeforeDeleteUpdater implements ExtendedFunctionality {

	@Override
	public void useExtendedFunctionality(String authToken, SpiderDataGroup spiderDataGroup) {
		SpiderDataGroup recordInfo = spiderDataGroup.extractGroup("recordInfo");
		String recordType = extractType(recordInfo);
		String recordId = recordInfo.extractAtomicValue("id");
		SpiderRecordUpdater spiderRecordUpdater = SpiderInstanceProvider.getSpiderRecordUpdater();
		spiderRecordUpdater.updateRecord(authToken, recordType, recordId, spiderDataGroup);
	}

	private String extractType(SpiderDataGroup recordInfo) {
		SpiderDataGroup type = recordInfo.extractGroup("type");
		return type.extractAtomicValue("linkedRecordId");
	}

}
