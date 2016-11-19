package br.edu.unicatolica.radio.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao
{

   @PersistenceContext
   private EntityManager manager;

   /*public List<Category> all()
   {
      return manager.createQuery("select c from Category c", Category.class).getResultList();
   }

   public void save(Category category)
   {
      manager.persist(category);
   }

   public Category findById(Integer id)
   {
      return manager.find(Category.class, id);
   }

   public void remove(Category category)
   {
      manager.remove(category);
   }

   public void update(Category category)
   {
      manager.merge(category);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, Category.class, page, max);
   }
*/
}
