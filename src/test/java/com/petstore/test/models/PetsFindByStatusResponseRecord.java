package com.petstore.test.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Model class for FindByStatus response records
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
        "category",
        "name",
        "photoUrls",
        "tags",
        "status"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetsFindByStatusResponseRecord {

    @JsonProperty("id")
    public Long id;
    @JsonProperty("category")
    public PetsFindByStatusResponseCategoryAndTag category;
    @JsonProperty("name")
    public String name;
    @JsonProperty("photoUrls")
    public List<String> photoUrls = null;
    @JsonProperty("tags")
    public List<PetsFindByStatusResponseCategoryAndTag> tags = null;
    @JsonProperty("status")
    public String status;
}
