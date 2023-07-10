package entity;

public class UserLogin {
    int id;
    String employeeId;
    String password;
    String name;
    String photo;
    String department;
    String position;

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
}
