package com.johar.mybatis.mybatistest.neo4j;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveNeo4jRepository<PersonEntity, String> {

    Mono<PersonEntity> findOneByName(String name);

    Mono<PersonEntity> findOneByTmdbID(Long tmdbID);
}
