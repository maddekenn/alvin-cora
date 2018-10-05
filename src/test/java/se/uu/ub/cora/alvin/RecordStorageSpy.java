package se.uu.ub.cora.alvin;

import java.util.Collection;

import se.uu.ub.cora.alvin.tocorastorage.fedora.AlvinFedoraToCoraConverterFactory;
import se.uu.ub.cora.bookkeeper.data.DataGroup;
import se.uu.ub.cora.bookkeeper.storage.MetadataStorage;
import se.uu.ub.cora.httphandler.HttpHandlerFactory;
import se.uu.ub.cora.searchstorage.SearchStorage;
import se.uu.ub.cora.spider.data.SpiderReadResult;
import se.uu.ub.cora.spider.record.storage.RecordStorage;

public class RecordStorageSpy implements RecordStorage, MetadataStorage, SearchStorage {

	private String basePath;
	public RecordStorageSpy basicStorage;
	public RecordStorageSpy fedoraToCoraStorage;
	public DbStorageSpy dbToCoraStorage;
	public HttpHandlerFactory httpHandlerFactory;
	public AlvinFedoraToCoraConverterFactory converterFactory;
	public String baseURL;

	public static RecordStorageSpy createRecordStorageOnDiskWithBasePath(String basePath) {
		return new RecordStorageSpy(basePath);
	}

	private RecordStorageSpy(String basePath) {
		this.basePath = basePath;
	}

	public static RecordStorage usingBasicAndFedoraAndDbStorage(RecordStorage basicStorage,
			RecordStorage fedoraToCoraStorage, RecordStorage dbToCoraStorage) {
		return new RecordStorageSpy(basicStorage, fedoraToCoraStorage, dbToCoraStorage);
	}

	public RecordStorageSpy(RecordStorage basicStorage, RecordStorage fedoraToCoraStorage,
			RecordStorage dbToCoraStorage) {
		this.basicStorage = (RecordStorageSpy) basicStorage;
		this.fedoraToCoraStorage = (RecordStorageSpy) fedoraToCoraStorage;
		this.dbToCoraStorage = (DbStorageSpy) dbToCoraStorage;
	}

	private RecordStorageSpy(HttpHandlerFactory httpHandlerFactory,
			AlvinFedoraToCoraConverterFactory converterFactory, String baseURL) {
		this.httpHandlerFactory = httpHandlerFactory;
		this.converterFactory = converterFactory;
		this.baseURL = baseURL;
	}

	public static RecordStorageSpy usingHttpHandlerFactoryAndConverterFactoryAndFedoraBaseURL(
			HttpHandlerFactory httpHandlerFactory,
			AlvinFedoraToCoraConverterFactory converterFactory, String baseURL) {
		return new RecordStorageSpy(httpHandlerFactory, converterFactory, baseURL);
	}

	@Override
	public DataGroup read(String type, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(String type, String id, DataGroup record, DataGroup collectedTerms,
			DataGroup linkList, String dataDivider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByTypeAndId(String type, String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean linksExistForRecord(String type, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(String type, String id, DataGroup record, DataGroup collectedTerms,
			DataGroup linkList, String dataDivider) {
		// TODO Auto-generated method stub

	}

	@Override
	public SpiderReadResult readList(String type, DataGroup filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpiderReadResult readAbstractList(String type, DataGroup filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGroup readLinkList(String type, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DataGroup> generateLinkCollectionPointingToRecord(String type, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean recordsExistForRecordType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recordExistsForAbstractOrImplementingRecordTypeAndRecordId(String type,
			String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<DataGroup> getMetadataElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DataGroup> getPresentationElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DataGroup> getTexts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DataGroup> getRecordTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DataGroup> getCollectTerms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGroup getSearchTerm(String searchTermId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGroup getCollectIndexTerm(String collectIndexTermId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBasePath() {
		return basePath;
	}

}
