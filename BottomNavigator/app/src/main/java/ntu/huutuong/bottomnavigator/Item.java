package ntu.huutuong.bottomnavigator;

public class Item {

    String tv_name;
    int image_item;

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public int getImage_item() {
        return image_item;
    }

    public void setImage_item(int image_item) {
        this.image_item = image_item;
    }

    public Item(String tv_name, int image_item) {
        this.tv_name = tv_name;
        this.image_item = image_item;
    }
}
