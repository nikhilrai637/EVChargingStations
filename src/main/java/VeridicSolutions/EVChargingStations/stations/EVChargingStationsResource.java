package VeridicSolutions.EVChargingStations.stations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.io.File;


@RestController
public class EVChargingStationsResource {
    @Autowired
    private EVChargingStationService evChargingStationService;
    @Autowired
    private FileServiceImpl fileService;

    @Value("${project.image}")
    private String path;
    @RequestMapping("/show")
    public  EVChargingListV0 showAllStations(
            @RequestParam(value = "page",defaultValue = "1",required = false) Integer page,
            @RequestParam(value = "limit",defaultValue = "1",required = false) Integer limit
            ,@RequestParam(value = "sort", defaultValue = "asc", required = false) String sort
            ,@RequestParam(value = "param", defaultValue = "stationName", required = false) String param
    ) {
        Sort.Direction dir =  sort.compareTo("asc") == 0 ?  Sort.Direction.ASC :Sort.Direction.DESC;

        EVChargingListV0 evChargingListV0 = new EVChargingListV0(evChargingStationService
                                              .findPaginatedStationsWithSorting(page-1, limit,param,dir).stream().toList());

        EVChargingListV0 evChargingListV1 = new EVChargingListV0(evChargingStationService
                                             .findPaginatedStationsWithSorting(page, limit,param,dir).stream().toList());


         if(evChargingListV1.getEVChargingList().size() > 0){
             Link next = Link.of("/show?page="+ (page+1) +  "&limit=" + (limit)+ "&sort=" + (sort)+ "&param=" + (param));
             if(page > 1 ) {
                 Link prev = Link.of("/show?page=" + (page - 1) + "&limit=" + (limit )+ "&sort=" + (sort)+ "&param=" + (param));
                 evChargingListV0.add(prev);
             }
             evChargingListV0.add(next);

         }
         return evChargingListV0;

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
        System.out.println("Resource / hitted");
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

        @RequestMapping(value =  "/{imgName}", method = RequestMethod.GET,
                produces = MediaType.IMAGE_JPEG_VALUE)
        public void getImage(HttpServletResponse response,@PathVariable String imgName) throws IOException {
            InputStream resource = this.fileService.serveImage(path,imgName);
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(resource,response.getOutputStream());
        }

}





