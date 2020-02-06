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
public class PurchaseOrderStatusController {
	@Autowired
	private PurchaseOrderStatusRepository repository;

	// returning all PurchaseOrderStatus
	@RequestMapping("/AllPurchaseOrderStatus")
	public Iterable<PurchaseOrderStatus> allPurchaseOrderStatus() {
		return repository.findAll();
	}

	// returning one PurchaseOrderStatus only
	@RequestMapping("/PurchaseOrderStatus/{id}")
	public Optional<PurchaseOrderStatus> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new PurchaseOrderStatus
	@RequestMapping(value = "/PurchaseOrderStatus", method = RequestMethod.POST)
	public @ResponseBody PurchaseOrderStatus create(@RequestBody PurchaseOrderStatus item) {
		return repository.save(item);
	}

	 // update an existing PurchaseOrderStatus
	@RequestMapping(value = "/PurchaseOrderStatus", method = RequestMethod.PUT)
	public @ResponseBody PurchaseOrderStatus update(@RequestBody PurchaseOrderStatus item) {
		return repository.save(item);
	}

	 // delete a PurchaseOrderStatus
	@RequestMapping(value = "/PurchaseOrderStatus", method = RequestMethod.DELETE)
	public void delete(@RequestBody PurchaseOrderStatus item) {
		repository.delete(item);
	}

}