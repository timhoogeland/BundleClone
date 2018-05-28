package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.Adress;
import Objects.Contract;

public class AddressDAO extends baseDAO {

	private String tablename = "public.address";

    private List<Adress> selectAdresss (String query) {
        List<Adress> results = new ArrayList<Adress>();

        try (Connection con = super.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int id = dbResultSet.getInt("addressid");
                String street = dbResultSet.getString("street");
                int number = dbResultSet.getInt("number");            	
            	String country = dbResultSet.getString("country");
            	String postalcode = dbResultSet.getString("postalCode");
            	String description = dbResultSet.getString("description");
            	String location = dbResultSet.getString("location");
           
                Adress newAdress = new Adress(id, street, number, country, postalcode, description, location);

                results.add(newAdress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<Adress> findAll() { return selectAdresss("SELECT * From "+tablename); }

    public Adress findByID(int id) {
        List<Adress> results = selectAdresss("SELECT * FROM "+tablename+" WHERE addressid = " + id + "");

        if (results.size() == 0) {
            return null;
        } else {
            return results.get(0);
        }
    }
    
    public List<Adress> findAdressesByUserIDFK(int id) {
        List<Adress> results = selectAdresss("SELECT * FROM "+tablename+" WHERE useridfk = '" + id + "'");
        return results;
    }
    
    public Adress newAddress(Adress address) {
        String query = "INSERT INTO "+tablename+" (addressid ,street, number, country, postalcode, description, location) VALUES (?,?,?,?,?,?,?) RETURNING addressid";

        try (Connection con = super.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setInt(1, address.getAdressId());
            pstmt.setString(2, address.getStreet());
            pstmt.setInt(3, address.getNumber());
            pstmt.setString(4, address.getCountry());
            pstmt.setString(5, address.getPostalCode());
            pstmt.setString(6, address.getDescription());
            pstmt.setString(7, address.getLocation());

            ResultSet dbResultSet = pstmt.executeQuery();
            if(dbResultSet.next()) {
                return findByID(dbResultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findByID(address.getAdressId());
    }

	public Adress update(Adress address) {
		String query = "UPDATE "+tablename+" SET street = ?, number = ?, country = ?, postalcode = ?,"
        		+ " description = ?, location=? WHERE addressid = ? ;";
		try (Connection con = super.getConnection()){
	            PreparedStatement pstmt = con.prepareStatement(query);
	            
	            pstmt.setString(1, address.getStreet());
	            pstmt.setInt(2, address.getNumber());
	            pstmt.setString(3, address.getCountry());
	            pstmt.setString(4, address.getPostalCode());
	            pstmt.setString(5, address.getDescription());
	            pstmt.setString(6, address.getLocation());
	            pstmt.setInt(7, address.getAdressId());

	            ResultSet dbResultSet = pstmt.executeQuery();
	            if(dbResultSet.next()) {
	                return findByID(dbResultSet.getInt(1));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return findByID(address.getAdressId());
	}
}
