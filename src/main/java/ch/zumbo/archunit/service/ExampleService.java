package ch.zumbo.archunit.service;

import ch.zumbo.archunit.business.MyCoreDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService implements ApplicationService
{
    @Autowired
    private DataRepository repository;

    public String getSomeData() {
        MyCoreDomain domain = new MyCoreDomain();
        String domainData = domain.doSomething();
        String repositoryData = repository.mockData();
        return domainData + "\n" + repositoryData;
    }
}
