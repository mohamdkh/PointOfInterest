package sig.mobile.wediscover.Services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sig.mobile.wediscover.Dao.PointInteretRepository;
import sig.mobile.wediscover.Entities.PointInteret;

@Service
public class PointService {
@Autowired
private PointInteretRepository repos;
public PointInteret AjouterPoint(PointInteret point,MultipartFile file)  {
	try {
		byte[] compressedimg=this.compressBytes(file.getBytes());
	PointInteret savedpoint=new PointInteret(point.getNom(), point.getType(), point.getDescription(),point.getLat(),
			point.getLon(),
			compressedimg
			);
	return repos.save(savedpoint);	
	}catch(Exception e){
		System.out.println("error");
		return null;
	}
}
public List<PointInteret> GetListPoint(){
	List<PointInteret> points=new ArrayList<PointInteret>();
	 repos.findAll().forEach(elem->{
		 elem.setImage(this.decompressBytes(elem.getImage()));
		 points.add(elem);
	 });
	 return points;
}

private byte[] compressBytes(byte[] data) {
    Deflater deflater = new Deflater();
    deflater.setInput(data);
    deflater.finish();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    while (!deflater.finished()) {
        int count = deflater.deflate(buffer);
        outputStream.write(buffer, 0, count);
    }
    try {
        outputStream.close();
    } catch (IOException e) {
    }
    return outputStream.toByteArray();
}
public static byte[] decompressBytes(byte[] data) {
    Inflater inflater = new Inflater();
    inflater.setInput(data);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    try {
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
    } catch (IOException ioe) {
    } catch (DataFormatException e) {
    }
    return outputStream.toByteArray();
}
}
