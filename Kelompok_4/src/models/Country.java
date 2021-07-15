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
public class Country {
    private String countryId, countryName;
    private int regionId;
    public Country() {
        this.countryId = "";
        this.countryName = "";
        this.regionId = 0;
    } public Country(String countryId, String countryName, int regionId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
    } public String getCountryId() {
        return countryId;
    } public void setCountryId(String countryId) {
        this.countryId = countryId;
    } public String getCountryName() {
        return countryName;
    } public void setCountryName(String countryName) {
        this.countryName = countryName;
    } public int getRegionId() {
        return regionId;
    } public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
    @Override
    public String toString() {
        return "Country{" + "countryId = " + countryId + ", countryName = " + countryName + ", regionId = " + regionId + '}';
    }
}