package mil.yaye.yours.util;

import java.util.ArrayList;
import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.Session;

public class Paginate implements PaginatedList {

	//Fields
	private static Paginate paginate = null;
	private Session session = null;
	private Paginate(){
		
	}
	public Paginate instance(Session session) {
		if(paginate == null) {
			paginate = new Paginate();
			this.session = session;
		}
		return paginate;
	}
	public int getFullListSize() {
		int fullListSize = 0;
		String hql = "";
		return 0;
	}

	public List getList() {
		List list = new ArrayList();
		return null;
	}

	public int getObjectsPerPage() {
		
		return 0;
	}

	public int getPageNumber() {
		
		return 0;
	}

	public String getSearchId() {
		
		return null;
	}

	public String getSortCriterion() {
		
		return null;
	}

	public SortOrderEnum getSortDirection() {
		
		return null;
	}

}
