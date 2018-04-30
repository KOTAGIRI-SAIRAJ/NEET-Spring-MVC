package sb.org.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

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
    private String email_id;

    @Column
    private String password;

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
    private int qualification;

    @Column
    private int aadhaar_number;

    @Column
    private int pan_number;

    @Column
    private int phone_number;

    @Column
    private int landline_number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="franchise_id")
    @JsonBackReference
    private Franchise franchise;

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

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public int getAadhaar_number() {
        return aadhaar_number;
    }

    public void setAadhaar_number(int aadhaar_number) {
        this.aadhaar_number = aadhaar_number;
    }

    public int getPan_number() {
        return pan_number;
    }

    public void setPan_number(int pan_number) {
        this.pan_number = pan_number;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getLandline_number() {
        return landline_number;
    }

    public void setLandline_number(int landline_number) {
        this.landline_number = landline_number;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}
