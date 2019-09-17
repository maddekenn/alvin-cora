package se.uu.ub.cora.alvin.extendedfunctionality;

import java.util.Map;

import se.uu.ub.cora.storage.RecordStorage;
import se.uu.ub.cora.storage.RecordStorageProvider;

public class RecordStorageProviderSpy implements RecordStorageProvider {

	public RecordStorage recordStorage;

	@Override
	public int getOrderToSelectImplementionsBy() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RecordStorage getRecordStorage() {
		return new RecordStorageSpy();
	}

	@Override
	public void startUsingInitInfo(Map<String, String> arg0) {
		// TODO Auto-generated method stub

	}

}
