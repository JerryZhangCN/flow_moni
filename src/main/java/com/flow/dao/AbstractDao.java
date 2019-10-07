package com.flow.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jerry
 * @date 2019-10-07 22:59
 */
public class AbstractDao  extends SqlSessionDaoSupport {

    /**
     * Autowired 必须要有
     */
    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){

        super.setSqlSessionFactory(sqlSessionFactory);
    }


}
