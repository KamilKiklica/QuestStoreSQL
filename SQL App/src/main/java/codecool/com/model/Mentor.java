package codecool.com.model;

public class Mentor extends AbstractUser {
    private String nickName;
    private String city;
    private int favouriteNumber;

    public Mentor() {

    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setFavouriteNumber(int favouriteNumber) {
        this.favouriteNumber = favouriteNumber;
    }
    public String getNickName() {
        return nickName;
    }
    public String getCity() {
        return city;
    }
    public int getFavouriteNumber() {
        return favouriteNumber;
    }


}

