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
	private String name;
	private String model;
	private String manufacturer;
	private String length;
	private String crew;		
	private String consumables;
//	array  films;
//	array  pilots;
	private String url;
	private String created;
	private String edited;
	
	//Custom criado pois existe valores "n/a" no SWAPI
	@JsonDeserialize(using=DefaultZero.class, as=Integer.class)
	private Integer passengers;
	
	@JsonProperty("MGLT")
	private BigDecimal mglt;
	
	@JsonProperty("starship_class")
	private String starshipClass;
	
	@JsonProperty("cost_in_credits")
	private String costInCredits;
	
	@JsonProperty("max_atmosphering_speed")
	private String maxAtmospheringSpeed;
	
	@JsonProperty("hyperdrive_rating")
	private String hyperdriveRating;
	
	@JsonProperty("cargo_capacity")
	private String cargoCapacity;
	
	public String melhorOpcao() {
		return String.format("%s: é a melhor opção pois leva %s passageiros, percorrendo %.0f de distância por parada", this.getName(), this.getPassengers(), this.getMglt()  ) ;
	}
	
}
