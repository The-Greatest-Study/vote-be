package tgs.vote.adapter.out.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.out.model.persistence.user.UserEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

}
