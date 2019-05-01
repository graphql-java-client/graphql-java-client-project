package org.graphql.maven.plugin.samples.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.graphql.maven.plugin.samples.server.graphql.Character;
import org.graphql.maven.plugin.samples.server.graphql.CharacterImpl;
import org.graphql.maven.plugin.samples.server.graphql.Droid;
import org.graphql.maven.plugin.samples.server.graphql.Episode;
import org.graphql.maven.plugin.samples.server.graphql.Human;
import org.graphql.maven.plugin.samples.server.jpa.CharacterRepository;
import org.graphql.maven.plugin.samples.server.jpa.DroidRepository;
import org.graphql.maven.plugin.samples.server.jpa.EpisodeRepository;
import org.graphql.maven.plugin.samples.server.jpa.HumanRepository;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

	/** The logger for this instance */
	protected Logger logger = LogManager.getLogger();

	@Resource
	CharacterRepository characterRepository;
	@Resource
	HumanRepository humanRepository;
	@Resource
	DroidRepository droidRepository;
	@Resource
	EpisodeRepository episodeRepository;

	public DataFetcher<Character> hero() {
		return dataFetchingEnvironment -> {
			List<CharacterImpl> ret;
			if (dataFetchingEnvironment.getArgument("episode") == null) {
				ret = characterRepository.findAll();
			} else {
				Episode episode = Episode.valueOf(dataFetchingEnvironment.getArgument("episode"));
				ret = characterRepository.findByAppearsIn(episode.toString());
			}
			logger.warn("'hero' query: return type is not a list, but {} rows were found (the first one is returned, or null if no row)", ret.size());
			return (ret.size() > 0) ? ret.get(0) : null;
		};

	}

	public DataFetcher<List<CharacterImpl>> characters() {
		return dataFetchingEnvironment -> {
			Episode episode = Episode.valueOf(dataFetchingEnvironment.getArgument("episode"));
			List<CharacterImpl> ret = characterRepository.findByAppearsIn(episode.toString());
			logger.debug("'hero' query: {} rows returned", ret.size());
			return ret;
		};
	}

	public DataFetcher<Human> human() {
		return dataFetchingEnvironment -> {
			String id = dataFetchingEnvironment.getArgument("id");
			Optional<Human> result = humanRepository.findById(id);
			Human human = result.isPresent() ? result.get() : null;
			logger.debug("'human' query returned: {}", human);
			return human;
		};
	}

	public DataFetcher<Droid> droid() {
		return dataFetchingEnvironment -> {
			String id = dataFetchingEnvironment.getArgument("id");
			Optional<Droid> result = droidRepository.findById(id);
			Droid droid = result.isPresent() ? result.get() : null;
			logger.debug("'droid' query returned: {}", droid);
			return droid;
		};
	}

	public DataFetcher<List<CharacterImpl>> friends() {
		return dataFetchingEnvironment -> {
			Character character = dataFetchingEnvironment.getSource();
			List<CharacterImpl> ret = characterRepository.findFriends(character.getId());
			logger.debug("'friends' subquery: {} rows returned", ret.size());
			return ret;
		};
	}

	public DataFetcher<List<Episode>> appearsIn() {
		return dataFetchingEnvironment -> {
			Character character = dataFetchingEnvironment.getSource();
			List<Episode> ret = new ArrayList<>();
			for (String name : episodeRepository.findAppearsIn(character.getId())) {
				ret.add(Episode.valueOf(name));
			} // for
			logger.debug("'appearsIn' subquery: {} rows returned", ret.size());
			return ret;
		};
	}
}
