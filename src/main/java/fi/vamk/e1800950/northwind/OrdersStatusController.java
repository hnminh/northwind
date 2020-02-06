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
public class OrdersStatusController {
	@Autowired
	private OrdersStatusRepository repository;

	// returning all OrdersStatuss
	@RequestMapping("/OrdersStatuss")
	public Iterable<OrdersStatus> ordersstatuss() {
		return repository.findAll();
	}

	// returning one OrdersStatus only
	@RequestMapping("/OrdersStatus/{id}")
	public Optional<OrdersStatus> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new OrdersStatus
	@RequestMapping(value = "/OrdersStatus", method = RequestMethod.POST)
	public @ResponseBody OrdersStatus create(@RequestBody OrdersStatus item) {
		return repository.save(item);
	}

	 // update an existing OrdersStatus
	@RequestMapping(value = "/OrdersStatus", method = RequestMethod.PUT)
	public @ResponseBody OrdersStatus update(@RequestBody OrdersStatus item) {
		return repository.save(item);
	}

	 // delete a OrdersStatus
	@RequestMapping(value = "/OrdersStatus", method = RequestMethod.DELETE)
	public void delete(@RequestBody OrdersStatus item) {
		repository.delete(item);
	}

}