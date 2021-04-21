package org.thefarm.tweb.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Product, Long> {

        List<Product> findOneByname(String name);

        List<Product> findAllByName(String name);

        Product findById(long id);

        List<Product> findAllByType(String type);

        List<Product> findAllByTypeAndPriceBetween(String type,int min, int max);

        List<Product> findAllByPriceBetween(int min, int max);
}
