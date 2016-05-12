package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class User implements Serializable{
    private String email;
    private String screenName;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Builder builder){
        this.email = builder.email;
        this.screenName = builder.screenName;
        this.password = builder.password;
    }

    public static class Builder{
        private String email;
        private String screenName;
        private String password;



        public Builder email(String value) {
            this.email = value;
            return this;
        }

        public Builder screenName(String value) {
            this.screenName = value;
            return this;
        }

        public Builder password(String value) {
            this.password = value;
            return this;
        }


        public Builder copy(User value) {
            this.email = value.email;
            this.screenName = value.screenName;
            this.password = value.password;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User  user = (User ) o;

        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
