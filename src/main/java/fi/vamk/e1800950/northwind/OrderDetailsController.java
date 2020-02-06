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
public class OrderDetailsController {
	@Autowired
	private OrderDetailsRepository repository;

	// returning all OrderDetailss
	@RequestMapping("/OrderDetailss")
	public Iterable<OrderDetails> orderdetailss() {
		return repository.findAll();
	}

	// returning one OrderDetails only
	@RequestMapping("/OrderDetails/{id}")
	public Optional<OrderDetails> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new OrderDetails
	@RequestMapping(value = "/OrderDetails", method = RequestMethod.POST)
	public @ResponseBody OrderDetails create(@RequestBody OrderDetails item) {
		return repository.save(item);
	}

	 // update an existing OrderDetails
	@RequestMapping(value = "/OrderDetails", method = RequestMethod.PUT)
	public @ResponseBody OrderDetails update(@RequestBody OrderDetails item) {
		return repository.save(item);
	}

	 // delete a OrderDetails
	@RequestMapping(value = "/OrderDetails", method = RequestMethod.DELETE)
	public void delete(@RequestBody OrderDetails item) {
		repository.delete(item);
	}

}