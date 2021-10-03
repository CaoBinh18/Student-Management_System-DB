package student.management.model;

public class Score {
    private int id;
    private int subId;
    private int stuId;
    private double ktBaiCu;
    private double kt15p;
    private double kt45p;
    private double ktHocKi;

    public Score() {
    }

    public Score(int id, int subId, int stuId, double ktBaiCu, double kt15p, double kt45p, double ktHocKi) {
        this.id = id;
        this.subId = subId;
        this.stuId = stuId;
        this.ktBaiCu = ktBaiCu;
        this.kt15p = kt15p;
        this.kt45p = kt45p;
        this.ktHocKi = ktHocKi;
    }

    public Score(int subId, int stuId, double ktBaiCu, double kt15p, double kt45p, double ktHocKi) {
        this.subId = subId;
        this.stuId = stuId;
        this.ktBaiCu = ktBaiCu;
        this.kt15p = kt15p;
        this.kt45p = kt45p;
        this.ktHocKi = ktHocKi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public double getKtBaiCu() {
        return ktBaiCu;
    }

    public void setKtBaiCu(double ktBaiCu) {
        this.ktBaiCu = ktBaiCu;
    }

    public double getKt15p() {
        return kt15p;
    }

    public void setKt15p(double kt15p) {
        this.kt15p = kt15p;
    }

    public double getKt45p() {
        return kt45p;
    }

    public void setKt45p(double kt45p) {
        this.kt45p = kt45p;
    }

    public double getKtHocKi() {
        return ktHocKi;
    }

    public void setKtHocKi(double ktHocKi) {
        this.ktHocKi = ktHocKi;
    }
}
