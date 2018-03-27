package me.piepers.super11.domain.sportdeer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import me.piepers.super11.domain.JsonDomainObject;

/**
 * A Sportdeer API object mapper. Specific for the Sportdeer API that always has
 * a "docs" element with a list of attributes that are bound to a specific type
 * by this mapper.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */

// TODO: see if this can be made more robust with only istances of DomainObject
// as the list in Docs and perhaps validation.
public final class SportdeerMapper {
	private final static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Map the JSON payload to the given type.
	 *
	 * @param json,
	 *            the String with JSON content.
	 * @param type,
	 *            the type of the domain object to which the object must be mapped.
	 *            Note: this is the domain object that is listed within the
	 *            {@link Docs} object, not the Docs class itself.
	 * @return a {@link Docs} object containing one or more items and optionally a
	 *         {@link Pagination} object.
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> Docs<T> from(String json, Class<T> type)
			throws JsonParseException, JsonMappingException, IOException {
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Docs.class, type);
		return objectMapper.readValue(json, javaType);
	}

	/**
	 * Map the given {@link Docs} object to a JSON string.
	 *
	 * @param docs,
	 *            the docs to map to a JSON string.
	 * @return the JSON payload
	 * @throws JsonProcessingException
	 */
	public static <T extends JsonDomainObject> String to(Docs<T> docs) throws JsonProcessingException {
		return objectMapper.writeValueAsString(docs);
	}
}
