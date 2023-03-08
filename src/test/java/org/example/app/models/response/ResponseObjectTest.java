package org.example.app.models.response;

import org.example.app.models.entity.Fresher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseObjectTest {

    @Test
    void set_getStatus() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setStatus("OK");
        assertEquals("OK",responseObject.getStatus());
    }

    @Test
    void set_getMsg() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMsg("Are you OK?");
        assertEquals("Are you OK?",responseObject.getMsg());
    }

    @Test
    void set_getData() {
        Fresher fresher = new Fresher("2019606150","Nguyễn Đức Huy",
                "An Vinh, Quỳnh Phụ, Thái Bình","0971561704","huyvuvi123@gmail.com");
        ResponseObject responseObject = new ResponseObject();
        responseObject.setData(fresher);
        assertEquals(fresher,responseObject.getData());
    }

    @Test
    void testResponseObjectConstructor(){
        ResponseObject responseObject = new ResponseObject("OK","Are you ok?","string");
        assertEquals("OK",responseObject.getStatus());
        assertEquals("Are you ok?",responseObject.getMsg());
        assertEquals("string",responseObject.getData());
    }

}