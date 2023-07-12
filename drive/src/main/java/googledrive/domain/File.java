package googledrive.domain;

import googledrive.DriveApplication;
import googledrive.domain.FileIndexed;
import googledrive.domain.FileUploaded;
import googledrive.domain.VideoProcessed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "File_table")
@Data
public class File {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String fileName;

    private Integer fileSize;

    private boolean isIndexed;

    private boolean isUploaded;

    private String videoUrl;

    @PostPersist
    public void onPostPersist() {
        FileUploaded fileUploaded = new FileUploaded(this);
        fileUploaded.publishAfterCommit();

        FileIndexed fileIndexed = new FileIndexed(this);
        fileIndexed.publishAfterCommit();

        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static FileRepository repository() {
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }
}
