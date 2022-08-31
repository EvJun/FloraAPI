package com.evanl.springidp;

import java.util.List;


public interface FungusService {	
	 List<Fungi> getAllFungi();
	 void saveFungus(Fungi fungi);
	 Fungi getFungusById(long fungusId);
	 void deleteFungusById(long fungusId);
}

