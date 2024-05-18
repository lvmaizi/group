package com.maizi.group.controller;

import com.maizi.group.domain.entity.Group;
import com.maizi.group.domain.entity.Posts;
import com.maizi.group.model.api.request.GroupDetailRequest;
import com.maizi.group.model.api.vo.VO;
import com.maizi.group.service.GroupService;
import com.maizi.group.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author create by fanwenhao
 */
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private PostsService postsService;

    @PostMapping("/api/group/create")
    public VO<Group> create(@RequestBody Group request) {
        groupService.create(request);
        return VO.success(request);
    }

    @PostMapping("/api/group/detail")
    public VO<Group> detail(@RequestBody GroupDetailRequest request) {
        String groupUuid = request.getGroupUuid();
        Group group = groupService.detail(groupUuid);
        return VO.success(group);
    }

    @PostMapping("/api/group/posts/create")
    public VO<Posts> create(@RequestBody Posts request) {
        postsService.create(request);
        return VO.success(request);
    }

}
