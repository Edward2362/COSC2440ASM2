package model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Note {
    @Column
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId", nullable = false)
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

