package VeridicSolutions.EVChargingStations.stations;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public   class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        //File Name
        String name = file.getOriginalFilename();
        //Full Path

        String randomID  = UUID.randomUUID().toString();
        String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
        String filePath = path + File.separator + fileName1;

        //Create folder if not created
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }
        //save : copy from source to target folder
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return fileName1;
    }
}