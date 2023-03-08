package org.example.app.service;

import org.example.app.models.response.Transcript;
import org.example.app.models.entity.Fresher;

import java.util.List;

public interface FresherService {
    List<Fresher> getAllFresher();

    List<Transcript> getTranscript();

    Fresher addFresher(Fresher fresher);

    Fresher editFresher(Fresher fresher);

    void deleteFresher(String id);

    List<Fresher> searchFresherWithFresherName(String fresherName);

    Fresher searchFresherWithFresherEmail(String fresherEmail);

    List<Fresher> searchFresherWithLP(String lp);
}
