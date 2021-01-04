package sig.mobile.wediscover.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sig.mobile.wediscover.Entities.Utilisateur;
import sig.mobile.wediscover.Services.UtilisateurService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Account/")
public class LoginController {
	 @Autowired
	 private UtilisateurService service;
	 @PostMapping("/Register")
	    public Utilisateur Register(@RequestBody Utilisateur user){
	        return service.Register(user.getEmail(), user.getMot_passe());
	    }
	 @PostMapping("/Login")
	    public Utilisateur Login(@RequestBody Utilisateur user){
	        return service.LoginUser(user.getEmail(), user.getMot_passe());
	    }
	 @GetMapping("/hello")
	 public String Testwork() {
		 return "worked";
	 }

}
