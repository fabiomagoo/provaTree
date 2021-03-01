package br.com.tree.prova;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DefaultZero extends JsonDeserializer<Integer> {
	
	public DefaultZero() {        
    }
    
	@Override
	public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		try {
			return p.getValueAsInt();
		} catch (Exception e) {
			return 0;
		}
	}

}
