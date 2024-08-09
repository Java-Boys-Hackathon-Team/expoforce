package ru.javaboys.expoforce.repository;

import io.jmix.core.repository.JmixDataRepository;
import ru.javaboys.expoforce.entity.TouchPoints;

import java.util.UUID;

public interface TouchPointsRepository extends JmixDataRepository<TouchPoints, UUID> {
}
