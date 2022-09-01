package com.example.caiyunkotlin.bean;

public class SuggestionDTO {
    private CarWashingDTO car_washing;
    private DressingDTO dressing;
    private FluDTO flu;
    private SportDTO sport;
    private TravelDTO travel;
    private UvDTO uv;

    public CarWashingDTO getCar_washing() {
        return car_washing;
    }

    public void setCar_washing(CarWashingDTO car_washing) {
        this.car_washing = car_washing;
    }

    public DressingDTO getDressing() {
        return dressing;
    }

    public void setDressing(DressingDTO dressing) {
        this.dressing = dressing;
    }

    public FluDTO getFlu() {
        return flu;
    }

    public void setFlu(FluDTO flu) {
        this.flu = flu;
    }

    public SportDTO getSport() {
        return sport;
    }

    public void setSport(SportDTO sport) {
        this.sport = sport;
    }

    public TravelDTO getTravel() {
        return travel;
    }

    public void setTravel(TravelDTO travel) {
        this.travel = travel;
    }

    public UvDTO getUv() {
        return uv;
    }

    public void setUv(UvDTO uv) {
        this.uv = uv;
    }
}
