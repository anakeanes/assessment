package com.kbtg.bootcamp.posttest.users;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.annotation.Id;

@Entity
@Table(name= "user_ticket")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lottery_id", referencedColumnName = "lottery_id")
    private String lottery;


public Users() {
    throw new UnsupportedOperationException("Not supported yet.");
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public User getUser() {
    return user;
}

public void setUser(User user){
    this.user = user;
}

public String getLottery(){
    return lottery;
}

public void setLottery(String lottery) {
    this.lottery = lottery;
}

}