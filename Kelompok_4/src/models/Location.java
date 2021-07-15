/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
/**
 *
 * @author ACER
 */
public class Location {
    private int locationId;
    private String streetAddress, postalCode, city, stateProvince, countryId;
    public Location() {
        this.locationId = 0;
        this.streetAddress = "";
        this.postalCode = "";
        this.city = "";
        this.stateProvince = "";
        this.countryId = "";
    } public Location(int locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        this.locationId = locationId;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
    } public int getLocationId() {
        return locationId;
    } public void setLocationId(int locationId) {
        this.locationId = locationId;
    } public String getStreetAddress() {
        return streetAddress;
    } public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    } public String getPostalCode() {
        return postalCode;
    } public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    } public String getCity() {
        return city;
    } public void setCity(String city) {
        this.city = city;
    } public String getStateProvince() {
        return stateProvince;
    } public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    } public String getCountryId() {
        return countryId;
    } public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
    @Override
    public String toString() {
        return "Location{" + "locationId = " + locationId + ", streetAddress = " + streetAddress + ", postalCode = " + postalCode + ", city = " + city + ", stateProvince = " + stateProvince + ", countryId = " + countryId + '}';
    }

}
