package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;

public class RegionDAO {

    private final Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }
    
      public List<Region> getAll() {
        List<Region> regions = new ArrayList<Region>();
        String query = "SELECT * FROM REGIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region r = new Region();
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                regions.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
      
    public boolean insert(Region region) {
        boolean result = false;
        String query = "INSERT INTO REGIONS(region_name,region_id) VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, region.getName());
            preparedStatement.setInt(2, region.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public boolean update(Region region) {
        boolean result = false;
        String query = "UPDATE REGIONS SET region_name =? WHERE region_id =? ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, region.getName());
            preparedStatement.setInt(2, region.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
        
        }
    
    public boolean delete(Region region) {
        boolean result = false;
        String query = "DELETE FROM REGIONS WHERE region_id=? ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, region.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
        
        }

    
}
