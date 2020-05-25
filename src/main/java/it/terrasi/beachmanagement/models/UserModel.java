package it.terrasi.beachmanagement.models;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import it.terrasi.beachmanagement.validators.ValidPassword;

public class UserModel {
    
    @NotBlank(message = "Username must be provided")
    @Length(min = 3, message = "Username must be minimum 3 characters lenght")
    private String username;

    @ValidPassword
    private String password;

    @ValidPassword
    private String confirmPassword;

    @NotBlank(message = "First name must be provided")
    private String firstName;

    @NotBlank(message = "Last name must be provided")
    private String lastName;

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassoword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}