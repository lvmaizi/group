package com.maizi.quan.manager.impl;

import com.maizi.quan.manager.BaseRepository;
import com.maizi.quan.manager.FileRepository;
import com.maizi.quan.manager.domain.File;
import com.maizi.quan.manager.mapper.FileMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author create by fanwenhao
 */
@Component
public class FileRepositoryImpl extends BaseRepository implements FileRepository {

    @Resource
    private FileMapper fileMapper;

    @Override
    public void save(File file) {
        super.save(fileMapper, file);
    }

    @Override
    public File get(String uuid) {
        return super.get(fileMapper, uuid);
    }
}
