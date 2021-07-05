/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.forum;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@Entity
@GraphQLObjectType("Member")
public class Member 
{

	public Member(){
		// No action
	}

	@Id
	@GeneratedValue
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = String.class)
	String id;


	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = String.class)
	String name;


	@GraphQLScalar(fieldName = "alias", graphQLTypeSimpleName = "String", javaClass = String.class)
	String alias;


	@GraphQLScalar(fieldName = "email", graphQLTypeSimpleName = "String", javaClass = String.class)
	String email;


	@GraphQLScalar(fieldName = "type", graphQLTypeSimpleName = "MemberType", javaClass = MemberType.class)
	@javax.persistence.Enumerated(javax.persistence.EnumType.STRING)
	MemberType type;



	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setType(MemberType type) {
		this.type = type;
	}

	public MemberType getType() {
		return type;
	}

    public String toString() {
        return "Member {"
				+ "id: " + id
				+ ", "
				+ "name: " + name
				+ ", "
				+ "alias: " + alias
				+ ", "
				+ "email: " + email
				+ ", "
				+ "type: " + type
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		Id("id"),
		Name("name"),
		Alias("alias"),
		Email("email"),
		Type("type");

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldName() {
			return fieldName;
		}

		public Class<?> getGraphQLType() {
			return this.getClass().getDeclaringClass();
		}

	}

	public static Builder builder() {
			return new Builder();
		}



	/**
	 * Builder
	 */
	public static class Builder {
		private String id;
		private String name;
		private String alias;
		private String email;
		private MemberType type;


		public Builder withId(String id) {
			this.id = id;
			return this;
		}
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		public Builder withAlias(String alias) {
			this.alias = alias;
			return this;
		}
		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}
		public Builder withType(MemberType type) {
			this.type = type;
			return this;
		}

		public Member build() {
			Member _object = new Member();
			_object.setId(id);
			_object.setName(name);
			_object.setAlias(alias);
			_object.setEmail(email);
			_object.setType(type);
			return _object;
		}
	}
}