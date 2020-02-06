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
public class InventoryTransactionTypesController {
	@Autowired
	private InventoryTransactionTypesRepository repository;

	// returning all InventoryTransactionTypess
	@RequestMapping("/InventoryTransactionTypess")
	public Iterable<InventoryTransactionTypes> inventorytransactiontypess() {
		return repository.findAll();
	}

	// returning one InventoryTransactionTypes only
	@RequestMapping("/InventoryTransactionTypes/{id}")
	public Optional<InventoryTransactionTypes> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new InventoryTransactionTypes
	@RequestMapping(value = "/InventoryTransactionTypes", method = RequestMethod.POST)
	public @ResponseBody InventoryTransactionTypes create(@RequestBody InventoryTransactionTypes item) {
		return repository.save(item);
	}

	 // update an existing InventoryTransactionTypes
	@RequestMapping(value = "/InventoryTransactionTypes", method = RequestMethod.PUT)
	public @ResponseBody InventoryTransactionTypes update(@RequestBody InventoryTransactionTypes item) {
		return repository.save(item);
	}

	 // delete a InventoryTransactionTypes
	@RequestMapping(value = "/InventoryTransactionTypes", method = RequestMethod.DELETE)
	public void delete(@RequestBody InventoryTransactionTypes item) {
		repository.delete(item);
	}

}