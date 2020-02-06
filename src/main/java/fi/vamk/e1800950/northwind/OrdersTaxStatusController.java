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
public class OrdersTaxStatusController {
	@Autowired
	private OrdersTaxStatusRepository repository;

	// returning all OrdersTaxStatuss
	@RequestMapping("/OrdersTaxStatuss")
	public Iterable<OrdersTaxStatus> orderstaxstatuss() {
		return repository.findAll();
	}

	// returning one OrdersTaxStatus only
	@RequestMapping("/OrdersTaxStatus/{id}")
	public Optional<OrdersTaxStatus> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new OrdersTaxStatus
	@RequestMapping(value = "/OrdersTaxStatus", method = RequestMethod.POST)
	public @ResponseBody OrdersTaxStatus create(@RequestBody OrdersTaxStatus item) {
		return repository.save(item);
	}

	 // update an existing OrdersTaxStatus
	@RequestMapping(value = "/OrdersTaxStatus", method = RequestMethod.PUT)
	public @ResponseBody OrdersTaxStatus update(@RequestBody OrdersTaxStatus item) {
		return repository.save(item);
	}

	 // delete a OrdersTaxStatus
	@RequestMapping(value = "/OrdersTaxStatus", method = RequestMethod.DELETE)
	public void delete(@RequestBody OrdersTaxStatus item) {
		repository.delete(item);
	}

}