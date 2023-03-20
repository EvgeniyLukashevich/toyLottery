package Toys;

public class BaseToy {
    private Integer toyId = -1;
    private String name;
    private Integer count = 0;
    private Integer rarity = 0;

    public BaseToy(String toyName) {
        this.name = toyName;
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
