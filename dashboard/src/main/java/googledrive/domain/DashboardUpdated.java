package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DashboardUpdated extends AbstractEvent {

    private String fileName;
    private Integer fileSize;
    private boolean isIndexed;
    private boolean isUploaded;
    private String videoUrl;

    public DashboardUpdated(Dashboard aggregate) {
        super(aggregate);
    }

    public DashboardUpdated() {
        super();
    }
}
