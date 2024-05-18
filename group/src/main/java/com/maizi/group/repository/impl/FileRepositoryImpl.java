package com.maizi.group.repository.impl;

import com.maizi.group.domain.entity.File;
import com.maizi.group.repository.FileRepository;
import com.maizi.group.repository.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author create by fanwenhao
 */
@Component
public class FileRepositoryImpl implements FileRepository {

    @Autowired
    private RepositoryWrapper<File, FileMapper> repositoryWrapper;
    @Autowired
    private FileMapper fileMapper;

    @Override
    public void save(File domain) {
        repositoryWrapper.save(fileMapper, domain);
    }

    @Override
    public void insert(File domain) {
        repositoryWrapper.insert(fileMapper, domain);
    }

    @Override
    public void update(File domain) {
        repositoryWrapper.update(fileMapper, domain);
    }

    @Override
    public File get(String uuid) {
        return repositoryWrapper.get(fileMapper, uuid);
    }
}
