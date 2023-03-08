package org.example.app.service.implement;

import org.example.app.exception.NotFoundException;
import org.example.app.exception.NotImplementedException;
import org.example.app.models.entity.Center;
import org.example.app.models.entity.Fresher;
import org.example.app.models.response.ErrorMessages;
import org.example.app.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.app.repositories.CenterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    CenterRepository centerRepository;

    @Override
    public List<Center> getAllCenter(){
        return centerRepository.findAll();
    }
    @Override
    public Center addCenter(Center center) {
        Optional<Center> centerList = centerRepository.findById(center.getCenterCode());
        if(centerList.isPresent()) {
            throw new NotImplementedException(ErrorMessages.CENTER_EXISTS_ERROR);
        }
        return centerRepository.save(center);
    }
    @Override
    public void deleteCenter(String id) {
        boolean exists = centerRepository.existsById(id);
        if(!exists) {
            throw new NotFoundException(ErrorMessages.CENTER_NULL_ERROR);
        }
        centerRepository.deleteById(id);
    }
    @Override
    public Center editCenter(Center center) {
        return centerRepository.findById(center.getCenterCode())
                .map(center1 -> {
                    center1.setCenterName(center.getCenterName());
                    center1.setCenterAddress(center.getCenterAddress());
                    center1.setCenterPhone(center.getCenterPhone());
                    return centerRepository.save(center1);
                }).orElseGet(()-> centerRepository.save(center));
    }
    @Override
    public List<Fresher> getListFresherOfCenter(String string) {
        List<Fresher> fresherList = centerRepository.getFresherOfCenter(string);
        if(!fresherList.isEmpty()) {
            return fresherList;
        }
        throw new NotFoundException(ErrorMessages.FRESHER_NULL_ERROR);
    }
}
