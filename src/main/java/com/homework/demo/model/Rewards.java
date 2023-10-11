package com.homework.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "rewards")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rewards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_email")
    private String userEmail;

    @Column(name="amount_spent")
    private int amountSpent;

    @Column(name="rewards_point")
    private int rewardsPoint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(int amountSpent) {
        this.amountSpent = amountSpent;
    }

    public int getRewardsPoint() {
        return rewardsPoint;
    }

    public void setRewardsPoint(int rewardsPoint) {
        this.rewardsPoint = rewardsPoint;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(!(o instanceof Rewards)){
            return false;
        }
        Rewards reward = (Rewards) o;
        return Objects.equals(this.id, reward.id) &&
                Objects.equals(this.userName, reward.userName) &&
                Objects.equals(this.userEmail, reward.userEmail) &&
                Objects.equals(this.amountSpent, reward.amountSpent) &&
                Objects.equals(this.rewardsPoint, reward.rewardsPoint);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.userName, this.userEmail, this.amountSpent, this.rewardsPoint);
    }

    @Override
    public String toString(){
        return "Rewards{" + "id=" + this.id + ", user_name='" + this.userName + '\'' + ", user_email='" +
                this.userEmail + '\'' + ", amount_spent='" + this.amountSpent + '\'' + ", rewards_point='" +
                this.rewardsPoint + '\'' + '}';
    }
}
