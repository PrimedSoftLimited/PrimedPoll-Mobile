package com.primedsoft.primedpoll.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("password_confirmation")
    private String passwordConfirmation;
    @SerializedName("verified")
    private boolean verified;
    @SerializedName("verifycode")
    private String verifyCode;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;
    @SerializedName("token")
    private String token;
    @SerializedName("data")
    private Data data;
    private ArrayList<Data> dataArrayList;
    @SerializedName("interest")
    private String interest;
    @SerializedName("user")
    User userObject;
    @SerializedName("Userinterests")
    ArrayList<Interest> Userinterests = new ArrayList<>();
    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("dob")
    private String dob;
    @SerializedName("phone")
    private String phone;

    public Data(String first_name, String last_name, String phone, String dob, ArrayList<Interest> arrayList) {
        this.token = token;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.dob = dob;
        this.Userinterests = arrayList;

    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUserObject() {
        return userObject;
    }

    public void setUserObject(User userObject) {
        this.userObject = userObject;
    }

    public ArrayList<Interest> getUserinterests() {
        return Userinterests;
    }

    public void setUserinterests(ArrayList<Interest> userinterests) {
        Userinterests = userinterests;
    }


    public ArrayList<Data> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }



    public Data(Boolean success, String token, User UserOject){
        this.success = success;
        this.token = token;
        this.userObject = UserOject;
    }

    public Data(String message, Boolean verified){
        this.message = message;
        this.verified = verified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public Data() {

    }
    public Data(String verifyCode, String password, String cnf_password) {
        this.verifyCode = verifyCode;
        this.password = password;
        this.passwordConfirmation = cnf_password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Data(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Data(String email) {
        this.email = email;

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return passwordConfirmation;
    }

    public void setConfirmPassword(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Data getData() {
        return data;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
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


    private class User {
    }
}
