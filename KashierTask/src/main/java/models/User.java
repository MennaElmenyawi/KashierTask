package models;

public class User {
    private String fullName;
    private String storeName;
    private String email;
    private String phone;
    private String password;
    private String passwordConfirm;
    private Boolean registerBusiness;

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public String getstoreName() {
        return storeName;
    }

    public void setstoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Boolean getregisterBusiness() {
        return registerBusiness;
    }

    public void setregisterBusiness(Boolean registerBusiness) {
        this.registerBusiness = registerBusiness;
    }


}
