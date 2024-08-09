package ru.javaboys.expoforce.repository;

import io.jmix.core.repository.JmixDataRepository;
import ru.javaboys.expoforce.entity.Event;

import java.util.UUID;

public interface EventRepository extends JmixDataRepository<Event, UUID>  {
}
