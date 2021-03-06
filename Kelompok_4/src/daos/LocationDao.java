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
import models.Location;
/**
 *
 * @author ACER
 */
public class LocationDao {
    private Connection connection;
    public LocationDao(Connection connection) {
        this.connection = connection;
    } public boolean delete(int idLocation) {
        boolean result = false;
        String query = "DELETE FROM LOCATIONS WHERE LOCATION_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idLocation);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } return result;
    } public List<Location> getAll() {
        List<Location> listLocation = new ArrayList<Location>();
        String query = "SELECT * FROM LOCATIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                listLocation.add(new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return listLocation;
    } public boolean insert(Location location) {
        boolean result = false;
        String query = "INSERT INTO LOCATIONS VALUES(LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location.getStreetAddress());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setString(5, location.getCountryId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } return result;
    } public boolean update(Location location) {
        boolean result = false;
        String query = "UPDATE LOCATIONS SET STREET_ADDRESS = ?, POSTAL_CODE = ?, CITY = ?, STATE_PROVINCE = ?, COUNTRY_ID = ? WHERE LOCATION_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location.getStreetAddress());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setString(5, location.getCountryId());
            preparedStatement.setInt(6, location.getLocationId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } return result;
    } public boolean checkByLocationId(int locationId) {
        boolean result = false;
        String query = "SELECT COUNT(*) FROM LOCATIONS WHERE LOCATION_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, locationId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1) == 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return result;
    } public boolean checkByCountryId(String countryId) {
        boolean result = false;
        String query = "SELECT COUNT(*) FROM LOCATIONS WHERE COUNTRY_ID = ?";
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
    } public List<Location> searchByIntegerType(String attribute, int value) {
        List<Location> listLocation = new ArrayList<Location>();
        String query = "SELECT * FROM LOCATIONS WHERE " + attribute + " = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                listLocation.add(new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return listLocation;
    } public List<Location> searchByStringType(String attribute, String value) {
        List<Location> listLocation = new ArrayList<Location>();
        String query = "SELECT * FROM LOCATIONS WHERE " + attribute + " LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + value + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                listLocation.add(new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return listLocation;
    }
}