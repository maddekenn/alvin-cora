package se.uu.ub.cora.alvin.extendedfunctionality;

import java.util.Collection;

import se.uu.ub.cora.data.DataGroup;
import se.uu.ub.cora.storage.RecordStorage;
import se.uu.ub.cora.storage.StorageReadResult;

public class RecordStorageSpy implements RecordStorage {

	public boolean updateWasCalled = false;

	@Override
	public void create(String arg0, String arg1, DataGroup arg2, DataGroup arg3, DataGroup arg4,
			String arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByTypeAndId(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean linksExistForRecord(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DataGroup read(String arg0, String arg1) {
		return DataGroup.withNameInData("someNameInData");
		// return null;
	}

	@Override
	public StorageReadResult readAbstractList(String arg0, DataGroup arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataGroup readLinkList(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageReadResult readList(String arg0, DataGroup arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean recordExistsForAbstractOrImplementingRecordTypeAndRecordId(String arg0,
			String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recordsExistForRecordType(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(String arg0, String arg1, DataGroup arg2, DataGroup arg3, DataGroup arg4,
			String arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<DataGroup> generateLinkCollectionPointingToRecord(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
