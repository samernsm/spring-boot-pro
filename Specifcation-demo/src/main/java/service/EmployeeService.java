package service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

//import com.sample.app.model.Employees;
//import com.sample.app.model.SearchQuery;
//import com.sample.app.repository.EmployeeRepository;
//import com.smaple.app.jpa.specification.SpecificationUtil;

import entity.Employees;
import repository.EmployeeRepository;
import util.SearchQuery;
import util.SpecificationUtil;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public List<Employees> findAll(SearchQuery searchQuery) {

		Specification<Employees> spec = SpecificationUtil.bySearchQuery(searchQuery, Employees.class);
		PageRequest pageRequest = getPageRequest(searchQuery);

		Page<Employees> page = empRepo.findAll(spec, pageRequest);

		return page.getContent();
	}

	private PageRequest getPageRequest(SearchQuery searchQuery) {

		int pageNumber = searchQuery.getPageNumber();
		int pageSize = searchQuery.getPageSize();

		List<Sort.Order> orders = new ArrayList<>();

		List<String> ascProps = searchQuery.getSortOrder().getAscendingOrder();

		if (ascProps != null && !ascProps.isEmpty()) {
			for (String prop : ascProps) {
				orders.add(Sort.Order.asc(prop));
			}
		}

		List<String> descProps = searchQuery.getSortOrder().getDescendingOrder();

		if (descProps != null && !descProps.isEmpty()) {
			for (String prop : descProps) {
				orders.add(Sort.Order.desc(prop));
			}

		}

		Sort sort = Sort.by(orders);

		return PageRequest.of(pageNumber, pageSize, sort);

	}
	
	@Transactional
	public void save(Employees emp) {
		empRepo.save(emp);
	}

}
