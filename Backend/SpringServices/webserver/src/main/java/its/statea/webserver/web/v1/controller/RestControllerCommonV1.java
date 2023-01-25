package its.statea.webserver.web.v1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import its.statea.webserver.db.service.DestinationService;
import its.statea.webserver.db.service.OriginService;
import its.statea.webserver.web.v1.payload.request.paramEnum.DestinationSortEnum;
import its.statea.webserver.web.v1.payload.request.paramEnum.OriginSortEnum;
import its.statea.webserver.web.v1.payload.response.DestinationResponse;
import its.statea.webserver.web.v1.payload.response.OriginResponse;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/v1")
public class RestControllerCommonV1 {

    @Autowired OriginService originService;
    @Autowired DestinationService destinationService;

    @GetMapping("/origins")
    public ResponseEntity<List<OriginResponse>> getOrigins(@RequestParam(required = false) Boolean isCountry, @RequestParam(defaultValue = "id") OriginSortEnum sortBy, @RequestParam(defaultValue = "true") Boolean ascendingOrder) {

        List<OriginResponse> responseBody = originService.fetchOriginList((isCountry != null)? !isCountry : null,
        sortBy.toString(),
        ascendingOrder, 
        (obj) -> {
            var res = new OriginResponse();
            res.setOriginDatamapFields(obj);
            return res;
        });

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/origins/{id}")
    public ResponseEntity<OriginResponse> getOriginById(@PathVariable String id) {

        Optional<OriginResponse> result = originService.fetchById(id, 
        (obj) -> {
            var res = new OriginResponse();
            res.setOriginDatamapFields(obj);
            return res;
        });

        if (result.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @GetMapping("/destinations")
    public ResponseEntity<List<DestinationResponse>> getDestinations(@RequestParam(required = false) Boolean isDistrict, @RequestParam(defaultValue = "id") DestinationSortEnum sortBy, @RequestParam(defaultValue = "true") Boolean ascendingOrder) {

        List<DestinationResponse> responseBody = destinationService.fetchDestinationList((isDistrict != null)? !isDistrict : null,
        sortBy.toString(),
        ascendingOrder, 
        (obj) -> {
            var res = new DestinationResponse();
            res.setDestinationDatamapFields(obj);
            return res;
        });

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/destinations/{id}")
    public ResponseEntity<DestinationResponse> getDestinationById(@PathVariable String id) {

        Optional<DestinationResponse> result = destinationService.fetchById(id, 
        (obj) -> {
            var res = new DestinationResponse();
            res.setDestinationDatamapFields(obj);
            return res;
        });

        if (result.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }
}