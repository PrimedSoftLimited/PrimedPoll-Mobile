package com.primedsoft.primedpoll.Models;

import com.google.gson.annotations.SerializedName;

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

    @SerializedName("interests")
    private List<InterestId> interests;

    public CompleteRegistration(String firstName, String lastName, String phoneNum, String dob, List<InterestId> interests) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.dob = dob;
        this.interests = interests;
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

    public List<InterestId> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestId> interests) {
        this.interests = interests;
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
