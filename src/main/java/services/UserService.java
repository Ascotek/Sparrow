package services;

import dao.UserDAO;
import model.User;

import javax.persistence.NoResultException;

public class UserService {
    public static final String EMAIL_ERROR = "emailError";
    public static final String LOGIN_ERROR = "loginError";
    public static final String SUCCESS = "success";
    public static final String EMAIL_AND_LOGIN_ERROR = "emailAndLoginError";

    UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String registerUser(User user) {
        if (isUserEmailAlreadyExist(user.getEmail())&&isUserLoginAlreadyExist(user.getLogin())) {
            return EMAIL_AND_LOGIN_ERROR;
        }
        else if (isUserEmailAlreadyExist(user.getEmail())) {
            return EMAIL_ERROR;
        }
        else if (isUserLoginAlreadyExist(user.getLogin())) {
            return LOGIN_ERROR;
        }
        userDAO.createUser(user);
        return SUCCESS;
    }

    private boolean isUserLoginAlreadyExist(String login) {
        try{
            userDAO.getUserByLogin(login);
            return true;
        }catch (NoResultException e){
            return false;
        }
    }

    private boolean isUserEmailAlreadyExist(String email){
       try{
           userDAO.getUserByEMail(email);
           return true;
       }catch (NoResultException e){
           return false;
        }
    }


}
