package ch.sebooom.frmbackend;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class ResponseDTO {

    private String msg;
    private String code;

    public ResponseDTO(String msg,String code){
        this.code = code;
        this.msg = msg;
    }
}
