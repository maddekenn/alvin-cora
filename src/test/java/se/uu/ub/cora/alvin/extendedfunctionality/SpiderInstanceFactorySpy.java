package se.uu.ub.cora.alvin.extendedfunctionality;

import java.util.ArrayList;
import java.util.List;

import se.uu.ub.cora.spider.dependency.SpiderInstanceFactory;
import se.uu.ub.cora.spider.record.SpiderDownloader;
import se.uu.ub.cora.spider.record.SpiderRecordCreator;
import se.uu.ub.cora.spider.record.SpiderRecordDeleter;
import se.uu.ub.cora.spider.record.SpiderRecordIncomingLinksReader;
import se.uu.ub.cora.spider.record.SpiderRecordListReader;
import se.uu.ub.cora.spider.record.SpiderRecordReader;
import se.uu.ub.cora.spider.record.SpiderRecordSearcher;
import se.uu.ub.cora.spider.record.SpiderRecordUpdater;
import se.uu.ub.cora.spider.record.SpiderRecordValidator;
import se.uu.ub.cora.spider.record.SpiderUploader;

public class SpiderInstanceFactorySpy implements SpiderInstanceFactory {

	public List<SpiderRecordUpdater> factoredRecordUpdaters = new ArrayList<>();

	@Override
	public String getDependencyProviderClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderRecordReader factorSpiderRecordReader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderRecordIncomingLinksReader factorSpiderRecordIncomingLinksReader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderRecordListReader factorSpiderRecordListReader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderRecordCreator factorSpiderRecordCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderRecordUpdater factorSpiderRecordUpdater() {
		SpiderRecordUpdaterSpy recordUpdater = new SpiderRecordUpdaterSpy();
		factoredRecordUpdaters.add(recordUpdater);
		return recordUpdater;
	}

	@Override
	public SpiderRecordDeleter factorSpiderRecordDeleter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderUploader factorSpiderUploader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderDownloader factorSpiderDownloader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderRecordSearcher factorSpiderRecordSearcher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderRecordValidator factorSpiderRecordValidator() {
		// TODO Auto-generated method stub
		return null;
	}

}
