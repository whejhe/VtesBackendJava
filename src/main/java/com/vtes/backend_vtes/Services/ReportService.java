package com.vtes.backend_vtes.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtes.backend_vtes.Entities.Report;
import com.vtes.backend_vtes.Repositories.ReportRepository;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    // GETTERS
    public List<Report> getAllReports() {
        try {
            return reportRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las cartas: " + e.getMessage());
        }
    }

    public Optional<Report> getReportById(Integer id) {
        try {
            return reportRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la carta con ID " + id + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByUserId(Integer userId) {
        try {
            return reportRepository.findByUser_id(userId);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas del usuario con ID " + userId + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByCardId(Integer cardId) {
        try {
            return reportRepository.findByCard_id(cardId);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas de la carta con ID " + cardId + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByCardName(String cardName) {
        try {
            return reportRepository.findByCard_name(cardName);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas de la carta con nombre " + cardName + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByCardAuthor(String cardAuthor) {
        try {
            return reportRepository.findByCard_author(cardAuthor);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas de la carta con autor " + cardAuthor + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByEmailReporter(String emailReporter) {
        try {
            return reportRepository.findByEmail_reporter(emailReporter);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas del usuario con email " + emailReporter + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByNameUserReporter(String nameUserReporter) {
        try {
            return reportRepository.findByName_user_reporter(nameUserReporter);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas del usuario con nombre " + nameUserReporter + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByReason(String reason) {
        try {
            return reportRepository.findByReason(reason);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas del usuario con nombre " + reason + ": " + e.getMessage());
        }
    }

    // SAVE
    public Report saveReport(Report report) {
        try {
            return reportRepository.save(report);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la carta: " + e.getMessage());
        }
    }

    // UPDATE
    public Report updateReport(Report report) {
        try {
            Optional<Report> existingReport = reportRepository.findById(report.getReport_id());
            if (existingReport.isPresent()) {
                Report updatedReport = existingReport.get();
                updatedReport.setUser_id(report.getUser_id());
                updatedReport.setCard_id(report.getCard_id());
                updatedReport.setCard_name(report.getCard_name());
                updatedReport.setCard_author(report.getCard_author());
                updatedReport.setEmail_reporter(report.getEmail_reporter());
                updatedReport.setName_user_reporter(report.getName_user_reporter());
                updatedReport.setReason(report.getReason());
                updatedReport.setComment(report.getComment());
                updatedReport.setIs_checked(report.getIs_checked());
                return reportRepository.save(updatedReport);
            } else {
                throw new RuntimeException("Report not found with id: " + report.getReport_id());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la carta: " + e.getMessage());
        }
    }

    // DELETE
    public void deleteReport(Integer id) {
        try {
            reportRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar la carta: " + e.getMessage());
        }
    }

    // DELETE BY USER ID
    public void deleteReportsByUserId(Integer userId) {
        try {
            reportRepository.deleteByUser_id(userId);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar las cartas del usuario " + userId + ": " + e.getMessage());
        }
    }

    // DELETE BY CARD ID
    public void deleteReportsByCardId(Integer cardId) {
        try {
            reportRepository.deleteByCard_id(cardId);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar las cartas de la carta " + cardId + ": " + e.getMessage());
        }
    }

    // DELETE BY CARD NAME
    public void deleteReportsByCardName(String cardName) {
        try {
            reportRepository.deleteByCard_name(cardName);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar las cartas de la carta " + cardName + ": " + e.getMessage());
        }
    }

    // DELETE BY CARD AUTHOR
    public void deleteReportsByCardAuthor(String cardAuthor) {
        try {
            reportRepository.deleteByCard_author(cardAuthor);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar las cartas de la carta " + cardAuthor + ": " + e.getMessage());
        }
    }

    // DELETE BY EMAIL REPORTER
    public void deleteReportsByEmailReporter(String emailReporter) {
        try {
            reportRepository.deleteByEmail_reporter(emailReporter);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al borrar las cartas del usuario " + emailReporter + ": " + e.getMessage());
        }
    }

    // DELETE BY NAME USER REPORTER
    public void deleteReportsByNameUserReporter(String nameUserReporter) {
        try {
            reportRepository.deleteByName_user_reporter(nameUserReporter);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al borrar las cartas del usuario " + nameUserReporter + ": " + e.getMessage());
        }
    }

    // DELETE BY REASON
    public void deleteReportsByReason(String reason) {
        try {
            reportRepository.deleteByReason(reason);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar las cartas del usuario " + reason + ": " + e.getMessage());
        }
    }
}
