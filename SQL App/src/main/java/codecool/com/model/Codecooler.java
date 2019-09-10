package codecool.com.model;

public class Codecooler extends User {

    private int userLevel;
    private int coinsBalance;
    private int classId;

    public Codecooler (){

    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getCoinsBalance() {
        return coinsBalance;
    }

    public void setCoinsBalance(int coinsBalance) {
        this.coinsBalance = coinsBalance;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
