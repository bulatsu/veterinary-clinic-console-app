package src.repository;

import java.util.List;

public interface GenericRepository<T> {

    List <T> getAll();

    void create(T t);

    void edit (int index, T t);

    void remove (T t);
}
