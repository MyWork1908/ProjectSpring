package org.example.app.service.implement;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.app.exception.NotFoundException;
import org.example.app.exception.NotImplementedException;
import org.example.app.models.entity.Fresher;
import org.example.app.models.response.Transcript;
import org.example.app.repositories.FresherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FresherServiceImplTest {
    @Mock
    FresherRepository fresherRepository;
    @InjectMocks
    FresherServiceImpl fresherService;
    private Fresher fresher;

    @BeforeEach
    void setUp() {
        fresher = new Fresher();
        fresher.setFresherId("2019200112");
        fresher.setFresherName("Alice");
        fresher.setFresherAddress("Ha Noi");
        fresher.setFresherPhone("0971561704");
        fresher.setFresherEmail("huyvuvi123@gmail.com");
    }
    @DisplayName("JUnit test for getAllFresher method")
    @Test
    void getAllFresher() {
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));

        when(fresherRepository.findAll()).thenReturn(freshers);

        List<Fresher> list = fresherService.getAllFresher();
        int size = list.size();
        assertThat(size).isEqualTo(freshers.size());

        verify(fresherRepository).findAll();
    }

    @DisplayName("JUnit test for getTranscript method")
    @Test
    void getTranscript() {
        List<Transcript> transcripts = new ArrayList<>();
        transcripts.add(mock(Transcript.class));
        transcripts.add(mock(Transcript.class));

        when(fresherRepository.getTranscript()).thenReturn(transcripts);
        List<Transcript> list = fresherService.getTranscript();
        int size = list.size();
        assertThat(size).isEqualTo(transcripts.size());;
        verify(fresherRepository).getTranscript();
    }

    @DisplayName("JUnit test for addFresher method")
    @Test
    void addFresher() {
        given(fresherRepository.save(fresher)).willReturn(fresher);
        Fresher saveFresher = fresherService.addFresher(fresher);
        assertThat(saveFresher).isNotNull();
    }
    @DisplayName("JUnit test for addFresher method which throws exception")
    @Test()
    void addFresherButException() {
        when(fresherRepository.findById(fresher.getFresherId()))
                .thenReturn(Optional.of(fresher));

        assertThrows(NotImplementedException.class, ()->{
            fresherService.addFresher(fresher);
        });
        verify(fresherRepository, times(1)).findById(fresher.getFresherId());
        verify(fresherRepository, never()).save(any(Fresher.class));
    }

    @DisplayName("JUnit test for deleteFresher method")
    @Test
    void deleteFresher() {
        when(fresherRepository.existsById(fresher.getFresherId()))
                .thenReturn(Boolean.TRUE);
        fresherService.deleteFresher(fresher.getFresherId());
        verify(fresherRepository).deleteById(fresher.getFresherId());
    }
    @DisplayName("JUnit test for deleteFresher method which throws exception")
    @Test
    void deleteFresherButException() {
        String id = "2019200112";
        when(fresherRepository.existsById(fresher.getFresherId()))
                .thenReturn(Boolean.FALSE);
        assertThrows(NotFoundException.class,()->{
            fresherService.deleteFresher(id);
        });
        verify(fresherRepository,never()).deleteById(id);
    }

    @DisplayName("JUnit test for searchFresherWithFresherName method")
    @Test
    void searchFresherWithFresherName() {
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));
        when(fresherRepository.findByFresherName(fresher.getFresherName()))
                .thenReturn(freshers);

        List<Fresher> list = fresherService.searchFresherWithFresherName(fresher.getFresherName());
        int size = list.size();
        assertThat(size).isEqualTo(freshers.size());
        verify(fresherRepository).findByFresherName(fresher.getFresherName());
    }

    @DisplayName("JUnit test for searchFresherWithFresherName method which throws exception")
    @Test
    void searchFresherWithFresherNameButException() {
        String name = fresher.getFresherName();
        List<Fresher> freshers = new ArrayList<>();
        when(fresherRepository.findByFresherName(name))
                .thenReturn(freshers);
        assertThrows(NotFoundException.class,()->{
           fresherService.searchFresherWithFresherName(name);
        });
        verify(fresherRepository, times(1)).findByFresherName(name);
    }

    @DisplayName("JUnit test for searchFresherWithFresherEmail method")
    @Test
    void searchFresherWithFresherEmail() {
        Fresher fresher = mock(Fresher.class);
        when(fresherRepository.findByFresherEmail(fresher.getFresherEmail()))
                .thenReturn(Optional.of(fresher));
        Fresher fresherOptional = fresherService.searchFresherWithFresherEmail(fresher.getFresherEmail());
        assertThat(fresherOptional.getFresherId()).isEqualTo(fresher.getFresherId());
        verify(fresherRepository).findByFresherEmail(fresher.getFresherEmail());
    }

    @DisplayName("JUnit test for searchFresherWithFresherEmail method which throw exception")
    @Test
    void searchFresherWithFresherEmailButException() {
        String email = fresher.getFresherEmail();
        when(fresherRepository.findByFresherEmail(email))
                .thenReturn(Optional.empty());
        assertThrows(NotFoundException.class,()->{
           fresherService.searchFresherWithFresherEmail(email);
        });
        verify(fresherRepository,times(1)).findByFresherEmail(email);
    }

    @DisplayName("JUnit test for searchFresherWithLP method")
    @Test
    void searchFresherWithLP() {
        String lp = "JAVA";
        List<Fresher> freshers = new ArrayList<>();
        freshers.add(mock(Fresher.class));
        freshers.add(mock(Fresher.class));
        when(fresherRepository.findByFresherWithLP(lp))
                .thenReturn(freshers);
        List<Fresher> list = fresherService.searchFresherWithLP(lp);
        int size = list.size();
        assertThat(size).isEqualTo(freshers.size());
        verify(fresherRepository).findByFresherWithLP(lp);
    }

    @DisplayName("JUnit test for searchFresherWithLP method which throw exception")
    @Test
    void searchFresherWithLPButException() {
        String lp = "JAVA";
        List<Fresher> freshers = new ArrayList<>();
        when(fresherRepository.findByFresherWithLP(lp))
                .thenReturn(freshers);
        assertThrows(NotFoundException.class,()->{
            fresherService.searchFresherWithLP(lp);
        });
        verify(fresherRepository,times(1)).findByFresherWithLP(lp);
    }

    @Test
    void editFresher() {
        when(fresherRepository.findById(fresher.getFresherId())).thenReturn(Optional.of(fresher));
        when(fresherRepository.save(fresher)).thenReturn(fresher);
        Fresher upFresher = fresherRepository.findById(fresher.getFresherId())
                                .map(f -> {
                                    f.setFresherName(fresher.getFresherName());
                                    f.setFresherAddress(fresher.getFresherAddress());
                                    f.setFresherPhone(fresher.getFresherPhone());
                                    f.setFresherEmail(fresher.getFresherEmail());
                                    return fresherRepository.save(f);
                                }).orElseGet(()-> fresherRepository.save(fresher));
        Fresher newFresher = fresherService.editFresher(fresher);
        assertEquals(upFresher, newFresher);
    }
    @Test
    void editFresherButException() {
        when(fresherRepository.findById(fresher.getFresherId())).thenReturn(Optional.empty());
        when(fresherRepository.save(fresher)).thenReturn(fresher);
        Fresher newFresher = fresherRepository.findById(fresher.getFresherId())
                .map(f -> {
                    f.setFresherName(fresher.getFresherName());
                    f.setFresherAddress(fresher.getFresherAddress());
                    f.setFresherPhone(fresher.getFresherPhone());
                    f.setFresherEmail(fresher.getFresherEmail());
                    return fresherRepository.save(f);
                }).orElseGet(()-> fresherRepository.save(fresher));
        Fresher upfresher = fresherService.editFresher(fresher);
        assertEquals(upfresher, newFresher);
    }
}