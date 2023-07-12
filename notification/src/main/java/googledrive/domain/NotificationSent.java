package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class NotificationSent extends AbstractEvent {

    private String fileName;
    private String userId;

    public NotificationSent(Notification aggregate) {
        super(aggregate);
    }

    public NotificationSent() {
        super();
    }
}
