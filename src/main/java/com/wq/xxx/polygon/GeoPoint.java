package com.wq.xxx.polygon;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/*
 * TODO
 * Created by wuqiang on 2021/3/11-10:05
 */
public class GeoPoint {
    private final double lat;
    private final double lon;
    
    public GeoPoint(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
    
    public double getLon() {
        return lon;
    }
    
    public double getLat() {
        return lat;
    }
}
