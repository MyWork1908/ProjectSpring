package org.example.app.service.implement;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.app.exception.NotFoundException;
import org.example.app.exception.NotImplementedException;
import org.example.app.models.entity.Center;
import org.example.app.models.entity.Fresher;
import org.example.app.repositories.CenterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CenterServiceImplTest {

    @Mock
    CenterRepository centerRepository;
    @InjectMocks
    CenterServiceImpl centerService;
    private Center center;
    @BeforeEach
    void setUp() {
        center = new Center();
        center.setCenterCode("AA");
    }

    @Test
    void getAllCenter() {
        List<Center> centerList = new ArrayList<>();
        centerList.add(mock(Center.class));
        centerList.add(mock(Center.class));

        when(centerRepository.findAll()).thenReturn(centerList);

        List<Center> centers = centerService.getAllCenter();
        int num = centers.size();
        assertThat(num).isEqualTo(centerList.size());
        verify(centerRepository).findAll();
    }

    @Test
    void addCenter() {
        when(centerRepository.findById(center.getCenterCode()))
                .thenReturn(Optional.empty());
        when(centerRepository.save(center)).thenReturn(center);
        Center center1 = centerService.addCenter(center);
        assertThat(center1).isNotNull();
    }

    @Test
    void addCenterButException() {
        when(centerRepository.findById(center.getCenterCode()))
                .thenReturn(Optional.of(center));
        assertThrows(NotImplementedException.class,()->{
            centerService.addCenter(center);
        });
        verify(centerRepository,times(1)).findById(center.getCenterCode());
        verify(centerRepository, never()).save(center);
    }

    @Test
    void deleteCenter() {
        when(centerRepository.existsById(center.getCenterCode()))
                .thenReturn(Boolean.TRUE);
        centerService.deleteCenter(center.getCenterCode());
        verify(centerRepository).deleteById(center.getCenterCode());
    }

    @Test
    void deleteCenterButException() {
        String id = "AA";
        when(centerRepository.existsById(center.getCenterCode()))
                .thenReturn(Boolean.FALSE);
        assertThrows(NotFoundException.class,()->{
            centerService.deleteCenter(id);
        });
        verify(centerRepository,never()).deleteById(id);
    }

    @Test
    void editCenter() {
        when(centerRepository.findById(center.getCenterCode())).thenReturn(Optional.of(center));
        when(centerRepository.save(center)).thenReturn(center);
        Center upCenter = centerRepository.findById(center.getCenterCode())
                            .map(center1 -> {
                                center1.setCenterName(center.getCenterName());
                                center1.setCenterAddress(center.getCenterAddress());
                                center1.setCenterPhone(center.getCenterPhone());
                                return centerRepository.save(center1);
                            }).orElseGet(()-> centerRepository.save(center));
        Center newCenter = centerService.editCenter(center);
        assertEquals(newCenter, upCenter);
    }

    @Test
    void editCenterButException() {
        when(centerRepository.findById(center.getCenterCode())).thenReturn(Optional.empty());
        when(centerRepository.save(center)).thenReturn(center);
        Center upCenter = centerRepository.findById(center.getCenterCode())
                .map(center1 -> {
                    center1.setCenterName(center.getCenterName());
                    center1.setCenterAddress(center.getCenterAddress());
                    center1.setCenterPhone(center.getCenterPhone());
                    return centerRepository.save(center1);
                }).orElseGet(()-> centerRepository.save(center));
        Center newCenter = centerService.editCenter(center);
        assertEquals(newCenter, upCenter);
    }

    @Test
    void getListFresherOfCenter() {
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));

        when(centerRepository.getFresherOfCenter(center.getCenterCode())).thenReturn(freshers);

        List<Fresher> fresherList = centerService.getListFresherOfCenter(center.getCenterCode());
        int size = fresherList.size();

        assertThat(size).isEqualTo(freshers.size());
    }
    @Test
    void getListFresherOfCenterButException() {
        List<Fresher> freshers = new ArrayList<>();

        when(centerRepository.getFresherOfCenter(center.getCenterCode())).thenReturn(freshers);

        assertThrows(NotFoundException.class, ()->{
           centerService.getListFresherOfCenter(center.getCenterCode());
        });
    }
}