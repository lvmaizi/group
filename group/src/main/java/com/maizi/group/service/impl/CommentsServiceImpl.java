package com.maizi.group.service.impl;

import com.maizi.group.domain.entity.Comments;
import com.maizi.group.repository.CommentsRepository;
import com.maizi.group.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author create by fanwenhao
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public void create(Comments comments) {
        commentsRepository.save(comments);
    }
}
