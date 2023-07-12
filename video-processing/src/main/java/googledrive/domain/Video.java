package googledrive.domain;

import googledrive.VideoProcessingApplication;
import googledrive.domain.VideoProcessed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
public class Video {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String fileName;

    private String videoUrl;

    @PostPersist
    public void onPostPersist() {
        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }

    public static void processVideo(FileUploaded fileUploaded) {
        //implement business logic here: fileUploaded 이벤트의 파일명을 이용하여 새로운 비디오를 만들어 저장하고 그 비디오를 바탕으로 VideoProcessed 이벤트를 발생

        // TODO: 구현해주세요.

        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);


         });
        */

    }
}
