package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Artifact;
import com.example.demo.mapper.ArtifactMapper;
import com.example.demo.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ObjectStreamClass;
import java.util.List;
import java.util.Map;

@RestController
public class ArtifactController {
    @Autowired
    ArtifactMapper artifactMapper;
    @Autowired
    CommentMapper commentMapper;

    //文物部分共有四个url,严格按照下面的url格式访问
    @GetMapping("/searchAll")

    //http://localhost:8080/searchAll
    @CrossOrigin(origins = "http://localhost:6103")
    public Result<?>searchAll(){
        List<Artifact> list=artifactMapper.findAllRandom();
        return Result.success(list,list.size());
    }

    @GetMapping("/artifact")//文物名称

    //http://localhost:8080/artifact?artifactName=xxx&order=xxx;
    @CrossOrigin(origins = "http://localhost:6103")
    public Result<?> search_by_name(String artifactName) {

        List<Artifact> list=artifactMapper.findByArtifactName(artifactName);
         return Result.success(list,list.size());
        //调用ArtifactMapper中的select by artifactName 将list返回至前端。
    }

    @GetMapping("/search_museum")//博物馆名称

    //http://localhost:8080/search_museum?museumName=xxx&order=xxx;
    @CrossOrigin(origins = "http://localhost:6103")
    public Result<?> search_by_museum(String museumName){

        List<Artifact> list= artifactMapper.findByLibraryName(museumName);
        return Result.success(list,list.size());
    }

    @GetMapping("/search_relicTime")//文物年代

    //http://localhost:8080/search_relicTime?relicTime=xxx&order=xxx;
    @CrossOrigin(origins = "http://localhost:6103")
    public Result<?> search_by_time(String relicTime){
        List<Artifact> list= artifactMapper.findByRelicTime(relicTime);
        return Result.success(list,list.size());
    }

    @GetMapping("/artifact/{id}")//文物详情页面

    //http://localhost:8080/artifact/{id}
    @CrossOrigin(origins = "http://localhost:6103")
    public Artifact artifact_details(@PathVariable String id){

        Artifact artifact=artifactMapper.findById(Integer.parseInt(id));
        artifact.comments=commentMapper.findCommentsByArtifact_id(Integer.parseInt(id));
        System.out.println(artifact);
        return artifact;
    }

    @PostMapping("/advanced_search")
    @CrossOrigin(origins = "http://localhost:6103")
    public Result<?> DeepSearch(@RequestBody Map<String, Object> requestMap){
        String condition = (String) requestMap.get("condition");
        Integer order = (Integer) requestMap.get("order");
        List<Artifact> list=artifactMapper.DeepSearch(condition);
        return Result.success(list, list.size());
    }
}
