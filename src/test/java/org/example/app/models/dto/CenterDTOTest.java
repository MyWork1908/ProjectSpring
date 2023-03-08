package org.example.app.models.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CenterDTOTest {

    @Test
    void getCenterCode() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenterCode("AA");
        assertEquals("AA",centerDTO.getCenterCode());
    }

    @Test
    void getCenterName() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenterName("EDUSMART");
        assertEquals("EDUSMART",centerDTO.getCenterName());
    }

    @Test
    void getCenterAddress() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenterAddress("Khu C Tòa nhà T&T Riverview, " +
                "số 440 Vĩnh Hưng, Hoàng Mai, Hà Nội");
        assertEquals("Khu C Tòa nhà T&T Riverview, " +
                "số 440 Vĩnh Hưng, Hoàng Mai, Hà Nội",centerDTO.getCenterAddress());
    }

    @Test
    void getCenterPhone() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenterPhone("0979263759");
        assertEquals("0979263759",centerDTO.getCenterPhone());
    }
    @Test
    void testCenterDTOConstructor() {
        CenterDTO centerDTO = new CenterDTO("AA","EDUSMART",
                "Khu C Tòa nhà T&T Riverview, số 440 Hoàng Mai, Hà Nội", "0979263759");
        assertEquals("AA",centerDTO.getCenterCode());
        assertEquals("EDUSMART",centerDTO.getCenterName());
        assertEquals("Khu C Tòa nhà T&T Riverview, số 440 Hoàng Mai, Hà Nội",centerDTO.getCenterAddress());
        assertEquals("0979263759",centerDTO.getCenterPhone());
    }
}