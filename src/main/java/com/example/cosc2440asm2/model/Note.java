package com.example.cosc2440asm2.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Note {
    @Column
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staffID;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Staff getStaffID() {
        return staffID;
    }

    public void setStaffID(Staff staff) {
        this.staffID = staff;
    }
}
