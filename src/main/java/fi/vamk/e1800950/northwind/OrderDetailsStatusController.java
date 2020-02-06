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
public class OrderDetailsStatusController {
	@Autowired
	private OrderDetailsStatusRepository repository;

	// returning all OrderDetailsStatuss
	@RequestMapping("/OrderDetailsStatuss")
	public Iterable<OrderDetailsStatus> orderdetailsstatuss() {
		return repository.findAll();
	}

	// returning one OrderDetailsStatus only
	@RequestMapping("/OrderDetailsStatus/{id}")
	public Optional<OrderDetailsStatus> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new OrderDetailsStatus
	@RequestMapping(value = "/OrderDetailsStatus", method = RequestMethod.POST)
	public @ResponseBody OrderDetailsStatus create(@RequestBody OrderDetailsStatus item) {
		return repository.save(item);
	}

	 // update an existing OrderDetailsStatus
	@RequestMapping(value = "/OrderDetailsStatus", method = RequestMethod.PUT)
	public @ResponseBody OrderDetailsStatus update(@RequestBody OrderDetailsStatus item) {
		return repository.save(item);
	}

	 // delete a OrderDetailsStatus
	@RequestMapping(value = "/OrderDetailsStatus", method = RequestMethod.DELETE)
	public void delete(@RequestBody OrderDetailsStatus item) {
		repository.delete(item);
	}

}