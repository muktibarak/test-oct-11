package com.homework.demo.service;

import com.homework.demo.model.Rewards;
import com.homework.demo.repository.RewardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RewardsService {

    @Autowired
    private RewardsRepository rewardsRepository;


    public List<Rewards> getAllRewards() {
        return rewardsRepository.findAll();
    }

    public void createRewards(Rewards rewards) {
        rewards.setId(rewards.getId());
        rewards.setUserName(rewards.getUserName());
        rewards.setUserEmail(rewards.getUserEmail());
        rewards.setAmountSpent(rewards.getAmountSpent());
        rewards.setRewardsPoint(calculateRewards(rewards.getAmountSpent()));
        rewardsRepository.save(rewards);
    }

    public Rewards updateRewards(Integer id, Rewards rewardsDetails) {
        Rewards rewards = rewardsRepository.findById(id).get();
        rewards.setUserName(rewardsDetails.getUserName());
        rewards.setUserEmail(rewardsDetails.getUserEmail());
        rewards.setAmountSpent(rewardsDetails.getAmountSpent());
        rewards.setRewardsPoint(calculateRewards(rewardsDetails.getAmountSpent()));

        return rewardsRepository.save(rewards);
    }

    public void deleteRewards(Integer id) {
        rewardsRepository.deleteById(id);
    }

//    helper function to calculate rewards
    private int calculateRewards(int amt){
        if (amt < 50) {
            return  0;
        } else if (amt >= 50 && amt <= 100){
            return amt - 50;
        } else {
            return 50 + (amt - 100) * 2;
        }
    }

}
