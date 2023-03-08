package org.example.app.models.dto.mapper;

import org.example.app.models.dto.CenterDTO;
import org.example.app.models.entity.Center;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CenterMapperTest {

    @Test
    void toCenter() {
        CenterDTO centerDTO = new CenterDTO("AA","EDUSMART",
                "Khu C Tòa nhà T&T Riverview, số 440 Vĩnh Hưng, Hoàng Mai, Hà Nội", "0979263759");
       CenterMapper centerMapper = new CenterMapper();
        Center center = centerMapper.toCenter(centerDTO);
        assertEquals("AA",center.getCenterCode());
        assertEquals("EDUSMART",center.getCenterName());
        assertEquals("Khu C Tòa nhà T&T Riverview, số 440 Vĩnh Hưng, Hoàng Mai, Hà Nội",center.getCenterAddress());
        assertEquals("0979263759",center.getCenterPhone());
    }
}