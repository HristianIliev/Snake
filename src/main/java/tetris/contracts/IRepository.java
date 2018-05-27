package tetris.contracts;

import java.util.List;

public interface IRepository<T extends IEntity> {
  List<T> getAll();

  T getById(int id);

  T create(T entity);

  T delete(T entity);

  T update(T entity);
}
