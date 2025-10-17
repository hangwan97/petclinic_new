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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for the Test tab.
 *
 * @author PetClinic Team
 */
@Controller
public class TestController {

	@GetMapping("/tests")
	public String showTests(Model model) {
		// Create mock data for test entries
		List<Map<String, String>> tests = new ArrayList<>();

		Map<String, String> test1 = new HashMap<>();
		test1.put("petName", "Max");
		test1.put("testType", "Blood Test");
		test1.put("dateAdministered", "2025-09-20");
		test1.put("result", "Normal");
		test1.put("veterinarian", "Dr. Anderson");
		tests.add(test1);

		Map<String, String> test2 = new HashMap<>();
		test2.put("petName", "Whiskers");
		test2.put("testType", "Vaccination");
		test2.put("dateAdministered", "2025-10-05");
		test2.put("result", "Completed");
		test2.put("veterinarian", "Dr. Martinez");
		tests.add(test2);

		Map<String, String> test3 = new HashMap<>();
		test3.put("petName", "Buddy");
		test3.put("testType", "X-Ray");
		test3.put("dateAdministered", "2025-10-08");
		test3.put("result", "Clear");
		test3.put("veterinarian", "Dr. Thompson");
		tests.add(test3);

		Map<String, String> test4 = new HashMap<>();
		test4.put("petName", "Luna");
		test4.put("testType", "Dental Check");
		test4.put("dateAdministered", "2025-10-11");
		test4.put("result", "Good");
		test4.put("veterinarian", "Dr. Wilson");
		tests.add(test4);

		Map<String, String> test5 = new HashMap<>();
		test5.put("petName", "Charlie");
		test5.put("testType", "General Checkup");
		test5.put("dateAdministered", "2025-10-15");
		test5.put("result", "Healthy");
		test5.put("veterinarian", "Dr. Anderson");
		tests.add(test5);

		Map<String, String> test6 = new HashMap<>();
		test6.put("petName", "Max");
		test6.put("testType", "Heartworm Test");
		test6.put("dateAdministered", "2025-10-16");
		test6.put("result", "Negative");
		test6.put("veterinarian", "Dr. Martinez");
		tests.add(test6);

		model.addAttribute("tests", tests);
		return "tests";
	}

}
