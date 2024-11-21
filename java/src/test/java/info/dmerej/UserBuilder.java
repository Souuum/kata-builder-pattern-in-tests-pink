package info.dmerej;

public class UserBuilder {
    private String nom;
    private String email;
    private int age;
    private boolean verified;
    private Address address;

    public User build(){
        return new User(nom,email,age,verified,address);
    }

    public UserBuilder withDefaultValues(){
      nom = "David";
      email = "David@test.com";
      age = 25;
      verified = true;
      address = new Address(
              "51 Franklin Street",
              "Fifth Floor",
              "Boston",
              "02110",
              "USA");

      return this;
    };


    public UserBuilder withName(String n){
        nom=n;
        return this;
    }

    public UserBuilder withEmail(String e){
        email=e;
        return this;
    }

    public UserBuilder withAge(int a){
        age=a;
        return this;
    }

    public UserBuilder withVerified(boolean v){
        verified=v;
        return this;
    }

    public UserBuilder withAddress(Address a){
        address = a;
        return this;
    }

    public UserBuilder withForeignAddress(){
        address = parisAddress;
        return this;
    }

    public UserBuilder minor(){
        age = 16;
        return this;
    }

    public UserBuilder notVerified(){
        verified = false;
        return this;
    }
}
