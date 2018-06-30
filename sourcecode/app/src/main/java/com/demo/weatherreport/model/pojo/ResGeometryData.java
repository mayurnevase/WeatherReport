package com.demo.weatherreport.model.pojo;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.List;

public class ResGeometryData implements Serializable {

    String geometryType;
    String type;
    List<Coordinates> coordinatesList;
    double lat, lng;
    boolean permission;
    String farmName;
    String fieldName;
    boolean ownership;
    String teamId;
    String farmSlug;
    String locationSlug;
    String soilType;
    String fieldId;
    String teamName;
    String fieldArea;
    String note;
    String workableArea;
    String farmLocation;

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Coordinates> getLatLngList() {
        return coordinatesList;
    }

    public void setLatLngList(List<Coordinates> latLngList) {
        this.coordinatesList = latLngList;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public boolean isOwnership() {
        return ownership;
    }

    public void setOwnership(boolean ownership) {
        this.ownership = ownership;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getFarmSlug() {
        return farmSlug;
    }

    public void setFarmSlug(String farmSlug) {
        this.farmSlug = farmSlug;
    }

    public String getLocationSlug() {
        return locationSlug;
    }

    public void setLocationSlug(String locationSlug) {
        this.locationSlug = locationSlug;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getFieldArea() {
        return fieldArea;
    }

    public void setFieldArea(String fieldArea) {
        this.fieldArea = fieldArea;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getWorkableArea() {
        return workableArea;
    }

    public void setWorkableArea(String workableArea) {
        this.workableArea = workableArea;
    }

    public String getFarmLocation() {
        return farmLocation;
    }

    public void setFarmLocation(String farmLocation) {
        this.farmLocation = farmLocation;
    }
}
