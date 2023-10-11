package com.homework.demo.controller;

import com.homework.demo.model.Rewards;
import com.homework.demo.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rewards")
@CrossOrigin(origins = "http://localhost:4200")
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping(value="/all-rewards")
    public List<Rewards> getRewards(){
        return rewardsService.getAllRewards();
    }

    @PostMapping(value="/post-new-reward")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRewards(@RequestBody Rewards rewards){
        rewardsService.createRewards(rewards);
    }

    @PutMapping(value="/all-rewards/{id}")
    public Rewards updateRewards(@PathVariable(value = "id") Integer id,
                                 @RequestBody Rewards rewardsDetails){
        return rewardsService.updateRewards(id, rewardsDetails);
    }

    @DeleteMapping(value="/all-rewards/{id}")
    public void updateRewards(@PathVariable(value = "id") Integer id){
        rewardsService.deleteRewards(id);
    }
}
