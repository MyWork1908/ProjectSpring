package org.example.app.models.dto.mapper;

import org.example.app.models.dto.CenterDTO;
import org.example.app.models.entity.Center;

public class CenterMapper {
    public Center toCenter(CenterDTO centerDTO) {
        Center center = new Center();
        center.setCenterCode(centerDTO.getCenterCode());
        center.setCenterName(centerDTO.getCenterName());
        center.setCenterAddress(centerDTO.getCenterAddress());
        center.setCenterPhone(centerDTO.getCenterPhone());
        return center;
    }
}
