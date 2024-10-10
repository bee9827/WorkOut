package GraduationProject.WorkOut.repository;

import GraduationProject.WorkOut.domain.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
}
