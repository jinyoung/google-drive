package googledrive.domain;

import googledrive.NotificationApplication;
import googledrive.domain.NotificationSent;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Notification_table")
@Data
public class Notification {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String fileName;

    private String userId;

    @PostPersist
    public void onPostPersist() {
        NotificationSent notificationSent = new NotificationSent(this);
        notificationSent.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = NotificationApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }
}
