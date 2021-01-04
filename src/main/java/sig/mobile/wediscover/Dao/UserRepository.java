package sig.mobile.wediscover.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sig.mobile.wediscover.Entities.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur,Integer>{

}
