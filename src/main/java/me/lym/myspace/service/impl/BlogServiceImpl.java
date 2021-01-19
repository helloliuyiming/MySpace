package me.lym.myspace.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.lym.myspace.pojo.Blog;
import me.lym.myspace.service.BlogService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Component
public class BlogServiceImpl implements BlogService {
    @Override
    public boolean saveBatch(Collection<Blog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Blog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Blog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Blog entity) {
        return false;
    }

    @Override
    public Blog getOne(Wrapper<Blog> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Blog> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Blog> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Blog> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Blog> getEntityClass() {
        return null;
    }
}
