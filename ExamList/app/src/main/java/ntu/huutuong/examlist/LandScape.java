package ntu.huutuong.examlist;

public class LandScape {
    String lanCation;

    public String getLanCation() {
        return lanCation;
    }

    public void setLanCation(String lanCation) {
        this.lanCation = lanCation;
    }

    public LandScape(String landImageName, String lanCation) {
        this.lanCation = lanCation;
    }
}
