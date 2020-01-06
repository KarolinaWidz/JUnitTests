import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Localisation {

    private String name;
    private String city;
    private List<Department> departmentList = new ArrayList<Department>();

    Localisation(){
        this.name="";
        this.city="";
        this.departmentList=null;
    }
    Localisation(String name, String city, List<Department> departmentList) {
        setName(name);
        setCity(city);
        setDepartmentList(departmentList);
    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public List<Department> getDepartmentList() { return departmentList; }
    public void setDepartmentList(List<Department> departmentList) { this.departmentList = departmentList; }

    public Person findEmployee(String pesel){
        for (Department department : departmentList){
            Person found = department.findEmployee(pesel);
            if(!found.equals(null))return found;
        }
        return null;
    }

    public boolean addDepartment(Department department){
        if(this.departmentList.contains(department)){
            return false;
        }
        this.departmentList.add(department);
        return true;
    }

    public boolean removeDepartment(Department department){
        if(this.departmentList.contains(department)){
            this.departmentList.remove(department);
            return true;
        }
        return false;
    }

    public boolean moveDepartment(Localisation localisation, Department department) throws Exception{
        for(Department department1 : localisation.getDepartmentList()){
            if(department.getDepartmentType()==department1.getDepartmentType()) {
                throw new Exception("This type of department already exists in this localisation");
            }
            if(this.departmentList.contains(department)){
                localisation.addDepartment(department);
                this.removeDepartment(department);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localisation that = (Localisation) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(departmentList, that.departmentList);
    }

    @Override
    public String toString() {
        return "Localisation{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", departmentList=" + departmentList +
                '}';
    }
}
