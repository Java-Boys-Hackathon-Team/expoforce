package ru.javaboys.expoforce.repository;

import io.jmix.core.repository.JmixDataRepository;
import ru.javaboys.expoforce.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JmixDataRepository<Product, UUID>  {
}
