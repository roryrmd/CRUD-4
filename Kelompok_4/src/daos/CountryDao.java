/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;

/**
 *
 * @author ACER
 */
public class CountryDao {
    private Connection connection;
    public CountryDao(Connection connection) {
        this.connection = connection;
    } public boolean delete(String countryId) {
        boolean result = false;
        String query = "DELETE FROM COUNTRIES WHERE COUNTRY_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, countryId);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } return result;
    } public List<Country> getAll() {
        List<Country> listRegion = new ArrayList<Country>();
        String query = "SELECT * FROM COUNTRIES";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Country country = new Country();
                country.setCountryId(resultSet.getString(1));
                country.setCountryName(resultSet.getString(2));
                country.setRegionId(resultSet.getInt(3));
                listRegion.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return listRegion;
    } public boolean insert(Country country) {
        boolean result = false;
        String query = "INSERT INTO COUNTRIES VALUES(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getCountryId());
            preparedStatement.setString(2, country.getCountryName());
            preparedStatement.setInt(3, country.getRegionId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } return result;
    } public boolean update(Country country) {
        boolean result = false;
        String query = "UPDATE COUNTRIES SET COUNTRY_NAME = ?, REGION_ID = ? WHERE COUNTRY_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getCountryName());
            preparedStatement.setInt(2, country.getRegionId());
            preparedStatement.setString(3, country.getCountryId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } return result;
    }
}