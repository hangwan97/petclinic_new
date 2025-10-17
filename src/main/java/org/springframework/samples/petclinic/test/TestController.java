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

package org.springframework.samples.petclinic.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.samples.petclinic.model.PetTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling pet test-related requests.
 */
@Controller
class TestController {

	@GetMapping("/test")
	public String showTestList(Model model) {
		// Create mock data for demonstration
		List<PetTest> petTests = new ArrayList<>();

		PetTest test1 = new PetTest();
		test1.setId(1);
		test1.setPetName("Max");
		test1.setTestType("Blood Test");
		test1.setDateAdministered(LocalDate.of(2024, 3, 20));
		test1.setResult("Normal");
		test1.setVeterinarian("Dr. Smith");
		test1.setFollowUpNeeded(false);
		petTests.add(test1);

		PetTest test2 = new PetTest();
		test2.setId(2);
		test2.setPetName("Buddy");
		test2.setTestType("Vaccination");
		test2.setDateAdministered(LocalDate.of(2024, 3, 15));
		test2.setResult("Completed");
		test2.setVeterinarian("Dr. Johnson");
		test2.setFollowUpNeeded(true);
		petTests.add(test2);

		PetTest test3 = new PetTest();
		test3.setId(3);
		test3.setPetName("Whiskers");
		test3.setTestType("Physical Examination");
		test3.setDateAdministered(LocalDate.of(2024, 3, 10));
		test3.setResult("Healthy");
		test3.setVeterinarian("Dr. Williams");
		test3.setFollowUpNeeded(false);
		petTests.add(test3);

		model.addAttribute("petTests", petTests);
		return "test/testList";
	}

}
