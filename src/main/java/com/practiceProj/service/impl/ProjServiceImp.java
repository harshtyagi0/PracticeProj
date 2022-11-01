package com.practiceProj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practiceProj.entity.EntityClass;
import com.practiceProj.model.ModelClass;
import com.practiceProj.repository.ProjRepo;
import com.practiceProj.service.ProjService;

@Service
public class ProjServiceImp implements ProjService {

	private final ProjRepo pRepo;

	public ProjServiceImp(ProjRepo pRepo) {
		this.pRepo = pRepo;
	}

	@Override
	public List<ModelClass> getAll() {
		List<ModelClass> list = new ArrayList<>();
		List<EntityClass> listE = pRepo.findAll();
		for (EntityClass e : listE) {
			ModelClass modClass = new ModelClass();
			modClass.setFirstName(e.getFirstName());
			modClass.setLastName(e.getLastName());
			modClass.setNumb(e.getNumb());
			modClass.setNumber(e.getNumber());
			list.add(modClass);
		}
		return list;
	}

	@Override
	public ModelClass getOneById(int id) {
		ModelClass modClass = new ModelClass();
		Optional<EntityClass> list = pRepo.findById(id);
		EntityClass e = list.get();
		modClass.setFirstName(e.getFirstName());
		modClass.setLastName(e.getLastName());
		modClass.setNumb(e.getNumb());
		modClass.setNumber(e.getNumber());
		return modClass;
	}

	@Override
	public boolean createModel(ModelClass modClass) {
		EntityClass e = new EntityClass();
		e.setFirstName(modClass.getFirstName());
		e.setLastName(modClass.getLastName());
		e.setNumb(modClass.getNumb());
		e.setNumber(modClass.getNumber());
		try {
			pRepo.save(e);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateModel(ModelClass modClass) {
		Optional<EntityClass> eList = pRepo.findById(modClass.getNumb());
		EntityClass updation = null;
		if (eList.isPresent()) {
			updation = eList.get();
			updation.setFirstName(modClass.getFirstName());
			updation.setLastName(modClass.getLastName());
			updation.setNumber(modClass.getNumber());

			pRepo.save(updation);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		if(pRepo.findById(id).isPresent()) {
			pRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
