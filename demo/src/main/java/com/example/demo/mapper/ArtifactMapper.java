package com.example.demo.mapper;

import com.example.demo.entity.Artifact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.*;


@Mapper
public interface ArtifactMapper {

    @Select("Select * from artifact where artifactname like CONCAT('%', #{artifactname}, '%')")
    public List<Artifact> findByArtifactName(String ArtifactName);

    public List<Artifact> DeepSearch(String s);
    @Select("Select * from artifact where library like CONCAT('%',#{libraryName},'%')")
    public List<Artifact> findByLibraryName(String libraryName);

    @Select("Select * from artifact where relicTime like CONCAT('%',#{relicTime},'%')")
    public List<Artifact> findByRelicTime(String relicTime);

    @Select("select * from artifact where id=#{artifactId}")
    public Artifact findById(Integer artifactId);

    @Select("SELECT * FROM artifact ORDER BY RAND()")
    public List<Artifact> findAllRandom();
}

