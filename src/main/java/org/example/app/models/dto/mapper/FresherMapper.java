package org.example.app.models.dto.mapper;

import org.example.app.models.dto.FresherDTO;
import org.example.app.models.entity.Fresher;

public class FresherMapper {
    public Fresher toFresher(FresherDTO fresherDTO) {
        Fresher fresher = new Fresher();
        fresher.setFresherId(fresherDTO.getFresherId());
        fresher.setFresherName(fresherDTO.getFresherName());
        fresher.setFresherAddress(fresherDTO.getFresherAddress());
        fresher.setFresherPhone(fresherDTO.getFresherPhone());
        fresher.setFresherEmail(fresherDTO.getFresherEmail());
        return fresher;
    }
}
