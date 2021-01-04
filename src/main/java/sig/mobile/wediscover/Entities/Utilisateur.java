package sig.mobile.wediscover.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Utilisateur {
	 @Id
	    @GeneratedValue(
	            strategy= GenerationType.AUTO,
	            generator="native"
	    )
	    @GenericGenerator(
	            name = "native",
	            strategy = "native"
	    )
	    @Getter @Setter
	    private int id;
	    @Getter @Setter
	    private String email;
	    @Getter @Setter
	    private String mot_passe;
		public Utilisateur( String email, String mot_passe) {
			super();
			this.email = email;
			this.mot_passe = mot_passe;
		}
		public Utilisateur() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}
