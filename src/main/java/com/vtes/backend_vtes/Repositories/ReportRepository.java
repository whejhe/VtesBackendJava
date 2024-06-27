package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    // finders
    Report findByReportId(Integer reportId);

    List<Report> findByUserId(Integer userId);

    List<Report> findByCardId(Integer cardId);

    List<Report> findByCardName(String cardName);

    List<Report> findByCardAuthor(String cardAuthor);

    List<Report> findByEmailReporter(String emailReporter);

    List<Report> findByNameUserReporter(String nameUserReporter);

    List<Report> findByReason(String reason);

    // Delete
    void deleteByReportId(Integer reportId);

    void deleteByUserId(Integer userId);

    void deleteByCardId(Integer cardId);

    void deleteByCardName(String cardName);

    void deleteByCardAuthor(String cardAuthor);

    void deleteByEmailReporter(String emailReporter);

    void deleteByNameUserReporter(String nameUserReporter);

    void deleteByReason(String reason);
}
