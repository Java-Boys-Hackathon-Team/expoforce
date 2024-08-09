package ru.javaboys.expoforce.repository;

import io.jmix.core.repository.JmixDataRepository;
import ru.javaboys.expoforce.entity.Source;

import java.util.UUID;

public interface SourceRepository extends JmixDataRepository<Source, UUID>  {
}
