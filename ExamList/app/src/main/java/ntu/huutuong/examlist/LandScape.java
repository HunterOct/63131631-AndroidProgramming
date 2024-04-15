package ntu.huutuong.examlist;

public class LandScape {
    String lanCation;
    String lanDate;
    String lanmessage;

    public String getLanDate() {
        return lanDate;
    }

    public void setLanDate(String lanDate) {
        this.lanDate = lanDate;
    }

    public String getLanmessage() {
        return lanmessage;
    }

    public void setLanmessage(String lanmessage) {
        this.lanmessage = lanmessage;
    }

    public String getLanCation() {
        return lanCation;
    }

    public void setLanCation(String lanCation) {
        this.lanCation = lanCation;
    }

    public LandScape(String lanCation, String lanDate, String lanmessage) {
        this.lanCation = lanCation;
        this.lanDate = lanDate;
        this.lanmessage = lanmessage;
    }
}
