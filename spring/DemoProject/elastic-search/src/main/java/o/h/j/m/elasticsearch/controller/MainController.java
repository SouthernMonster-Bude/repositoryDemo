package o.h.j.m.elasticsearch.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import o.h.j.m.elasticsearch.vo.People;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.ResponseException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class MainController {

    @Autowired
    private TransportClient client;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("get/poeple/man")
    public ResponseEntity get(
            @RequestParam(name = "id",defaultValue = "") String id) {
        GetResponse result = this.client.prepareGet("people","man",id).get();
        if(!result.isExists()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(),HttpStatus.OK);
    }
    @PostMapping("add/poeple/man")
    public ResponseEntity create(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "age") String age,
                                 @RequestParam(name = "gender") String gender,
                                 @RequestParam(name = "country") String country,
                                 @RequestParam(name = "date")
                                 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                         Date date    ) {
        try {
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("name",name)
                    .field("age",age)
                    .field("gender",gender)
                    .field("country",country)
                    .field("date",date.getTime())
                    .endObject();
            IndexResponse result = this.client.prepareIndex("people","man")
            .setSource(xContentBuilder).get();
            return new ResponseEntity(result.getId(),HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("update/people/man")
    public ResponseEntity update(
            @RequestParam(name = "id") String id,
            @RequestParam(name = "content") String content
             ) {
        UpdateRequest update = new UpdateRequest("people","man",id);

        try {
            Map<String,Object> cMap = new Gson().fromJson(content, HashMap.class);
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder().startObject();
            for(String m : cMap.keySet()){
                Object value = cMap.get(m);
                if(value != null){
                    if("date".equals(m)){
                        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value.toString());
                        xContentBuilder.field(m,date.getTime());
                    }else {
                        xContentBuilder.field(m,value);
                    }
                }
            }
            xContentBuilder.endObject();
            update.doc(xContentBuilder);
            UpdateResponse result = client.update(update).get();
            return new ResponseEntity(result.getResult().toString(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("delete/people/man")
    public ResponseEntity delete(
            @RequestParam(name = "id") String id) {
        DeleteResponse result = client.prepareDelete("people","man",id).get();
        return new ResponseEntity(result.getResult().toString(),HttpStatus.OK);
    }

    /**
     *
     * @param content
     * {
          "trems":{"key1":"value","key2":"value"},
          "rangeName":"name",
          "min":minimum,
          "max":maxmun
     }
     * @return
     */
    @PostMapping("query/people/man")
    public ResponseEntity query(@RequestParam(name = "content") String content){
        Map<String,Object> cMap = new Gson().fromJson(content, HashMap.class);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        Map<String,Object> tremsMap = (Map)cMap.get("trems");
        try {
            for(String m : tremsMap.keySet()){
                Object value = tremsMap.get(m);
                if(value != null){
                    if("date".equals(m)){
                        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value.toString());
                        boolQueryBuilder.must(QueryBuilders.matchQuery(m,date.getTime()));
                    }else {
                        boolQueryBuilder.must(QueryBuilders.matchQuery(m,value));
                    }
                }
            }
            RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery(cMap.get("rangeName").toString())
                    .from((int)Double.parseDouble(cMap.get("min")+""))
                    .to((int)Double.parseDouble(cMap.get("max")+""));
            boolQueryBuilder.filter(rangeQueryBuilder);
            SearchRequestBuilder builder = this.client.prepareSearch("people")
                    .setTypes("man")
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    .setQuery(boolQueryBuilder)
                    .setFrom(0)
                    .setSize(10);
            System.out.println(builder);
            SearchResponse response = builder.get();

            List<Map<String,Object>> result  = new ArrayList<Map<String,Object>>();
            for(SearchHit hit : response.getHits()){
                result.add(hit.getSourceAsMap());
            }
            return new ResponseEntity(result,HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
