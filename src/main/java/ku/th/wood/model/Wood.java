package ku.th.wood.model;

public class Wood {
    private String woodId;//0001,0002,0003
    private String type;  // water wood , sun wood ,
    private String tier; // A,B,C
    private double price ; //1616.00
    private String des;// คำอธิบาย
    private String woodname; // apple


    public Wood(String woodId, String type, String tier, double price, String des, String woodname) {
        this.woodId = woodId;
        this.type = type;
        this.tier = tier;
        this.price = price;
        this.des = des;
        this.woodname = woodname;
    }
    public String getWoodId(){
        return woodId;
    }
    public void setWoodId(String woodId){
        this.woodId = woodId;

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getName() {
        return woodname;
    }

    public void setName(String woodname) {
        this.woodname = woodname;
    }
}
