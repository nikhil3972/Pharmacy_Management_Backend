package com.manager.demo.service;

import com.manager.demo.dao.DisaeseDao;
import com.manager.demo.entity.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DiseaseService {

    @Autowired
    private DisaeseDao dao;

    public String addDisease(Disease disease) {
        dao.save(disease);
        return "CustomerMedicine added";
    }

    public String deleteDisease(int id) {
        Disease disease = dao.getById(id);
        dao.delete(disease);
        return "Disease deleted " + id;
    }

    public String updateDisease(Disease disease) {
        dao.save(disease);
        return "Disease Updated";
    }

    public List<Disease> getDisease() {
        List<Disease> disease = dao.findAll();
        return disease;
    }
}
