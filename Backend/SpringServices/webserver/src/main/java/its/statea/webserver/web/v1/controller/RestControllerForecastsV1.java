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

import its.statea.webserver.db.service.PredictionMonthService;
import its.statea.webserver.db.service.PredictionYearService;
import its.statea.webserver.web.common.controller.error.MyHttpException;
import its.statea.webserver.web.v1.payload.request.paramEnum.PredictionMonthSortEnum;
import its.statea.webserver.web.v1.payload.request.paramEnum.PredictionYearSortEnum;
import its.statea.webserver.web.v1.payload.response.AnnualRecordResponse;
import its.statea.webserver.web.v1.payload.response.DatesRangeResponse;
import its.statea.webserver.web.v1.payload.response.MonthlyRecordResponse;
import its.statea.webserver.web.v1.payload.response.YearsRangeResponse;
import jakarta.validation.constraints.Pattern;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/v1/forecasts")
public class RestControllerForecastsV1 {

    @Autowired PredictionYearService predictionYearService;
    @Autowired PredictionMonthService predictionMonthService;

    @GetMapping("/dates/range")
    public ResponseEntity<DatesRangeResponse> getDatesRange() throws MyHttpException {

        DatesRangeResponse responseBody = predictionMonthService.fetchDatesRange(

            (d1, d2) -> new DatesRangeResponse(d1, d2)
        );

        if (responseBody == null) {

            throw new MyHttpException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching the range"); // INTERNAL_SERVER_ERROR - no range found in DB
        }

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/years/range")
    public ResponseEntity<YearsRangeResponse> getYearsRange() throws MyHttpException {

        YearsRangeResponse responseBody = predictionYearService.fetchYearsRange(

            (y1, y2) -> new YearsRangeResponse(y1, y2)
        );

        if (responseBody == null) {

            throw new MyHttpException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching the range"); // INTERNAL_SERVER_ERROR - no range found in DB
        }

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/annual/origin/{originId}/destination/{destinationId}/type/{observationTypeId}")
    public ResponseEntity<List<AnnualRecordResponse>> getPredictionAnnual(@PathVariable String originId, @PathVariable String destinationId, @PathVariable String observationTypeId, @RequestParam(defaultValue = "2023") @Pattern(regexp = "^[1-2][0-9][0-9][0-9]$") String startYear, @RequestParam(defaultValue = "2999") @Pattern(regexp = "^[1-2][0-9][0-9][0-9]$") String endYear, @RequestParam(defaultValue = "year") PredictionYearSortEnum sortBy, @RequestParam(defaultValue = "true") Boolean ascendingOrder) {

        List<AnnualRecordResponse> responseBody = predictionYearService.fetchPredictionYearList(originId, destinationId, observationTypeId, startYear, endYear,
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
    public ResponseEntity<List<MonthlyRecordResponse>> getPredictionMonthly(@PathVariable String originId, @PathVariable String destinationId, @PathVariable String observationTypeId, @RequestParam(defaultValue = "2023-01-01") @DateTimeFormat(iso = ISO.DATE) LocalDate startDate, @RequestParam(defaultValue = "2999-12-01") @DateTimeFormat(iso = ISO.DATE) LocalDate endDate, @RequestParam(defaultValue = "date") PredictionMonthSortEnum sortBy, @RequestParam(defaultValue = "true") Boolean ascendingOrder) {

        List<MonthlyRecordResponse> responseBody = predictionMonthService.fetchPredictionMonthList(originId, destinationId, observationTypeId, startDate, endDate,
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