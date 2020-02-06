package fi.vamk.e1800950.northwind;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesReportsController {
	@Autowired
	private SalesReportsRepository repository;

	// returning all SalesReportss
	@RequestMapping("/SalesReportss")
	public Iterable<SalesReports> salesreportss() {
		return repository.findAll();
	}

	// returning one SalesReports only
	@RequestMapping("/SalesReports/{id}")
	public Optional<SalesReports> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new SalesReports
	@RequestMapping(value = "/SalesReports", method = RequestMethod.POST)
	public @ResponseBody SalesReports create(@RequestBody SalesReports item) {
		return repository.save(item);
	}

	 // update an existing SalesReports
	@RequestMapping(value = "/SalesReports", method = RequestMethod.PUT)
	public @ResponseBody SalesReports update(@RequestBody SalesReports item) {
		return repository.save(item);
	}

	 // delete a SalesReports
	@RequestMapping(value = "/SalesReports", method = RequestMethod.DELETE)
	public void delete(@RequestBody SalesReports item) {
		repository.delete(item);
	}

}