package its.statea.webserver.web.v1.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import its.statea.webserver.db.service.ObservationMonthCustomViewService;
import its.statea.webserver.db.service.ObservationYearService;
import its.statea.webserver.web.common.controller.error.MyHttpException;
import its.statea.webserver.web.v1.payload.request.paramEnum.ObservationMonthSortEnum;
import its.statea.webserver.web.v1.payload.request.paramEnum.ObservationYearSortEnum;
import its.statea.webserver.web.v1.payload.response.AnnualRecordResponse;
import its.statea.webserver.web.v1.payload.response.DatesRangeResponse;
import its.statea.webserver.web.v1.payload.response.MonthlyRecordResponse;
import its.statea.webserver.web.v1.payload.response.YearsRangeResponse;
import jakarta.validation.constraints.Pattern;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/v1/data")
public class RestControllerDataV1 {

    @Autowired ObservationYearService observationYearService;
    @Autowired ObservationMonthCustomViewService observationMonthCustomViewService;

    @GetMapping("/dates/range")
    public ResponseEntity<DatesRangeResponse> getDatesRange() throws MyHttpException {

        DatesRangeResponse responseBody = observationMonthCustomViewService.fetchDatesRange(

            (d1, d2) -> new DatesRangeResponse(d1, d2)
        );

        if (responseBody == null) {

            throw new MyHttpException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching the range"); // INTERNAL_SERVER_ERROR - no range found in DB
        }

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/years/range")
    public ResponseEntity<YearsRangeResponse> getYearsRange() throws MyHttpException {

        YearsRangeResponse responseBody = observationYearService.fetchYearsRange(

            (y1, y2) -> new YearsRangeResponse(y1, y2)
        );

        if (responseBody == null) {

            throw new MyHttpException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching the range"); // INTERNAL_SERVER_ERROR - no range found in DB
        }

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/annual/origin/{originId}/destination/{destinationId}/type/{observationTypeId}")
    public ResponseEntity<List<AnnualRecordResponse>> getObservationAnnual(@PathVariable String originId, @PathVariable String destinationId, @PathVariable String observationTypeId, @RequestParam(defaultValue = "1900") @Pattern(regexp = "^[1-2][0-9][0-9][0-9]$") String startYear, @RequestParam(defaultValue = "2999") @Pattern(regexp = "^[1-2][0-9][0-9][0-9]$") String endYear, @RequestParam(defaultValue = "year") ObservationYearSortEnum sortBy, @RequestParam(defaultValue = "true") Boolean ascendingOrder) {

        List<AnnualRecordResponse> responseBody = observationYearService.fetchObservationYearList(originId, destinationId, observationTypeId, startYear, endYear,
        sortBy.toString(),
        ascendingOrder, 
        (obj) -> {
            var res = new AnnualRecordResponse();
            res.setYearRecordDatamapFields(obj);
            return res;
        });

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/monthly/origin/{originId}/destination/{destinationId}/type/{observationTypeId}")
    public ResponseEntity<List<MonthlyRecordResponse>> getObservationMonthly(@PathVariable String originId, @PathVariable String destinationId, @PathVariable String observationTypeId, @RequestParam(defaultValue = "1900-01-01") @DateTimeFormat(iso = ISO.DATE) LocalDate startDate, @RequestParam(defaultValue = "2999-12-01") @DateTimeFormat(iso = ISO.DATE) LocalDate endDate, @RequestParam(defaultValue = "date") ObservationMonthSortEnum sortBy, @RequestParam(defaultValue = "true") Boolean ascendingOrder) {

        List<MonthlyRecordResponse> responseBody = observationMonthCustomViewService.fetchObservationMonthList(originId, destinationId, observationTypeId, startDate, endDate,
        sortBy.toString(),
        ascendingOrder, 
        (obj) -> {
            var res = new MonthlyRecordResponse();
            res.setMonthRecordDatamapFields(obj);
            return res;
        });

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}