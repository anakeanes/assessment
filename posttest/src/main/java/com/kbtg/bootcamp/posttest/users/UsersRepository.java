package com.kbtg.bootcamp.posttest.users;

import jakarta.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

    public Optional<Users> findBy(SingularAttribute<AbstractPersistable, Serializable> id);

}