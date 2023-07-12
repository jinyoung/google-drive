package googledrive.infra;

import googledrive.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DashboardHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Dashboard>> {

    @Override
    public EntityModel<Dashboard> process(EntityModel<Dashboard> model) {
        return model;
    }
}
