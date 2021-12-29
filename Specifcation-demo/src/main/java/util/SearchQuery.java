package util;

import java.util.List;

public class SearchQuery {

	private List<SearchFilter> searchFilter;
	
	private int pageNumber;
	private int pageSize;
	
	private SortOrder sortOrder;
	
	private List<JoinColumnProps> JoinColumnProps;

	public List<SearchFilter> getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(List<SearchFilter> searchFilter) {
		this.searchFilter = searchFilter;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<JoinColumnProps> getJoinColumnProps() {
		return JoinColumnProps;
	}

	public void setJoinColumnProps(List<JoinColumnProps> joinColumnProps) {
		JoinColumnProps = joinColumnProps;
	}
	
	
	
}
