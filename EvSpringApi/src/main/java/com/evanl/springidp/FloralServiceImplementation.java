package com.evanl.springidp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloralServiceImplementation implements FloralService{

	@Autowired
	private FloralRepository fr;
	
	@Override
	public List<Floral> getAllFloral() {
		return fr.findAll();
	}
	
	@Override
	public void saveFloral(Floral floral) {
		this.fr.save(floral);	
	}

	@Override
	public Floral getFloralById(long floralId) {
        Optional<Floral> optFloral = fr.findById(floralId);
        Floral floral = null;
        if (optFloral.isPresent()) {
        	floral = optFloral.get();
        } else {
            throw new RuntimeException("Item not found for id " + floralId);
        }
        return floral;
	}
	

	@Override
	public void deleteFloralById(long floralId) {
		this.fr.deleteById(floralId);
	}
}
