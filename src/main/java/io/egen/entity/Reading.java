package io.egen.entity;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "readings")
public class Reading {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String rid;

    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    @Column(columnDefinition = "DECIMAL(15,10)")
    private double latitude;

    @Column(columnDefinition = "DECIMAL(15,10)")
    private double longitude;

    @Column(columnDefinition = "DECIMAL(4,2)")
    private double fuelVolume;

    @Column(columnDefinition = "INTEGER(3)")
    private int speed;

    @Column(columnDefinition = "INTEGER(4)")
    private int engineHp;

//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    @NotNull
    private boolean checkEngineLightOn;

//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    @NotNull
    private boolean engineCoolantLow;

//    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    @NotNull
    private boolean cruiseControlOn;

    @Column(columnDefinition = "INTEGER(4)")
    private int engineRpm;

    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss.sTZD")
    private Date timestamp;

//    @OneToOne(fetch = FetchType.LAZY,
//            cascade =  CascadeType.ALL)
//    @JoinColumn(unique = true, name = "tires_tid", referencedColumnName = "tid")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tires_tid")
    private Tires tires;

    public Reading(){
        this.rid = UUID.randomUUID().toString();
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "rid='" + rid + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", timestamp=" + timestamp +
                ", tires=" + tires +
                '}';
    }
}
