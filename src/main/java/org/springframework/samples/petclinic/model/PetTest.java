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

package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

/**
 * Simple JavaBean domain object representing a pet test or examination.
 */
public class PetTest extends BaseEntity {

	private String petName;

	private String testType;

	private LocalDate dateAdministered;

	private String result;

	private String veterinarian;

	private Boolean followUpNeeded;

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public LocalDate getDateAdministered() {
		return dateAdministered;
	}

	public void setDateAdministered(LocalDate dateAdministered) {
		this.dateAdministered = dateAdministered;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(String veterinarian) {
		this.veterinarian = veterinarian;
	}

	public Boolean getFollowUpNeeded() {
		return followUpNeeded;
	}

	public void setFollowUpNeeded(Boolean followUpNeeded) {
		this.followUpNeeded = followUpNeeded;
	}

}
