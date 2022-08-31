package com.evanl.springidp;

import java.util.List;


public interface FloralService {	
	 List<Floral> getAllFloral();
	 void saveFloral(Floral floral);
	 Floral getFloralById(long floralId);
	 void deleteFloralById(long floralId);
}

