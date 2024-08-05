package com.sut.ood.onlinefoodbackend.Model.DeliveryGuy;
import java.util.ArrayList;
public class LiveLocation{
    private double lat;
    private double lon;


    public ArrayList<Double> getLocation(){
        ArrayList<Double> liveLocation = new ArrayList<Double>();
        liveLocation.add(lat);
        liveLocation.add(lon);
        return liveLocation;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }

    public void updateLocation(double lat, double lon) {
        setLat(lat);
        setLon(lon);
    }

}



