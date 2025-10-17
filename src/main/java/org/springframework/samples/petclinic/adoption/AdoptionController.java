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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the Adoption page. This is a UI-only implementation with static sample
 * data.
 *
 * @author PetClinic Team
 */
@Controller
public class AdoptionController {

	@GetMapping("/adoption")
	public String showAdoptionPage(Model model) {
		// Create sample adoption data (static for UI-only implementation)
		List<AdoptionPet> adoptionPets = new ArrayList<>();

		adoptionPets.add(new AdoptionPet(1, "Buddy", "Dog / Labrador", "2y", "Male", "Available", "2025-10-10"));
		adoptionPets
			.add(new AdoptionPet(2, "Mittens", "Cat / Domestic Shorthair", "1y", "Female", "Pending", "2025-10-11"));
		adoptionPets
			.add(new AdoptionPet(3, "Charlie", "Dog / Golden Retriever", "3y", "Male", "Available", "2025-10-08"));
		adoptionPets.add(new AdoptionPet(4, "Luna", "Cat / Persian", "6m", "Female", "Available", "2025-10-15"));
		adoptionPets.add(new AdoptionPet(5, "Max", "Dog / German Shepherd", "4y", "Male", "Adopted", "2025-09-20"));
		adoptionPets.add(new AdoptionPet(6, "Bella", "Dog / Beagle", "1y", "Female", "Available", "2025-10-12"));
		adoptionPets.add(new AdoptionPet(7, "Oliver", "Cat / Maine Coon", "2y", "Male", "Pending", "2025-10-14"));
		adoptionPets.add(new AdoptionPet(8, "Daisy", "Dog / Poodle", "5y", "Female", "Available", "2025-10-09"));

		model.addAttribute("adoptionPets", adoptionPets);
		return "adoption";
	}

	/**
	 * Simple POJO class to represent an adoption pet entry.
	 */
	public static class AdoptionPet {

		private Integer id;

		private String name;

		private String species;

		private String age;

		private String gender;

		private String status;

		private String datePosted;

		public AdoptionPet(Integer id, String name, String species, String age, String gender, String status,
				String datePosted) {
			this.id = id;
			this.name = name;
			this.species = species;
			this.age = age;
			this.gender = gender;
			this.status = status;
			this.datePosted = datePosted;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSpecies() {
			return species;
		}

		public void setSpecies(String species) {
			this.species = species;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getDatePosted() {
			return datePosted;
		}

		public void setDatePosted(String datePosted) {
			this.datePosted = datePosted;
		}

	}

}
