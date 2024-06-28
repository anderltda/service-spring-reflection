package br.com.spring.reflection;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HandlerRepository extends CrudRepository<Dog, Long> {
	
	String FILTER_CUSTOMERS_ON_NAME_QUERY = "select d from Dog d where d.name like CONCAT('%',(?1),'%') ";

	@Query(FILTER_CUSTOMERS_ON_NAME_QUERY)
	List<Dog> findByNames(String name);

}