package study.section05.hoyunjung;

import lombok.Getter;

public class Main {
    public static void main(String[] args) {
        HttpStatus ok = HttpStatus.OK;
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        System.out.println("status: " + ok.getCode() + " " + ok.getMessage());
        System.out.println("status: " + badRequest.getCode() + " " + badRequest.getMessage());
        System.out.println("status: " + internalServerError.getCode() + " " + internalServerError.getMessage());
    }
}

@Getter
enum HttpStatus {
    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}