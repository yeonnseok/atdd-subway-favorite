package wooteco.subway.web.station;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wooteco.subway.domain.station.Station;
import wooteco.subway.service.station.StationService;
import wooteco.subway.service.station.dto.StationCreateRequest;
import wooteco.subway.service.station.dto.StationResponse;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public ResponseEntity<Void> createStation(
            @Valid @RequestBody StationCreateRequest request
    ) {
        Station persistStation = stationService.createStation(request.toStation());

        return ResponseEntity
                .created(URI.create("/stations/" + persistStation.getId()))
                .build();
    }

    @GetMapping
    public ResponseEntity<List<StationResponse>> showStations() {
        return ResponseEntity.ok().body(StationResponse.listFrom(stationService.findStations()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        stationService.deleteStationById(id);
        return ResponseEntity.noContent().build();
    }
}
