package service;

import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import util.DbUtil;

import java.util.List;

public class StudentService {

    private EntityManager entityManager;

    public StudentService(){
        entityManager = DbUtil.getEntityManager();
    }

    public void saveStudent(Student student){

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    public List<Student> findAllStudents(){
        Query selectAll = null;
        try{
            entityManager.getTransaction().begin();
            selectAll  = entityManager.createQuery("from Student");
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        return selectAll.getResultList();
    }

    public void updateStudentById(String name, int id){

        try{
            entityManager.getTransaction().begin();
            Query updateQuery = entityManager.createQuery("update Student s set s.name = :name where s.id = :id");
            updateQuery.setParameter("name", name);
            updateQuery.setParameter("id", id);
            updateQuery.executeUpdate();
            entityManager.getTransaction().commit();

        }catch(Exception e){
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    public void deleteStudentByName(String name){
        try{
            entityManager.getTransaction().begin();
            Query deleteQuery = entityManager.createQuery("delete from Student s where s.name like :name");
            deleteQuery.setParameter("name", '%'+name+'%');
            deleteQuery.executeUpdate();
            entityManager.getTransaction().commit();

        }catch (Exception e){
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
    }
}
