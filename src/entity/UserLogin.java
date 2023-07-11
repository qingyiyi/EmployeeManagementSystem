package entity;


import java.text.SimpleDateFormat;
import java.util.Date;

public class UserLogin {
    private int id;
    private String employeeId;
    private String password;
    private String name;
    private String photo;
    private String department;
    private String position;
    private int isAdministrator;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getIsAdministrator() {
        return isAdministrator;
    }

    public void setIsAdministrator(int isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", employeeId='" + employeeId + '\'' +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                '}'+'\n';
    }

    public String ShowTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(Date.parse(time.toString()));
    }
}
