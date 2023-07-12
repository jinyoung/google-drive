package googledrive.domain;

import googledrive.DashboardApplication;
import googledrive.domain.DashboardUpdated;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Dashboard_table")
@Data
public class Dashboard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String fileName;

    private Integer fileSize;

    private boolean isIndexed;

    private boolean isUploaded;

    private String videoUrl;

    @PostPersist
    public void onPostPersist() {
        DashboardUpdated dashboardUpdated = new DashboardUpdated(this);
        dashboardUpdated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static DashboardRepository repository() {
        DashboardRepository dashboardRepository = DashboardApplication.applicationContext.getBean(
            DashboardRepository.class
        );
        return dashboardRepository;
    }
}
