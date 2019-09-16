package se.uu.ub.cora.alvin.extendedfunctionality;

import se.uu.ub.cora.spider.data.SpiderDataGroup;
import se.uu.ub.cora.spider.data.SpiderDataRecord;
import se.uu.ub.cora.spider.record.SpiderRecordUpdater;

public class SpiderRecordUpdaterSpy implements SpiderRecordUpdater {

	public String authToken;
	public String type;
	public String id;
	public SpiderDataGroup record;

	@Override
	public SpiderDataRecord updateRecord(String authToken, String type, String id,
			SpiderDataGroup record) {
		this.authToken = authToken;
		this.type = type;
		this.id = id;
		this.record = record;

		return null;
	}

}
