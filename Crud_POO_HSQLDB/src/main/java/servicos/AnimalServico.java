package servicos;

import entidades.Animal;

import java.util.List;

public class AnimalServico {

public void inserir(Animal animal)
{
try (var em = HibernateUtil.criarEntityManager()) {
    em.getTransaction().begin();
    em.merge(animal);
    em.getTransaction().commit();
}
}
public List<Animal> listarTodos() {
    try (var em = HibernateUtil.criarEntityManager()){
        return em.createQuery("from Animal a", Animal.class).getResultList();
    }
}

public void excluir(long id) {
    try (var em = HibernateUtil.criarEntityManager()) {
        em.getTransaction().begin();
        var esp = em.find(Animal.class, id);
        if (esp != null) {
            em.remove(esp);
        }
        em.getTransaction().commit();
    }
}
public void alterarComObjetoNaoGerenciado(Animal animal) {
    try (var em = HibernateUtil.criarEntityManager()) {
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
    }
}
    public Animal encontrarAnimal(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Animal.class, id);
        }
    }
}
