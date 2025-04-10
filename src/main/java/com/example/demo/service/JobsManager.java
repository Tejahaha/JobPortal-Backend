package com.example.demo.service;


import com.example.demo.model.Jobs;
import com.example.demo.repo.JobsRepository;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobsManager {

    @Autowired
    JobsRepository JR;

    public String createJob(Jobs j) {
        try{
            JR.save(j);
            return "Job created";
        }catch(Exception e){
            return "Job creation failed"+e.getMessage();
        }

    }

    public String ReadJobs()
    {
        try {
            List<Jobs> joblist = JR.findAll();
            return new GsonBuilder().create().toJson(joblist);
        }catch(Exception e){
            return "Job read failed "+e.getMessage();
        }
    }

    public String getData(Long id){
    try
        {
        Jobs J = JR.findById(id).get();
        return new GsonBuilder().create().toJson(J);
        }catch(Exception e)
            {
                return "404::"+e.getMessage();
            }
    }

    public String updatejob(Jobs J){
        try{
            JR.save(J);
            return "Job updated";
        }catch(Exception e){
            return "Job updation failed "+e.getMessage();
        }
    }

    public String deletejob(Long id){
        try{
            JR.deleteById(id);
            return "Job deleted";
        }catch(Exception e){
            return "Job deletion failed "+e.getMessage();
        }
    }

}
