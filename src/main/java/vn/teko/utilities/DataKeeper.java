package vn.teko.utilities;

import java.util.ArrayList;
import java.util.List;

public class DataKeeper {
	private List<Integer> idList = new ArrayList<Integer>();
	private Class<?> className;

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
		
	public List<Integer> addIdToList(int id) {		
		if(id > 0)
			idList.add(id);
		return idList;
	}

	public Class<?> getClassName() {
		return className;
	}

	public void setClassName(Class<?> className) {
		this.className = className;
	}

	
}
