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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for the Adoption tab.
 *
 * @author PetClinic Team
 */
@Controller
public class AdoptionController {

	@GetMapping("/adoptions")
	public String showAdoptions(Model model) {
		// Create mock data for adoption entries
		List<Map<String, String>> adoptions = new ArrayList<>();

		Map<String, String> adoption1 = new HashMap<>();
		adoption1.put("petName", "Max");
		adoption1.put("species", "Dog - Golden Retriever");
		adoption1.put("adoptionDate", "2025-09-15");
		adoption1.put("adopterName", "John Smith");
		adoption1.put("status", "Completed");
		adoptions.add(adoption1);

		Map<String, String> adoption2 = new HashMap<>();
		adoption2.put("petName", "Whiskers");
		adoption2.put("species", "Cat - Persian");
		adoption2.put("adoptionDate", "2025-10-01");
		adoption2.put("adopterName", "Sarah Johnson");
		adoption2.put("status", "Completed");
		adoptions.add(adoption2);

		Map<String, String> adoption3 = new HashMap<>();
		adoption3.put("petName", "Buddy");
		adoption3.put("species", "Dog - Labrador");
		adoption3.put("adoptionDate", "2025-10-10");
		adoption3.put("adopterName", "Michael Brown");
		adoption3.put("status", "Pending");
		adoptions.add(adoption3);

		Map<String, String> adoption4 = new HashMap<>();
		adoption4.put("petName", "Luna");
		adoption4.put("species", "Cat - Siamese");
		adoption4.put("adoptionDate", "2025-10-12");
		adoption4.put("adopterName", "Emily Davis");
		adoption4.put("status", "Completed");
		adoptions.add(adoption4);

		Map<String, String> adoption5 = new HashMap<>();
		adoption5.put("petName", "Charlie");
		adoption5.put("species", "Dog - Beagle");
		adoption5.put("adoptionDate", "2025-10-16");
		adoption5.put("adopterName", "David Wilson");
		adoption5.put("status", "In Progress");
		adoptions.add(adoption5);

		model.addAttribute("adoptions", adoptions);
		return "adoptions";
	}

}
