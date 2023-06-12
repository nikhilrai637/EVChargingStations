package VeridicSolutions.EVChargingStations.stations;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
    public String uploadImage(String path , MultipartFile file) throws IOException;
    public InputStream serveImage(String path, String fileName) throws FileNotFoundException;
}
