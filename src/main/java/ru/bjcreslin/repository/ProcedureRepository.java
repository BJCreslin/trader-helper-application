package ru.bjcreslin.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import ru.bjcreslin.domain.Procedure;

/**
 * Spring Data  repository for the Procedure entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {}
