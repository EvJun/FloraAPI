package com.evanl.springidp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class FloralRepositoryTest {

	@Autowired
	private FloralRepository fr;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateFloral() {
		Floral floral = new Floral();
		floral.setName("tester1");
		floral.setScientificName("scientific name test");
		floral.setLocation("location test");
		floral.setRisk("risk test");
		floral.setCharacteristics("characteristics test");
		
		Floral savedFloral = fr.saveFloral(floral);
		Floral existingFloral = entityManager.find(Floral.class, savedFloral.getFloralId()); //class and primary key
		assertThat(existingFloral.getScientificName().isEqualTo(floral.getScientificName());
	}
}
