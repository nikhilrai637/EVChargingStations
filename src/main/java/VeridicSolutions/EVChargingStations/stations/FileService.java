package VeridicSolutions.EVChargingStations.stations;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public void uploadImage(String path , MultipartFile file);
}
