package br.com.tree.prova.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Starship {
	String name;
	String model;
	String manufacturer;
	String length;
	String crew;
	String passengers;	
	String consumables;
//	array  films;
//	array  pilots;
	String url;
	String created;
	String edited;
	
	@JsonProperty("MGLT")
	BigDecimal mglt;
	
	@JsonProperty("starship_class")
	String starshipClass;
	
	@JsonProperty("cost_in_credits")
	String costInCredits;
	
	@JsonProperty("max_atmosphering_speed")
	String maxAtmospheringSpeed;
	@JsonProperty("hyperdrive_rating")
	String hyperdriveRating;
	
	@JsonProperty("cargo_capacity")
	String cargoCapacity;
	
}
