package ch.zumbo.archunit.infrastructure;

import ch.zumbo.archunit.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInterface {
    @Autowired
    private ApplicationService applicationService;

    public String getSomeData() {
        return applicationService.getSomeData();
    }
}
