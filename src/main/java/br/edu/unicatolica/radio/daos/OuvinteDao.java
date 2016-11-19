package br.edu.unicatolica.radio.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.edu.unicatolica.radio.models.PaginatedList;
import br.edu.unicatolica.radio.models.Ouvinte;

@Repository
public class OuvinteDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<Ouvinte> all()
   {
      return manager.createQuery("select c from Ouvinte c", Ouvinte.class).getResultList();
   }

   public void save(Ouvinte Ouvinte)
   {
      manager.persist(Ouvinte);
   }

   public Ouvinte findById(Integer id)
   {
      return manager.find(Ouvinte.class, id);
   }

   public void remove(Ouvinte Ouvinte)
   {
      manager.remove(Ouvinte);
   }

   public void update(Ouvinte Ouvinte)
   {
      manager.merge(Ouvinte);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Ouvinte.class, page, max);
   }

}
