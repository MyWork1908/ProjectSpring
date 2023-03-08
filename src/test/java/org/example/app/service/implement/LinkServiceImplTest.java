package org.example.app.service.implement;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.app.models.entity.Center;
import org.example.app.models.entity.Fresher;
import org.example.app.models.entity.FresherCenter;
import org.example.app.models.entity.Subject;
import org.example.app.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LinkServiceImplTest {
    @Mock
    FresherRepository fresherRepository;
    @Mock
    CenterRepository centerRepository;
    @Mock
    FresherCenterRepository fresherCenterRepository;
    @Mock
    SubjectRepository subjectRepository;
    @Mock
    ScoreRepository scoreRepository;
    @InjectMocks
    LinkServiceImpl linkService;
    private Fresher fresher;
    private Center center;
    private Subject subject;
    private FresherCenter fresherCenter;
    @BeforeEach
    void setUp() {
    }

    @Test
    void addFresherToCenter() {
    }

    @Test
    void addScore() {
    }
}