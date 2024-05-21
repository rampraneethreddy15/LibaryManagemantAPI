package libgenesis.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libgenesis.models.members;

@Repository
public interface membersRepo extends JpaRepository<members, UUID>{

}
