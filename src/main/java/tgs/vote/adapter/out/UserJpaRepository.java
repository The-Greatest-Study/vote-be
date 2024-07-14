package tgs.vote.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.out.model.user.UserEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

}
