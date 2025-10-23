package tn.tym.esprit.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class Calendar {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@JsonFormat(pattern = "yyyy-mm-dd")

	 private Date d;
	@JsonFormat(pattern = "yyyy-mm-dd")

     private Date f;
	

    // Other fields and getters/setters
    
    public Date getD() {
		return d;
	}


	public void setD(Date d) {
		this.d = d;
	}


	public Date getF() {
		return f;
	}


	public void setF(Date f) {
		this.f = f;
	}


	public Long getId() {
        return id;
       
    }

}
