package com.acceptedboy.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Be used to send message to client or frontend with restful design.
 * @author acceptedboy
 */
public class ResponseMessage {

    public enum Type {
        SUCCESS, WARNING, INFO, DANGER;
    }
    
    private boolean success; //whether success or not
    private Type type;	//the enum
    private String text; // the json data to client
    private String code; //the appointment between frontend and backstage
    private List<Error> errors = new ArrayList<Error>();

    public ResponseMessage(Type type, String text, boolean success) {
        this.type = type;
        this.text = text;
        this.success = success;
    }
    
    public ResponseMessage(Type type, String text, boolean success, List<Error> errors) {
        this.type = type;
        this.text = text;
        this.success = success;
        this.errors = errors;
    }

    public ResponseMessage(Type type, String code, String text, boolean success) {
        this.type = type;
        this.code = code;
        this.text = text;
        this.success = success;
    }
    
    public boolean whetherSuccess() {
    	return success;
    }

    public String getText() {
        return text;
    }

    public Type getType() {
        return type;
    }

    public String getCode() {
        return code;
    }
    
    public static ResponseMessage success(String text) {
        return new ResponseMessage(Type.SUCCESS, text, true);
    }

    public static ResponseMessage warning(String text) {
        return new ResponseMessage(Type.WARNING, text, true);
    }

    public static ResponseMessage danger(String text) {
        return new ResponseMessage(Type.DANGER, text, false);
    }

    public static ResponseMessage info(String text) {
        return new ResponseMessage(Type.INFO, text, true);
    }
    
    public static ResponseMessage generateError(List<Error> errors) {
    	return new ResponseMessage(Type.DANGER, null, false, errors);
    }
    
    public static ResponseMessage generateNullData() {
    	return new ResponseMessage(Type.WARNING, null, false, null);
    }
    
    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public void addError(String field, String code, String message) {
        this.errors.add(new Error(field, code, message));
    }
    
    public void addNullPointerError(String message) {
    	this.errors.add(new Error("java.lang.NullPointerException", "500", message));
    }

    class Error {

        private final String code;	//the appointment between frontend and backstage
        private final String message;	//the error message
        private final String field;		//the exception type or the error field

        private Error(String field, String code, String message) {
            this.field = field;
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public String getField() {
            return field;
        }

    }

}
