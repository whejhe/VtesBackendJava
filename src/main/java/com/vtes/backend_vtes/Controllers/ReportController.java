package com.vtes.backend_vtes.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtes.backend_vtes.Entities.Report;
import com.vtes.backend_vtes.Services.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public Optional<Report> getReportById(@PathVariable Integer id) {
        return reportService.getReportById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Report> getReportsByUserId(@PathVariable Integer userId) {
        return reportService.getReportsByUserId(userId);
    }

    @GetMapping("/card/{cardId}")
    public List<Report> getReportsByCardId(@PathVariable Integer cardId) {
        return reportService.getReportsByCardId(cardId);
    }

    @GetMapping("/card/name/{cardName}")
    public List<Report> getReportsByCardName(@PathVariable String cardName) {
        return reportService.getReportsByCardName(cardName);
    }

    @GetMapping("/card/author/{cardAuthor}")
    public List<Report> getReportsByCardAuthor(@PathVariable String cardAuthor) {
        return reportService.getReportsByCardAuthor(cardAuthor);
    }

    @GetMapping("/reporter/email/{emailReporter}")
    public List<Report> getReportsByEmailReporter(@PathVariable String emailReporter) {
        return reportService.getReportsByEmailReporter(emailReporter);
    }

    @GetMapping("/reporter/name/{nameUserReporter}")
    public List<Report> getReportsByNameUserReporter(@PathVariable String nameUserReporter) {
        return reportService.getReportsByNameUserReporter(nameUserReporter);
    }

    @GetMapping("/reason/{reason}")
    public List<Report> getReportsByReason(@PathVariable String reason) {
        return reportService.getReportsByReason(reason);
    }

    @PostMapping
    public Report saveReport(@RequestBody Report report) {
        return reportService.saveReport(report);
    }

    @PutMapping("/{id}")
    public Report updateReport(@PathVariable Integer id, @RequestBody Report report) {
        report.setReport_id(id);
        return reportService.saveReport(report);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Integer id) {
        reportService.deleteReport(id);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteReportsByUserId(@PathVariable Integer userId) {
        reportService.deleteReportsByUserId(userId);
    }

    @DeleteMapping("/card/{cardId}")
    public void deleteReportsByCardId(@PathVariable Integer cardId) {
        reportService.deleteReportsByCardId(cardId);
    }

    @DeleteMapping("/card/name/{cardName}")
    public void deleteReportsByCardName(@PathVariable String cardName) {
        reportService.deleteReportsByCardName(cardName);
    }

    @DeleteMapping("/card/author/{cardAuthor}")
    public void deleteReportsByCardAuthor(@PathVariable String cardAuthor) {
        reportService.deleteReportsByCardAuthor(cardAuthor);
    }

    @DeleteMapping("/reporter/email/{emailReporter}")
    public void deleteReportsByEmailReporter(@PathVariable String emailReporter) {
        reportService.deleteReportsByEmailReporter(emailReporter);
    }

    @DeleteMapping("/reporter/name/{nameUserReporter}")
    public void deleteReportsByNameUserReporter(@PathVariable String nameUserReporter) {
        reportService.deleteReportsByNameUserReporter(nameUserReporter);
    }

    @DeleteMapping("/reason/{reason}")
    public void deleteReportsByReason(@PathVariable String reason) {
        reportService.deleteReportsByReason(reason);
    }
}
