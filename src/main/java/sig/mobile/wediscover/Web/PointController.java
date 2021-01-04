package sig.mobile.wediscover.Web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import sig.mobile.wediscover.Entities.PointInteret;
import sig.mobile.wediscover.Services.PointService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Point/")
public class PointController {
	@Autowired
private PointService service;
	@PostMapping("/postData")
	 public PointInteret AjouterPoint(@RequestParam("imagefile") MultipartFile file,
			 @RequestParam("nom") String nom,
			 @RequestParam("type") String type,
			 @RequestParam("description") String description,
			 @RequestParam("lat") float lat,
			 @RequestParam("lon") float lon)throws Exception{
		PointInteret Point=new PointInteret(nom, type, description, lat, lon, null);
//		System.out.println(Point.getDescription()+Point.getLat()+"++"+Point.getLon()+"++"+Point.getNom());
//		System.out.println(file.getContentType());
		try {
		System.out.println("he");
		PointInteret point=new PointInteret(nom, type, description, lat, lon, null);
		return service.AjouterPoint(Point,file);
		}catch(Exception e) {
			System.out.println("EZrreur"+e.getLocalizedMessage());
			return null;
		}
	}
	@GetMapping("/GetAll")
	 public List<PointInteret> GetAllPoint(){
		
		return service.GetListPoint();
	}
}
