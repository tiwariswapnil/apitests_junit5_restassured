package com.petstore.test.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class for Category and Tag objects in FindByStatus response
 * <p>
 * Annotations:
 *
 * @JsonInclude - To include non-null fields while serialization/deserialization of JSON
 * @Data - Lombok Annotation for getter/setter and additional methods
 * @**Constructor - To generate constructor methods during compile time
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetsFindByStatusResponseCategoryAndTag {

    @JsonProperty("id")
    public Long id;
    @JsonProperty("name")
    public String name;

}
