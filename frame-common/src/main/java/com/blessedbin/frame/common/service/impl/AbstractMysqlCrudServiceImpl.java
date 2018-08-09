package com.blessedbin.frame.common.service.impl;


import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.common.service.CheckExistsService;
import com.blessedbin.frame.common.service.CrudService;
import com.blessedbin.frame.common.service.DataTableService;
import com.blessedbin.frame.common.service.MysqlCrudService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xubin on 2018/6/27.
 *
 * @author 37075
 * @date 2018/6/27
 * @time 14:55
 * @tool intellij idea
 */
@Slf4j
public abstract class AbstractMysqlCrudServiceImpl<M,PK extends Serializable>
        implements MysqlCrudService<M,PK> {

    @Autowired
    protected MyMapper<M> mapper;

    @Override
    public int insert(M record) {
        Assert.notNull(record,"record is not null");
        return mapper.insert(record);
    }


    @Override
    public int insertSelective(M record) {
        Assert.notNull(record,"record is not null");
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPk(PK pk) {
        Assert.notNull(pk,"primary key is not null");
        return mapper.deleteByPrimaryKey(pk);
    }

    @Override
    public int deleteByPks(Iterable<PK> pks) {
        AtomicInteger count = new AtomicInteger();
        pks.forEach(pk -> {
            int i = mapper.deleteByPrimaryKey(pk);
            count.set(count.get() + i);
        });
        return count.get();
    }

    @Override
    public int updateByPk(M record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPkSelective(M record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据主键查询
     *
     * @param pk 主键
     * @return 查询结果, 无结果时返回{@code null}
     */
    @Override
    public M selectByPk(PK pk) {
        return mapper.selectByPrimaryKey(pk);
    }

    /**
     * 根据多个主键查询
     *
     * @param pks 主键集合
     * @return 查询结果, 如果无结果返回空集合
     */
    @Override
    public List<M> selectByPks(Iterable<PK> pks) {
        List<M> result = new ArrayList<>();
        pks.forEach(pk -> result.add(mapper.selectByPrimaryKey(pk)));
        return result;
    }

    /**
     * 查询所有结果
     *
     * @return 所有结果, 如果无结果则返回空集合
     */
    @Override
    public List<M> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<M> selectAllByExample(Object example) {
        return mapper.selectByExample(example);
    }

    /**
     * 查询所有结果
     *
     * @param pageNum
     * @param pageSize
     * @return 获取分页结果
     */
    @Override
    public PageInfo<M> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<M> ms = mapper.selectAll();
        return new PageInfo<M>(ms);
    }


    /**
     * 获取dataTable
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Pagination<M> getDataTable(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<M> ms = selectAll();
        PageInfo<M> pageInfo = new PageInfo<>(ms);
        return new Pagination<M>(pageInfo.getPageNum(),pageInfo.getPageSize(),
                pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public Pagination<M> getDataTable(int pageNum, int pageSize, Object example) {
        PageHelper.startPage(pageNum,pageSize);
        List<M> ms = mapper.selectByExample(example);
        PageInfo<M> pageInfo = new PageInfo<>(ms);
        return new Pagination<M>(pageInfo.getPageNum(),pageInfo.getPageSize(),
                pageInfo.getTotal(),pageInfo.getList());
    }

    @Override
    public boolean checkExistsByExample(Object example) {
        return mapper.selectCountByExample(example) > 0;
    }

    @Override
    public boolean checkExistsByPk(Object pk) {
        return mapper.existsWithPrimaryKey(pk);
    }
}
