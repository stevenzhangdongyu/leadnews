package com.heima.search.service.impl;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.search.dtos.HistorySearchDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.search.pojos.ApUserSearch;
import com.heima.search.service.ApUserSearchService;
import com.heima.utils.common.thread.ApUserSearchThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ApUserSearchServiceImpl implements ApUserSearchService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询搜索历史
     *
     * @return
     */
    @Override
    public ResponseResult findUserSearch() {
        //获取当前用户
        ApUser user = ApUserSearchThreadLocalUtil.getUser();
        if(user == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }

        //根据用户查询数据，按照时间倒序
        List<ApUserSearch> apUserSearches = mongoTemplate.find(Query.query(Criteria.where("userId").is(user.getId())).with(Sort.by(Sort.Direction.DESC, "createdTime")), ApUserSearch.class);
        return ResponseResult.okResult(apUserSearches);
    }

    @Override
    public ResponseResult delUserSearch(HistorySearchDto dto) {
        if(dto.getId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        ApUser user = ApUserSearchThreadLocalUtil.getUser();
        if (user == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        mongoTemplate.remove(Query.query(Criteria.where("id").is(dto.getId()).and("userId").is(user.getId())),ApUserSearch.class);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    @Async
    public void insert(String keyword, Integer userId) {
        if (StringUtils.isBlank(keyword) || userId == null) {
            return;
        }
       ApUserSearch apUserSearch = mongoTemplate.findOne(Query.query(Criteria.where("userId").is(userId).and("keyword").is(keyword)), ApUserSearch.class);
        if (apUserSearch != null) {
            apUserSearch.setCreatedTime(new Date());
            mongoTemplate.save(apUserSearch);

        }else {
            ApUserSearch apUserSearchNew =new ApUserSearch();
            apUserSearchNew.setUserId(userId);
            apUserSearchNew.setKeyword(keyword);
            apUserSearchNew.setCreatedTime(new Date());
            List<ApUserSearch> apUserSearches = mongoTemplate.find(Query.query(Criteria.where("userId").is(userId))
                    .with(Sort.by(Sort.Direction.DESC,"createdTime")), ApUserSearch.class);
            if (apUserSearches == null || apUserSearches.size() < 10) {
                mongoTemplate.insert(apUserSearchNew);
            }else {
                ApUserSearch replacedApUserSearch = apUserSearches.get(apUserSearches.size() - 1);
                mongoTemplate.findAndReplace(Query.query(Criteria.where("id").is(replacedApUserSearch.getId())),apUserSearchNew);
            }
        }
    }
}
