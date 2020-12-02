package com.rest.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xx_employee")
public class Employee {
        @Id
        @Column(name="emp_id")
        private int emp_id;

        @Column(name="emp_fname")
        private String emp_fname;
        @Column(name="emp_lname")
        private String emp_lname;
        @Column(name="emp_gender")
        private String emp_gender;
        @Column(name="emp_role")
        private String emp_role;

        public Employee() {}
        public Employee(int emp_id, String emp_fname, String emp_lname, String emp_gender, String emp_role)
        {
            this.emp_id=emp_id;
            this.emp_fname=emp_fname;
            this.emp_lname=emp_lname;
            this.emp_gender=emp_gender;
            this.emp_role=emp_role;
        }

        public int getEmp_id() {
            return emp_id;
        }

        public String getEmp_fname() {
            return emp_fname;
        }

        public void setEmp_fname(String emp_fname) {
            this.emp_fname = emp_fname;
        }

        public String getEmp_lname() {
            return emp_lname;
        }

        public void setEmp_lname(String emp_lname) {
            this.emp_lname = emp_lname;
        }

        public String getEmp_gender() {
            return emp_gender;
        }

        public void setEmp_gender(String emp_gender) {
            this.emp_gender = emp_gender;
        }

        public String getEmp_role() {
            return emp_role;
        }

        public void setEmp_role(String emp_role) {
            this.emp_role = emp_role;
        }

        public void setEmp_id(int emp_id) {
            this.emp_id = emp_id;
        }

    }

