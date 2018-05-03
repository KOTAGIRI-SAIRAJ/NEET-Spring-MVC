package sb.org.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "franchise")
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String middle_name;

    @Column
    private String gender;

    @Column
    private String franchise_name;

    @Column
    private String email_id;

    @Column
    private String franchise_reg_no;

    @Column
    private String password;

    @Column
    private String phone_number;

    @Column
    private String landline_number;

    @Column
    private String pan_number;

    @Column
    private String aadhaar_number;

    @Column
    private String lane_one;

    @Column
    private String lane_two;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private int zip_code;

    @Column
    private byte[] aadhaar_img;

    @Column
    private String pan_img;

    @Column
    private String office_img;

    @Column
    private String passport_img;

    @OneToMany(mappedBy="franchise",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFranchise_name() {
        return franchise_name;
    }

    public void setFranchise_name(String franchise_name) {
        this.franchise_name = franchise_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getFranchise_reg_no() {
        return franchise_reg_no;
    }

    public void setFranchise_reg_no(String franchise_reg_no) {
        this.franchise_reg_no = franchise_reg_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getLandline_number() {
        return landline_number;
    }

    public void setLandline_number(String landline_number) {
        this.landline_number = landline_number;
    }

    public String getPan_number() {
        return pan_number;
    }

    public void setPan_number(String pan_number) {
        this.pan_number = pan_number;
    }

    public String  getAadhaar_number() {
        return aadhaar_number;
    }

    public void setAadhaar_number(String aadhaar_number) {
        this.aadhaar_number = aadhaar_number;
    }

    public String getLane_one() {
        return lane_one;
    }

    public void setLane_one(String lane_one) {
        this.lane_one = lane_one;
    }

    public String getLane_two() {
        return lane_two;
    }

    public void setLane_two(String lane_two) {
        this.lane_two = lane_two;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public byte[] getAadhaar_img() {
        return aadhaar_img;
    }

    public void setAadhaar_img(byte[] aadhaar_img) {
        this.aadhaar_img = aadhaar_img;
    }

    public String getPan_img() {
        return pan_img;
    }

    public void setPan_img(String pan_img) {
        this.pan_img = pan_img;
    }

    public String getOffice_img() {
        return office_img;
    }

    public void setOffice_img(String office_img) {
        this.office_img = office_img;
    }

    public String getPassport_img() {
        return passport_img;
    }

    public void setPassport_img(String passport_img) {
        this.passport_img = passport_img;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
