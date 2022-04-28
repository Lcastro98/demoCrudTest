package com.sofka.democrudtest.repositories;

import com.sofka.democrudtest.models.UserRolModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolRepository extends CrudRepository<UserRolModel, Long> {
}
