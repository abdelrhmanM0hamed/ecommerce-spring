//Data Access layer , access directly to Db
// el interface da dlwaaty mkhlene 3ndy implemented functions w gahza eni astkhdmha m3 el Db
package com.programmingtechie.product_service.repository;
import com.programmingtechie.product_service.model.Product; // da bywadda7 en elrepository di htt3aml m3 el product type
import org.springframework.data.mongodb.repository.MongoRepository;// di contains ready functions zy el save wel find w shwyt built in functions mofeeda bdl ma aktebha tany

public interface ProductRepository extends MongoRepository<Product, String > {

}
