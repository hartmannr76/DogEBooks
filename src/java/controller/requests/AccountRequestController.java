/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.requests;

import controller.managers.UserManager;
import item.Item;
import java.io.Serializable;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sessions.StaffAccountSession;
import sessions.UserSession;
import stf.StaffAccount;
import user.User;
import user.UserWishlist;
import user.WishlistItem;

/**
 *
 * @author Ricky
 */
@ManagedBean (name = "accountReq")
@RequestScoped
public class AccountRequestController implements Serializable {

    
    @EJB
    UserSession us;
    @EJB
    StaffAccountSession sas;
    @EJB
    UserManager um;
    
    int barCode;
    String username;
    String password;
    String wishlistName;
    String firstName;
    String lastName;
    String email;
    int mobileNumber;
    String message;
    boolean success;
    
    /**
     * Creates a new instance of AccountRequestController
     */
    public AccountRequestController() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getWishlistName() {
        return wishlistName;
    }
    
    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    public String doLogin() {
        User u = null;
        if(!username.equals("") && !password.equals(""))
            u = um.doesUserExist(username, password);
        if(u != null) {
            us.setUser(u);
            us.setCheckouts(um.getUsersCheckouts(u));
            us.getUser().setWishlists(um.getUsersWishlist(u.getIdUserLibraryCode()));
            success = true;
            message = "Thank you for logging in! Please browse our library!";
            return "";
        }
        else {
            success = false;
            message = "Oops... it seems you have entered a wrong username or password";
            return "/account/login.xhtml";
        }
    }
    
    public String doStaffLogin() {
        StaffAccount u = null;
        if(!username.equals("") && !password.equals(""))
            u = um.doesStaffExist(username, password);
        if(u != null) {
            sas.setSa(u);
            success = true;
            message = "Thank you for logging in! Please browse our library!";
            return "";
        }
        else {
            success = false;
            message = "Oops... it seems you have entered a wrong username or password";
            return "";
        }
    }
    
    public String emailPassword() {
        User u = null;
        if(!username.equals(""))
            u = um.userPasswordRecovery(username);
        if(u != null) {
                Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                props.put("mail.smtp.from", "no-reply@dog-ebooks.com");
 
		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("dogebookslibrary@gmail.com","mrsnarfster1!");
				}
			});
 
		try {
                        InternetAddress[] ia = new InternetAddress[1];
                        ia[0] = new InternetAddress("no-reply@dog-ebooks.com");
			Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("no-reply@dog-ebooks.com"));
                        message.setReplyTo(ia);
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(u.getUserEmail()));
			message.setSubject("Password Recovery");
			message.setText(u.getFirstName()+"," +
					"\n\n Your password is: " + u.getPassword());
 
			Transport.send(message);
 
			System.out.println("Done");
                        this.message = "Your password has been sent to the email address registered to the account!";
                        success = true;
                        return "";
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        }
        else
        {
            success = false;
            this.message = "Sorry, the username you entered does not exist!";
            return "";
        }
    }
    
    public List<Item> getCurrentCart() {
        return us.getObjCart();
    }
    
    public User getCurrentUser() {
        return us.getUser();
    }
    
    public StaffAccount getCurrentStaff() {
        return sas.getSa();
    }
    
    public List<Item> getCurrentCheckouts() {
        return us.getCheckouts();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public String logout() {
        us.setUser(null);
        
        String orig = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        String[] postSplit = orig.split("/");
        
        if(postSplit[1].equals("account"))
            return "../index.xhtml";
        else
            return "";
    }
    
    public String logoutStaff() {
        sas.setSa(null);
        
        return "";
    }
    
    public String login() {
        if(us.getUser() != null)
            return us.getUser().getFirstName();
        else return null;
    }
    
    public String checkStaffLogin() {
        if(sas.getSa() != null)
            return sas.getSa().getUserName();
        else return null;
    }
    
    public int getStaffPerm() {
        if(sas.getSa() != null)
            return sas.getSa().getPermissionsLevel();
        else
            return 4;
        
    }
    
    public String createUser() {
        User u = new User(barCode, username, password, firstName, lastName, email);
        u.setUserMobileNumber(Integer.toString(mobileNumber));
        um.createUser(u);        
        
        return "";
    }
    
    public String updateUser() {
        
        
        return "/account/view.xhtml";
    }
    
    public String checkout() {
        um.checoutUser(us.getObjCart(), us.getUser());
        us.clearCart();
        us.setCheckouts(um.getUsersCheckouts(us.getUser()));
        return "/account/checkouts.xhtml?faces-redirect=true";
    }
    
    public void returnItem(Item i) {
        um.returnItem(i, us.getUser());
        us.setCheckouts(um.getUsersCheckouts(us.getUser()));
    }
    
    public void addItemToWishlist(Item i) {
        // Make sure it doesn't already exist
        boolean ifExist = true;
        for(WishlistItem wli : us.getUser().getWishlists()) {
            if(wli.getItem().equals(i))
                ifExist = false;
        }
        if(ifExist) {
            WishlistItem itemToAdd = new WishlistItem(new Date(), Integer.toString(i.getItemType()), i, us.getUser().getIdUserLibraryCode());
            // Add item to database
            um.addItemToWishlist(itemToAdd);
            // Refresh wishlists in session
            us.getUser().setWishlists(um.getUsersWishlist(us.getUser().getIdUserLibraryCode()));
        }
    }
    
    public void removeItemFromWishlist(WishlistItem wli) {
        // Remove from session
        us.getUser().removeItemFromWishlist(wli);
        // Remove from database
        um.removeItemFromWishlist(wli);
    }
    
    
    
    public String viewAccountMain() {
        return "/account/view.xhtml?faces-redirect=true";
    }
    
    public String viewLogin() {
        return "/account/login.xhtml?faces-redirect=true";
    }
    
    public String viewCart() {
        return "/account/cart.xhtml?faces-redirect=true";
    }
    
    public String viewWishlist() {
        return "/account/wishlists.xhtml?faces-redirect=true";
    }
    
    public String viewRegister() {
        return "/account/register.xhtml?faces-redirect=true";
    }
}
