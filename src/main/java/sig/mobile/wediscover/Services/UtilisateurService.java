package sig.mobile.wediscover.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sig.mobile.wediscover.Dao.UserRepository;
import sig.mobile.wediscover.Entities.Utilisateur;

@Service
public class UtilisateurService {
	@Autowired
	private UserRepository repos;
	public Utilisateur Register(String email,String password ) {
		Utilisateur user=new Utilisateur(email, password);
		return repos.save(user);
	}
	public Utilisateur LoginUser(String email,String password) {
		List<Utilisateur> users= repos.findAll().stream().filter(e->
			e.getEmail().equals(email) && e.getMot_passe().equals(password)
		).collect(Collectors.toList());
		if(users.size()==0)
			return null;
		else 
			return users.get(0);
	}

}
