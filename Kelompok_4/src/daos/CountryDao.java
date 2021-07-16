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
    } public boolean checkByCountryId(String countryId) {
        boolean result = false;
        String query = "SELECT COUNT(*) FROM COUNTRIES WHERE COUNTRY_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, countryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1) == 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return result;
    } public boolean checkByRegionId(int regionId) {
        boolean result = false;
        String query = "SELECT COUNT(*) FROM COUNTRIES WHERE REGION_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, regionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1) == 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return result;
    } public List<Country> searchByIntegerType(String attribute, int value) {
        List<Country> listCountry = new ArrayList<Country>();
        String query = "SELECT * FROM COUNTRIES WHERE " + attribute + " = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                listCountry.add(new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return listCountry;
    } public List<Country> searchByStringType(String attribute, String value) {
        List<Country> listCountry = new ArrayList<Country>();
        String query = "SELECT * FROM COUNTRIES WHERE " + attribute + " LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + value + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                listCountry.add(new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return listCountry;
    }
}