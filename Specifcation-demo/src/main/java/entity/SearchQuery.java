package entity;

import java.util.List;

public class SearchQuery {

	private List<SearchFilter> searchFilter;
	
	private Long pageNumber;
	private Long pageSize;
	
	private SortOrder sortOrder;
	
	private List<JoinColumnProps> JoinColumnProps;

	public List<SearchFilter> getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(List<SearchFilter> searchFilter) {
		this.searchFilter = searchFilter;
	}

	public Long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
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
