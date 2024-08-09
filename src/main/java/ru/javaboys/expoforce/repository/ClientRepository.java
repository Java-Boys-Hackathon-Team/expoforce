package ru.javaboys.expoforce.repository;

import io.jmix.core.repository.JmixDataRepository;
import ru.javaboys.expoforce.entity.Client;

import java.util.UUID;

public interface ClientRepository extends JmixDataRepository<Client, UUID> {
}