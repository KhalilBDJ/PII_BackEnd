package com.PII.backend.Repositories;

import com.PII.backend.Classes.ImageObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageObjectRepository extends JpaRepository<ImageObject, Long> {
}
