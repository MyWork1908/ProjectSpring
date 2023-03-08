package org.example.app.models.response;

import org.example.app.models.entity.Fresher;
import org.example.app.models.entity.Score;
import org.example.app.models.entity.Subject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranscriptTest {

    @Test
    void set_getFresherName() {
        Transcript transcript = new Transcript();
        transcript.setFresherName("Nguyễn Văn Đạo");
        assertEquals("Nguyễn Văn Đạo",transcript.getFresherName());
    }

    @Test
    void set_getLp() {
        Transcript transcript = new Transcript();
        transcript.setLp("JAVA");
        assertEquals("JAVA",transcript.getLp());
    }

    @Test
    void set_getScore01() {
        Transcript transcript = new Transcript();
        transcript.setScore01(6.5);
        assertEquals(6.5,transcript.getScore01());
    }

    @Test
    void set_getScore02() {
        Transcript transcript = new Transcript();
        transcript.setScore02(6d);
        assertEquals(6d,transcript.getScore02());
    }

    @Test
    void set_getScore03() {
        Transcript transcript = new Transcript();
        transcript.setScore03(7d);
        assertEquals(7d,transcript.getScore03());
    }

    @Test
    void set_getAverage() {
        Transcript transcript = new Transcript();
        transcript.setAverage(7.5);
        assertEquals(7.5,transcript.getAverage());
    }

    @Test
    void testTranscriptConstructor() {
        Transcript transcript = new Transcript("Nguyễn Văn Đạo","PYTHON",
                6d,5d,5.5,7.5);
        assertEquals("Nguyễn Văn Đạo",transcript.getFresherName());
        assertEquals("PYTHON",transcript.getLp());
        assertEquals(6d,transcript.getScore01());
        assertEquals(5d,transcript.getScore02());
        assertEquals(5.5,transcript.getScore03());
        assertEquals(7.5,transcript.getAverage());
    }
    @Test
    void testTranscriptConstructorExtendsScore(){
        Fresher fresher = new Fresher("","Alice","","","");
        Subject subject = new Subject("","JAVA",null);
        Score score = new Score(1L,4d,5d,6d,fresher,subject);
        Transcript transcript = new Transcript(score);
        assertEquals(4d,transcript.getScore01());
        assertEquals(5d,transcript.getScore02());
        assertEquals(6d,transcript.getScore03());
        assertEquals("Alice",transcript.getFresherName());
        assertEquals("JAVA",transcript.getLp());
    }
}