package ch.sebooom.frmbackend.service;

import ch.sebooom.frmbackend.domain.Tache;

import java.util.List;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface TacheService {

    List<Tache> findAllTasks();

    void save(Tache task);

    Tache endTask(Integer id);

    Tache assign(Integer id, String user);
}
