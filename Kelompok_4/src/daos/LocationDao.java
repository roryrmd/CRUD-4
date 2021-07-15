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
//import models.Region;
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
        String query = "INSERT INTO LOCATIONS VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, location.getLocationId());
            preparedStatement.setString(2, location.getStreetAddress());
            preparedStatement.setString(3, location.getPostalCode());
            preparedStatement.setString(4, location.getCity());
            preparedStatement.setString(5, location.getStateProvince());
            preparedStatement.setString(6, location.getCountryId());
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
    }
}