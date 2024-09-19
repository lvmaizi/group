package com.maizi.group.controller;

import com.maizi.group.domain.entity.Resource;
import com.maizi.group.model.api.vo.VO;
import com.maizi.group.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author create by fanwenhao
 */
@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/api/resource/create")
    public VO<Resource> create(@RequestBody Resource request) {
        resourceService.create(request);
        return VO.success(request);
    }
}
