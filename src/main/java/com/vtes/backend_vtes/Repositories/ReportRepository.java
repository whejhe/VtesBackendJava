package com.vtes.backend_vtes.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    // finders
    Report findByReport_id(Integer report_id);

    List<Report> findByUser_id(Integer user_id);

    List<Report> findByCard_id(Integer card_id);

    List<Report> findByCard_name(String card_name);

    List<Report> findByCard_author(String card_author);

    List<Report> findByEmail_reporter(String email_reporter);

    List<Report> findByName_user_reporter(String name_user_reporter);

    List<Report> findByReason(String reason);

    // Delete
    void deleteByReport_id(Integer report_id);

    void deleteByUser_id(Integer user_id);

    void deleteByCard_id(Integer card_id);

    void deleteByCard_name(String card_name);

    void deleteByCard_author(String card_author);

    void deleteByEmail_reporter(String email_reporter);

    void deleteByName_user_reporter(String name_user_reporter);

    void deleteByReason(String reason);
}
