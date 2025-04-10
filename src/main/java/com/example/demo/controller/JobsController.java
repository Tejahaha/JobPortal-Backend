package com.example.demo.controller;


import com.example.demo.model.Jobs;
import com.example.demo.service.JobsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Jobs")
@CrossOrigin(origins = "*")
public class JobsController {

    @Autowired
    JobsManager JM;

    @PostMapping("/create")
    public String create(@RequestBody Jobs J)
    {
        return JM.createJob(J);
    }


    @GetMapping("/getjobs")
    public String ReadJobs()
    {
        return JM.ReadJobs();
    }

    @GetMapping("/getdata/{id}")
    public String getData(@PathVariable("id") Long ID){
        return JM.getData(ID);
    }

    @PutMapping("/update")
    public String update(@RequestBody Jobs J)
    {
        return JM.updatejob(J);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long ID){
        return JM.deletejob(ID);
    }
}
