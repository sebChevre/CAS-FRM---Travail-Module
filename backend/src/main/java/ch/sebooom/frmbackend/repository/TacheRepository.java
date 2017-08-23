package ch.sebooom.frmbackend.repository;

import ch.sebooom.frmbackend.domain.Tache;

import java.util.List;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public interface TacheRepository {

    List<Tache> findAll();

    void save(Tache task);

    Tache endTask(Integer id);

    Tache assign(Integer id, String user);
}
