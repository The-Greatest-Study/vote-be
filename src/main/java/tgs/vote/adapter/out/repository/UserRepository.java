package tgs.vote.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tgs.vote.adapter.out.model.persistence.user.UserEntity;
import tgs.vote.adapter.out.model.persistence.vote.VoteEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
