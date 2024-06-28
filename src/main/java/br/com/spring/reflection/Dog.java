package br.com.spring.reflection;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOG")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "temperament", nullable = true, length = 100)
	private String temperament;

	@Column(name = "origin", nullable = true, length = 45)
	private String origin;

	@Column(name = "country_code", nullable = true, length = 45)
	private String country_code;

	@Column(name = "bred_for", nullable = true, length = 100)
	private String bred_for;

	@Column(name = "breed_group", nullable = true, length = 100)
	private String breed_group;

	@Column(name = "life_span", nullable = true, length = 100)
	private String life_span;

	@Column(name = "history", nullable = true, length = 100)
	private String history;

	@Column(name = "reference_image_id", nullable = false, length = 100)
	private String reference_image_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getBred_for() {
		return bred_for;
	}

	public void setBred_for(String bred_for) {
		this.bred_for = bred_for;
	}

	public String getBreed_group() {
		return breed_group;
	}

	public void setBreed_group(String breed_group) {
		this.breed_group = breed_group;
	}

	public String getLife_span() {
		return life_span;
	}

	public void setLife_span(String life_span) {
		this.life_span = life_span;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getReference_image_id() {
		return reference_image_id;
	}

	public void setReference_image_id(String reference_image_id) {
		this.reference_image_id = reference_image_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return Objects.equals(id, other.id);
	}

}
