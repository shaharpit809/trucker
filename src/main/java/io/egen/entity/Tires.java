package io.egen.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Tires")
public class Tires {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tid;

    @Column(columnDefinition = "INTEGER(2)")
    private int frontLeft;

    @Column(columnDefinition = "INTEGER(2)")
    private int frontRight;

    @Column(columnDefinition = "INTEGER(2)")
    private int rearLeft;

    @Column(columnDefinition = "INTEGER(2)")
    private int rearRight;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "tires")
    private Reading reading;

    public Tires(){
        this.tid = UUID.randomUUID().toString();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public String toString() {
        return "Tires{" +
                "tid='" + tid + '\'' +
                ", frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                ", reading=" + reading +
                '}';
    }
}
