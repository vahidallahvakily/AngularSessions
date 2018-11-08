package ir.co.isc.software.angulartraining.service;

import ir.co.isc.software.angulartraining.entity.Employee;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 *  *
 *  * @author V_Alahvakil
 *    CreateDateTime 11/8/2018
 *  
 */
@Stateless
@LocalBean
public class EmployeeService {

    @PersistenceContext(name = "ISCPU")
    private EntityManager em;

    public Employee getEmployee(Long id){
        return em.find(Employee.class,id);
    }

    public List<Employee> getEmployees(Integer page,Integer pageSize){
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> rootObject = cq.from(Employee.class);
            //Select From Object
            cq.select(rootObject);
            TypedQuery<Employee> q =em.createQuery(cq);
            q= q.setMaxResults(pageSize).setFirstResult( (page-1)*pageSize);
            List<Employee> lstResult = q.getResultList();
            return lstResult;
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    public boolean save(Employee emp){
        try
        {
            em.merge(emp);
            em.flush();
            return true;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }

    }
}
