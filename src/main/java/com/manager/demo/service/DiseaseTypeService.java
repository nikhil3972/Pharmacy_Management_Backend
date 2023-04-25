package com.manager.demo.service;

import com.manager.demo.dao.DiseasesTypeDao;
import com.manager.demo.entity.DiseaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DiseaseTypeService {
    @Autowired
    private DiseasesTypeDao dao;
    public String addDiseaseType(DiseaseType diseaseType){
        dao.save(diseaseType);
        return "DiseaseType added";
    }
    public String deleteDiseaseType(int id){
        DiseaseType diseaseType=dao.getById(id);
        dao.delete(diseaseType);
        return "DiseaseType deleted "+id;
    }
    public String updateDiseaseType(DiseaseType diseaseType){
        dao.save(diseaseType);
        return "DiseaseType Updated";
    }
    public List<DiseaseType> getDiseaseType(){
        List<DiseaseType> diseaseType=dao.findAll();
        return diseaseType;
    }
}
