package ch.sebooom.frmbackend.transformer;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();


    public String render(Object model) {
        return gson.toJson(model);
    }

}