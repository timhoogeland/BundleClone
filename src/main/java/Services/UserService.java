package Services;

import java.util.List;

import DAOS.UserDAO;
import Objects.User;
import Objects.UserLoanInformation;
import Objects.UserWithAddress;

public class UserService {
	    private UserDAO userDAO = new UserDAO();

	    public UserService() {}

	    public List<UserWithAddress> getAllUsers() { 
	    	return userDAO.findAllUsers(); 
	    	}

	    public UserWithAddress getUserByID(int id) { 
	    	return userDAO.findById(id); 
	    	}
	    
	    public UserWithAddress getUserByID2(int id) { 
	    	return userDAO.findById(id); 
	    	}
	    
	    public int getIdByEmail(String name) { 
	    	return userDAO.findIdByName(name); 
	    	}

	    public UserWithAddress update (UserWithAddress user) { 
	    	return userDAO.update(user); 
	    	}

	    public boolean delete (int userId) { 
	    	return userDAO.delete(userId); 
	    	}

	    public UserWithAddress newUser (User user) { 
	    	return userDAO.save(user); 
	    	}
	    public List<UserLoanInformation> getUserLoanInformation(int userId){
	    	return userDAO.getUserLoanInformation(userId);
	    }
}
