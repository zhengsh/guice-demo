package cn.edu.cqive.dao;

import org.springframework.stereotype.Component;

@Component
public class SampleDao {
    public void save(String data) {
        System.out.println(data + " saved.");
    }
}
