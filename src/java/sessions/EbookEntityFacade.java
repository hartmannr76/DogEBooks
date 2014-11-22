/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entity.EbookEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author
 * Piotr
 */
@Stateless
public class EbookEntityFacade extends AbstractFacade<EbookEntity> {
    @PersistenceContext(unitName = "cse308entitytestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EbookEntityFacade() {
        super(EbookEntity.class);
    }
    
}
