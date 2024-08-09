package ru.javaboys.expoforce.ml;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javaboys.expoforce.entity.Client;
import ru.javaboys.expoforce.entity.Event;
import ru.javaboys.expoforce.entity.Product;
import ru.javaboys.expoforce.entity.TouchPoints;
import ru.javaboys.expoforce.repository.ClientRepository;
import ru.javaboys.expoforce.repository.EventRepository;
import ru.javaboys.expoforce.repository.ProductRepository;
import ru.javaboys.expoforce.repository.TouchPointsRepository;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataPreparation {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TouchPointsRepository touchPointsRepository;

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);

        return clients;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);

        return products;
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);

        return events;
    }

    public List<TouchPoints> getAllTouchPoints() {
        List<TouchPoints> touchPoints = new ArrayList<>();
        touchPointsRepository.findAll().forEach(touchPoints::add);

        return touchPoints;
    }

    public Instances prepareTrainingData() {
        List<Client> clients = getAllClients();
        List<Product> products = getAllProducts();
        List<Event> events = getAllEvents();
        List<TouchPoints> touchPoints = getAllTouchPoints();

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("age"));
        attributes.add(new Attribute("incomeAmount"));
        attributes.add(new Attribute("married"));
        attributes.add(new Attribute("productPrice"));
        attributes.add(new Attribute("productType"));

        Instances data = new Instances("TrainingData", attributes, clients.size());

        for (Client client : clients) {
            for (TouchPoints touchPoint : touchPoints) {
                if (touchPoint.getClient().getId().equals(client.getId())) {
                    DenseInstance instance = new DenseInstance(attributes.size());
                    instance.setValue(attributes.get(0), client.getAge());
                    instance.setValue(attributes.get(1), client.getIncomeAmount().doubleValue());
                    instance.setValue(attributes.get(2), client.getMarried() ? 1.0 : 0.0);
                    instance.setValue(attributes.get(3), touchPoint.getCost().doubleValue());

                    data.add(instance);
                }
            }
        }

        data.setClassIndex(data.numAttributes() - 1);
        return data;
    }
}
