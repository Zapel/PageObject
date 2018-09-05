package PageObjects;

public class Customer extends DataProviders {
    private String firstname;
    private String lastname;
    private String address1;
    private String postcode;
    private String city;
    private String country;
    private String zone;
    private String email;
    private String phone;
    private String password;

    public Customer(Builder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.address1 = builder.address1;
        this.postcode = builder.postcode;
        this.city = builder.city;
        this.country = builder.country;
        this.zone = builder.zone;
        this.email = builder.email;
        this.phone = builder.phone;
        this.password = builder.password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress1() {
        return address1;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZone() {
        return zone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String address1;
        private String postcode;
        private String city;
        private String country;
        private String zone;
        private String email;
        private String phone;
        private String password;

        public Builder () {
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setAdress1(String address1) {
            this.address1 = address1;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setZone(String zone) {
            this.zone = zone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPostcode(String  postcode) {
            this.postcode =  postcode;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
