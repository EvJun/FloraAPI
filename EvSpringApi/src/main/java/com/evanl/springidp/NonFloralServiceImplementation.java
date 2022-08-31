package com.evanl.springidp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NonFloralServiceImplementation implements NonFloralService{

	@Autowired
	private NonFloralRepository nfr;
	
	@Override
	public List<NonFloral> getAllNonFloral() {
		return nfr.findAll();
	}

	@Override
	public void saveNonFloral(NonFloral nonFloral) {
		this.nfr.save(nonFloral);	
	}

	@Override
	public NonFloral getNonFloralById(long nonFloralId) {
        Optional<NonFloral> optNonFloral = nfr.findById(nonFloralId);
        NonFloral nonFloral = null;
        if (optNonFloral.isPresent()) {
        	nonFloral = optNonFloral.get();
        } else {
            throw new RuntimeException("Item not found for id " + nonFloralId);
        }
        return nonFloral;	
	}

	@Override
	public void deleteNonFloralById(long nonFloralId) {
		this.nfr.deleteById(nonFloralId);
	}
}
