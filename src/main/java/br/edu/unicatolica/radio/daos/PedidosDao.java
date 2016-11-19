package br.edu.unicatolica.radio.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import br.edu.unicatolica.radio.models.PaginatedList;
import br.edu.unicatolica.radio.models.PedidoMusical;

@Repository
public class PedidosDao
{

   @PersistenceContext
   private EntityManager manager;

   public List<PedidoMusical> all()
   {
      return manager.createQuery("select c from PedidoMusical c", PedidoMusical.class).getResultList();
   }

   public void save(PedidoMusical PedidoMusical)
   {
      manager.persist(PedidoMusical);
   }

   public PedidoMusical findById(Integer id)
   {
      return manager.find(PedidoMusical.class, id);
   }

   public void remove(PedidoMusical PedidoMusical)
   {
      manager.remove(PedidoMusical);
   }

   public void update(PedidoMusical PedidoMusical)
   {
      manager.merge(PedidoMusical);
   }

   public PaginatedList paginated(int page, int max)
   {
      return new PaginatorQueryHelper().list(manager, PedidoMusical.class, page, max);
   }

}
