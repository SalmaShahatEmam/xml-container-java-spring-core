package spring.core;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class ItemRepo {
	
		
	 public Connection con;
	 
	 public Statement statement;
	 
	 public PreparedStatement preStatement;
	 
	 public item item;
	 
	 public ItemRepo(Connection con)
	 {
	     this.con = con;
		
	 }
	 
	 public ArrayList<item> itemPrice() {
		    String sql = "SELECT * FROM items WHERE price > ?";
		    ArrayList<item> items = new ArrayList<>();

		    try {
		        this.preStatement = this.con.prepareStatement(sql);
		        this.preStatement.setInt(1, 50);
		        ResultSet resultSet = this.preStatement.executeQuery();

		        while (resultSet.next()) {
		            item oneItem = new item(
		                resultSet.getInt("id"),
		                resultSet.getString("name"),
		                resultSet.getInt("price"),
		                resultSet.getInt("total")
		            );
		            items.add(oneItem);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return items;
		}

	 
	 public ArrayList<item> itemHasI() {
		 
		    String sql = "SELECT * FROM items WHERE name LIKE ?";
		    ArrayList<item> items = new ArrayList<>();
		    

		    try {
		    	
		    	
		    	
		    	
		    	
		        this.preStatement = this.con.prepareStatement(sql);
		        this.preStatement.setString(1, "%i%");
		             ResultSet resultSet = this.preStatement.executeQuery();

		        while (resultSet.next()) {
		            item oneItem = new item(
		                resultSet.getInt("id"),
		                resultSet.getString("name"),
		                resultSet.getInt("price"),
		                resultSet.getInt("total")
		            );
		            items.add(oneItem);
		           }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return items;
		}

	 
	 public ArrayList<item> getAllItems() {
		 
		 String sql = "select * from items;";
		 
		 ArrayList<item> items = new ArrayList<>();

		 try {
			ResultSet resultSet = this.statement.executeQuery(sql);
			 while(resultSet.next()) {
				 item oneItem = new item( resultSet.getInt("id") ,  resultSet.getString("name") ,resultSet.getInt("total"),resultSet.getInt("total") );
				 items.add(oneItem);
			 }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	 }
	 
	 public item getItembyId(String id) {

		 String sql = "select * from items Where id = ?";
		 int itemId = Integer.parseInt(id);
		// System.out.println(itemId);

		 item item = null;
		 try {
			 this.preStatement = this.con.prepareStatement(sql);
			 this.preStatement.setInt(1, itemId);

			 ResultSet result = this.preStatement.executeQuery();
			 
			 if(result.next()) {
				 return new item(result.getInt("id") , result.getString("name") , result.getInt("price"),result.getInt("total"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return item;
		
	 }
	 
	 public ArrayList<item> getItemsBetween1And15() {
		    String sql = "SELECT * FROM items WHERE id BETWEEN 1 AND 15;";
		    ArrayList<item> items = new ArrayList<>();

		    try {
		       this.preStatement = this.con.prepareStatement(sql);
		        ResultSet resultSet = this.preStatement.executeQuery();

		        while (resultSet.next()) {
		            item item = new item(
		                resultSet.getInt("id"),
		                resultSet.getString("name"),
		                resultSet.getInt("price"),
		                resultSet.getInt("total")
		            );
		            items.add(item);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return items;
		}

	 
	 public boolean deleteItem(String id) {
		    String sql = "DELETE FROM items WHERE id = ?";
		    int itemId = Integer.parseInt(id);

		    try {
		        this.preStatement = this.con.prepareStatement(sql);
		        this.preStatement.setInt(1, itemId);
		        int result = this.preStatement.executeUpdate();
		        if (result > 0) {
		            return true;
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
		}

	 
	 public boolean updateItem(String id, item item) {
		    String sql = "UPDATE items SET name = ?, price = ?, total = ? WHERE id = ?;";
		    
		    try {
		        this.preStatement = this.con.prepareStatement(sql);
		        this.preStatement.setString(1, item.getName());
		        this.preStatement.setInt(2, item.getPrice());
		        this.preStatement.setInt(3, item.getTotal());
		        this.preStatement.setString(4, id);

		        int res = this.preStatement.executeUpdate();
		        
		        if (res > 0) {
		            return true;
		        }
		        
		    } catch (SQLException e) {
		    	return false;
		       // e.printStackTrace();
		    }
		    
		    return false;
		}

	 
	 public boolean createItem(item item) {
         String q = "INSERT INTO items (name, price, total) VALUES (?, ?, ?);";
         
         
				try {
					this.preStatement = this.con.prepareStatement(q);
					this.preStatement.setString(1, item.getName());
					this.preStatement.setInt(2, item.getPrice());
					this.preStatement.setInt(3, item.getTotal());
			
					int result = this.preStatement.executeUpdate();
					return result > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return false;
	 }

}
