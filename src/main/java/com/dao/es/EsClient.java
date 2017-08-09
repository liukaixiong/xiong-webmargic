package com.dao.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.es.EsModel;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.bulk.byscroll.BulkByScrollResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.rest.RestStatus.OK;

/**
 * es相关操作
 *
 * @author Liukx
 * @create 2017-05-08 16:07
 * @email liukx@elab-plus.com
 **/
@Repository("esClient")
public class EsClient {

    @Value("${es.host}")
    private String host = "127.0.0.1";
    @Value("${es.port}")
    private int port = 9300;

    private IndicesAdminClient adminClient;

    private TransportClient client;

    /**
     * 获取数据源
     *
     * @return
     * @throws UnknownHostException
     */
    public EsClient() {
        if (client == null) {
            try {
                client = new PreBuiltTransportClient(Settings.EMPTY)
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
                adminClient = client.admin().indices();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 判断索引是否存在,如果不存在则创建
     *
     * @param model
     */
    public void isIndexExist(EsModel model) {
        IndicesExistsRequest request = new IndicesExistsRequest(model.getIndex());
        IndicesExistsResponse response = adminClient.exists(request).actionGet();
        if (!response.isExists()) {
            client.prepareIndex(model.getIndex(), model.getType());
        }
    }

    /**
     * 批量添加数据
     *
     * @param dataModel
     * @return
     * @throws Exception
     */
    public boolean insertIndex(EsModel dataModel) throws Exception {
        if (dataModel.getJsonData() != null) {
            //判断索引是否存在
            // isIndexExist(dataModel);
            BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
            if (dataModel.getJsonData().size() == 1) {
                IndexRequestBuilder indexRequestBuilder = client.prepareIndex(dataModel.getIndex(), dataModel.getType()).setSource(dataModel.getJsonData().get(0), XContentType.JSON);
                JSONObject json = JSON.parseObject(dataModel.getJsonData().get(0));
                if (json.getString("id") != null) {
                    indexRequestBuilder.setId(json.getString("id"));
                }
                bulkRequestBuilder.add(indexRequestBuilder);
            } else {
                for (int i = 0; i < dataModel.getJsonData().size(); i++) {
                    IndexRequestBuilder indexRequestBuilder = client.prepareIndex(dataModel.getIndex(), dataModel.getType()).setSource(dataModel.getJsonData().get(i), XContentType.JSON);
                    JSONObject json = JSON.parseObject(dataModel.getJsonData().get(i));
                    if (json.getString("id") != null) {
                        indexRequestBuilder.setId(json.getString("id"));
                    }
                    bulkRequestBuilder.add(indexRequestBuilder);
                }
            }
            BulkResponse bulkResponse = bulkRequestBuilder.get();
            return !bulkResponse.hasFailures();
        }
        return false;
    }

    /**
     * 根据主键删文档
     *
     * @param index 索引
     * @param type  类型
     * @param id    主键
     * @return
     */
    public boolean deleteDocumentById(String index, String type, String id) {
        DeleteResponse deleteResponse = null;
        try {
            deleteResponse = client.prepareDelete(index, type, id).execute().get();
            int status = deleteResponse.status().getStatus();
            if (deleteResponse.status() == OK) {
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(deleteResponse.toString());
        return false;
    }

    /**
     * 根据查询条件删除文档
     *
     * @param queryBuilders
     * @return
     */
    public long deleteDocumentListByQuery(String index, QueryBuilder queryBuilders) {
        BulkByScrollResponse response =
                DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
                        .filter(queryBuilders)
                        .source(index)
                        .get();
        long deleted = response.getDeleted();
        return deleted;
    }

    /**
     * 根据索引名称、类型、主键
     *
     * @param index
     * @param type
     * @param id
     * @return
     */
    public Map<String, Object> findDocumentById(String index, String type, String id) {
        GetRequestBuilder requestBuilder = client.prepareGet(index, type, id);
        GetResponse getResponse = requestBuilder.get();
        Map<String, Object> source = getResponse.getSource();
        return source;
    }

    /**
     * 根据查询条件获取查询列表
     *
     * @param model
     * @param queryBuilder
     * @return
     */
    public SearchHits findDocumentListByQuery(EsModel model, QueryBuilder queryBuilder) {
        System.out.println(queryBuilder.toString());
        SearchResponse response = client.prepareSearch(model.getIndex())
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setFrom(model.getFrom()).setSize(model.getSize())
                .setQuery(queryBuilder)
                .get();
        return response.getHits();
    }

    public SearchHits findDocumentHighlighterListByQuery(EsModel model, QueryBuilder queryBuilder, HighlightBuilder highlightBuilder) {
        /**
         *
         * HighlightBuilder hBuilder = new HighlightBuilder();
         hBuilder.preTags("<h2>");
         hBuilder.postTags("</h2>");
         hBuilder.field("content");
         *
         *
         */
        SearchResponse response = client.prepareSearch(model.getIndex())
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setFrom(model.getFrom()).setSize(model.getSize())
                .setQuery(queryBuilder)
                .highlighter(highlightBuilder)
                .get();
        return response.getHits();
    }


    public static void printData(SearchHits searchHits) {
        int length = searchHits.getHits().length;
        long totalHits = searchHits.getTotalHits();
        float maxScore = searchHits.getMaxScore();
        System.out.println("-----------总条数:" + totalHits + "\t score : " + maxScore);
        if (length > 0) {
            for (int i = 0; i < searchHits.getHits().length; i++) {
                SearchHit searchHitFields = searchHits.getHits()[i];
                String name = searchHitFields.getSource().get("content").toString();
                if (searchHitFields.getHighlightFields().size() > 0) {
                    Text[] text = searchHitFields.getHighlightFields().get("content").getFragments();
                    for (Text str : text) {
                        System.out.println(str.string());
                    }
                    System.out.println(" --------------- " + name);
                }
            }
        }
    }

//    public void aggregations(){
//        SearchResponse sr = client.prepareSearch()
//                .addAggregation(
//                        AggregationBuilders.terms("一").field("content")
//                                .subAggregation(AggregationBuilders.dateHistogram("content")
////                                        .field("dateOfBirth")
////                                        .dateHistogramInterval(DateHistogramInterval.YEAR)
//                                        .subAggregation(AggregationBuilders.avg("avg_children").field("children"))
//                                )
//                )
//                .execute().actionGet();
//    }

    public String[] findAllIndexList() throws ExecutionException, InterruptedException {
        GetIndexRequestBuilder getIndexRequestBuilder = adminClient.prepareGetIndex();
        GetIndexResponse getIndexResponse = getIndexRequestBuilder.execute().get();
        return getIndexResponse.getIndices();

    }

    public boolean deleteIndexByName(String index) {
        DeleteIndexResponse dResponse = client.admin().indices().prepareDelete(index)
                .execute().actionGet();
        return dResponse.isAcknowledged();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EsClient es = new EsClient();
        String[] allIndexList = es.findAllIndexList();
        for (int i = 0; i < allIndexList.length; i++) {
            String index = allIndexList[i];
            if(index.matches("\\d+")){
                es.deleteIndexByName(index);
            }
        }
    }
}
