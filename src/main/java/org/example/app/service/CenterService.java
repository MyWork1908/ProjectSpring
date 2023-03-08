package org.example.app.service;

import org.example.app.models.entity.Center;
import org.example.app.models.entity.Fresher;

import java.util.List;

public interface CenterService {
    List<Center> getAllCenter();

    Center addCenter(Center center);

    void deleteCenter(String id);

    Center editCenter(Center center);

    List<Fresher> getListFresherOfCenter(String string);
}
