package com.maizi.group.repository.impl;

import com.maizi.group.repository.BaseRepository;
import com.maizi.group.repository.FileRepository;
import com.maizi.group.repository.mapper.FileMapper;
import com.maizi.group.domain.File;
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
