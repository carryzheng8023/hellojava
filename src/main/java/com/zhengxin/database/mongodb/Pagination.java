package com.zhengxin.database.mongodb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Description : 分页工具
 * Author :  140796
 * Time   :  2016/4/18
 **/
public class Pagination<T> implements Serializable{

    /**
     *  返回的数据
     */
    private List<T> list;

    /* 每页大小，默认20 */
    private Integer pageSize = 20;

    /* 当前页数 */
    private Integer pgaeNum;

    /* 总条数 */
    private Integer totalCount;

    /* 总页数 */
    private Integer pageCount;

    /* 查询参数 */
    private Map<String, Object> queriesParam;

    public Pagination() {
    }

    public Pagination(Integer pageSize, Integer pgaeNum, Map<String, Object> queriesParam) {
        this.pageSize = pageSize;
        this.pgaeNum = pgaeNum;
        this.queriesParam = queriesParam;
    }

    public Integer getPageSize() {
        return pageSize;
    }


    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPgaeNum() {
        return pgaeNum;
    }

    public void setPgaeNum(Integer pgaeNum) {
        this.pgaeNum = pgaeNum;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount/pageSize + 1;
    }

    public List<T> getList() {

        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Map<String, Object> getQueriesParam() {
        return queriesParam;
    }

    public void setQueriesParam(Map<String, Object> queriesParam) {
        this.queriesParam = queriesParam;
    }
}
