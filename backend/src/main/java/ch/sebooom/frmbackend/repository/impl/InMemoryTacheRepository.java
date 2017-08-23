package ch.sebooom.frmbackend.repository.impl;

import ch.sebooom.frmbackend.domain.Etat;
import ch.sebooom.frmbackend.domain.Tache;
import ch.sebooom.frmbackend.repository.TacheRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class InMemoryTacheRepository implements TacheRepository{

    private static final Map<Integer,Tache> dataSource = new HashMap<>();

    static{
        dataSource.put(1,new Tache(1,"Correction code","Seb",2));
        dataSource.put(2,new Tache(2,"Rédaction doumentation",Etat.A_FAIRE,1));
        dataSource.put(3,new Tache(3,"Fix bug",Etat.EN_COURS,2));
        dataSource.put(4,new Tache(4,"Implémentation test",Etat.TERMINE,4));
    }

    public List<Tache> findAll(){
        return dataSource.values().stream().collect(Collectors.toList());
    }

    @Override
    public void save(Tache task) {
        task.id(getNextId());
        dataSource.put(task.id(),task);
    }

    @Override
    public Tache endTask(Integer id) {
        Tache task = dataSource.get(id);

        task.etat(Etat.TERMINE);

        return task;
    }

    @Override
    public Tache assign(Integer id, String user) {
        Tache task = dataSource.get(id);

        task.assignUser(user);

        return task;
    }

    private Integer getNextId(){
        Optional<Integer> maxId = dataSource.keySet().stream().max((val1, val2) ->{
            return Integer.compare(val1,val2);
        });

        if(maxId.isPresent()){
            return maxId.get() + 1;
        }else{
            throw new RuntimeException("Exception during netx id generation");
        }
    }

}
