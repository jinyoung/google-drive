package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileUploaded extends AbstractEvent {

    private String fileName;
    private Integer fileSize;
    private Object isIndexed;
    private Object isUploaded;
    private String videoUrl;
}
