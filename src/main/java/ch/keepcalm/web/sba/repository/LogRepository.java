package ch.keepcalm.web.sba.repository;

import ch.keepcalm.web.sba.domain.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntity, Long> {



}
