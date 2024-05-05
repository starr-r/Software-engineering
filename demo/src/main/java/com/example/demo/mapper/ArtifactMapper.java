package com.example.demo.mapper;

import com.example.demo.entity.Artifact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.*;


@Mapper
public interface ArtifactMapper {

    @Select("Select * from artifact where artifactname like CONCAT('%', #{artifactname}, '%') or artifactName_Chinese like CONCAT('%', #{artifactname}, '%') ")
    public List<Artifact> findByArtifactName(String artifactname);

    public List<Artifact> DeepSearch(String s);


    @Select("Select * from artifact where library like CONCAT('%',#{libraryName},'%') or library_Chinese like CONCAT('%',#{libraryName},'%') ")
    public List<Artifact> findByLibraryName(String libraryName);

    @Select("Select * from artifact where relicTime like CONCAT('%',#{relicTime},'%')")
    public List<Artifact> findByRelicTime(String relicTime);

    @Select("select * from artifact where id=#{artifactId}")
    public Artifact findById(Integer artifactId);

    @Select("SELECT * FROM artifact ")
    public List<Artifact> findAllRandom();

    @Select("select * from artifact where " +
            "material_Chinese like CONCAT('%',#{materialChinese},'%') " +
            "or country =#{country} or library_Chinese=#{libraryChinese} " +
            "or relicTime_chinese=#{libraryChinese} " +
            "and id !=#{id} order by rand() LIMIT 10 ")
    public List<Artifact> findVague(Artifact artifact);
}

