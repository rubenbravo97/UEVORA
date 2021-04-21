package org.thefarm.tweb.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findOneByUserName(String userName);

	User findById(long id);
}
