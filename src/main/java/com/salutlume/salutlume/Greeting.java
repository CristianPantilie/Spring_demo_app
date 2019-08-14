package com.salutlume.salutlume;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeting {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String message;

    @Autowired
    public Greeting(){

    }

    @Autowired
    public Greeting(String message){
        this.message = message;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
