package VeridicSolutions.EVChargingStations;

import org.springframework.beans.factory.annotation.Value;


import org.springframework.stereotype.Component;

@Component
public class Path {
    @Value("${project.image}")
    private String path;

    @Override
    public String toString() {
        return "Path{" +
                "path='" + path + '\'' +
                '}';
    }
}
