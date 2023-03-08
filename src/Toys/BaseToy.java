package Toys;

public class BaseToy {
    private Integer toyId;
    private String name;
    private Integer count;
    private Integer rarity;

    public BaseToy(String toyName) {
        this.name = toyName;
        this.toyId = -1;
        this.count = 0;
        this.rarity = 0;
    }

    public void setId(Integer toyId) {
        this.toyId = toyId;
    }

    public void setName(String toyName) {
        this.name = toyName;
    }

    public void setCount(Integer toyCount) {
        this.count = toyCount;
    }

    public void setRarity(Integer toyRarity) {
        this.rarity = toyRarity;
    }

    public Integer getId() {
        return this.toyId;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCount() {
        return this.count;
    }

    public Integer getRarity() {
        return this.rarity;
    }
}
