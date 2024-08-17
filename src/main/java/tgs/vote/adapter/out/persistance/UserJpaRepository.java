package tgs.vote.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.model.persistence.user.UserEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

}
