package br.com.tree.prova.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.tree.prova.DefaultZero;
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
	String consumables;
//	array  films;
//	array  pilots;
	String url;
	String created;
	String edited;
	
	//Custom criado pois existe valores "n/a" no SWAPI
	@JsonDeserialize(using=DefaultZero.class, as=Integer.class)
	Integer passengers;
	
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
