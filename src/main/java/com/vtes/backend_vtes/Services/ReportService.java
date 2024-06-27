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
            return reportRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas del usuario con ID " + userId + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByCardId(Integer cardId) {
        try {
            return reportRepository.findByCardId(cardId);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas de la carta con ID " + cardId + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByCardName(String cardName) {
        try {
            return reportRepository.findByCardName(cardName);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas de la carta con nombre " + cardName + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByCardAuthor(String cardAuthor) {
        try {
            return reportRepository.findByCardAuthor(cardAuthor);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas de la carta con autor " + cardAuthor + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByEmailReporter(String emailReporter) {
        try {
            return reportRepository.findByEmailReporter(emailReporter);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener las cartas del usuario con email " + emailReporter + ": " + e.getMessage());
        }
    }

    public List<Report> getReportsByNameUserReporter(String nameUserReporter) {
        try {
            return reportRepository.findByNameUserReporter(nameUserReporter);
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
            Optional<Report> existingReport = reportRepository.findById(report.getReportId());
            if (existingReport.isPresent()) {
                Report updatedReport = existingReport.get();
                updatedReport.setUserId(report.getUserId());
                updatedReport.setCardId(report.getCardId());
                updatedReport.setCardName(report.getCardName());
                updatedReport.setCardAuthor(report.getCardAuthor());
                updatedReport.setEmailReporter(report.getEmailReporter());
                updatedReport.setNameUserReporter(report.getNameUserReporter());
                updatedReport.setReason(report.getReason());
                updatedReport.setComment(report.getComment());
                updatedReport.setIsChecked(report.getIsChecked());
                return reportRepository.save(updatedReport);
            } else {
                throw new RuntimeException("Report not found with id: " + report.getReportId());
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
            reportRepository.deleteByUserId(userId);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar las cartas del usuario " + userId + ": " + e.getMessage());
        }
    }

    // DELETE BY CARD ID
    public void deleteReportsByCardId(Integer cardId) {
        try {
            reportRepository.deleteByCardId(cardId);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar las cartas de la carta " + cardId + ": " + e.getMessage());
        }
    }

    // DELETE BY CARD NAME
    public void deleteReportsByCardName(String cardName) {
        try {
            reportRepository.deleteByCardName(cardName);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar las cartas de la carta " + cardName + ": " + e.getMessage());
        }
    }

    // DELETE BY CARD AUTHOR
    public void deleteReportsByCardAuthor(String cardAuthor) {
        try {
            reportRepository.deleteByCardAuthor(cardAuthor);
        } catch (Exception e) {
            throw new RuntimeException("Error al borrar las cartas de la carta " + cardAuthor + ": " + e.getMessage());
        }
    }

    // DELETE BY EMAIL REPORTER
    public void deleteReportsByEmailReporter(String emailReporter) {
        try {
            reportRepository.deleteByEmailReporter(emailReporter);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al borrar las cartas del usuario " + emailReporter + ": " + e.getMessage());
        }
    }

    // DELETE BY NAME USER REPORTER
    public void deleteReportsByNameUserReporter(String nameUserReporter) {
        try {
            reportRepository.deleteByNameUserReporter(nameUserReporter);
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
