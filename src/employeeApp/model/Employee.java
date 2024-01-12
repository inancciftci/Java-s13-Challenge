package employeeApp.model;

import java.util.Arrays;

//POJO(Plain Old Java Object) - Klasik(en basit anlamda) bir java objesi
public class Employee {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String[] healthPlans;

    //boilerplate code

    public Employee(int id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }

    public Employee(int id, String fullName, String email, String password, String[] healthPlans) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.healthPlans = healthPlans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getHealthPlans() {
        return healthPlans;
    }

    public void setHealthPlans(String[] healthPlans) {
        this.healthPlans = healthPlans;
    }

    //new String[4] => healthPlans = [null, null, null, null]
    public void addHealthPlan(int index, String name){
        //Guarding: Olumsuz senaryoları önden yakalamak.

        if (index < 0) {
            System.out.println("Index değeri sıfırdan küçük olamaz");
        } else if (index >= healthPlans.length) {
            System.out.println("Index değeri maksimum: " + (healthPlans.length - 1) + " olabilir.");
        } else {
            try {

                boolean isExist = false;
                for(String healthplan: healthPlans) {
                    if(healthplan != null && healthplan.equals(name)) {
                        isExist = true;
                        System.out.println("Bu plan zaten mevcut. Plan:  " + name);
                        break;
                    }
                }

                if(!isExist) {
                    if (healthPlans[index] == null) {
                        this.healthPlans[index] = name;
                    } else {
                        System.out.println("İlgili index doludur. Index: " + index);
                    }
                }


            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Invalid index: " + index);
            } catch (Exception ex) {
                System.out.println("Error occurred: " + ex.getMessage());
            }

        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", healthPlans=" + Arrays.toString(healthPlans) +
                '}';
    }
}
