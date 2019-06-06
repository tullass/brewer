package co.mz.schoolCtrl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.mz.schoolCtrl.model.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

	
}
