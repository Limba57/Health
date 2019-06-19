package Sebastien.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private int id;

    @Column(name = "score")
    private int score;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Patient patient;

    public Score() {
    }

    public Score(Patient patient) {

        int calcul;

        calcul = patient.getFirstname().length();
        calcul += patient.getLastname().length();
        calcul +=((new Date().getTime()-patient.getBirthdate().getTime())/1000/60/60/24);

        score = calcul;
    }

    public int getScore() {
        return score;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
