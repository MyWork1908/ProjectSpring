package org.example.app.models.response;

import lombok.*;
import org.example.app.models.entity.Score;

@Setter @Getter
@NoArgsConstructor
public class Transcript extends Score {
    private String fresherName;
    private String lp;
    private Double score01;
    private Double score02;
    private Double score03;
    private Double average;

    public Transcript(String fresherName, String lp, Double score01, Double score02, Double score03, Double average) {
        this.fresherName = fresherName;
        this.lp = lp;
        this.score01 = score01;
        this.score02 = score02;
        this.score03 = score03;
        this.average = (double)Math.round(average * 100) / 100;
    }
    public Transcript(Score score) {
        this.fresherName = score.getFresher().getFresherName();
        this.lp = score.getSubject().getLp();
        this.score01 = score.getScore01();
        this.score02 = score.getScore02();
        this.score03 = score.getScore03();
        this.average = (double)Math.round(((score01+score02+score03)/3) * 100) / 100;
    }
}
