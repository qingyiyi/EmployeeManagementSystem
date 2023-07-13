package entity;

public class DepartmentPosition {
    int id;
    String departmentName;
    String positionName;
    String positionIntroduction;

    int ranking;

    public String getPositionName() {
        return positionName;
    }
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getPositionIntroduction() {
        return positionIntroduction;
    }
    public void setPositionIntroduction(String positionIntroduction) {
        this.positionIntroduction = positionIntroduction;
    }
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
