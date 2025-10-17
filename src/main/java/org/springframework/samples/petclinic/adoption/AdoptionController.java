/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.adoption;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.samples.petclinic.model.AdoptionPet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling adoption-related requests.
 */
@Controller
class AdoptionController {

	@GetMapping("/adoption")
	public String showAdoptionList(Model model) {
		// Create mock data for demonstration
		List<AdoptionPet> adoptionPets = new ArrayList<>();

		AdoptionPet pet1 = new AdoptionPet();
		pet1.setId(1);
		pet1.setName("Buddy");
		pet1.setSpecies("Dog");
		pet1.setBreed("Golden Retriever");
		pet1.setAge(3);
		pet1.setAdoptionStatus("Available");
		pet1.setIntakeDate(LocalDate.of(2024, 1, 15));
		pet1.setNotes("Friendly and energetic");
		adoptionPets.add(pet1);

		AdoptionPet pet2 = new AdoptionPet();
		pet2.setId(2);
		pet2.setName("Whiskers");
		pet2.setSpecies("Cat");
		pet2.setBreed("Siamese");
		pet2.setAge(2);
		pet2.setAdoptionStatus("Available");
		pet2.setIntakeDate(LocalDate.of(2024, 2, 20));
		pet2.setNotes("Calm and affectionate");
		adoptionPets.add(pet2);

		AdoptionPet pet3 = new AdoptionPet();
		pet3.setId(3);
		pet3.setName("Max");
		pet3.setSpecies("Dog");
		pet3.setBreed("Labrador");
		pet3.setAge(5);
		pet3.setAdoptionStatus("Pending");
		pet3.setIntakeDate(LocalDate.of(2023, 11, 10));
		pet3.setNotes("Good with children");
		adoptionPets.add(pet3);

		model.addAttribute("adoptionPets", adoptionPets);
		return "adoption/adoptionList";
	}

}
