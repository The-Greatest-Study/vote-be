package tgs.vote.adapter.out.persistance;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.model.user.UserEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByProviderId(String providerId);
}
