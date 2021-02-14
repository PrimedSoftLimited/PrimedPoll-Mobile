package com.primedsoft.primedpoll.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CompleteRegistration {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("phone")
    private String phoneNum;

    @SerializedName("dob")
    private String dob;


    @SerializedName("Userinterests")
    private ArrayList<userInterests> userInterests;


    public class userInterests{
        @SerializedName("interest_ids")
        private Interest interests;
    }

    public ArrayList<CompleteRegistration.userInterests> getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(ArrayList<CompleteRegistration.userInterests> userInterests) {
        this.userInterests = userInterests;
    }

    public CompleteRegistration(String firstName, String lastName, String phoneNum, String dob, ArrayList<userInterests> interests) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.dob = dob;
        this.userInterests = interests;
    }

    public ArrayList<userInterests> getInterests() {
        return userInterests;
    }

    public void setInterests(ArrayList<userInterests> interests) {
        this.userInterests = interests;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }



    public static class InterestId {
        @SerializedName("interest_id")
        private String interestId;

        public InterestId(String interestId) {

            this.interestId = interestId;
        }

        public String getInterestId() {
            return interestId;
        }

        public void setInterestId(String interestId) {
            this.interestId = interestId;
        }
    }

    public static class CompleteRegisterationResponseBody {
        @SerializedName("success")
        private boolean isSuccessful;

        @SerializedName("message")
        private String message;

        public boolean isSuccessful() {
            return isSuccessful;
        }

        public void setSuccessful(boolean successful) {
            isSuccessful = successful;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class CompleteRegistrationData {
        @SerializedName("data")
        private CompleteRegistration completeRegistration;

        public CompleteRegistrationData(CompleteRegistration completeRegistration) {
            this.completeRegistration = completeRegistration;
        }

        public CompleteRegistration getCompleteRegistration() {
            return completeRegistration;
        }

        public void setCompleteRegistration(CompleteRegistration completeRegistration) {
            this.completeRegistration = completeRegistration;
        }
    }
}
