package ch.sebooom.frmbackend.service.impl;

import ch.sebooom.frmbackend.domain.Tache;
import ch.sebooom.frmbackend.repository.TacheRepository;
import ch.sebooom.frmbackend.service.TacheService;

import java.util.List;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class TacheServiceImpl implements TacheService{

    private TacheRepository repository;

    public TacheServiceImpl(TacheRepository repository){
        this.repository = repository;
    }


    @Override
    public List<Tache> findAllTasks() {
        return repository.findAll();
    }

    @Override
    public void save(Tache task) {
        this.repository.save(task);
    }

    @Override
    public Tache endTask(Integer id) {
        return this.repository.endTask(id);
    }

    @Override
    public Tache assign(Integer id, String user) {
        return this.repository.assign(id,user);
    }
}
