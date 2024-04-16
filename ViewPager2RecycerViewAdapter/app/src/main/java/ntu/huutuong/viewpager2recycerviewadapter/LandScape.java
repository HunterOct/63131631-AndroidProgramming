package ntu.huutuong.viewpager2recycerviewadapter;

public class LandScape {
    String landImageName;
    String lanCation;

    public String getLandImageName() {
        return landImageName;
    }

    public void setLandImageName(String landImageName) {
        this.landImageName = landImageName;
    }

    public String getLanCation() {
        return lanCation;
    }

    public void setLanCation(String lanCation) {
        this.lanCation = lanCation;
    }

    public LandScape(String landImageName, String lanCation) {
        this.landImageName = landImageName;
        this.lanCation = lanCation;
    }
}
