package com.evanl.springidp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FungusServiceImplementation implements FungusService{

	@Autowired
	private FungusRepository fr;
	
	@Override
	public List<Fungi> getAllFungi() {
		return fr.findAll();
	}

	@Override
	public void saveFungus(Fungi fungi) {
		this.fr.save(fungi);	
	}

	@Override
	public Fungi getFungusById(long fungusId) {
        Optional <Fungi> optFungi = fr.findById(fungusId);
        Fungi fungi = null;
        if (optFungi.isPresent()) {
        	fungi = optFungi.get();
        } else {
            throw new RuntimeException("Item not found for id " + fungusId);
        }
        return fungi;	
	}

	@Override
	public void deleteFungusById(long fungusId) {
		this.fr.deleteById(fungusId);
	}
}
