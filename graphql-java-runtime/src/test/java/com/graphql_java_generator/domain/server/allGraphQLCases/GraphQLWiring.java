/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.request.WebRequest;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring.Builder;
import graphql.spring.web.servlet.ExecutionInputCustomizer;
import graphql.spring.web.servlet.GraphQLInvocation;
import graphql.spring.web.servlet.GraphQLInvocationData;
import graphql.spring.web.servlet.OnDemandDataLoaderRegistry;
import graphql.spring.web.servlet.components.DefaultGraphQLInvocation;

import com.graphql_java_generator.server.util.BatchLoaderDelegate;

import java.util.Date;
import java.util.UUID;

/**
 * This class is responsible for providing all the GraphQL Beans to the graphql-java Spring Boot integration.
 * <BR/><BR/>
 * Based on the https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/ tutorial
 * 
 * @author etienne-sf
 */
@Component
public class GraphQLWiring {

	/** The logger for this instance */
	protected Logger logger = LoggerFactory.getLogger(GraphQLWiring.class);

	@Autowired
	protected GraphQLDataFetchers graphQLDataFetchers;

	protected RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring()
			//
			// Wiring every custom scalar definitions
			.scalar(com.graphql_java_generator.customscalars.GraphQLScalarTypeDate.Date)
			//
			// Wiring every custom scalar definitions
			.scalar(graphql.Scalars.GraphQLLong)
			//
			// Wiring every custom scalar definitions
			.scalar(com.graphql_java_generator.customscalars.GraphQLScalarTypeString.String)
			//
			// Wiring every custom scalar definitions
			.scalar(graphql.scalars.ExtendedScalars.NonNegativeInt)
			//
			// Wiring every GraphQL type
			.type("MyQueryType", typeWiring -> addWiringForMyQueryType(typeWiring))
			.type("AnotherMutationType", typeWiring -> addWiringForAnotherMutationType(typeWiring))
			.type("TheSubscriptionType", typeWiring -> addWiringForTheSubscriptionType(typeWiring))
			.type("AllFieldCases", typeWiring -> addWiringForAllFieldCases(typeWiring))
			.type("AllFieldCasesInterfaceType", typeWiring -> addWiringForAllFieldCasesInterfaceType(typeWiring))
			.type("Human", typeWiring -> addWiringForHuman(typeWiring))
			.type("Droid", typeWiring -> addWiringForDroid(typeWiring))
			.type("Commented", typeWiring -> addWiringForCommented(typeWiring))
			.type("AllFieldCasesInterface", typeWiring -> addWiringForAllFieldCasesInterface(typeWiring))
			.type("Character", typeWiring -> addWiringForCharacter(typeWiring))
			.type("AllFieldCasesWithIdSubtype", typeWiring -> addWiringForAllFieldCasesWithIdSubtype(typeWiring))
			.type("WithID", typeWiring -> addWiringForWithID(typeWiring))
			//
			// Let's link the interface types to the concrete types
			.type("WithID", typeWiring -> typeWiring.typeResolver(getResolverForWithID()))
			.type("Commented", typeWiring -> typeWiring.typeResolver(getResolverForCommented()))
			.type("UnusedInterface", typeWiring -> typeWiring.typeResolver(getResolverForUnusedInterface()))
			.type("AllFieldCasesInterface", typeWiring -> typeWiring.typeResolver(getResolverForAllFieldCasesInterface()))
			.type("Character", typeWiring -> typeWiring.typeResolver(getResolverForCharacter()))
			//
			// Let's link the union types to the concrete types
			.type("AnyCharacter", typeWiring -> typeWiring.typeResolver(getResolverForAnyCharacter()))
			//
			// Let's finish the job
			.build();
	} // buildWiring()


	/**
	 * Wiring for the MyQueryType object type. This method actually calls the 
	 * <I>getMyQueryType_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getMyQueryType_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForMyQueryType(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("withoutParameters", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeWithoutParameters());
		typeWiring.dataFetcher("withOneOptionalParam", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeWithOneOptionalParam());
		typeWiring.dataFetcher("withOneMandatoryParam", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeWithOneMandatoryParam());
		typeWiring.dataFetcher("withOneMandatoryParamDefaultValue", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeWithOneMandatoryParamDefaultValue());
		typeWiring.dataFetcher("withTwoMandatoryParamDefaultVal", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeWithTwoMandatoryParamDefaultVal());
		typeWiring.dataFetcher("withEnum", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeWithEnum());
		typeWiring.dataFetcher("withListOfList", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeWithListOfList());
		typeWiring.dataFetcher("withList", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeWithList());
		typeWiring.dataFetcher("allFieldCases", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeAllFieldCases());
		typeWiring.dataFetcher("unionTest", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeUnionTest());
		typeWiring.dataFetcher("error", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeError());
		typeWiring.dataFetcher("aBreak", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeABreak());
		typeWiring.dataFetcher("directiveOnQuery", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeDirectiveOnQuery());
		typeWiring.dataFetcher("directiveOnField", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeDirectiveOnField());
		typeWiring.dataFetcher("connectionWithoutParameters", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeConnectionWithoutParameters());
		typeWiring.dataFetcher("connectionOnHuman", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeConnectionOnHuman());
		typeWiring.dataFetcher("issue53", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeIssue53());
		typeWiring.dataFetcher("issue82Float", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeIssue82Float());
		typeWiring.dataFetcher("issue82ID", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeIssue82ID());
		typeWiring.dataFetcher("relay", graphQLDataFetchers.dataFetchersDelegateMyQueryTypeRelay());
		return typeWiring;
	}

	/**
	 * Wiring for the AnotherMutationType object type. This method actually calls the 
	 * <I>getAnotherMutationType_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getAnotherMutationType_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForAnotherMutationType(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("createHuman", graphQLDataFetchers.dataFetchersDelegateAnotherMutationTypeCreateHuman());
		typeWiring.dataFetcher("createAllFieldCases", graphQLDataFetchers.dataFetchersDelegateAnotherMutationTypeCreateAllFieldCases());
		typeWiring.dataFetcher("deleteSnacks", graphQLDataFetchers.dataFetchersDelegateAnotherMutationTypeDeleteSnacks());
		return typeWiring;
	}

	/**
	 * Wiring for the TheSubscriptionType object type. This method actually calls the 
	 * <I>getTheSubscriptionType_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getTheSubscriptionType_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForTheSubscriptionType(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("subscribeNewHumanForEpisode", graphQLDataFetchers.dataFetchersDelegateTheSubscriptionTypeSubscribeNewHumanForEpisode());
		typeWiring.dataFetcher("subscribeToAList", graphQLDataFetchers.dataFetchersDelegateTheSubscriptionTypeSubscribeToAList());
		typeWiring.dataFetcher("issue53", graphQLDataFetchers.dataFetchersDelegateTheSubscriptionTypeIssue53());
		return typeWiring;
	}

	/**
	 * Wiring for the AllFieldCases object type. This method actually calls the 
	 * <I>getAllFieldCases_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getAllFieldCases_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForAllFieldCases(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("dates", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesDates());
		typeWiring.dataFetcher("comments", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesComments());
		typeWiring.dataFetcher("booleans", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesBooleans());
		typeWiring.dataFetcher("aliases", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesAliases());
		typeWiring.dataFetcher("planets", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesPlanets());
		typeWiring.dataFetcher("friends", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesFriends());
		typeWiring.dataFetcher("matrix", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesMatrix());
		typeWiring.dataFetcher("oneWithIdSubType", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesOneWithIdSubTypeWithDataLoader());
		typeWiring.dataFetcher("listWithIdSubTypes", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesListWithIdSubTypes());
		typeWiring.dataFetcher("oneWithoutIdSubType", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesOneWithoutIdSubType());
		typeWiring.dataFetcher("listWithoutIdSubTypes", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesListWithoutIdSubTypes());
		typeWiring.dataFetcher("issue65", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesIssue65());
		typeWiring.dataFetcher("issue66", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesIssue66WithDataLoader());
		return typeWiring;
	}

	/**
	 * Wiring for the AllFieldCasesInterfaceType object type. This method actually calls the 
	 * <I>getAllFieldCasesInterfaceType_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getAllFieldCasesInterfaceType_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForAllFieldCasesInterfaceType(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("comments", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceTypeComments());
		typeWiring.dataFetcher("booleans", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceTypeBooleans());
		typeWiring.dataFetcher("aliases", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceTypeAliases());
		typeWiring.dataFetcher("planets", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceTypePlanets());
		typeWiring.dataFetcher("friends", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceTypeFriends());
		typeWiring.dataFetcher("oneWithIdSubType", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceTypeOneWithIdSubTypeWithDataLoader());
		typeWiring.dataFetcher("listWithIdSubTypes", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceTypeListWithIdSubTypes());
		typeWiring.dataFetcher("oneWithoutIdSubType", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceTypeOneWithoutIdSubType());
		typeWiring.dataFetcher("listWithoutIdSubTypes", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceTypeListWithoutIdSubTypes());
		return typeWiring;
	}

	/**
	 * Wiring for the Human object type. This method actually calls the 
	 * <I>getHuman_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getHuman_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForHuman(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("bestFriend", graphQLDataFetchers.dataFetchersDelegateHumanBestFriendWithDataLoader());
		typeWiring.dataFetcher("friends", graphQLDataFetchers.dataFetchersDelegateHumanFriends());
		typeWiring.dataFetcher("comments", graphQLDataFetchers.dataFetchersDelegateHumanComments());
		typeWiring.dataFetcher("appearsIn", graphQLDataFetchers.dataFetchersDelegateHumanAppearsIn());
		return typeWiring;
	}

	/**
	 * Wiring for the Droid object type. This method actually calls the 
	 * <I>getDroid_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getDroid_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForDroid(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("friends", graphQLDataFetchers.dataFetchersDelegateDroidFriends());
		typeWiring.dataFetcher("appearsIn", graphQLDataFetchers.dataFetchersDelegateDroidAppearsIn());
		return typeWiring;
	}

	/**
	 * Wiring for the Commented object type. This method actually calls the 
	 * <I>getCommented_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getCommented_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForCommented(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("comments", graphQLDataFetchers.dataFetchersDelegateCommentedComments());
		return typeWiring;
	}

	/**
	 * Wiring for the AllFieldCasesInterface object type. This method actually calls the 
	 * <I>getAllFieldCasesInterface_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getAllFieldCasesInterface_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForAllFieldCasesInterface(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("comments", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceComments());
		typeWiring.dataFetcher("booleans", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceBooleans());
		typeWiring.dataFetcher("aliases", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceAliases());
		typeWiring.dataFetcher("planets", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfacePlanets());
		typeWiring.dataFetcher("friends", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceFriends());
		typeWiring.dataFetcher("oneWithIdSubType", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceOneWithIdSubTypeWithDataLoader());
		typeWiring.dataFetcher("listWithIdSubTypes", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceListWithIdSubTypes());
		typeWiring.dataFetcher("oneWithoutIdSubType", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceOneWithoutIdSubType());
		typeWiring.dataFetcher("listWithoutIdSubTypes", graphQLDataFetchers.dataFetchersDelegateAllFieldCasesInterfaceListWithoutIdSubTypes());
		return typeWiring;
	}

	/**
	 * Wiring for the Character object type. This method actually calls the 
	 * <I>getCharacter_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getCharacter_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForCharacter(TypeRuntimeWiring.Builder typeWiring) {
		typeWiring.dataFetcher("friends", graphQLDataFetchers.dataFetchersDelegateCharacterFriends());
		typeWiring.dataFetcher("appearsIn", graphQLDataFetchers.dataFetchersDelegateCharacterAppearsIn());
		return typeWiring;
	}

	/**
	 * Wiring for the AllFieldCasesWithIdSubtype object type. This method actually calls the 
	 * <I>getAllFieldCasesWithIdSubtype_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getAllFieldCasesWithIdSubtype_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForAllFieldCasesWithIdSubtype(TypeRuntimeWiring.Builder typeWiring) {
		return typeWiring;
	}

	/**
	 * Wiring for the WithID object type. This method actually calls the 
	 * <I>getWithID_XXXXXDataFetcher()</I> methods. So, when you need to override the default wiring, 
	 * you can either override this method and declare all the field's wiring, or override one of the
	 * <I>getWithID_XXXXXDataFetcher()</I> methods to only redefine the wiring for one field 
	 * 
	 * @param typeWiring The Builder, on which you can for instance call the {@link Builder#dataFetcher(String, graphql.schema.DataFetcher)} 
	 * 		or {@link Builder#dataFetchers(java.util.Map)} method.
	 * @return The builder
	 */
	protected TypeRuntimeWiring.Builder addWiringForWithID(TypeRuntimeWiring.Builder typeWiring) {
		return typeWiring;
	}

	
	protected TypeResolver getResolverForWithID() {
		return new TypeResolver() {
			@Override
			public GraphQLObjectType getType(TypeResolutionEnvironment env) {
				Object javaObject = env.getObject();
				String ret = null;
				if (javaObject instanceof AllFieldCases) {
					ret = "AllFieldCases";
				} else
				if (javaObject instanceof AllFieldCasesInterfaceType) {
					ret = "AllFieldCasesInterfaceType";
				} else
				if (javaObject instanceof Human) {
					ret = "Human";
				} else
				if (javaObject instanceof Droid) {
					ret = "Droid";
				} else
				{
					throw new RuntimeException("Can't resolve javaObject " + javaObject.getClass().getName());
				}
				logger.trace("Resolved type for javaObject {} is {}", javaObject.getClass().getName());
				return env.getSchema().getObjectType(ret);
			}
		};
	}

	protected TypeResolver getResolverForCommented() {
		return new TypeResolver() {
			@Override
			public GraphQLObjectType getType(TypeResolutionEnvironment env) {
				Object javaObject = env.getObject();
				String ret = null;
				if (javaObject instanceof Human) {
					ret = "Human";
				} else
				{
					throw new RuntimeException("Can't resolve javaObject " + javaObject.getClass().getName());
				}
				logger.trace("Resolved type for javaObject {} is {}", javaObject.getClass().getName());
				return env.getSchema().getObjectType(ret);
			}
		};
	}

	protected TypeResolver getResolverForUnusedInterface() {
		return new TypeResolver() {
			@Override
			public GraphQLObjectType getType(TypeResolutionEnvironment env) {
				return null;
			}
		};
	}

	protected TypeResolver getResolverForAllFieldCasesInterface() {
		return new TypeResolver() {
			@Override
			public GraphQLObjectType getType(TypeResolutionEnvironment env) {
				Object javaObject = env.getObject();
				String ret = null;
				if (javaObject instanceof AllFieldCasesInterfaceType) {
					ret = "AllFieldCasesInterfaceType";
				} else
				{
					throw new RuntimeException("Can't resolve javaObject " + javaObject.getClass().getName());
				}
				logger.trace("Resolved type for javaObject {} is {}", javaObject.getClass().getName());
				return env.getSchema().getObjectType(ret);
			}
		};
	}

	protected TypeResolver getResolverForCharacter() {
		return new TypeResolver() {
			@Override
			public GraphQLObjectType getType(TypeResolutionEnvironment env) {
				Object javaObject = env.getObject();
				String ret = null;
				if (javaObject instanceof Human) {
					ret = "Human";
				} else
				if (javaObject instanceof Droid) {
					ret = "Droid";
				} else
				{
					throw new RuntimeException("Can't resolve javaObject " + javaObject.getClass().getName());
				}
				logger.trace("Resolved type for javaObject {} is {}", javaObject.getClass().getName());
				return env.getSchema().getObjectType(ret);
			}
		};
	}

	protected TypeResolver getResolverForAnyCharacter() {
		return new TypeResolver() {
			@Override
			public GraphQLObjectType getType(TypeResolutionEnvironment env) {
				Object javaObject = env.getObject();
				String ret = null;

				if (javaObject instanceof Human) {
					ret = "Human";
				} else
				if (javaObject instanceof Droid) {
					ret = "Droid";
				} else
				{
					throw new RuntimeException("Can't resolve javaObject " + javaObject.getClass().getName());
				}
				logger.trace("Resolved type for javaObject {} is {}", javaObject.getClass().getName());
				return env.getSchema().getObjectType(ret);
			}
		};
	}

}
