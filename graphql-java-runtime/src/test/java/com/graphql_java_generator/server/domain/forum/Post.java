/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.server.domain.forum;

import java.util.Date;
import java.util.UUID;

import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLObjectType("Post")
public class Post {

	public Post() {
		// No action
	}

	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID",  javaClass = UUID.class)
	UUID id;

	@GraphQLScalar(fieldName = "date", graphQLTypeSimpleName = "Date",  javaClass = Date.class)
	Date date;

	@GraphQLNonScalar(fieldName = "author", graphQLTypeSimpleName = "Member",  javaClass = Member.class)
	Member author;

	@GraphQLScalar(fieldName = "publiclyAvailable", graphQLTypeSimpleName = "Boolean",  javaClass = Boolean.class)
	Boolean publiclyAvailable;

	@GraphQLScalar(fieldName = "title", graphQLTypeSimpleName = "String",  javaClass = String.class)
	String title;

	@GraphQLScalar(fieldName = "content", graphQLTypeSimpleName = "String",  javaClass = String.class)
	String content;

	UUID authorId;

	UUID topicId;

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setAuthor(Member author) {
		this.author = author;
	}

	public Member getAuthor() {
		return author;
	}

	public void setPubliclyAvailable(Boolean publiclyAvailable) {
		this.publiclyAvailable = publiclyAvailable;
	}

	public Boolean getPubliclyAvailable() {
		return publiclyAvailable;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setAuthorId(UUID authorId) {
		this.authorId = authorId;
	}

	public UUID getAuthorId() {
		return authorId;
	}

	public void setTopicId(UUID topicId) {
		this.topicId = topicId;
	}

	public UUID getTopicId() {
		return topicId;
	}

	@Override
	public String toString() {
		return "Post {" + "id: " + id + ", " + "date: " + date + ", " + "author: " + author + ", "
				+ "publiclyAvailable: " + publiclyAvailable + ", " + "title: " + title + ", " + "content: " + content
				+ ", " + "authorId: " + authorId + ", " + "topicId: " + topicId + "}";
	}

	/**
	 * Enum of field names
	 */
	public static enum Field implements GraphQLField {
		Id("id"), Date("date"), Author("author"), PubliclyAvailable("publiclyAvailable"), Title("title"), Content(
				"content"), AuthorId("authorId"), TopicId("topicId");

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		@Override
		public String getFieldName() {
			return fieldName;
		}

		@Override
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
		private UUID id;
		private Date date;
		private Member author;
		private Boolean publiclyAvailable;
		private String title;
		private String content;
		private UUID authorId;
		private UUID topicId;

		public Builder withId(UUID id) {
			this.id = id;
			return this;
		}

		public Builder withDate(Date date) {
			this.date = date;
			return this;
		}

		public Builder withAuthor(Member author) {
			this.author = author;
			return this;
		}

		public Builder withPubliclyAvailable(Boolean publiclyAvailable) {
			this.publiclyAvailable = publiclyAvailable;
			return this;
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withContent(String content) {
			this.content = content;
			return this;
		}

		public Builder withAuthorId(UUID authorId) {
			this.authorId = authorId;
			return this;
		}

		public Builder withTopicId(UUID topicId) {
			this.topicId = topicId;
			return this;
		}

		public Post build() {
			Post _object = new Post();
			_object.setId(id);
			_object.setDate(date);
			_object.setAuthor(author);
			_object.setPubliclyAvailable(publiclyAvailable);
			_object.setTitle(title);
			_object.setContent(content);
			_object.setAuthorId(authorId);
			_object.setTopicId(topicId);
			return _object;
		}
	}
}