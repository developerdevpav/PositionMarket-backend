package by.psu.service.api;

import by.psu.model.postgres.Type;
import by.psu.model.postgres.repository.RepositoryType;
import by.psu.service.merger.AbstractNsiMerger;
import org.springframework.stereotype.Service;

@Service
public class TypeService extends NsiService<Type> {

    public TypeService(RepositoryType repositoryType, AbstractNsiMerger<Type> abstractNsiMerger) {
        super(repositoryType, abstractNsiMerger);
    }

    @Override
    protected void deleteConsumer(Type object) {
        object.setAttractions(null);
    }

}
