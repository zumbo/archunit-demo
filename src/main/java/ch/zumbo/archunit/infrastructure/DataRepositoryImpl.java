package ch.zumbo.archunit.infrastructure;

import ch.zumbo.archunit.service.DataRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepositoryImpl implements DataRepository {
    public String mockData() {
        return "Let's pretend this is read from the DB";
    }
}
