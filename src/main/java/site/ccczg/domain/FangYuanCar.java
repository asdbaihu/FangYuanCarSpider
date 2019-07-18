package site.ccczg.domain;

/**
 * @Author: Effort
 * @Date: 2019/7/18 13:24
 * @Description: 方圆汽车实体类
 */
public class FangYuanCar {
    private int id;
    /**
     * 车辆信息
     */
    private String massage;
    /**
     * 上牌时间
     */
    private String cardsdate;
    /**
     * 行车里程
     */
    private String mileage;
    /**
     * 出厂日期
     */
    private String factorydate;
    /**
     *新车价格
     */
    private String newcarprices;
    /**
     * 一口价
     */
    private String fixedprice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getCardsdate() {
        return cardsdate;
    }

    public void setCardsdate(String cardsdate) {
        this.cardsdate = cardsdate;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getFactorydate() {
        return factorydate;
    }

    public void setFactorydate(String factorydate) {
        this.factorydate = factorydate;
    }

    public String getNewcarprices() {
        return newcarprices;
    }

    public void setNewcarprices(String newcarprices) {
        this.newcarprices = newcarprices;
    }

    public String getFixedprice() {
        return fixedprice;
    }

    public void setFixedprice(String fixedprice) {
        this.fixedprice = fixedprice;
    }

    @Override
    public String toString() {
        return "FangYuanCar{" +
                "id=" + id +
                ", massage='" + massage + '\'' +
                ", cardsdate='" + cardsdate + '\'' +
                ", mileage='" + mileage + '\'' +
                ", factorydate='" + factorydate + '\'' +
                ", newcarprices='" + newcarprices + '\'' +
                ", fixedprice='" + fixedprice + '\'' +
                '}';
    }
}

