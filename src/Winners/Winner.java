package Winners;

import Toys.BaseToy;

public class Winner {
    private Integer winnerId = -1;
    private String winnerName;
    private BaseToy winnerToy;

    // false - игрушка не выдана; true - игрушка выдана
    private Boolean winnerStatus = false;


    public Winner(String winnerName) {
        this.winnerName = winnerName;
    }

    public void setId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public Integer getId() {
        return this.winnerId;
    }

    public void setName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getName() {
        return this.winnerName;
    }

    public void setStatus(Boolean winnerStatus) {
        this.winnerStatus = winnerStatus;
    }

    public Boolean getStatus() {
        return this.winnerStatus;
    }

    public void setToy(BaseToy winnerToy) {
        this.winnerToy = winnerToy;
    }

    public BaseToy getToy() {
        return this.winnerToy;
    }

}
