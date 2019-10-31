package com.example.democonnectinternet.bai4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("profile_pic")
    @Expose
    private String profilePic;

    @SerializedName("phone")
    @Expose
    private Phone phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

//getter + setter

    // class phone

    public class Phone {
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("home")
        @Expose
        private String home;
        @SerializedName("office")
        @Expose
        private String office;

        /**
         * @return The mobile
         */
        public String getMobile() {
            return mobile;
        }

        /**
         * @param mobile The mobile
         */
        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        /**
         * @return The home
         */
        public String getHome() {
            return home;
        }

        /**
         * @param home The home
         */
        public void setHome(String home) {
            this.home = home;
        }

        /**
         * @return The office
         */
        public String getOffice() {
            return office;
        }

        /**
         * @param office The office
         */
        public void setOffice(String office) {
            this.office = office;
        }

    }
}
