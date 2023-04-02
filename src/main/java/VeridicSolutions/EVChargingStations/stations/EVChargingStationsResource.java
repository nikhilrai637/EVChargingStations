package VeridicSolutions.EVChargingStations.stations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Watchable;
import java.security.SecureRandom;
import java.util.List;


@RestController
public class EVChargingStationsResource {
    @Autowired
    private EVChargingStationService evChargingStationService;
    @Autowired
    private FileServiceImpl fileService;

    @Value("${project.image}")
    private String path;
    @RequestMapping("/show")
    public List<EVChargingStation> showAllStations() {
        return evChargingStationService.showAll();
    }

    @RequestMapping("/show/{id}")
    public EVChargingStation showAllStationsById(@PathVariable String id){
        return     evChargingStationService.showById(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.POST,
    consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })

    public void insertStation(@RequestPart("image") MultipartFile image,
                              @RequestPart String station
                                    )   {

        EVChargingStation stationJson = new EVChargingStation();
        try {
              stationJson = new ObjectMapper().readValue(station,EVChargingStation.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String fileName = null;
        try {
            fileName = this.fileService.uploadImage(this.path,image);
//            return new ResponseEntity<>(new FileResponse(fileName,
//                    "file uploaded successfully")
//                    , HttpStatus.OK);
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
//            return new ResponseEntity<>(new FileResponse(null,
//                    "file not  uploaded successfully")
//                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        SecureRandom secureRandom = new SecureRandom();
        String station_id = secureRandom.generateSeed(32).toString();
        stationJson.setStation_id(station_id);
        stationJson.setStation_image(fileName);
        evChargingStationService.addStation(stationJson);
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.PUT)
    public void editStations( @PathVariable String id, @RequestBody EVChargingStation station) {
            evChargingStationService.editStation(id,station);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void deleteStations( @PathVariable String id) {
            evChargingStationService.deleteStation(id);
    }

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image){

              String fileName = null;
              try {
                  fileName = this.fileService.uploadImage(this.path,image);
                  return new ResponseEntity<>(new FileResponse(fileName,
                          "file uploaded successfully")
                          , HttpStatus.OK);
              } catch (IOException ex) {
                  System.out.println(ex.getStackTrace());
                  return new ResponseEntity<>(new FileResponse(null,
                                        "file not  uploaded successfully")
                          , HttpStatus.INTERNAL_SERVER_ERROR);
              }

          }

}


