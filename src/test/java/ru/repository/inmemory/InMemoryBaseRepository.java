package ru.repository.inmemory;

import org.springframework.stereotype.Repository;
import ru.javawebinar.clients.model.AbstractBaseEntity;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryBaseRepository<T extends AbstractBaseEntity> {

    private static AtomicInteger counter = new AtomicInteger(0);

    Map<Integer, T> entryMap = new ConcurrentHashMap<>();

    public T save(T entry) {
        if (entry.isNew()) {
            entry.setId(counter.incrementAndGet());
            entryMap.put(entry.getId(), entry);
            return entry;
        }
        return entryMap.computeIfPresent(entry.getId(), (id, oldT) -> entry);
    }

    public boolean delete(int id) {
        return entryMap.remove(id) != null;
    }

    public T get(int id) {
        return entryMap.get(id);
    }

    Collection<T> getCollection() {
        return entryMap.values();
    }
}