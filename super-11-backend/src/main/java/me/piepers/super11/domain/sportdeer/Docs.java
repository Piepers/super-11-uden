package me.piepers.super11.domain.sportdeer;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.core.json.JsonObject;
import me.piepers.super11.domain.JsonDomainObject;

/**
 * The wrapper that always comes with a response from the SportDeer API. It
 * contains a list of data that is of a particular type and optionally
 * Pagination information.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
// TODO: is this class needed as we have the calling classes to map all the
// relevant domain objects anyway?
@JsonInclude(Include.NON_NULL)
public class Docs<T> implements JsonDomainObject {

	@JsonProperty("docs")
	private List<T> data;
	@JsonProperty("pagination")
	private final Pagination pagination;
	@JsonIgnore
	private Class<T> typeParameterClass;

	@JsonCreator
	public Docs(@JsonProperty("docs") List<T> data, @JsonProperty("pagination") Pagination pagination) {
		this.data = data;
		this.pagination = pagination;
	}

	public Docs(JsonObject jsonObject, Class<T> typeParameterClass) throws Exception {
		this.pagination = new Pagination(jsonObject.getJsonObject("pagination"));
		this.data = jsonObject.getJsonArray("docs").stream().map(object -> (JsonObject) object).map(jo -> {
			Constructor<T> constructor;
			try {
				constructor = typeParameterClass.getConstructor(JsonObject.class);
				return constructor.newInstance(jsonObject);
			} catch (Exception e) {
				// FIXME: make more concise.
				e.printStackTrace();
				return null;
			}
		}).collect(Collectors.toList());
	}

	public List<T> getData() {
		return this.data;
	}

	// public void addDataElement(T element) {
	// if (Objects.isNull(this.data)) {
	// this.data = new ArrayList<>();
	// }
	//
	// this.data.add(element);
	// }

	public Pagination getPagination() {
		return this.pagination;
	}
}
