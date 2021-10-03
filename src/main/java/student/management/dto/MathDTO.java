package student.management.dto;

public class MathDTO {
    private int id;
    private String name;
    private double ktBaiCu;
    private double kt15p;
    private double kt45p;
    private double ktHocKi;

    public MathDTO() {
    }


    public MathDTO(int id, String name, double ktBaiCu, double kt15p, double kt45p, double ktHocKi) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
