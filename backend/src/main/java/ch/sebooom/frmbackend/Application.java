package ch.sebooom.frmbackend;

import ch.sebooom.frmbackend.domain.Tache;
import ch.sebooom.frmbackend.repository.impl.InMemoryTacheRepository;
import ch.sebooom.frmbackend.service.TacheService;
import ch.sebooom.frmbackend.service.impl.TacheServiceImpl;
import ch.sebooom.frmbackend.transformer.JsonTransformer;
import com.google.gson.Gson;

import static spark.Spark.*;
/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class Application {

    TacheService tacheService;

    public static void main(java.lang.String[] args) {

        port(9090);

        enableCORS();

        new Application(new TacheServiceImpl(
                new InMemoryTacheRepository())).start();
    }

    public Application(TacheService service){
        this.tacheService = service;
    }

    private void start() {

        get("/hello", (request, response) -> new HelloDTO("ok"),new JsonTransformer());


        get("/tasks", (request,response) -> {
            return tacheService.findAllTasks();
        },new JsonTransformer());


        post("/task","application/json",(request, response) -> {

            Tache task = new Gson().fromJson(request.body(),Tache.class);

            tacheService.save(task);

            System.out.print(task.id());

            return new ResponseDTO("Task saved, id: " + task.id(),"200 OK");
        },new JsonTransformer());


        patch("/task/:id/done", (request, response) -> {
            Integer id = Integer.valueOf(request.params(":id"));

            Tache tache = tacheService.endTask(id);

            return new ResponseDTO("Task ended, id: " + tache.id(),"200 OK");
        },new JsonTransformer());


        patch("/task/:id/assign", (request, response) -> {
            Integer id = Integer.valueOf(request.params(":id"));
            String user = new Gson().fromJson(request.body(),String.class);

            Tache tache = tacheService.assign(id,user);

            return new ResponseDTO("Task assigne, id: " + tache.id() + "to user: " + tache.assignUser(),"200 OK");
        },new JsonTransformer());




    }

    private static void enableCORS() {

        options("/*",
                (request, response) -> {

                    java.lang.String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    java.lang.String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
    }
}

