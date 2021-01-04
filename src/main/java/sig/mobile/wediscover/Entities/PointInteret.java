package sig.mobile.wediscover.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PointInteret {
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
	private String nom;
	 @Getter @Setter
	private String type;
	 @Getter @Setter
	private String description;
	 @Getter @Setter
	 private byte[] image;
	 @Getter @Setter
	 private float lat;
	 @Getter @Setter
	 private float lon;
	public PointInteret(String nom, String type, String description, float lat, float lon, byte[] image) {
		super();
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.lat=lat;
		this.lon=lon;
		this.image = image;
	}
	public PointInteret() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}
