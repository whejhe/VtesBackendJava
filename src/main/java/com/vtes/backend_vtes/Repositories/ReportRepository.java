package com.vtes.backend_vtes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtes.backend_vtes.Entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    // finders
    Report findByReport_id(Integer report_id);

    Report findByUser_id(Integer user_id);

    Report findByCard_id(Integer card_id);

    Report findByCard_name(String card_name);

    Report findByCard_author(String card_author);

    Report findByEmail_reporter(String email_reporter);

    Report findByName_user_reporter(String name_user_reporter);

    Report findByReason(String reason);

    // no need to define save(), delete() and update() methods, they are already defined in JpaRepository
}
