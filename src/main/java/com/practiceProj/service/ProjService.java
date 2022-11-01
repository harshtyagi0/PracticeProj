package com.practiceProj.service;

import java.util.List;

import com.practiceProj.model.ModelClass;

public interface ProjService {

	List<ModelClass> getAll();

	ModelClass getOneById(int id);

	boolean createModel(ModelClass modClass);

	boolean updateModel(ModelClass modClass);

	boolean deleteById(int id);

}
